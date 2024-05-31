package unimi.redmerska.anna.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import unimi.redmerska.anna.*;
import unimi.redmerska.anna.tools.Position;

public class ExitClient {
    private static int okCounter = 0;
    public static void exit(CleaningRobot robot, int port) {
        System.out.println("Requesting to leave Greenfield from robot on port: " + port);
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
        ExitServiceGrpc.ExitServiceBlockingStub stub = ExitServiceGrpc.newBlockingStub(channel);
        Exit.ExitRequest request = Exit.ExitRequest.newBuilder()
                .setId(robot.getId())
                .build();
        Exit.ExitResponse response;
        response = stub.exit(request);
        if (response.getMessage().equals("ok")){
            okCounter++;
            System.out.println(okCounter);
        }
        channel.shutdown();
        //System.out.println(response.getMessage());
    }

    public static int getOkCounter(){
        return okCounter;
    }
}