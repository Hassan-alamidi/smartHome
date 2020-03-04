package io.grpc.examples.oven;

import io.grpc.Context;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.examples.oven.OvenServiceGrpc.OvenServiceImplBase;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class OvenServer extends OvenServiceImplBase {

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
    public void changeTemp(floatRequest request, StreamObserver<StringResponse> responseObserver) {
        desiredTemp = request.getValue();

        response = StringResponse.newBuilder().setText("desired temp has been set").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void setTimer(floatRequest request, StreamObserver<StringResponse> responseObserver) {
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
    public void startCooking(Empty request, StreamObserver<StringResponse> responseObserver) {
        if(timer > 0){
            for (float i = timer; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                    response = StringResponse.newBuilder().setText("Time Left: " + i).build();
                    responseObserver.onNext(response);
                    Context.current().isCancelled();
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            response = StringResponse.newBuilder().setText("ding ding ding..... ding ding ding, cooking completed").build();
        }else {
            response = StringResponse.newBuilder().setText("Timer not set").build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
