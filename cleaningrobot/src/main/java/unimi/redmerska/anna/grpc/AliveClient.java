package unimi.redmerska.anna.grpc;

import com.sun.jersey.api.client.ClientResponse;
import io.grpc.Context;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import unimi.redmerska.anna.AliveServiceGrpc;
import unimi.redmerska.anna.CheckIfAlive;
import unimi.redmerska.anna.CleaningRobot;
import unimi.redmerska.anna.rest.RestClient;
import unimi.redmerska.anna.tools.Position;

import java.util.concurrent.TimeUnit;

public class AliveClient {
    private static long deadlineMs = 2000;

    public static void alive(CleaningRobot robot, int port, int id) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
        AliveServiceGrpc.AliveServiceBlockingStub stub = AliveServiceGrpc.newBlockingStub(channel);
        CheckIfAlive.AliveRequest request = CheckIfAlive.AliveRequest.newBuilder()
                .setMessage("are you alive")
                .build();
        try {
            CheckIfAlive.AliveResponse response = stub.withDeadlineAfter(deadlineMs, TimeUnit.MILLISECONDS).alive(request);
        } catch (Exception e) {
            System.out.println("Robot on port " + port + " is not answering. Removing it from my list.");
            ClientResponse getRobots = robot.rclient.get("/exitrobot/" + id);
            robot.deleteOtherRobotByPort(port);
        }
        channel.shutdown();
        //System.out.println(response.getMessage());
    }
}