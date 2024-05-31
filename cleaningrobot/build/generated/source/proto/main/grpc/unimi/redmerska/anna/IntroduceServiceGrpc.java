package unimi.redmerska.anna;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: introduce.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IntroduceServiceGrpc {

  private IntroduceServiceGrpc() {}

  public static final String SERVICE_NAME = "IntroduceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<unimi.redmerska.anna.Introduce.IntroduceRequest,
      unimi.redmerska.anna.Introduce.IntroduceResponse> getIntroduceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "introduce",
      requestType = unimi.redmerska.anna.Introduce.IntroduceRequest.class,
      responseType = unimi.redmerska.anna.Introduce.IntroduceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<unimi.redmerska.anna.Introduce.IntroduceRequest,
      unimi.redmerska.anna.Introduce.IntroduceResponse> getIntroduceMethod() {
    io.grpc.MethodDescriptor<unimi.redmerska.anna.Introduce.IntroduceRequest, unimi.redmerska.anna.Introduce.IntroduceResponse> getIntroduceMethod;
    if ((getIntroduceMethod = IntroduceServiceGrpc.getIntroduceMethod) == null) {
      synchronized (IntroduceServiceGrpc.class) {
        if ((getIntroduceMethod = IntroduceServiceGrpc.getIntroduceMethod) == null) {
          IntroduceServiceGrpc.getIntroduceMethod = getIntroduceMethod =
              io.grpc.MethodDescriptor.<unimi.redmerska.anna.Introduce.IntroduceRequest, unimi.redmerska.anna.Introduce.IntroduceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "introduce"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  unimi.redmerska.anna.Introduce.IntroduceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  unimi.redmerska.anna.Introduce.IntroduceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IntroduceServiceMethodDescriptorSupplier("introduce"))
              .build();
        }
      }
    }
    return getIntroduceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IntroduceServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IntroduceServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IntroduceServiceStub>() {
        @java.lang.Override
        public IntroduceServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IntroduceServiceStub(channel, callOptions);
        }
      };
    return IntroduceServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IntroduceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IntroduceServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IntroduceServiceBlockingStub>() {
        @java.lang.Override
        public IntroduceServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IntroduceServiceBlockingStub(channel, callOptions);
        }
      };
    return IntroduceServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IntroduceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IntroduceServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IntroduceServiceFutureStub>() {
        @java.lang.Override
        public IntroduceServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IntroduceServiceFutureStub(channel, callOptions);
        }
      };
    return IntroduceServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void introduce(unimi.redmerska.anna.Introduce.IntroduceRequest request,
        io.grpc.stub.StreamObserver<unimi.redmerska.anna.Introduce.IntroduceResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIntroduceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service IntroduceService.
   */
  public static abstract class IntroduceServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return IntroduceServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service IntroduceService.
   */
  public static final class IntroduceServiceStub
      extends io.grpc.stub.AbstractAsyncStub<IntroduceServiceStub> {
    private IntroduceServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IntroduceServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IntroduceServiceStub(channel, callOptions);
    }

    /**
     */
    public void introduce(unimi.redmerska.anna.Introduce.IntroduceRequest request,
        io.grpc.stub.StreamObserver<unimi.redmerska.anna.Introduce.IntroduceResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIntroduceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service IntroduceService.
   */
  public static final class IntroduceServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IntroduceServiceBlockingStub> {
    private IntroduceServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IntroduceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IntroduceServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public unimi.redmerska.anna.Introduce.IntroduceResponse introduce(unimi.redmerska.anna.Introduce.IntroduceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIntroduceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service IntroduceService.
   */
  public static final class IntroduceServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<IntroduceServiceFutureStub> {
    private IntroduceServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IntroduceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IntroduceServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<unimi.redmerska.anna.Introduce.IntroduceResponse> introduce(
        unimi.redmerska.anna.Introduce.IntroduceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIntroduceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INTRODUCE = 0;

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
        case METHODID_INTRODUCE:
          serviceImpl.introduce((unimi.redmerska.anna.Introduce.IntroduceRequest) request,
              (io.grpc.stub.StreamObserver<unimi.redmerska.anna.Introduce.IntroduceResponse>) responseObserver);
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
          getIntroduceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              unimi.redmerska.anna.Introduce.IntroduceRequest,
              unimi.redmerska.anna.Introduce.IntroduceResponse>(
                service, METHODID_INTRODUCE)))
        .build();
  }

  private static abstract class IntroduceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IntroduceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return unimi.redmerska.anna.Introduce.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IntroduceService");
    }
  }

  private static final class IntroduceServiceFileDescriptorSupplier
      extends IntroduceServiceBaseDescriptorSupplier {
    IntroduceServiceFileDescriptorSupplier() {}
  }

  private static final class IntroduceServiceMethodDescriptorSupplier
      extends IntroduceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    IntroduceServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (IntroduceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IntroduceServiceFileDescriptorSupplier())
              .addMethod(getIntroduceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
