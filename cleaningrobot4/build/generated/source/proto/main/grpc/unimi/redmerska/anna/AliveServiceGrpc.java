package unimi.redmerska.anna;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: checkIfAlive.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AliveServiceGrpc {

  private AliveServiceGrpc() {}

  public static final String SERVICE_NAME = "AliveService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<unimi.redmerska.anna.CheckIfAlive.AliveRequest,
      unimi.redmerska.anna.CheckIfAlive.AliveResponse> getAliveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "alive",
      requestType = unimi.redmerska.anna.CheckIfAlive.AliveRequest.class,
      responseType = unimi.redmerska.anna.CheckIfAlive.AliveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<unimi.redmerska.anna.CheckIfAlive.AliveRequest,
      unimi.redmerska.anna.CheckIfAlive.AliveResponse> getAliveMethod() {
    io.grpc.MethodDescriptor<unimi.redmerska.anna.CheckIfAlive.AliveRequest, unimi.redmerska.anna.CheckIfAlive.AliveResponse> getAliveMethod;
    if ((getAliveMethod = AliveServiceGrpc.getAliveMethod) == null) {
      synchronized (AliveServiceGrpc.class) {
        if ((getAliveMethod = AliveServiceGrpc.getAliveMethod) == null) {
          AliveServiceGrpc.getAliveMethod = getAliveMethod =
              io.grpc.MethodDescriptor.<unimi.redmerska.anna.CheckIfAlive.AliveRequest, unimi.redmerska.anna.CheckIfAlive.AliveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "alive"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  unimi.redmerska.anna.CheckIfAlive.AliveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  unimi.redmerska.anna.CheckIfAlive.AliveResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AliveServiceMethodDescriptorSupplier("alive"))
              .build();
        }
      }
    }
    return getAliveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AliveServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AliveServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AliveServiceStub>() {
        @java.lang.Override
        public AliveServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AliveServiceStub(channel, callOptions);
        }
      };
    return AliveServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AliveServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AliveServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AliveServiceBlockingStub>() {
        @java.lang.Override
        public AliveServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AliveServiceBlockingStub(channel, callOptions);
        }
      };
    return AliveServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AliveServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AliveServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AliveServiceFutureStub>() {
        @java.lang.Override
        public AliveServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AliveServiceFutureStub(channel, callOptions);
        }
      };
    return AliveServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void alive(unimi.redmerska.anna.CheckIfAlive.AliveRequest request,
        io.grpc.stub.StreamObserver<unimi.redmerska.anna.CheckIfAlive.AliveResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAliveMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AliveService.
   */
  public static abstract class AliveServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AliveServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AliveService.
   */
  public static final class AliveServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AliveServiceStub> {
    private AliveServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AliveServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AliveServiceStub(channel, callOptions);
    }

    /**
     */
    public void alive(unimi.redmerska.anna.CheckIfAlive.AliveRequest request,
        io.grpc.stub.StreamObserver<unimi.redmerska.anna.CheckIfAlive.AliveResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAliveMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AliveService.
   */
  public static final class AliveServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AliveServiceBlockingStub> {
    private AliveServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AliveServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AliveServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public unimi.redmerska.anna.CheckIfAlive.AliveResponse alive(unimi.redmerska.anna.CheckIfAlive.AliveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAliveMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AliveService.
   */
  public static final class AliveServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AliveServiceFutureStub> {
    private AliveServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AliveServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AliveServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<unimi.redmerska.anna.CheckIfAlive.AliveResponse> alive(
        unimi.redmerska.anna.CheckIfAlive.AliveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAliveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ALIVE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ALIVE:
          serviceImpl.alive((unimi.redmerska.anna.CheckIfAlive.AliveRequest) request,
              (io.grpc.stub.StreamObserver<unimi.redmerska.anna.CheckIfAlive.AliveResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAliveMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              unimi.redmerska.anna.CheckIfAlive.AliveRequest,
              unimi.redmerska.anna.CheckIfAlive.AliveResponse>(
                service, METHODID_ALIVE)))
        .build();
  }

  private static abstract class AliveServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AliveServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return unimi.redmerska.anna.CheckIfAlive.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AliveService");
    }
  }

  private static final class AliveServiceFileDescriptorSupplier
      extends AliveServiceBaseDescriptorSupplier {
    AliveServiceFileDescriptorSupplier() {}
  }

  private static final class AliveServiceMethodDescriptorSupplier
      extends AliveServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AliveServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AliveServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AliveServiceFileDescriptorSupplier())
              .addMethod(getAliveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
