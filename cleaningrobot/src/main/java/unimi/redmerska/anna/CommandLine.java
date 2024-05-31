package unimi.redmerska.anna;

import java.util.Scanner;

public class CommandLine extends Thread{
    private CleaningRobot robot;
    public CommandLine(CleaningRobot robot){
        this.robot = robot;
    }
    public void run(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            if (input.toLowerCase().equals("quit")){
                while(robot.getMalfunction()) {
                    System.out.println("Waiting for the robot to get fixed before leaving Greenfield");
                }
                robot.robotExit();
            }
            if (input.toLowerCase().equals("fix")){
                robot.malfunction = true;
            }
        }
    }
}
