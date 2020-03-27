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
    comments = "Source: heating.proto")
public final class HeatingServiceGrpc {

  private HeatingServiceGrpc() {}

  public static final String SERVICE_NAME = "HeatingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Heating.Empty,
      Heating.FloatResponse> getGetSystemTempSettingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getSystemTempSetting",
      requestType = Heating.Empty.class,
      responseType = Heating.FloatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Heating.Empty,
      Heating.FloatResponse> getGetSystemTempSettingMethod() {
    io.grpc.MethodDescriptor<Heating.Empty, Heating.FloatResponse> getGetSystemTempSettingMethod;
    if ((getGetSystemTempSettingMethod = HeatingServiceGrpc.getGetSystemTempSettingMethod) == null) {
      synchronized (HeatingServiceGrpc.class) {
        if ((getGetSystemTempSettingMethod = HeatingServiceGrpc.getGetSystemTempSettingMethod) == null) {
          HeatingServiceGrpc.getGetSystemTempSettingMethod = getGetSystemTempSettingMethod = 
              io.grpc.MethodDescriptor.<Heating.Empty, Heating.FloatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "HeatingService", "getSystemTempSetting"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Heating.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Heating.FloatResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HeatingServiceMethodDescriptorSupplier("getSystemTempSetting"))
                  .build();
          }
        }
     }
     return getGetSystemTempSettingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Heating.FloatRequest,
      Heating.StringResponse> getChangeSystemTempSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeSystemTempSettings",
      requestType = Heating.FloatRequest.class,
      responseType = Heating.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Heating.FloatRequest,
      Heating.StringResponse> getChangeSystemTempSettingsMethod() {
    io.grpc.MethodDescriptor<Heating.FloatRequest, Heating.StringResponse> getChangeSystemTempSettingsMethod;
    if ((getChangeSystemTempSettingsMethod = HeatingServiceGrpc.getChangeSystemTempSettingsMethod) == null) {
      synchronized (HeatingServiceGrpc.class) {
        if ((getChangeSystemTempSettingsMethod = HeatingServiceGrpc.getChangeSystemTempSettingsMethod) == null) {
          HeatingServiceGrpc.getChangeSystemTempSettingsMethod = getChangeSystemTempSettingsMethod = 
              io.grpc.MethodDescriptor.<Heating.FloatRequest, Heating.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "HeatingService", "changeSystemTempSettings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Heating.FloatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Heating.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HeatingServiceMethodDescriptorSupplier("changeSystemTempSettings"))
                  .build();
          }
        }
     }
     return getChangeSystemTempSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Heating.Empty,
      Heating.StringResponse> getToggleHeatingSystemStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "toggleHeatingSystemStatus",
      requestType = Heating.Empty.class,
      responseType = Heating.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Heating.Empty,
      Heating.StringResponse> getToggleHeatingSystemStatusMethod() {
    io.grpc.MethodDescriptor<Heating.Empty, Heating.StringResponse> getToggleHeatingSystemStatusMethod;
    if ((getToggleHeatingSystemStatusMethod = HeatingServiceGrpc.getToggleHeatingSystemStatusMethod) == null) {
      synchronized (HeatingServiceGrpc.class) {
        if ((getToggleHeatingSystemStatusMethod = HeatingServiceGrpc.getToggleHeatingSystemStatusMethod) == null) {
          HeatingServiceGrpc.getToggleHeatingSystemStatusMethod = getToggleHeatingSystemStatusMethod = 
              io.grpc.MethodDescriptor.<Heating.Empty, Heating.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "HeatingService", "toggleHeatingSystemStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Heating.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Heating.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HeatingServiceMethodDescriptorSupplier("toggleHeatingSystemStatus"))
                  .build();
          }
        }
     }
     return getToggleHeatingSystemStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HeatingServiceStub newStub(io.grpc.Channel channel) {
    return new HeatingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HeatingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HeatingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HeatingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HeatingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HeatingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getSystemTempSetting(Heating.Empty request,
        io.grpc.stub.StreamObserver<Heating.FloatResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSystemTempSettingMethod(), responseObserver);
    }

    /**
     */
    public void changeSystemTempSettings(Heating.FloatRequest request,
        io.grpc.stub.StreamObserver<Heating.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeSystemTempSettingsMethod(), responseObserver);
    }

    /**
     */
    public void toggleHeatingSystemStatus(Heating.Empty request,
        io.grpc.stub.StreamObserver<Heating.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getToggleHeatingSystemStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetSystemTempSettingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Heating.Empty,
                Heating.FloatResponse>(
                  this, METHODID_GET_SYSTEM_TEMP_SETTING)))
          .addMethod(
            getChangeSystemTempSettingsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Heating.FloatRequest,
                Heating.StringResponse>(
                  this, METHODID_CHANGE_SYSTEM_TEMP_SETTINGS)))
          .addMethod(
            getToggleHeatingSystemStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Heating.Empty,
                Heating.StringResponse>(
                  this, METHODID_TOGGLE_HEATING_SYSTEM_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class HeatingServiceStub extends io.grpc.stub.AbstractStub<HeatingServiceStub> {
    private HeatingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HeatingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HeatingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HeatingServiceStub(channel, callOptions);
    }

    /**
     */
    public void getSystemTempSetting(Heating.Empty request,
        io.grpc.stub.StreamObserver<Heating.FloatResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSystemTempSettingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeSystemTempSettings(Heating.FloatRequest request,
        io.grpc.stub.StreamObserver<Heating.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangeSystemTempSettingsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void toggleHeatingSystemStatus(Heating.Empty request,
        io.grpc.stub.StreamObserver<Heating.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getToggleHeatingSystemStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HeatingServiceBlockingStub extends io.grpc.stub.AbstractStub<HeatingServiceBlockingStub> {
    private HeatingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HeatingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HeatingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HeatingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Heating.FloatResponse getSystemTempSetting(Heating.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetSystemTempSettingMethod(), getCallOptions(), request);
    }

    /**
     */
    public Heating.StringResponse changeSystemTempSettings(Heating.FloatRequest request) {
      return blockingUnaryCall(
          getChannel(), getChangeSystemTempSettingsMethod(), getCallOptions(), request);
    }

    /**
     */
    public Heating.StringResponse toggleHeatingSystemStatus(Heating.Empty request) {
      return blockingUnaryCall(
          getChannel(), getToggleHeatingSystemStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HeatingServiceFutureStub extends io.grpc.stub.AbstractStub<HeatingServiceFutureStub> {
    private HeatingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HeatingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HeatingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HeatingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Heating.FloatResponse> getSystemTempSetting(
        Heating.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSystemTempSettingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Heating.StringResponse> changeSystemTempSettings(
        Heating.FloatRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getChangeSystemTempSettingsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Heating.StringResponse> toggleHeatingSystemStatus(
        Heating.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getToggleHeatingSystemStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SYSTEM_TEMP_SETTING = 0;
  private static final int METHODID_CHANGE_SYSTEM_TEMP_SETTINGS = 1;
  private static final int METHODID_TOGGLE_HEATING_SYSTEM_STATUS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HeatingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HeatingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SYSTEM_TEMP_SETTING:
          serviceImpl.getSystemTempSetting((Heating.Empty) request,
              (io.grpc.stub.StreamObserver<Heating.FloatResponse>) responseObserver);
          break;
        case METHODID_CHANGE_SYSTEM_TEMP_SETTINGS:
          serviceImpl.changeSystemTempSettings((Heating.FloatRequest) request,
              (io.grpc.stub.StreamObserver<Heating.StringResponse>) responseObserver);
          break;
        case METHODID_TOGGLE_HEATING_SYSTEM_STATUS:
          serviceImpl.toggleHeatingSystemStatus((Heating.Empty) request,
              (io.grpc.stub.StreamObserver<Heating.StringResponse>) responseObserver);
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

  private static abstract class HeatingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HeatingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Heating.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HeatingService");
    }
  }

  private static final class HeatingServiceFileDescriptorSupplier
      extends HeatingServiceBaseDescriptorSupplier {
    HeatingServiceFileDescriptorSupplier() {}
  }

  private static final class HeatingServiceMethodDescriptorSupplier
      extends HeatingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HeatingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HeatingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HeatingServiceFileDescriptorSupplier())
              .addMethod(getGetSystemTempSettingMethod())
              .addMethod(getChangeSystemTempSettingsMethod())
              .addMethod(getToggleHeatingSystemStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
