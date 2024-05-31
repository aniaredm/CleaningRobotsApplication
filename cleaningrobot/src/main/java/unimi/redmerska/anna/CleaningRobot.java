package unimi.redmerska.anna;

import com.sun.jersey.api.client.ClientResponse;
import unimi.redmerska.anna.grpc.*;
import unimi.redmerska.anna.mqtt.MQTTPublisher;
import unimi.redmerska.anna.rest.RestClient;
import unimi.redmerska.anna.sensor.Measurement;
import unimi.redmerska.anna.sensor.MeasurementList;
import unimi.redmerska.anna.sensor.PM10Simulator;
import unimi.redmerska.anna.tools.Position;

import javax.print.attribute.standard.MediaSize;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class CleaningRobot {
    private int id;
    private PM10Simulator sensor;
    private MeasurementList ml;
    private boolean running;

    private Position position;
    private Random rand;

    private MQTTPublisher publisher;

    private static final int MOVE_INTERVAL = 60000;
    private static final int CHECK_MALFUNCTION_INTERVAL = 10000;
    private static final int CHECK_OTHER_ROBOTS_INTERVAL = 5000;
    public boolean malfunction;
    private int district;
    private int port;

    public RestClient rclient;

    private List<OtherRobot> otherRobots;

    private CommandLine commandLine;
    private long malfunctionTimestamp;
    public CleaningRobot(){
        running = false;

        otherRobots = new ArrayList<>();

        rclient = new RestClient("http://localhost:1337");

        init();

        /*System.out.println(id);
        System.out.println(district);
        System.out.println(port);*/

        ml = new MeasurementList();
        sensor = new PM10Simulator(ml);

        rand = new Random();

        publisher = new MQTTPublisher("tcp://localhost:1883", 15000, this);
        publisher.connect();

        commandLine = new CommandLine(this);

        GRPCServer server = new GRPCServer(this);
        server.start();
    }

    private void init() {
        ClientResponse getRobots = rclient.get("/getrobots");
        parseGetRobotsRESTMessage(getRobots.getEntity(String.class));
        ClientResponse initRobotData = rclient.get("/initrobot");
        if(initRobotData != null) {
            running = true;
            parseInitRobotRESTMessage(initRobotData.getEntity(String.class));
            introduce();
        }
    }

    private void parseInitRobotRESTMessage(String restMessage){
        String[] data = restMessage.split(";");
        id = Integer.parseInt(data[0]);
        district = Integer.parseInt(data[1]);
        port = Integer.parseInt(data[2]);
        int x = Integer.parseInt(data[3]);
        int y = Integer.parseInt(data[4]);
        position = new Position(x, y);
        System.out.println("My initial parameters gotten from the server - id: " + id + ", district: " + district + ", port: " + port + ", position: " + x + "," + y);
    }

    private void parseGetRobotsRESTMessage(String restMessage){
        if (restMessage.equals("")) {
            return;
        }
        System.out.println("List of other robots in Greenfield gotten from the server: " + restMessage);
        String[] robotData = restMessage.split(";");
        for (String s : robotData){
            String[] data = s.split(",");
            OtherRobot robot = new OtherRobot(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
            otherRobots.add(robot);
        }
    }

    public String createMqttMessage(){
        String mqttMessage = String.valueOf(id) + ",";
        List<Measurement> mList = ml.readAllAndClean();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        mqttMessage += timeStamp + ",";
        for (Measurement m : mList){
            mqttMessage += m.getValue() + " ";
        }
        return mqttMessage;
    }

    public void checkIfBroken(){
        int value = rand.nextInt(10);
        if (value == 1){
            malfunction = true;
        }
    }

    public void start() {
        sensor.start() ;
        publisher.start();
        commandLine.start();

        long robotMoveTime = System.currentTimeMillis();
        long lastRobotMoveTime = robotMoveTime;
        long checkRobotMalfunction = System.currentTimeMillis();
        long lastCheckRobotMalfunction = checkRobotMalfunction;
        long checkOtherRobotsTime = System.currentTimeMillis();
        long lastCheckOtherRobotsTime = checkOtherRobotsTime;
        while (running){
            if (robotMoveTime - lastRobotMoveTime >= MOVE_INTERVAL){
                lastRobotMoveTime = robotMoveTime;
                moveRobot();
            }
            if (checkRobotMalfunction - lastCheckRobotMalfunction >= CHECK_MALFUNCTION_INTERVAL){
                lastCheckRobotMalfunction = checkRobotMalfunction;
                checkIfBroken();
            }
            if (malfunction){
                System.out.println("Robot needs to go to the mechanic");
                malfunctionTimestamp = System.currentTimeMillis();
                int robotsCounter = otherRobots.size();
                requestGoingToMechanic();
                while (MechanicClient.getOkCounter() != otherRobots.size()){
                    // if new robots come to Greenfield during mutual exclusion algorithm
                    if (otherRobots.size() != robotsCounter){
                        int newRobots = otherRobots.size() - robotsCounter;
                        if (newRobots > 0) {
                            for (int i = 0; i < newRobots; i++) {
                                MechanicClient.mechanicRequest(this, otherRobots.get(otherRobots.size() - i - 1).port);
                            }
                        }
                    }
                    System.out.println("Waiting for 'ok' from all robots to go to the mechanic");
                }
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Robot fixed");
                malfunction = false;
                MechanicClient.resetOkCounter();
            }
            if (checkOtherRobotsTime - lastCheckOtherRobotsTime >= CHECK_OTHER_ROBOTS_INTERVAL){
                lastCheckOtherRobotsTime = checkOtherRobotsTime;
                for (int i = 0; i < otherRobots.size(); i++){
                    AliveClient.alive(this, otherRobots.get(i).port, otherRobots.get(i).id);
                }
            }
            robotMoveTime = System.currentTimeMillis();
            checkRobotMalfunction = System.currentTimeMillis();
            checkOtherRobotsTime = System.currentTimeMillis();
        }
    }

    private void moveRobot(){
        int moveX = rand.nextInt(2) - 1;
        int moveY = rand.nextInt(2) - 1;
        position.x += moveX;
        position.y += moveY;
        int lowerXLimit, upperXLimit, lowerYLimit, upperYLimit;
        if (district == 0){
            lowerXLimit = 0;
            upperXLimit = 4;
            lowerYLimit = 0;
            upperYLimit = 4;
        }
        else if (district == 1){
            lowerXLimit = 5;
            upperXLimit = 9;
            lowerYLimit = 0;
            upperYLimit = 4;
        }
        else if (district == 2){
            lowerXLimit = 5;
            upperXLimit = 9;
            lowerYLimit = 5;
            upperYLimit = 9;
        }
        else{
            lowerXLimit = 0;
            upperXLimit = 4;
            lowerYLimit = 5;
            upperYLimit = 9;
        }
        if (position.x < lowerXLimit) position.x = lowerXLimit;
        if (position.x > upperXLimit) position.x = upperXLimit;
        if (position.y < lowerYLimit) position.y = lowerYLimit;
        if (position.y > upperYLimit) position.y = upperYLimit;
    }

    public int getDistrict() {
        return district;
    }

    public void robotExit(){
        // send grpc to other robots and message to server
        for (OtherRobot r : otherRobots){
            ExitClient.exit(this, r.port);
        }
        while (ExitClient.getOkCounter() != otherRobots.size()){
            // if new robots come to Greenfield during mutual exclusion algorithm
            System.out.println("Waiting for 'ok' from all robots to exit Greenfield");
        }
        System.out.println("All robots sent 'ok' to exit Greenfield");
        ClientResponse getRobots = rclient.get("/exitrobot/" + id);
        String response = getRobots.getEntity(String.class);
        if (response.equals("ok")) {
            System.out.println("Server sent 'ok' to exit Greenfield");
            System.exit(0);
        }
    }

    public Position getPosition(){
        return position;
    }

    public int getId(){
        return id;
    }

    public int getPort(){
        return port;
    }

    public void addOtherRobot(OtherRobot otherRobot){
        otherRobots.add(otherRobot);
    }

    public void deleteOtherRobotById(int id){
        otherRobots.removeIf(otherRobot -> otherRobot.id == id);
    }

    public void deleteOtherRobotByPort(int port){
        otherRobots.removeIf(otherRobot -> otherRobot.port == port);
    }

    public void fillInformationAboutRobot(int port, Position position, int district){
        for (OtherRobot r : otherRobots){
            if (r.port == port){
                r.x = position.x;
                r.y = position.y;
                r.district = district;
                return;
            }
        }
    }

    public void introduce(){
        for (OtherRobot r : otherRobots){
            IntroduceClient.introduce(this, r.port);
        }
    }
    public void requestGoingToMechanic(){
        for (OtherRobot r : otherRobots){
            MechanicClient.mechanicRequest(this, r.port);
        }
    }

    public boolean getMalfunction(){
        return malfunction;
    }

    public long getMalfunctionTimestamp(){
        return malfunctionTimestamp;
    }
}
