package io.grpc.examples.coffee_maker;

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
    comments = "Source: coffeeMaker.proto")
public final class CoffeeMakerServiceGrpc {

  private CoffeeMakerServiceGrpc() {}

  public static final String SERVICE_NAME = "coffeeMaker.CoffeeMakerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.coffee_maker.BrewType,
      io.grpc.examples.coffee_maker.Response> getSetBrewingTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setBrewingType",
      requestType = io.grpc.examples.coffee_maker.BrewType.class,
      responseType = io.grpc.examples.coffee_maker.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.coffee_maker.BrewType,
      io.grpc.examples.coffee_maker.Response> getSetBrewingTypeMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.coffee_maker.BrewType, io.grpc.examples.coffee_maker.Response> getSetBrewingTypeMethod;
    if ((getSetBrewingTypeMethod = CoffeeMakerServiceGrpc.getSetBrewingTypeMethod) == null) {
      synchronized (CoffeeMakerServiceGrpc.class) {
        if ((getSetBrewingTypeMethod = CoffeeMakerServiceGrpc.getSetBrewingTypeMethod) == null) {
          CoffeeMakerServiceGrpc.getSetBrewingTypeMethod = getSetBrewingTypeMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.coffee_maker.BrewType, io.grpc.examples.coffee_maker.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "coffeeMaker.CoffeeMakerService", "setBrewingType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.coffee_maker.BrewType.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.coffee_maker.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new CoffeeMakerServiceMethodDescriptorSupplier("setBrewingType"))
                  .build();
          }
        }
     }
     return getSetBrewingTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.coffee_maker.Empty,
      io.grpc.examples.coffee_maker.Response> getBeginBrewingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "beginBrewing",
      requestType = io.grpc.examples.coffee_maker.Empty.class,
      responseType = io.grpc.examples.coffee_maker.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<io.grpc.examples.coffee_maker.Empty,
      io.grpc.examples.coffee_maker.Response> getBeginBrewingMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.coffee_maker.Empty, io.grpc.examples.coffee_maker.Response> getBeginBrewingMethod;
    if ((getBeginBrewingMethod = CoffeeMakerServiceGrpc.getBeginBrewingMethod) == null) {
      synchronized (CoffeeMakerServiceGrpc.class) {
        if ((getBeginBrewingMethod = CoffeeMakerServiceGrpc.getBeginBrewingMethod) == null) {
          CoffeeMakerServiceGrpc.getBeginBrewingMethod = getBeginBrewingMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.coffee_maker.Empty, io.grpc.examples.coffee_maker.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "coffeeMaker.CoffeeMakerService", "beginBrewing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.coffee_maker.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.coffee_maker.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new CoffeeMakerServiceMethodDescriptorSupplier("beginBrewing"))
                  .build();
          }
        }
     }
     return getBeginBrewingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CoffeeMakerServiceStub newStub(io.grpc.Channel channel) {
    return new CoffeeMakerServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CoffeeMakerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CoffeeMakerServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CoffeeMakerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CoffeeMakerServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CoffeeMakerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void setBrewingType(io.grpc.examples.coffee_maker.BrewType request,
        io.grpc.stub.StreamObserver<io.grpc.examples.coffee_maker.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getSetBrewingTypeMethod(), responseObserver);
    }

    /**
     */
    public void beginBrewing(io.grpc.examples.coffee_maker.Empty request,
        io.grpc.stub.StreamObserver<io.grpc.examples.coffee_maker.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getBeginBrewingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetBrewingTypeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.coffee_maker.BrewType,
                io.grpc.examples.coffee_maker.Response>(
                  this, METHODID_SET_BREWING_TYPE)))
          .addMethod(
            getBeginBrewingMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                io.grpc.examples.coffee_maker.Empty,
                io.grpc.examples.coffee_maker.Response>(
                  this, METHODID_BEGIN_BREWING)))
          .build();
    }
  }

  /**
   */
  public static final class CoffeeMakerServiceStub extends io.grpc.stub.AbstractStub<CoffeeMakerServiceStub> {
    private CoffeeMakerServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CoffeeMakerServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoffeeMakerServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CoffeeMakerServiceStub(channel, callOptions);
    }

    /**
     */
    public void setBrewingType(io.grpc.examples.coffee_maker.BrewType request,
        io.grpc.stub.StreamObserver<io.grpc.examples.coffee_maker.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetBrewingTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void beginBrewing(io.grpc.examples.coffee_maker.Empty request,
        io.grpc.stub.StreamObserver<io.grpc.examples.coffee_maker.Response> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getBeginBrewingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CoffeeMakerServiceBlockingStub extends io.grpc.stub.AbstractStub<CoffeeMakerServiceBlockingStub> {
    private CoffeeMakerServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CoffeeMakerServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoffeeMakerServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CoffeeMakerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.examples.coffee_maker.Response setBrewingType(io.grpc.examples.coffee_maker.BrewType request) {
      return blockingUnaryCall(
          getChannel(), getSetBrewingTypeMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<io.grpc.examples.coffee_maker.Response> beginBrewing(
        io.grpc.examples.coffee_maker.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getBeginBrewingMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CoffeeMakerServiceFutureStub extends io.grpc.stub.AbstractStub<CoffeeMakerServiceFutureStub> {
    private CoffeeMakerServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CoffeeMakerServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoffeeMakerServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CoffeeMakerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.coffee_maker.Response> setBrewingType(
        io.grpc.examples.coffee_maker.BrewType request) {
      return futureUnaryCall(
          getChannel().newCall(getSetBrewingTypeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_BREWING_TYPE = 0;
  private static final int METHODID_BEGIN_BREWING = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CoffeeMakerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CoffeeMakerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_BREWING_TYPE:
          serviceImpl.setBrewingType((io.grpc.examples.coffee_maker.BrewType) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.coffee_maker.Response>) responseObserver);
          break;
        case METHODID_BEGIN_BREWING:
          serviceImpl.beginBrewing((io.grpc.examples.coffee_maker.Empty) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.coffee_maker.Response>) responseObserver);
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

  private static abstract class CoffeeMakerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CoffeeMakerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.examples.coffee_maker.CoffeeMakerServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CoffeeMakerService");
    }
  }

  private static final class CoffeeMakerServiceFileDescriptorSupplier
      extends CoffeeMakerServiceBaseDescriptorSupplier {
    CoffeeMakerServiceFileDescriptorSupplier() {}
  }

  private static final class CoffeeMakerServiceMethodDescriptorSupplier
      extends CoffeeMakerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CoffeeMakerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CoffeeMakerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CoffeeMakerServiceFileDescriptorSupplier())
              .addMethod(getSetBrewingTypeMethod())
              .addMethod(getBeginBrewingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
