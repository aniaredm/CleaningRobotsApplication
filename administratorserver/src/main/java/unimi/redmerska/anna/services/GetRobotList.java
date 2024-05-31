package unimi.redmerska.anna.services;

import unimi.redmerska.anna.RobotManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/getrobots")
public class GetRobotList {
    @GET
    @Produces("text/plain")
    public String getRobotList(){
        return RobotManager.getInstance().toString();
    }
}
