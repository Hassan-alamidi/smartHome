import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.oven.*;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;
import java.util.function.Consumer;

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

    public String setTemp(int temp) throws io.grpc.StatusRuntimeException{
        IntRequest request = IntRequest.newBuilder().setValue(temp).build();
        StringResponse response = blockingStub.changeTemp(request);
        return response.getText();
    }

    public String setTimer(int value) throws io.grpc.StatusRuntimeException{
        IntRequest request = IntRequest.newBuilder().setValue(value).build();
        StringResponse response = blockingStub.setTimer(request);
        return response.getText();
    }

    public String changeSetting(OvenSetting.Setting setting) throws io.grpc.StatusRuntimeException{
        OvenSetting ovenSetting = OvenSetting.newBuilder().setSetting(setting).build();
        StringResponse response = blockingStub.changeSetting(ovenSetting);
        return response.getText();
    }

    public OvenStatus getCurrentStatus() throws io.grpc.StatusRuntimeException{
        OvenStatus response = blockingStub.getCurrentStatus(empty);
        return response;
    }

    public void startCooking(Consumer<OvenStatus> progress) throws io.grpc.StatusRuntimeException{
        //remember using bi-directional to allow early turn off
        StreamObserver<OvenStatus> responseStreamObserver = new StreamObserver<OvenStatus>() {
            @Override
            public void onNext(OvenStatus response) {
                progress.accept(response);
            }

            @Override
            public void onError(Throwable throwable) {
                OvenStatus status = OvenStatus.newBuilder()
                                            .setStatus(OvenStatus.Status.OFF)
                                            .setCurrentTemp(0)
                                            .setRemainingTime(0)
                                            .build();
                progress.accept(status);
                System.out.println("Disconnect From Service");
            }

            @Override
            public void onCompleted() {
                System.out.println("request completed");
            }
        };
        StreamObserver<OvenStatus> beginCooking = asyncStub.startCooking(responseStreamObserver);

        beginCooking.onNext(OvenStatus.newBuilder().setStatus(OvenStatus.Status.PRE_HEAT).build());
        Empty empty = Empty.newBuilder().build();
        OvenStatus status = blockingStub.getCurrentStatus(empty);
        while (status.getStatus().equals(OvenStatus.Status.PRE_HEAT)){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progress.accept(status);
            status = blockingStub.getCurrentStatus(empty);
            System.out.println(status.getStatus());
        }
        beginCooking.onNext(OvenStatus.newBuilder().setStatus(OvenStatus.Status.COOKING).build());
        System.out.println("starting to cook");
        beginCooking.onCompleted();
    }
}
