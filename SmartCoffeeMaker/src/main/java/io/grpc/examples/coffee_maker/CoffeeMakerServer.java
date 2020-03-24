package io.grpc.examples.coffee_maker;

import io.grpc.Context;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.examples.coffee_maker.CoffeeMakerServiceGrpc.CoffeeMakerServiceImplBase;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class CoffeeMakerServer extends CoffeeMakerServiceImplBase {

    private static final int PORT = 8000;
    private static final int FULL_CARAFE_BREW_TIME = 600;
    private static final int HALF_CARAFE_BREW_TIME = 300;
    private static final int SINGLE_CUP_BREW_TIME = 180;

    private static int timer;
    private static StringResponse response;

    public static void main(final String[] args){
        CoffeeMakerServer coffeeMakerServer = new CoffeeMakerServer();

        try {
            Server server = ServerBuilder.forPort(PORT)
                                        .addService(coffeeMakerServer)
                                        .build()
                                        .start();
            System.out.println("Server is listening");
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            //TODO handle this properly
            e.printStackTrace();
        }
    }

    @Override
    public void setBrewingType(BrewType request, StreamObserver<StringResponse> responseObserver) {
        BrewType.type brewType = request.getBrewType();
        String message;
        switch (brewType){
            case CARAFE:
                timer = FULL_CARAFE_BREW_TIME;
                message = "Coffee maker set to brew full carafe";
                break;
            case HALF_CARAFE:
                timer = HALF_CARAFE_BREW_TIME;
                message = "Coffee maker set to brew half carafe";
                break;
            default:
                timer = SINGLE_CUP_BREW_TIME;
                message = "Coffee maker set to brew single cup";
        }
        response = StringResponse.newBuilder().setText(message).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void beginBrewing(Empty request, StreamObserver<StringResponse> responseObserver) {

        if(timer > 0){
            response = StringResponse.newBuilder().setText("Your coffee is being brewed").build();
            responseObserver.onNext(response);
            response = StringResponse.newBuilder().setText("Please Wait").build();
            responseObserver.onNext(response);
            for (float i = timer; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    //TODO handle this properly
                    e.printStackTrace();
                }
            }
            response = StringResponse.newBuilder().setText("Your coffee has been brewed").build();
        }else {
            response = StringResponse.newBuilder().setText("brew type not set").build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
