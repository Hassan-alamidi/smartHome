import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.oven.*;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;

public class OvenClient {

    private static final Empty empty = Empty.newBuilder().build();
    private static OvenServiceGrpc.OvenServiceStub asyncStub;
    private static OvenServiceGrpc.OvenServiceBlockingStub blockingStub;

    public void setupClient(final String name, final int port){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port)
                .usePlaintext()
                .build();
        asyncStub = OvenServiceGrpc.newStub(channel);
        blockingStub = OvenServiceGrpc.newBlockingStub(channel);
    }

    public void setTemp(){
        //TODO pass temp in
        IntRequest request = IntRequest.newBuilder().setValue(300).build();
        StringResponse response = blockingStub.changeTemp(request);
        System.out.println(response.getText());
    }

    public void setTimer(){
        //TODO pass timer in
        IntRequest request = IntRequest.newBuilder().setValue(200).build();
        StringResponse response = blockingStub.setTimer(request);
        System.out.println(response.getText());
    }

    public void startCooking(){
        //remember using bi-directional to allow early turn off
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
        StreamObserver<OvenStatus> beginCooking = asyncStub.startCooking(responseStreamObserver);

        //beginCooking.onNext(OvenStatus.newBuilder().setStatus(OvenStatus.Status.PRE_HEAT).build());
        Scanner scanner = new Scanner(System.in);
        System.out.println("press enter to continue");
        scanner.nextLine();
        Empty empty = Empty.newBuilder().build();
        OvenStatus status = blockingStub.getCurrentStatus(empty);
        while (status.getStatus().equals(OvenStatus.Status.PRE_HEAT)){
            System.out.println("Oven is not ready yet try again after system has notified you that oven is ready");
            scanner.nextLine();
            status = blockingStub.getCurrentStatus(empty);
        }
        beginCooking.onNext(OvenStatus.newBuilder().setStatus(OvenStatus.Status.COOKING).build());
        System.out.println("starting to cook");
        scanner.nextLine();
        beginCooking.onCompleted();
    }
}
