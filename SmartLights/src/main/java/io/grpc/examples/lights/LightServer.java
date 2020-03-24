package io.grpc.examples.lights;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.examples.lights.LightsServiceGrpc.LightsServiceImplBase;

import java.io.IOException;

public class LightServer extends LightsServiceImplBase {

    private static final int PORT = 9000;
    private static int MAX_LUMENS = 1000;
    private static int MIN_LUMENS = 250;

    private int currentLuminosity = 0;
    private boolean lightOn = false;

    public static void main(final String[] args){
        LightServer lightServer = new LightServer();

        try {
            final Server server = ServerBuilder.forPort(PORT)
                                                .addService(lightServer)
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
    public void toggleLights(final Empty request, final StreamObserver<StringResponse> responseObserver) {
        lightOn = !lightOn;
        String message;
        if(lightOn){
            message = "Lights have been turned on";
        }else {
            message = "Lights have been turned off";
        }

        StringResponse response = StringResponse.newBuilder()
                                                .setText(message)
                                                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getLightsStatus(final Empty request, final StreamObserver<StringResponse> responseObserver) {
        lightOn = !lightOn;
        String message;
        if(lightOn){
            message = "Lights are currently turned on, \n current luminosity is set to " + currentLuminosity;
        }else {
            message = "Lights are currently turned off";
        }

        StringResponse response = StringResponse.newBuilder()
                .setText(message)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<SintRequest> changeLuminosity(final StreamObserver<StringResponse> responseObserver) {

        return new StreamObserver<SintRequest>() {
            int beforeRequest = currentLuminosity;
            @Override
            public void onNext(SintRequest value) {
                currentLuminosity += value.getValue();
            }

            @Override
            public void onError(Throwable t) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onCompleted() {
                String message;
                if(currentLuminosity > beforeRequest){
                    message = "Luminosity has been increased to " + currentLuminosity;
                }else if(currentLuminosity < beforeRequest){
                    message = "Luminosity has been decreased to " + currentLuminosity;
                }else{
                    message = "no change";
                }

                StringResponse response = StringResponse.newBuilder().setText(message).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }


        };
    }
}
