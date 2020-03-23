package io.grpc.examples.coffee_maker;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class CoffeeMakerClient {

    private static CoffeeMakerServiceGrpc.CoffeeMakerServiceStub asyncStub;
    private static CoffeeMakerServiceGrpc.CoffeeMakerServiceBlockingStub blockingStub;
    private static boolean connected = false;

    public static void main(String[] args){
        //NOTE this main class is unneeded, it is only used for testing
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8000)
                                                        .usePlaintext()
                                                        .build();
        asyncStub = CoffeeMakerServiceGrpc.newStub(channel);
        blockingStub = CoffeeMakerServiceGrpc.newBlockingStub(channel);
        //setBrewingType();
        //beginBrewing();
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setupClient(final String name, final int port){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port)
                .usePlaintext()
                .build();
        asyncStub = CoffeeMakerServiceGrpc.newStub(channel);
        blockingStub = CoffeeMakerServiceGrpc.newBlockingStub(channel);
    }

    public void setBrewingType(){
        BrewType brewType = BrewType.newBuilder().setBrewType(BrewType.type.SINGLE_CUP).build();
        StringResponse response = blockingStub.setBrewingType(brewType);
        System.out.println(response.getText());
    }

    public void beginBrewing(){
        StreamObserver<StringResponse> responseStreamObserver = new StreamObserver<StringResponse>() {
            @Override
            public void onNext(StringResponse stringResponse) {
                System.out.println(stringResponse.getText());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                System.out.println("request completed");
            }
        };
        Empty empty = Empty.newBuilder().build();
        asyncStub.beginBrewing(empty, responseStreamObserver);
    }

    public void toggleConnected(){
        connected = !connected;
    }

    public boolean isConnected(){
        return connected;
    }
}
