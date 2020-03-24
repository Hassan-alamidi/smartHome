package io.grpc.examples.lights;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: lights.proto")
public final class LightsServiceGrpc {

  private LightsServiceGrpc() {}

  public static final String SERVICE_NAME = "lights.LightsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.lights.Empty,
      io.grpc.examples.lights.StringResponse> getToggleLightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "toggleLights",
      requestType = io.grpc.examples.lights.Empty.class,
      responseType = io.grpc.examples.lights.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.lights.Empty,
      io.grpc.examples.lights.StringResponse> getToggleLightsMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.lights.Empty, io.grpc.examples.lights.StringResponse> getToggleLightsMethod;
    if ((getToggleLightsMethod = LightsServiceGrpc.getToggleLightsMethod) == null) {
      synchronized (LightsServiceGrpc.class) {
        if ((getToggleLightsMethod = LightsServiceGrpc.getToggleLightsMethod) == null) {
          LightsServiceGrpc.getToggleLightsMethod = getToggleLightsMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.lights.Empty, io.grpc.examples.lights.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lights.LightsService", "toggleLights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.lights.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.lights.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightsServiceMethodDescriptorSupplier("toggleLights"))
                  .build();
          }
        }
     }
     return getToggleLightsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.lights.Empty,
      io.grpc.examples.lights.StringResponse> getGetLightsStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getLightsStatus",
      requestType = io.grpc.examples.lights.Empty.class,
      responseType = io.grpc.examples.lights.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.lights.Empty,
      io.grpc.examples.lights.StringResponse> getGetLightsStatusMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.lights.Empty, io.grpc.examples.lights.StringResponse> getGetLightsStatusMethod;
    if ((getGetLightsStatusMethod = LightsServiceGrpc.getGetLightsStatusMethod) == null) {
      synchronized (LightsServiceGrpc.class) {
        if ((getGetLightsStatusMethod = LightsServiceGrpc.getGetLightsStatusMethod) == null) {
          LightsServiceGrpc.getGetLightsStatusMethod = getGetLightsStatusMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.lights.Empty, io.grpc.examples.lights.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lights.LightsService", "getLightsStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.lights.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.lights.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightsServiceMethodDescriptorSupplier("getLightsStatus"))
                  .build();
          }
        }
     }
     return getGetLightsStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.lights.SintRequest,
      io.grpc.examples.lights.StringResponse> getChangeLuminosityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeLuminosity",
      requestType = io.grpc.examples.lights.SintRequest.class,
      responseType = io.grpc.examples.lights.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<io.grpc.examples.lights.SintRequest,
      io.grpc.examples.lights.StringResponse> getChangeLuminosityMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.lights.SintRequest, io.grpc.examples.lights.StringResponse> getChangeLuminosityMethod;
    if ((getChangeLuminosityMethod = LightsServiceGrpc.getChangeLuminosityMethod) == null) {
      synchronized (LightsServiceGrpc.class) {
        if ((getChangeLuminosityMethod = LightsServiceGrpc.getChangeLuminosityMethod) == null) {
          LightsServiceGrpc.getChangeLuminosityMethod = getChangeLuminosityMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.lights.SintRequest, io.grpc.examples.lights.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lights.LightsService", "changeLuminosity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.lights.SintRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.lights.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightsServiceMethodDescriptorSupplier("changeLuminosity"))
                  .build();
          }
        }
     }
     return getChangeLuminosityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightsServiceStub newStub(io.grpc.Channel channel) {
    return new LightsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LightsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LightsServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class LightsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void toggleLights(io.grpc.examples.lights.Empty request,
        io.grpc.stub.StreamObserver<io.grpc.examples.lights.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getToggleLightsMethod(), responseObserver);
    }

    /**
     */
    public void getLightsStatus(io.grpc.examples.lights.Empty request,
        io.grpc.stub.StreamObserver<io.grpc.examples.lights.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLightsStatusMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.examples.lights.SintRequest> changeLuminosity(
        io.grpc.stub.StreamObserver<io.grpc.examples.lights.StringResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getChangeLuminosityMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getToggleLightsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.lights.Empty,
                io.grpc.examples.lights.StringResponse>(
                  this, METHODID_TOGGLE_LIGHTS)))
          .addMethod(
            getGetLightsStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.lights.Empty,
                io.grpc.examples.lights.StringResponse>(
                  this, METHODID_GET_LIGHTS_STATUS)))
          .addMethod(
            getChangeLuminosityMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                io.grpc.examples.lights.SintRequest,
                io.grpc.examples.lights.StringResponse>(
                  this, METHODID_CHANGE_LUMINOSITY)))
          .build();
    }
  }

  /**
   */
  public static final class LightsServiceStub extends io.grpc.stub.AbstractStub<LightsServiceStub> {
    private LightsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightsServiceStub(channel, callOptions);
    }

    /**
     */
    public void toggleLights(io.grpc.examples.lights.Empty request,
        io.grpc.stub.StreamObserver<io.grpc.examples.lights.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getToggleLightsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLightsStatus(io.grpc.examples.lights.Empty request,
        io.grpc.stub.StreamObserver<io.grpc.examples.lights.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetLightsStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.examples.lights.SintRequest> changeLuminosity(
        io.grpc.stub.StreamObserver<io.grpc.examples.lights.StringResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getChangeLuminosityMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class LightsServiceBlockingStub extends io.grpc.stub.AbstractStub<LightsServiceBlockingStub> {
    private LightsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.examples.lights.StringResponse toggleLights(io.grpc.examples.lights.Empty request) {
      return blockingUnaryCall(
          getChannel(), getToggleLightsMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.examples.lights.StringResponse getLightsStatus(io.grpc.examples.lights.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetLightsStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LightsServiceFutureStub extends io.grpc.stub.AbstractStub<LightsServiceFutureStub> {
    private LightsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.lights.StringResponse> toggleLights(
        io.grpc.examples.lights.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getToggleLightsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.lights.StringResponse> getLightsStatus(
        io.grpc.examples.lights.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetLightsStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TOGGLE_LIGHTS = 0;
  private static final int METHODID_GET_LIGHTS_STATUS = 1;
  private static final int METHODID_CHANGE_LUMINOSITY = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TOGGLE_LIGHTS:
          serviceImpl.toggleLights((io.grpc.examples.lights.Empty) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.lights.StringResponse>) responseObserver);
          break;
        case METHODID_GET_LIGHTS_STATUS:
          serviceImpl.getLightsStatus((io.grpc.examples.lights.Empty) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.lights.StringResponse>) responseObserver);
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
        case METHODID_CHANGE_LUMINOSITY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.changeLuminosity(
              (io.grpc.stub.StreamObserver<io.grpc.examples.lights.StringResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LightsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.examples.lights.LightsServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightsService");
    }
  }

  private static final class LightsServiceFileDescriptorSupplier
      extends LightsServiceBaseDescriptorSupplier {
    LightsServiceFileDescriptorSupplier() {}
  }

  private static final class LightsServiceMethodDescriptorSupplier
      extends LightsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LightsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightsServiceFileDescriptorSupplier())
              .addMethod(getToggleLightsMethod())
              .addMethod(getGetLightsStatusMethod())
              .addMethod(getChangeLuminosityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
