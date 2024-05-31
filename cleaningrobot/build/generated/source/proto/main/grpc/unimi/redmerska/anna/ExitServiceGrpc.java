package unimi.redmerska.anna;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: exit.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ExitServiceGrpc {

  private ExitServiceGrpc() {}

  public static final String SERVICE_NAME = "ExitService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<unimi.redmerska.anna.Exit.ExitRequest,
      unimi.redmerska.anna.Exit.ExitResponse> getExitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "exit",
      requestType = unimi.redmerska.anna.Exit.ExitRequest.class,
      responseType = unimi.redmerska.anna.Exit.ExitResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<unimi.redmerska.anna.Exit.ExitRequest,
      unimi.redmerska.anna.Exit.ExitResponse> getExitMethod() {
    io.grpc.MethodDescriptor<unimi.redmerska.anna.Exit.ExitRequest, unimi.redmerska.anna.Exit.ExitResponse> getExitMethod;
    if ((getExitMethod = ExitServiceGrpc.getExitMethod) == null) {
      synchronized (ExitServiceGrpc.class) {
        if ((getExitMethod = ExitServiceGrpc.getExitMethod) == null) {
          ExitServiceGrpc.getExitMethod = getExitMethod =
              io.grpc.MethodDescriptor.<unimi.redmerska.anna.Exit.ExitRequest, unimi.redmerska.anna.Exit.ExitResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "exit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  unimi.redmerska.anna.Exit.ExitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  unimi.redmerska.anna.Exit.ExitResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExitServiceMethodDescriptorSupplier("exit"))
              .build();
        }
      }
    }
    return getExitMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ExitServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExitServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExitServiceStub>() {
        @java.lang.Override
        public ExitServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExitServiceStub(channel, callOptions);
        }
      };
    return ExitServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExitServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExitServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExitServiceBlockingStub>() {
        @java.lang.Override
        public ExitServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExitServiceBlockingStub(channel, callOptions);
        }
      };
    return ExitServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ExitServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExitServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExitServiceFutureStub>() {
        @java.lang.Override
        public ExitServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExitServiceFutureStub(channel, callOptions);
        }
      };
    return ExitServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void exit(unimi.redmerska.anna.Exit.ExitRequest request,
        io.grpc.stub.StreamObserver<unimi.redmerska.anna.Exit.ExitResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExitMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ExitService.
   */
  public static abstract class ExitServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ExitServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ExitService.
   */
  public static final class ExitServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ExitServiceStub> {
    private ExitServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExitServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExitServiceStub(channel, callOptions);
    }

    /**
     */
    public void exit(unimi.redmerska.anna.Exit.ExitRequest request,
        io.grpc.stub.StreamObserver<unimi.redmerska.anna.Exit.ExitResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExitMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ExitService.
   */
  public static final class ExitServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ExitServiceBlockingStub> {
    private ExitServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExitServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExitServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public unimi.redmerska.anna.Exit.ExitResponse exit(unimi.redmerska.anna.Exit.ExitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExitMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ExitService.
   */
  public static final class ExitServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ExitServiceFutureStub> {
    private ExitServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExitServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExitServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<unimi.redmerska.anna.Exit.ExitResponse> exit(
        unimi.redmerska.anna.Exit.ExitRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExitMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EXIT = 0;

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
        case METHODID_EXIT:
          serviceImpl.exit((unimi.redmerska.anna.Exit.ExitRequest) request,
              (io.grpc.stub.StreamObserver<unimi.redmerska.anna.Exit.ExitResponse>) responseObserver);
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
          getExitMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              unimi.redmerska.anna.Exit.ExitRequest,
              unimi.redmerska.anna.Exit.ExitResponse>(
                service, METHODID_EXIT)))
        .build();
  }

  private static abstract class ExitServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExitServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return unimi.redmerska.anna.Exit.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ExitService");
    }
  }

  private static final class ExitServiceFileDescriptorSupplier
      extends ExitServiceBaseDescriptorSupplier {
    ExitServiceFileDescriptorSupplier() {}
  }

  private static final class ExitServiceMethodDescriptorSupplier
      extends ExitServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ExitServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ExitServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ExitServiceFileDescriptorSupplier())
              .addMethod(getExitMethod())
              .build();
        }
      }
    }
    return result;
  }
}
