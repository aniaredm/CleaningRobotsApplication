package unimi.redmerska.anna.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import unimi.redmerska.anna.CleaningRobot;

import java.io.IOException;

public class GRPCServer extends Thread{
    private Server server;
    private CleaningRobot robot;

    public GRPCServer(CleaningRobot robot){
        this.robot = robot;
    }

    public void run() {
        try {
            server = ServerBuilder.forPort(robot.getPort())
                    .addService(new IntroduceServiceImpl(robot))
                    .addService(new MechanicServiceImpl(robot))
                    .addService(new ExitServiceImpl(robot))
                    .addService(new AliveServiceImpl())
                    .build()
                    .start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("GRPC server is running");
        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
