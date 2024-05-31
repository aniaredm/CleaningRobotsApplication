package unimi.redmerska.anna.services;

import unimi.redmerska.anna.MeasurementsManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/getaverage")
public class GetAverage {
    @Path("/{id}/{n}")
    @GET
    @Produces("text/plain")
    public String getAverage(@PathParam("id") int id, @PathParam("n") int n){
        System.out.println(id + " " + n);
        return MeasurementsManager.getInstance().toString(id, n);
    }
}
