package io.grpc.examples.oven;

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
    comments = "Source: oven.proto")
public final class OvenServiceGrpc {

  private OvenServiceGrpc() {}

  public static final String SERVICE_NAME = "oven.OvenService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.oven.IntRequest,
      io.grpc.examples.oven.StringResponse> getChangeTempMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeTemp",
      requestType = io.grpc.examples.oven.IntRequest.class,
      responseType = io.grpc.examples.oven.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.oven.IntRequest,
      io.grpc.examples.oven.StringResponse> getChangeTempMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.oven.IntRequest, io.grpc.examples.oven.StringResponse> getChangeTempMethod;
    if ((getChangeTempMethod = OvenServiceGrpc.getChangeTempMethod) == null) {
      synchronized (OvenServiceGrpc.class) {
        if ((getChangeTempMethod = OvenServiceGrpc.getChangeTempMethod) == null) {
          OvenServiceGrpc.getChangeTempMethod = getChangeTempMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.oven.IntRequest, io.grpc.examples.oven.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "oven.OvenService", "changeTemp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.oven.IntRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.oven.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OvenServiceMethodDescriptorSupplier("changeTemp"))
                  .build();
          }
        }
     }
     return getChangeTempMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.oven.IntRequest,
      io.grpc.examples.oven.StringResponse> getSetTimerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setTimer",
      requestType = io.grpc.examples.oven.IntRequest.class,
      responseType = io.grpc.examples.oven.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.oven.IntRequest,
      io.grpc.examples.oven.StringResponse> getSetTimerMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.oven.IntRequest, io.grpc.examples.oven.StringResponse> getSetTimerMethod;
    if ((getSetTimerMethod = OvenServiceGrpc.getSetTimerMethod) == null) {
      synchronized (OvenServiceGrpc.class) {
        if ((getSetTimerMethod = OvenServiceGrpc.getSetTimerMethod) == null) {
          OvenServiceGrpc.getSetTimerMethod = getSetTimerMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.oven.IntRequest, io.grpc.examples.oven.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "oven.OvenService", "setTimer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.oven.IntRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.oven.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OvenServiceMethodDescriptorSupplier("setTimer"))
                  .build();
          }
        }
     }
     return getSetTimerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.oven.OvenSetting,
      io.grpc.examples.oven.StringResponse> getChangeSettingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeSetting",
      requestType = io.grpc.examples.oven.OvenSetting.class,
      responseType = io.grpc.examples.oven.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.oven.OvenSetting,
      io.grpc.examples.oven.StringResponse> getChangeSettingMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.oven.OvenSetting, io.grpc.examples.oven.StringResponse> getChangeSettingMethod;
    if ((getChangeSettingMethod = OvenServiceGrpc.getChangeSettingMethod) == null) {
      synchronized (OvenServiceGrpc.class) {
        if ((getChangeSettingMethod = OvenServiceGrpc.getChangeSettingMethod) == null) {
          OvenServiceGrpc.getChangeSettingMethod = getChangeSettingMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.oven.OvenSetting, io.grpc.examples.oven.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "oven.OvenService", "changeSetting"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.oven.OvenSetting.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.oven.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OvenServiceMethodDescriptorSupplier("changeSetting"))
                  .build();
          }
        }
     }
     return getChangeSettingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.oven.Empty,
      io.grpc.examples.oven.OvenStatus> getGetCurrentStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCurrentStatus",
      requestType = io.grpc.examples.oven.Empty.class,
      responseType = io.grpc.examples.oven.OvenStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.oven.Empty,
      io.grpc.examples.oven.OvenStatus> getGetCurrentStatusMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.oven.Empty, io.grpc.examples.oven.OvenStatus> getGetCurrentStatusMethod;
    if ((getGetCurrentStatusMethod = OvenServiceGrpc.getGetCurrentStatusMethod) == null) {
      synchronized (OvenServiceGrpc.class) {
        if ((getGetCurrentStatusMethod = OvenServiceGrpc.getGetCurrentStatusMethod) == null) {
          OvenServiceGrpc.getGetCurrentStatusMethod = getGetCurrentStatusMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.oven.Empty, io.grpc.examples.oven.OvenStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "oven.OvenService", "getCurrentStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.oven.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.oven.OvenStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new OvenServiceMethodDescriptorSupplier("getCurrentStatus"))
                  .build();
          }
        }
     }
     return getGetCurrentStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.oven.OvenStatus,
      io.grpc.examples.oven.StringResponse> getStartCookingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "startCooking",
      requestType = io.grpc.examples.oven.OvenStatus.class,
      responseType = io.grpc.examples.oven.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<io.grpc.examples.oven.OvenStatus,
      io.grpc.examples.oven.StringResponse> getStartCookingMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.oven.OvenStatus, io.grpc.examples.oven.StringResponse> getStartCookingMethod;
    if ((getStartCookingMethod = OvenServiceGrpc.getStartCookingMethod) == null) {
      synchronized (OvenServiceGrpc.class) {
        if ((getStartCookingMethod = OvenServiceGrpc.getStartCookingMethod) == null) {
          OvenServiceGrpc.getStartCookingMethod = getStartCookingMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.oven.OvenStatus, io.grpc.examples.oven.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "oven.OvenService", "startCooking"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.oven.OvenStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.oven.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OvenServiceMethodDescriptorSupplier("startCooking"))
                  .build();
          }
        }
     }
     return getStartCookingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OvenServiceStub newStub(io.grpc.Channel channel) {
    return new OvenServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OvenServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new OvenServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OvenServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new OvenServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class OvenServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void changeTemp(io.grpc.examples.oven.IntRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.oven.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeTempMethod(), responseObserver);
    }

    /**
     */
    public void setTimer(io.grpc.examples.oven.IntRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.oven.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetTimerMethod(), responseObserver);
    }

    /**
     */
    public void changeSetting(io.grpc.examples.oven.OvenSetting request,
        io.grpc.stub.StreamObserver<io.grpc.examples.oven.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeSettingMethod(), responseObserver);
    }

    /**
     */
    public void getCurrentStatus(io.grpc.examples.oven.Empty request,
        io.grpc.stub.StreamObserver<io.grpc.examples.oven.OvenStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentStatusMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.examples.oven.OvenStatus> startCooking(
        io.grpc.stub.StreamObserver<io.grpc.examples.oven.StringResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getStartCookingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getChangeTempMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.oven.IntRequest,
                io.grpc.examples.oven.StringResponse>(
                  this, METHODID_CHANGE_TEMP)))
          .addMethod(
            getSetTimerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.oven.IntRequest,
                io.grpc.examples.oven.StringResponse>(
                  this, METHODID_SET_TIMER)))
          .addMethod(
            getChangeSettingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.oven.OvenSetting,
                io.grpc.examples.oven.StringResponse>(
                  this, METHODID_CHANGE_SETTING)))
          .addMethod(
            getGetCurrentStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.oven.Empty,
                io.grpc.examples.oven.OvenStatus>(
                  this, METHODID_GET_CURRENT_STATUS)))
          .addMethod(
            getStartCookingMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.grpc.examples.oven.OvenStatus,
                io.grpc.examples.oven.StringResponse>(
                  this, METHODID_START_COOKING)))
          .build();
    }
  }

  /**
   */
  public static final class OvenServiceStub extends io.grpc.stub.AbstractStub<OvenServiceStub> {
    private OvenServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OvenServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OvenServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OvenServiceStub(channel, callOptions);
    }

    /**
     */
    public void changeTemp(io.grpc.examples.oven.IntRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.oven.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangeTempMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setTimer(io.grpc.examples.oven.IntRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.oven.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetTimerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeSetting(io.grpc.examples.oven.OvenSetting request,
        io.grpc.stub.StreamObserver<io.grpc.examples.oven.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangeSettingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCurrentStatus(io.grpc.examples.oven.Empty request,
        io.grpc.stub.StreamObserver<io.grpc.examples.oven.OvenStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.examples.oven.OvenStatus> startCooking(
        io.grpc.stub.StreamObserver<io.grpc.examples.oven.StringResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getStartCookingMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class OvenServiceBlockingStub extends io.grpc.stub.AbstractStub<OvenServiceBlockingStub> {
    private OvenServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OvenServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OvenServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OvenServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.examples.oven.StringResponse changeTemp(io.grpc.examples.oven.IntRequest request) {
      return blockingUnaryCall(
          getChannel(), getChangeTempMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.examples.oven.StringResponse setTimer(io.grpc.examples.oven.IntRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetTimerMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.examples.oven.StringResponse changeSetting(io.grpc.examples.oven.OvenSetting request) {
      return blockingUnaryCall(
          getChannel(), getChangeSettingMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.examples.oven.OvenStatus getCurrentStatus(io.grpc.examples.oven.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class OvenServiceFutureStub extends io.grpc.stub.AbstractStub<OvenServiceFutureStub> {
    private OvenServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OvenServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OvenServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OvenServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.oven.StringResponse> changeTemp(
        io.grpc.examples.oven.IntRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getChangeTempMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.oven.StringResponse> setTimer(
        io.grpc.examples.oven.IntRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetTimerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.oven.StringResponse> changeSetting(
        io.grpc.examples.oven.OvenSetting request) {
      return futureUnaryCall(
          getChannel().newCall(getChangeSettingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.oven.OvenStatus> getCurrentStatus(
        io.grpc.examples.oven.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCurrentStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHANGE_TEMP = 0;
  private static final int METHODID_SET_TIMER = 1;
  private static final int METHODID_CHANGE_SETTING = 2;
  private static final int METHODID_GET_CURRENT_STATUS = 3;
  private static final int METHODID_START_COOKING = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OvenServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OvenServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHANGE_TEMP:
          serviceImpl.changeTemp((io.grpc.examples.oven.IntRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.oven.StringResponse>) responseObserver);
          break;
        case METHODID_SET_TIMER:
          serviceImpl.setTimer((io.grpc.examples.oven.IntRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.oven.StringResponse>) responseObserver);
          break;
        case METHODID_CHANGE_SETTING:
          serviceImpl.changeSetting((io.grpc.examples.oven.OvenSetting) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.oven.StringResponse>) responseObserver);
          break;
        case METHODID_GET_CURRENT_STATUS:
          serviceImpl.getCurrentStatus((io.grpc.examples.oven.Empty) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.oven.OvenStatus>) responseObserver);
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
        case METHODID_START_COOKING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.startCooking(
              (io.grpc.stub.StreamObserver<io.grpc.examples.oven.StringResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class OvenServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OvenServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.examples.oven.OvenServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OvenService");
    }
  }

  private static final class OvenServiceFileDescriptorSupplier
      extends OvenServiceBaseDescriptorSupplier {
    OvenServiceFileDescriptorSupplier() {}
  }

  private static final class OvenServiceMethodDescriptorSupplier
      extends OvenServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OvenServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (OvenServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OvenServiceFileDescriptorSupplier())
              .addMethod(getChangeTempMethod())
              .addMethod(getSetTimerMethod())
              .addMethod(getChangeSettingMethod())
              .addMethod(getGetCurrentStatusMethod())
              .addMethod(getStartCookingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
