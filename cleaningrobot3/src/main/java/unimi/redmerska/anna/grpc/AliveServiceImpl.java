package unimi.redmerska.anna.grpc;

import io.grpc.stub.StreamObserver;
import unimi.redmerska.anna.AliveServiceGrpc;
import unimi.redmerska.anna.CheckIfAlive;

public class AliveServiceImpl extends AliveServiceGrpc.AliveServiceImplBase{
    @Override
    public void alive(CheckIfAlive.AliveRequest request, StreamObserver<CheckIfAlive.AliveResponse> responseObserver) {
        CheckIfAlive.AliveResponse response = CheckIfAlive.AliveResponse.newBuilder()
                .setMessage("alive")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
