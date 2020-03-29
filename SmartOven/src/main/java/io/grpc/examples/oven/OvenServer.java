package io.grpc.examples.oven;

import com.jmDNS.grpc.DnsServiceGrpc;
import com.jmDNS.grpc.details;
import io.grpc.*;
import io.grpc.examples.oven.OvenServiceGrpc.OvenServiceImplBase;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class OvenServer extends OvenServiceImplBase {

    private static final int MAX_TEMP = 250;
    private static final int MIN_TEMP = 0;
    private static final int PORT = 8080;
    private static final String SERVER_NAME = "SmartOven";
    private static final String DEFAULT_TYPE = "_http._tcp.local.";
    private static final String DEFAULT_PATH = "path=index.html";
    private static final String DNS_SERVER_ADDRESS = "127.0.1.1";
    private static final int DNS_SERVER_PORT = 9090;

    private static DnsServiceGrpc.DnsServiceBlockingStub blockingStub;
    private static details serverDetails;
    private OvenStatus.Status ovenStatus = OvenStatus.Status.OFF;
    private float desiredTemp = 0;
    private float currentTemp = 0;
    private int timer = 0;
    private OvenSetting.Setting setting;
    private StringResponse response;


    public static void main(String[] args){
        OvenServer ovenServer = new OvenServer();

        try {
            Server server = ServerBuilder.forPort(PORT)
                    .addService(ovenServer)
                    .build()
                    .start();

            DnsConnection();
            serverDetails = details.newBuilder()
                                    .setPort(PORT)
                                    .setType(DEFAULT_TYPE)
                                    .setName(SERVER_NAME)
                                    .setPath(DEFAULT_PATH)
                                    .build();
            blockingStub.selfRegistration(serverDetails);

            System.out.println("server is listening");
            server.awaitTermination();
        } catch(io.grpc.StatusRuntimeException e){
            //TODO change with logger
            System.out.println("Error: You must start the dns server first");
        }catch (IOException | InterruptedException e) {
            blockingStub.selfUnregister(serverDetails);
            e.printStackTrace();
        }
    }

    private static void DnsConnection(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(DNS_SERVER_ADDRESS, DNS_SERVER_PORT)
                .usePlaintext()
                .build();
        blockingStub = DnsServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public void changeTemp(IntRequest request, StreamObserver<StringResponse> responseObserver) {
        float val = request.getValue();
        val = val >= MAX_TEMP ? MAX_TEMP : val;
        val = val <= MIN_TEMP ? MIN_TEMP : val;
        desiredTemp = val;
        response = StringResponse.newBuilder().setText("desired temp has been set to: " + desiredTemp).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void setTimer(IntRequest request, StreamObserver<StringResponse> responseObserver) {
        timer = request.getValue();
        response = StringResponse.newBuilder().setText("timer has been set").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void changeSetting(OvenSetting request, StreamObserver<StringResponse> responseObserver) {
        setting = request.getSetting();
        response = StringResponse.newBuilder().setText("oven has been set to " + setting).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getCurrentStatus(Empty request, StreamObserver<OvenStatus> responseObserver) {
        OvenStatus resp = OvenStatus.newBuilder().setStatus(ovenStatus).build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<OvenStatus> startCooking(StreamObserver<OvenStatus> responseObserver) {
        return new StreamObserver<OvenStatus>() {

            @Override
            public void onNext(OvenStatus status) {
                OvenStatus currentStatus = OvenStatus.newBuilder().build();
                OvenStatus.Status newStatus = status.getStatus();
                try {
                    if(newStatus.equals(OvenStatus.Status.PRE_HEAT)){
                        ovenStatus = newStatus;
                        while (currentTemp < desiredTemp){
                            currentStatus = OvenStatus.newBuilder().setStatus(ovenStatus).setCurrentTemp(currentTemp).build();
                            responseObserver.onNext(currentStatus);
                           Thread.sleep(100);
                           currentTemp++;

                           System.out.println("the temp is: " + currentTemp);
                        }
                        ovenStatus = OvenStatus.Status.READY;
                        currentStatus = OvenStatus.newBuilder().setCurrentTemp(currentTemp).setRemainingTime(timer).setStatus(ovenStatus).build();
                    }else if(timer > 0 && newStatus.equals(OvenStatus.Status.COOKING)){
                        ovenStatus = newStatus;
                        for (int i = timer; i > 0; i--) {
                            Thread.sleep(1000);
                            currentStatus = OvenStatus.newBuilder().setCurrentTemp(currentTemp).setRemainingTime(i).setStatus(ovenStatus).build();
                            responseObserver.onNext(currentStatus);
                            System.out.println(i);
                            currentTemp = currentTemp < desiredTemp ? (currentTemp + 5) : currentTemp;
                        }
                    }else {
                        ovenStatus = OvenStatus.Status.OFF;
                        currentStatus = OvenStatus.newBuilder().setStatus(ovenStatus).build();
                        response = StringResponse.newBuilder().setText("Timer not set or oven is turned off").build();
                        responseObserver.onNext(currentStatus);
                        responseObserver.onCompleted();
                    }
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
                responseObserver.onNext(currentStatus);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

                ovenStatus = OvenStatus.Status.OFF;
                OvenStatus currentStatus = OvenStatus.newBuilder().setStatus(ovenStatus).build();
                responseObserver.onNext(currentStatus);
                responseObserver.onCompleted();
                timer = 0;
                currentTemp = 0;
            }
        };
    }
}
