package unimi.redmerska.anna.rest;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {
    private String serverAddress;

    private Client client;

    public RestClient(String serverAddress) {
        this.serverAddress = serverAddress;
        client = Client.create();
    }

    public ClientResponse get(String path) {
        String fullAddress = serverAddress + path;
        ClientResponse response = getRequest(client, fullAddress);
        return response;
    }

    public static ClientResponse getRequest(Client client, String url){
        WebResource webResource = client.resource(url);
        try {
            return webResource.type("application/json").get(ClientResponse.class);
        } catch (ClientHandlerException e) {
            System.out.println("Server not responding.");
            return null;
        }
    }
}
