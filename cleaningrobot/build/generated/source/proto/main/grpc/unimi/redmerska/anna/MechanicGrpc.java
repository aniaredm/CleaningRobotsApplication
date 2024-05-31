package unimi.redmerska.anna;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: mechanic.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MechanicGrpc {

  private MechanicGrpc() {}

  public static final String SERVICE_NAME = "Mechanic";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<unimi.redmerska.anna.MechanicOuterClass.RequestMechanic,
      unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic> getHandleRequestMechanicMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "handleRequestMechanic",
      requestType = unimi.redmerska.anna.MechanicOuterClass.RequestMechanic.class,
      responseType = unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<unimi.redmerska.anna.MechanicOuterClass.RequestMechanic,
      unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic> getHandleRequestMechanicMethod() {
    io.grpc.MethodDescriptor<unimi.redmerska.anna.MechanicOuterClass.RequestMechanic, unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic> getHandleRequestMechanicMethod;
    if ((getHandleRequestMechanicMethod = MechanicGrpc.getHandleRequestMechanicMethod) == null) {
      synchronized (MechanicGrpc.class) {
        if ((getHandleRequestMechanicMethod = MechanicGrpc.getHandleRequestMechanicMethod) == null) {
          MechanicGrpc.getHandleRequestMechanicMethod = getHandleRequestMechanicMethod =
              io.grpc.MethodDescriptor.<unimi.redmerska.anna.MechanicOuterClass.RequestMechanic, unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "handleRequestMechanic"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  unimi.redmerska.anna.MechanicOuterClass.RequestMechanic.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic.getDefaultInstance()))
              .setSchemaDescriptor(new MechanicMethodDescriptorSupplier("handleRequestMechanic"))
              .build();
        }
      }
    }
    return getHandleRequestMechanicMethod;
  }

  private static volatile io.grpc.MethodDescriptor<unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic,
      unimi.redmerska.anna.MechanicOuterClass.RequestMechanic> getRequestMechanicMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "requestMechanic",
      requestType = unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic.class,
      responseType = unimi.redmerska.anna.MechanicOuterClass.RequestMechanic.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic,
      unimi.redmerska.anna.MechanicOuterClass.RequestMechanic> getRequestMechanicMethod() {
    io.grpc.MethodDescriptor<unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic, unimi.redmerska.anna.MechanicOuterClass.RequestMechanic> getRequestMechanicMethod;
    if ((getRequestMechanicMethod = MechanicGrpc.getRequestMechanicMethod) == null) {
      synchronized (MechanicGrpc.class) {
        if ((getRequestMechanicMethod = MechanicGrpc.getRequestMechanicMethod) == null) {
          MechanicGrpc.getRequestMechanicMethod = getRequestMechanicMethod =
              io.grpc.MethodDescriptor.<unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic, unimi.redmerska.anna.MechanicOuterClass.RequestMechanic>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "requestMechanic"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  unimi.redmerska.anna.MechanicOuterClass.RequestMechanic.getDefaultInstance()))
              .setSchemaDescriptor(new MechanicMethodDescriptorSupplier("requestMechanic"))
              .build();
        }
      }
    }
    return getRequestMechanicMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MechanicStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MechanicStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MechanicStub>() {
        @java.lang.Override
        public MechanicStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MechanicStub(channel, callOptions);
        }
      };
    return MechanicStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MechanicBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MechanicBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MechanicBlockingStub>() {
        @java.lang.Override
        public MechanicBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MechanicBlockingStub(channel, callOptions);
        }
      };
    return MechanicBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MechanicFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MechanicFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MechanicFutureStub>() {
        @java.lang.Override
        public MechanicFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MechanicFutureStub(channel, callOptions);
        }
      };
    return MechanicFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void handleRequestMechanic(unimi.redmerska.anna.MechanicOuterClass.RequestMechanic request,
        io.grpc.stub.StreamObserver<unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHandleRequestMechanicMethod(), responseObserver);
    }

    /**
     */
    default void requestMechanic(unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic request,
        io.grpc.stub.StreamObserver<unimi.redmerska.anna.MechanicOuterClass.RequestMechanic> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestMechanicMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Mechanic.
   */
  public static abstract class MechanicImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MechanicGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Mechanic.
   */
  public static final class MechanicStub
      extends io.grpc.stub.AbstractAsyncStub<MechanicStub> {
    private MechanicStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MechanicStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MechanicStub(channel, callOptions);
    }

    /**
     */
    public void handleRequestMechanic(unimi.redmerska.anna.MechanicOuterClass.RequestMechanic request,
        io.grpc.stub.StreamObserver<unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHandleRequestMechanicMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void requestMechanic(unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic request,
        io.grpc.stub.StreamObserver<unimi.redmerska.anna.MechanicOuterClass.RequestMechanic> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRequestMechanicMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Mechanic.
   */
  public static final class MechanicBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MechanicBlockingStub> {
    private MechanicBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MechanicBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MechanicBlockingStub(channel, callOptions);
    }

    /**
     */
    public unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic handleRequestMechanic(unimi.redmerska.anna.MechanicOuterClass.RequestMechanic request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHandleRequestMechanicMethod(), getCallOptions(), request);
    }

    /**
     */
    public unimi.redmerska.anna.MechanicOuterClass.RequestMechanic requestMechanic(unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestMechanicMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Mechanic.
   */
  public static final class MechanicFutureStub
      extends io.grpc.stub.AbstractFutureStub<MechanicFutureStub> {
    private MechanicFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MechanicFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MechanicFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic> handleRequestMechanic(
        unimi.redmerska.anna.MechanicOuterClass.RequestMechanic request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHandleRequestMechanicMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<unimi.redmerska.anna.MechanicOuterClass.RequestMechanic> requestMechanic(
        unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRequestMechanicMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HANDLE_REQUEST_MECHANIC = 0;
  private static final int METHODID_REQUEST_MECHANIC = 1;

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
          serviceImpl.handleRequestMechanic((unimi.redmerska.anna.MechanicOuterClass.RequestMechanic) request,
              (io.grpc.stub.StreamObserver<unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic>) responseObserver);
          break;
        case METHODID_REQUEST_MECHANIC:
          serviceImpl.requestMechanic((unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic) request,
              (io.grpc.stub.StreamObserver<unimi.redmerska.anna.MechanicOuterClass.RequestMechanic>) responseObserver);
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
              unimi.redmerska.anna.MechanicOuterClass.RequestMechanic,
              unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic>(
                service, METHODID_HANDLE_REQUEST_MECHANIC)))
        .addMethod(
          getRequestMechanicMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              unimi.redmerska.anna.MechanicOuterClass.ResponseMechanic,
              unimi.redmerska.anna.MechanicOuterClass.RequestMechanic>(
                service, METHODID_REQUEST_MECHANIC)))
        .build();
  }

  private static abstract class MechanicBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MechanicBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return unimi.redmerska.anna.MechanicOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Mechanic");
    }
  }

  private static final class MechanicFileDescriptorSupplier
      extends MechanicBaseDescriptorSupplier {
    MechanicFileDescriptorSupplier() {}
  }

  private static final class MechanicMethodDescriptorSupplier
      extends MechanicBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MechanicMethodDescriptorSupplier(String methodName) {
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
      synchronized (MechanicGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MechanicFileDescriptorSupplier())
              .addMethod(getHandleRequestMechanicMethod())
              .addMethod(getRequestMechanicMethod())
              .build();
        }
      }
    }
    return result;
  }
}
