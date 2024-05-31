package unimi.redmerska.anna.services;

import unimi.redmerska.anna.CleaningRobot;
import unimi.redmerska.anna.RobotManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/initrobot")
public class InitRobot {
    @GET
    @Produces("text/plain")
    public String initRobot(){
        CleaningRobot robot = RobotManager.getInstance().addRobot();
        return robot.toString();
    }


}
