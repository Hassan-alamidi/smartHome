package io.grpc.examples.coffee_maker;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class CoffeeMakerClient {

    private static CoffeeMakerServiceGrpc.CoffeeMakerServiceStub asyncStub;
    private static CoffeeMakerServiceGrpc.CoffeeMakerServiceBlockingStub blockingStub;

    public static void main(String[] args){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8000)
                                                        .usePlaintext()
                                                        .build();
        asyncStub = CoffeeMakerServiceGrpc.newStub(channel);
        blockingStub = CoffeeMakerServiceGrpc.newBlockingStub(channel);
        setBrewingType();
        beginBrewing();
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void setupClient(final String name, final int port){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8000)
                .usePlaintext()
                .build();
        asyncStub = CoffeeMakerServiceGrpc.newStub(channel);
        blockingStub = CoffeeMakerServiceGrpc.newBlockingStub(channel);
    }

    public static void setBrewingType(){
        BrewType brewType = BrewType.newBuilder().setBrewType(BrewType.type.SINGLE_CUP).build();
        StringResponse response = blockingStub.setBrewingType(brewType);
        System.out.println(response.getText());
    }

    public static void beginBrewing(){
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
}
