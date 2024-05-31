package unimi.redmerska.anna.grpc;

import io.grpc.stub.StreamObserver;
import unimi.redmerska.anna.*;
import unimi.redmerska.anna.tools.Position;

public class ExitServiceImpl extends ExitServiceGrpc.ExitServiceImplBase{
    private CleaningRobot robot;
    public ExitServiceImpl(CleaningRobot robot){
        super();
        this.robot = robot;
    }

    @Override
    public void exit(Exit.ExitRequest request, StreamObserver<Exit.ExitResponse> responseObserver) {
        robot.deleteOtherRobotById(request.getId());
        System.out.println("Removing robot with id: " + request.getId() + " from my list.");
        Exit.ExitResponse response = Exit.ExitResponse.newBuilder()
                .setMessage("ok")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
