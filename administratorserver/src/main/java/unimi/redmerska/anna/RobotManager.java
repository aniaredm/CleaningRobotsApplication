package unimi.redmerska.anna;

import unimi.redmerska.anna.tools.Position;

import java.util.*;

public class RobotManager {
    private HashMap<Integer ,List<CleaningRobot>> robots;

    private static final RobotManager ROBOT_MANAGER = new RobotManager();

    public static RobotManager getInstance(){
        return ROBOT_MANAGER;
    }

    private RobotManager(){
        robots = new HashMap<>();
        for (int i = 0; i < 4; i++){
            robots.put(i, new ArrayList<>());
        }
    }

    public CleaningRobot addRobot(){
        int id = CleaningRobot.assignID();
        int district = findBestDistrict();
        int port = CleaningRobot.assignGrpcPort();
        Position position =getInitialPos(district);
        String address = "localhost";
        CleaningRobot robot = new CleaningRobot(id, district, port, position, address);
        robots.get(district).add(robot);
        System.out.println("Added robot with id: " + id + " to Greenfield.");
        return robot;
    }

    private Position getInitialPos(int district){
        int x, y;
        Random rand = new Random();
        x = rand.nextInt(5);
        y = rand.nextInt(5);
        if (district == 1) x += 5;
        else if (district == 2){
            x += 5;
            y += 5;
        }
        else if (district == 3) y += 5;
        Position position = new Position(x, y);
        return position;
    }

    private int findBestDistrict(){
        int minDistrict = 0;
        int minSize = -1;
        for (int i = 0; i < robots.size(); i++){
            List<CleaningRobot> list = robots.get(i);
            if (list.size() < minSize || minSize == -1){
                minSize = list.size();
                minDistrict = i;
            }
        }
        return minDistrict;
    }

    public String toString(){
        String s = "";
        for (List<CleaningRobot> district : robots.values()){
            for (CleaningRobot robot : district){
                s += String.valueOf(robot.id) + "," + String.valueOf(robot.port) + "," + String.valueOf(robot.district) + ";";
            }
        }
        return s;
    }

    public void removeRobot(int id){
        for (List<CleaningRobot> list : robots.values()){
            list.removeIf(robot -> robot.id == id);
            System.out.println("Removed robot with id: " + id + " from Greenfield.");
        }
    }

}
