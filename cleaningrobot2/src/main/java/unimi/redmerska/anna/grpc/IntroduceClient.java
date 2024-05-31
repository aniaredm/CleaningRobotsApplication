package unimi.redmerska.anna.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import unimi.redmerska.anna.CleaningRobot;
import unimi.redmerska.anna.Introduce;
import unimi.redmerska.anna.IntroduceServiceGrpc;
import unimi.redmerska.anna.tools.Position;

public class IntroduceClient {
    public static void introduce(CleaningRobot robot, int port) {
        System.out.println("Introducing myself to robot on port: " + port);
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
        IntroduceServiceGrpc.IntroduceServiceBlockingStub stub = IntroduceServiceGrpc.newBlockingStub(channel);
        Introduce.IntroduceRequest request = Introduce.IntroduceRequest.newBuilder()
                .setX(robot.getPosition().x)
                .setY(robot.getPosition().y)
                .setDistrict(robot.getDistrict())
                .setId(robot.getId())
                .setPort(robot.getPort())
                .build();
        Introduce.IntroduceResponse response;
        response = stub.introduce(request);
        Position position = new Position(response.getX(), response.getY());
        int district = response.getDistrict();
        robot.fillInformationAboutRobot(port, position, district);
        channel.shutdown();
    }
}
