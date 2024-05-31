package unimi.redmerska.anna.services;

import unimi.redmerska.anna.RobotManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/getmeasurementslist")
public class GetMeasurementsList {
    @GET
    @Produces("text/plain")
    public String getMeasurementsList(){
        return RobotManager.getInstance().toString();
    }
}
