package unimi.redmerska.anna.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import unimi.redmerska.anna.CleaningRobot;
import unimi.redmerska.anna.Mechanic;
import unimi.redmerska.anna.MechanicServiceGrpc;

public class MechanicClient {

    private static int okCounter = 0;
    public static void mechanicRequest(CleaningRobot robot, int port) {
        System.out.println("Requesting to go to mechanic from robot on port: " + port);
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
        MechanicServiceGrpc.MechanicServiceBlockingStub stub = MechanicServiceGrpc.newBlockingStub(channel);
        Mechanic.RequestMechanic request = Mechanic.RequestMechanic.newBuilder()
                .setId(robot.getId())
                .setTimestamp(Long.toString(robot.getMalfunctionTimestamp()))
                .build();
        Mechanic.ResponseMechanic response;
        response = stub.handleRequestMechanic(request);
        if (response.getOk().equals("ok")){
            okCounter++;
            System.out.println("I have got " + okCounter + " 'ok' answers from other robots.");
        }
        channel.shutdown();
        //System.out.println(response.getMessage());
    }

    public static int getOkCounter(){ return okCounter; }

    public static void resetOkCounter(){
        okCounter = 0;
    }
}
