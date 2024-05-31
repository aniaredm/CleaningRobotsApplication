package unimi.redmerska.anna.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/connect")
public class Connect {

    @GET
    @Produces("text/plain")
    public String connect(){
        return "Connected to the server!";
    }

}

