package unimi.redmerska.anna.grpc;

import io.grpc.stub.StreamObserver;
import unimi.redmerska.anna.CleaningRobot;
import unimi.redmerska.anna.Mechanic;
import unimi.redmerska.anna.MechanicServiceGrpc;

import java.util.ArrayList;
import java.util.List;

public class MechanicServiceImpl extends MechanicServiceGrpc.MechanicServiceImplBase{
    private CleaningRobot robot;
    //private List<StreamObserver<Mechanic.ResponseMechanic>> mechanicQueue;

    public MechanicServiceImpl(CleaningRobot robot){
        super();
        this.robot = robot;
        //mechanicQueue = new ArrayList<>();
    }
    @Override
    public void handleRequestMechanic(Mechanic.RequestMechanic request, StreamObserver<Mechanic.ResponseMechanic> responseObserver) {
        System.out.println("Got the request from robot with id: " + request.getId() + " to give my permission to be fixed.");
        Mechanic.ResponseMechanic response = Mechanic.ResponseMechanic.newBuilder().setOk("ok").build();
        if (robot.getMalfunction()){
            if (robot.getMalfunctionTimestamp() < Long.parseLong(request.getTimestamp())){
                //mechanicQueue.add(responseObserver);
                System.out.println("Added robot with id: " + request.getId() + " and request timestamp: " + request.getTimestamp() + " to the queue.");
                while(robot.getMalfunction()){
                    System.out.println("Fixing");
                }
                /*for (StreamObserver<Mechanic.ResponseMechanic> otherRobotResponse : mechanicQueue){
                    System.out.println("Giving my permission to be fixed to the robot with id  " + request.getId());
                    otherRobotResponse.onNext(response);
                    otherRobotResponse.onCompleted();
                }
                mechanicQueue.clear();*/
                System.out.println("Giving my permission to be fixed to the robot with id  " + request.getId());
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
            else{
                System.out.println("Giving my permission to be fixed to the robot with id  " + request.getId());
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        }
        else{
            System.out.println("Giving my permission to be fixed to the robot with id  " + request.getId());
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
