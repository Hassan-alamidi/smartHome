package io.grpc.examples.oven;

import io.grpc.Context;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.examples.oven.OvenServiceGrpc.OvenServiceImplBase;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class OvenServer extends OvenServiceImplBase {

    private static final float MAX_TEMP = 250;
    private static final float MIN_TEMP = 0;

    private OvenStatus.Status ovenStatus = OvenStatus.Status.OFF;

    private float desiredTemp = 0;
    private float currentTemp = 0;
    private float timer = 0;
    private OvenSetting.Setting setting;
    private StringResponse response;

    public static void main(String[] args){
        OvenServer ovenServer = new OvenServer();
        int port = 8080;

        try {
            Server server = ServerBuilder.forPort(port)
                    .addService(ovenServer)
                    .build()
                    .start();
            System.out.println("server is listening");
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeTemp(FloatRequest request, StreamObserver<StringResponse> responseObserver) {
        float val = request.getValue();
        val = val >= MAX_TEMP ? MAX_TEMP : val;
        val = val <= MIN_TEMP ? MIN_TEMP : val;
        desiredTemp = val;
        response = StringResponse.newBuilder().setText("desired temp has been set to: " + desiredTemp).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void setTimer(FloatRequest request, StreamObserver<StringResponse> responseObserver) {
        timer = request.getValue();
        response = StringResponse.newBuilder().setText("timer has been set").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void changeSetting(OvenSetting request, StreamObserver<StringResponse> responseObserver) {
        setting = request.getSetting();
        response = StringResponse.newBuilder().setText("oven has been set to" + setting).build();
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
    public StreamObserver<OvenStatus> startCooking(StreamObserver<StringResponse> responseObserver) {
        return new StreamObserver<OvenStatus>() {

            @Override
            public void onNext(OvenStatus status) {
                OvenStatus.Status newStatus = status.getStatus();
                try {
                    if(newStatus.equals(OvenStatus.Status.PRE_HEAT)){
                        ovenStatus = newStatus;
                        responseObserver.onNext(StringResponse.newBuilder()
                                                    .setText("Oven is now pre-heating")
                                                    .build());
                        while (currentTemp < desiredTemp){
                           Thread.sleep(100);
                           currentTemp++;
                           System.out.println("the temp is: " + currentTemp);
                        }
                        ovenStatus = OvenStatus.Status.READY;
                        response = StringResponse.newBuilder().setText("Oven is at temp, current temp is: " + currentTemp).build();
                    }else if(timer > 0 && newStatus.equals(OvenStatus.Status.COOKING)){
                        ovenStatus = newStatus;
                        for (float i = timer; i > 0; i--) {
                            Thread.sleep(1000);
                            responseObserver.onNext(StringResponse.newBuilder()
                                                        .setText("Time Left: " + i + ", current temp is: " + currentTemp)
                                                        .build());
                            System.out.println(i);
                            currentTemp = currentTemp < desiredTemp ? (currentTemp + 5) : currentTemp;
                        }
                        response = StringResponse.newBuilder().setText("ding ding ding..... ding ding ding, cooking completed").build();
                    }else {
                        ovenStatus = OvenStatus.Status.OFF;
                        response = StringResponse.newBuilder().setText("Timer not set or oven is turned off").build();
                        responseObserver.onNext(response);
                        responseObserver.onCompleted();
                    }
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onNext( StringResponse.newBuilder().setText("Oven is turning off").build());
                responseObserver.onCompleted();
                ovenStatus = OvenStatus.Status.OFF;
                timer = 0;
                currentTemp = 0;
            }
        };
    }
}
