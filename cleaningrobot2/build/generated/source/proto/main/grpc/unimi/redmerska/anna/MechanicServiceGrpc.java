package unimi.redmerska.anna;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: mechanic.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MechanicServiceGrpc {

  private MechanicServiceGrpc() {}

  public static final String SERVICE_NAME = "MechanicService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<unimi.redmerska.anna.Mechanic.RequestMechanic,
      unimi.redmerska.anna.Mechanic.ResponseMechanic> getHandleRequestMechanicMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "handleRequestMechanic",
      requestType = unimi.redmerska.anna.Mechanic.RequestMechanic.class,
      responseType = unimi.redmerska.anna.Mechanic.ResponseMechanic.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<unimi.redmerska.anna.Mechanic.RequestMechanic,
      unimi.redmerska.anna.Mechanic.ResponseMechanic> getHandleRequestMechanicMethod() {
    io.grpc.MethodDescriptor<unimi.redmerska.anna.Mechanic.RequestMechanic, unimi.redmerska.anna.Mechanic.ResponseMechanic> getHandleRequestMechanicMethod;
    if ((getHandleRequestMechanicMethod = MechanicServiceGrpc.getHandleRequestMechanicMethod) == null) {
      synchronized (MechanicServiceGrpc.class) {
        if ((getHandleRequestMechanicMethod = MechanicServiceGrpc.getHandleRequestMechanicMethod) == null) {
          MechanicServiceGrpc.getHandleRequestMechanicMethod = getHandleRequestMechanicMethod =
              io.grpc.MethodDescriptor.<unimi.redmerska.anna.Mechanic.RequestMechanic, unimi.redmerska.anna.Mechanic.ResponseMechanic>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "handleRequestMechanic"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  unimi.redmerska.anna.Mechanic.RequestMechanic.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  unimi.redmerska.anna.Mechanic.ResponseMechanic.getDefaultInstance()))
              .setSchemaDescriptor(new MechanicServiceMethodDescriptorSupplier("handleRequestMechanic"))
              .build();
        }
      }
    }
    return getHandleRequestMechanicMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MechanicServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MechanicServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MechanicServiceStub>() {
        @java.lang.Override
        public MechanicServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MechanicServiceStub(channel, callOptions);
        }
      };
    return MechanicServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MechanicServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MechanicServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MechanicServiceBlockingStub>() {
        @java.lang.Override
        public MechanicServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MechanicServiceBlockingStub(channel, callOptions);
        }
      };
    return MechanicServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MechanicServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MechanicServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MechanicServiceFutureStub>() {
        @java.lang.Override
        public MechanicServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MechanicServiceFutureStub(channel, callOptions);
        }
      };
    return MechanicServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void handleRequestMechanic(unimi.redmerska.anna.Mechanic.RequestMechanic request,
        io.grpc.stub.StreamObserver<unimi.redmerska.anna.Mechanic.ResponseMechanic> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHandleRequestMechanicMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MechanicService.
   */
  public static abstract class MechanicServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MechanicServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MechanicService.
   */
  public static final class MechanicServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MechanicServiceStub> {
    private MechanicServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MechanicServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MechanicServiceStub(channel, callOptions);
    }

    /**
     */
    public void handleRequestMechanic(unimi.redmerska.anna.Mechanic.RequestMechanic request,
        io.grpc.stub.StreamObserver<unimi.redmerska.anna.Mechanic.ResponseMechanic> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHandleRequestMechanicMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MechanicService.
   */
  public static final class MechanicServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MechanicServiceBlockingStub> {
    private MechanicServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MechanicServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MechanicServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public unimi.redmerska.anna.Mechanic.ResponseMechanic handleRequestMechanic(unimi.redmerska.anna.Mechanic.RequestMechanic request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHandleRequestMechanicMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MechanicService.
   */
  public static final class MechanicServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MechanicServiceFutureStub> {
    private MechanicServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MechanicServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MechanicServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<unimi.redmerska.anna.Mechanic.ResponseMechanic> handleRequestMechanic(
        unimi.redmerska.anna.Mechanic.RequestMechanic request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHandleRequestMechanicMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HANDLE_REQUEST_MECHANIC = 0;

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
        case METHODID_HANDLE_REQUEST_MECHANIC:
          serviceImpl.handleRequestMechanic((unimi.redmerska.anna.Mechanic.RequestMechanic) request,
              (io.grpc.stub.StreamObserver<unimi.redmerska.anna.Mechanic.ResponseMechanic>) responseObserver);
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
          getHandleRequestMechanicMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              unimi.redmerska.anna.Mechanic.RequestMechanic,
              unimi.redmerska.anna.Mechanic.ResponseMechanic>(
                service, METHODID_HANDLE_REQUEST_MECHANIC)))
        .build();
  }

  private static abstract class MechanicServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MechanicServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return unimi.redmerska.anna.Mechanic.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MechanicService");
    }
  }

  private static final class MechanicServiceFileDescriptorSupplier
      extends MechanicServiceBaseDescriptorSupplier {
    MechanicServiceFileDescriptorSupplier() {}
  }

  private static final class MechanicServiceMethodDescriptorSupplier
      extends MechanicServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MechanicServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MechanicServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MechanicServiceFileDescriptorSupplier())
              .addMethod(getHandleRequestMechanicMethod())
              .build();
        }
      }
    }
    return result;
  }
}
