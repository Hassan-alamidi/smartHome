package com.jmDNS.grpc;

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
    comments = "Source: jmDnsHandler.proto")
public final class DnsServiceGrpc {

  private DnsServiceGrpc() {}

  public static final String SERVICE_NAME = "DnsServer.DnsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.jmDNS.grpc.details,
      com.jmDNS.grpc.Empty> getSelfRegistrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selfRegistration",
      requestType = com.jmDNS.grpc.details.class,
      responseType = com.jmDNS.grpc.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jmDNS.grpc.details,
      com.jmDNS.grpc.Empty> getSelfRegistrationMethod() {
    io.grpc.MethodDescriptor<com.jmDNS.grpc.details, com.jmDNS.grpc.Empty> getSelfRegistrationMethod;
    if ((getSelfRegistrationMethod = DnsServiceGrpc.getSelfRegistrationMethod) == null) {
      synchronized (DnsServiceGrpc.class) {
        if ((getSelfRegistrationMethod = DnsServiceGrpc.getSelfRegistrationMethod) == null) {
          DnsServiceGrpc.getSelfRegistrationMethod = getSelfRegistrationMethod = 
              io.grpc.MethodDescriptor.<com.jmDNS.grpc.details, com.jmDNS.grpc.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "DnsServer.DnsService", "selfRegistration"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jmDNS.grpc.details.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jmDNS.grpc.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new DnsServiceMethodDescriptorSupplier("selfRegistration"))
                  .build();
          }
        }
     }
     return getSelfRegistrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.jmDNS.grpc.details,
      com.jmDNS.grpc.Empty> getSelfUnregisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selfUnregister",
      requestType = com.jmDNS.grpc.details.class,
      responseType = com.jmDNS.grpc.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jmDNS.grpc.details,
      com.jmDNS.grpc.Empty> getSelfUnregisterMethod() {
    io.grpc.MethodDescriptor<com.jmDNS.grpc.details, com.jmDNS.grpc.Empty> getSelfUnregisterMethod;
    if ((getSelfUnregisterMethod = DnsServiceGrpc.getSelfUnregisterMethod) == null) {
      synchronized (DnsServiceGrpc.class) {
        if ((getSelfUnregisterMethod = DnsServiceGrpc.getSelfUnregisterMethod) == null) {
          DnsServiceGrpc.getSelfUnregisterMethod = getSelfUnregisterMethod = 
              io.grpc.MethodDescriptor.<com.jmDNS.grpc.details, com.jmDNS.grpc.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "DnsServer.DnsService", "selfUnregister"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jmDNS.grpc.details.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jmDNS.grpc.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new DnsServiceMethodDescriptorSupplier("selfUnregister"))
                  .build();
          }
        }
     }
     return getSelfUnregisterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DnsServiceStub newStub(io.grpc.Channel channel) {
    return new DnsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DnsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DnsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DnsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DnsServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class DnsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void selfRegistration(com.jmDNS.grpc.details request,
        io.grpc.stub.StreamObserver<com.jmDNS.grpc.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getSelfRegistrationMethod(), responseObserver);
    }

    /**
     */
    public void selfUnregister(com.jmDNS.grpc.details request,
        io.grpc.stub.StreamObserver<com.jmDNS.grpc.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getSelfUnregisterMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSelfRegistrationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.jmDNS.grpc.details,
                com.jmDNS.grpc.Empty>(
                  this, METHODID_SELF_REGISTRATION)))
          .addMethod(
            getSelfUnregisterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.jmDNS.grpc.details,
                com.jmDNS.grpc.Empty>(
                  this, METHODID_SELF_UNREGISTER)))
          .build();
    }
  }

  /**
   */
  public static final class DnsServiceStub extends io.grpc.stub.AbstractStub<DnsServiceStub> {
    private DnsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DnsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DnsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DnsServiceStub(channel, callOptions);
    }

    /**
     */
    public void selfRegistration(com.jmDNS.grpc.details request,
        io.grpc.stub.StreamObserver<com.jmDNS.grpc.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelfRegistrationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selfUnregister(com.jmDNS.grpc.details request,
        io.grpc.stub.StreamObserver<com.jmDNS.grpc.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelfUnregisterMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DnsServiceBlockingStub extends io.grpc.stub.AbstractStub<DnsServiceBlockingStub> {
    private DnsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DnsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DnsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DnsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.jmDNS.grpc.Empty selfRegistration(com.jmDNS.grpc.details request) {
      return blockingUnaryCall(
          getChannel(), getSelfRegistrationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.jmDNS.grpc.Empty selfUnregister(com.jmDNS.grpc.details request) {
      return blockingUnaryCall(
          getChannel(), getSelfUnregisterMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DnsServiceFutureStub extends io.grpc.stub.AbstractStub<DnsServiceFutureStub> {
    private DnsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DnsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DnsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DnsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jmDNS.grpc.Empty> selfRegistration(
        com.jmDNS.grpc.details request) {
      return futureUnaryCall(
          getChannel().newCall(getSelfRegistrationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jmDNS.grpc.Empty> selfUnregister(
        com.jmDNS.grpc.details request) {
      return futureUnaryCall(
          getChannel().newCall(getSelfUnregisterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SELF_REGISTRATION = 0;
  private static final int METHODID_SELF_UNREGISTER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DnsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DnsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SELF_REGISTRATION:
          serviceImpl.selfRegistration((com.jmDNS.grpc.details) request,
              (io.grpc.stub.StreamObserver<com.jmDNS.grpc.Empty>) responseObserver);
          break;
        case METHODID_SELF_UNREGISTER:
          serviceImpl.selfUnregister((com.jmDNS.grpc.details) request,
              (io.grpc.stub.StreamObserver<com.jmDNS.grpc.Empty>) responseObserver);
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

  private static abstract class DnsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DnsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.jmDNS.grpc.DnsServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DnsService");
    }
  }

  private static final class DnsServiceFileDescriptorSupplier
      extends DnsServiceBaseDescriptorSupplier {
    DnsServiceFileDescriptorSupplier() {}
  }

  private static final class DnsServiceMethodDescriptorSupplier
      extends DnsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DnsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DnsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DnsServiceFileDescriptorSupplier())
              .addMethod(getSelfRegistrationMethod())
              .addMethod(getSelfUnregisterMethod())
              .build();
        }
      }
    }
    return result;
  }
}
