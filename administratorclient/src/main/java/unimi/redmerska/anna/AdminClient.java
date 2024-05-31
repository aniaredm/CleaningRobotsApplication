package unimi.redmerska.anna;

import com.sun.jersey.api.client.ClientResponse;
import unimi.redmerska.anna.rest.RestClient;

import java.util.Objects;
import java.util.Scanner;

public class AdminClient {
    private RestClient restClient;
    private static final int CHECK_INTERVAL = 10000;

    public AdminClient(){
        restClient = new RestClient("http://localhost:1337");
        start();
    }

    private boolean checkConnection(){
        ClientResponse response = restClient.get("/connect");
        if (response != null){
            return true;
        }
        return false;
    }

    private void start(){
        boolean connected = false;
        long checkTime = System.currentTimeMillis();
        long lastCheckTime = 0;
        while (!connected){
            if (checkTime - lastCheckTime >= CHECK_INTERVAL) connected = checkConnection();
        }
        while(connected){
            displayMenu();
        }
    }

    private void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Get the list of the cleaning robots currently located in Greenfield");
        System.out.println("2. Get the average of the last n air pollution levels sent to the server by a given robot");
        System.out.println("3. Get the average of the air pollution levels sent by all the robots to the server and occurred from timestamps t1 and t2");
        System.out.println("4. Close client");
        String v = scanner.next();
        while(!v.matches("[1-4]")){
            System.out.println("Invalid input!");
            displayMenu();
        }
        if (Integer.parseInt(v) == 1) getList();
        if (Integer.parseInt(v) == 2) {
            System.out.print("Enter number of air pollution levels n: ");
            String n = scanner.next();
            while (!n.matches("[1-9][0-9]*")){
                System.out.print("Number of air pollution levels must be an integer. Enter n again. n: ");
                n = scanner.next();
            }
            System.out.print("Enter the robot id: ");
            String id = scanner.next();
            while (!id.matches("[1-9][0-9]*")){
                System.out.print("Robot id must be an integer. Enter id again. id: ");
                id = scanner.next();
            }
            ClientResponse getAverage = restClient.get("/getaverage/" + Integer.parseInt(id) + "/" + Integer.parseInt(n));
            String response = getAverage.getEntity(String.class);
            if (Objects.equals(response, "-1.0")){
                System.out.println("There is no robot with id " + id + " in Greenfield");
            }
            else {
                System.out.println("The average of the last " + n + " air pollution levels sent to the server by a robot with id " + id + ": " + response);
            }
        }
        if (Integer.parseInt(v) == 3){
            boolean validInput = false;
            String t1 = "", t2 = "";
            while(!validInput) {
                System.out.print("Enter t1 as the milliseconds elapsed since the program started: ");
                t1 = scanner.next();
                while (!t1.matches("[0-9]*")) {
                    System.out.print("Robot id must be a long type. Enter t1 again. t1: ");
                    t1 = scanner.next();
                }
                System.out.print("Enter t2 as the milliseconds elapsed since the program started: ");
                t2 = scanner.next();
                while (!t2.matches("[0-9]*")) {
                    System.out.print("Robot id must be a long type. Enter t2 again. t2: ");
                    t2 = scanner.next();
                }
                if (Long.parseLong(t2) > Long.parseLong(t1)){
                    validInput = true;
                }
                else{
                    System.out.println("Invalid timestamps. T2 cannot be smaller than t1.");
                }
            }
            ClientResponse getAverage = restClient.get("/getaveragetimestamps/" + Long.parseLong(t1) + "/" + Long.parseLong(t2));
            String response = getAverage.getEntity(String.class);
            System.out.println("The average of the air pollution levels sent by all the robots to the server and occurred from timestamps "
                    + t1 + " and " + t2 + " : " + response);
        }
        if (Integer.parseInt(v) == 4){
            System.out.println("Closing client");
            System.exit(0);
        }
    }

    private void getList(){
        ClientResponse getRobots = restClient.get("/getrobots");
        System.out.println("The list of the cleaning robots currently located in Greenfield:");
        printGetRobotsRESTMessage(getRobots.getEntity(String.class));
    }

    private void printGetRobotsRESTMessage(String restMessage){
        if (restMessage.equals("")) {
            System.out.println("There are no working robots in Greenfield.");
            return;
        }
        String[] robotData = restMessage.split(";");
        for (String s : robotData){
            String[] data = s.split(",");
            if (data.length > 0) {
                System.out.println("Robot id: " + data[0] + " district: " + data[2]);
            }
        }
    }
}
