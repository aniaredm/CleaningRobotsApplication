package unimi.redmerska.anna.services;

import unimi.redmerska.anna.RobotManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/exitrobot")
public class ExitRobot {
    @Path("/{id}")
    @GET
    @Produces("text/plain")
    public String exitRobot(@PathParam("id") int id){
        RobotManager.getInstance().removeRobot(id);
        return "ok";
    }
}
