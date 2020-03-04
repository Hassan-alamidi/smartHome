package io.grpc.examples.oven;

import io.grpc.Context;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class OvenClient {

    private static final Empty empty = Empty.newBuilder().build();
    private static OvenServiceGrpc.OvenServiceStub asyncStub;
    private static OvenServiceGrpc.OvenServiceBlockingStub blockingStub;
    private static Context.CancellableContext cancellableContext;

    public static void main(String[] args){
        cancellableContext = Context.current().withCancellation();
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
        asyncStub = OvenServiceGrpc.newStub(channel);
        blockingStub = OvenServiceGrpc.newBlockingStub(channel);
        setTimer();
        startCooking();

        try {
            Thread.sleep(5000);
            cancellableContext.cancel(new Exception());
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void setTimer(){
        FloatRequest request = FloatRequest.newBuilder().setValue(200).build();
        StringResponse response = blockingStub.setTimer(request);
        System.out.println(response.getText());
    }

    private static void startCooking(){

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
                cancellableContext.cancel(null);
            }
        };
        cancellableContext.run(new Runnable() {
            @Override
            public void run() {
                asyncStub.startCooking(empty, responseStreamObserver);
            }
        });
        System.out.println("starting to cook");
    }
}
