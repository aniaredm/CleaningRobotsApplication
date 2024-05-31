package unimi.redmerska.anna.grpc;

import io.grpc.stub.StreamObserver;
import unimi.redmerska.anna.*;
import unimi.redmerska.anna.tools.Position;

public class IntroduceServiceImpl extends IntroduceServiceGrpc.IntroduceServiceImplBase{
    private CleaningRobot robot;
    public IntroduceServiceImpl(CleaningRobot robot){
        super();
        this.robot = robot;
    }

    @Override
    public void introduce(Introduce.IntroduceRequest request, StreamObserver<Introduce.IntroduceResponse> responseObserver) {
        Position position = new Position(request.getX(), request.getY());
        int district = request.getDistrict();
        int id = request.getId();
        int port = request.getPort();
        OtherRobot otherRobot = new OtherRobot(id, port);
        otherRobot.x = position.x;
        otherRobot.y = position.y;
        otherRobot.district = district;
        System.out.println("Adding robot with id: " + id + " to my list.");
        robot.addOtherRobot(otherRobot);
        Introduce.IntroduceResponse response = Introduce.IntroduceResponse.newBuilder()
                .setX(robot.getPosition().x)
                .setY(robot.getPosition().y)
                .setDistrict(robot.getDistrict())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
