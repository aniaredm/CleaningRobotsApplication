package unimi.redmerska.anna.services;

import unimi.redmerska.anna.MeasurementsManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/getaveragetimestamps")
public class GetAverageTimestamps {
    @Path("/{t1}/{t2}")
    @GET
    @Produces("text/plain")
    public String getAverageTimestamps(@PathParam("t1") long t1, @PathParam("t2") long t2){
        return MeasurementsManager.getInstance().getMessage(t1, t2);
    }
}
