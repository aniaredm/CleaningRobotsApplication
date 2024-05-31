package unimi.redmerska.anna.rest;

import com.sun.net.httpserver.HttpServer;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;

import java.io.IOException;

public class RESTServer {

    public RESTServer(String host, int port) {
        HttpServer server = null;
        try {
            server = HttpServerFactory.create("http://"+host+":"+port+"/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        server.start();
    }

}
