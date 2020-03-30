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
    private StreamObserver<OvenStatus> beginCooking;

    //setup resolved service
    public void setupClient(final String name, final int port){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port)
                .usePlaintext()
                .build();
        asyncStub = OvenServiceGrpc.newStub(channel);
        blockingStub = OvenServiceGrpc.newBlockingStub(channel);
    }

    //send request to server to change desired temp
    public String setTemp(int temp) throws io.grpc.StatusRuntimeException{
        IntRequest request = IntRequest.newBuilder().setValue(temp).build();
        StringResponse response = blockingStub.changeTemp(request);
        return response.getText();
    }

    //send request to server to set the desired timer
    public String setTimer(int value) throws io.grpc.StatusRuntimeException{
        IntRequest request = IntRequest.newBuilder().setValue(value).build();
        StringResponse response = blockingStub.setTimer(request);
        return response.getText();
    }

    //send request to server to change the oven setting
    public String changeSetting(OvenSetting.Setting setting) throws io.grpc.StatusRuntimeException{
        OvenSetting ovenSetting = OvenSetting.newBuilder().setSetting(setting).build();
        StringResponse response = blockingStub.changeSetting(ovenSetting);
        return response.getText();
    }

    //request the current status of the oven
    public OvenStatus getCurrentStatus() throws io.grpc.StatusRuntimeException{
        OvenStatus response = blockingStub.getCurrentStatus(empty);
        return response;
    }

    //initiate the cooking process
    public void startCooking(Consumer<OvenStatus> progress) throws io.grpc.StatusRuntimeException{
        //remember using bi-directional to allow early turn off
        StreamObserver<OvenStatus> responseStreamObserver = new StreamObserver<OvenStatus>() {
            @Override
            public void onNext(OvenStatus response) {
                //callback to display the ovens progress
                progress.accept(response);
            }

            @Override
            public void onError(Throwable throwable) {
                //if connection fails and this method is executed then reset the panel and output message to console
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
        beginCooking = asyncStub.startCooking(responseStreamObserver);
        //tell server to begin preheating
        beginCooking.onNext(OvenStatus.newBuilder().setStatus(OvenStatus.Status.PRE_HEAT).build());
        Empty empty = Empty.newBuilder().build();
        OvenStatus status = getCurrentStatus();
        //while the oven is still in pre heating status loop
        while (status.getStatus().equals(OvenStatus.Status.PRE_HEAT)){
            //wait one second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //callback to update user on current status
            progress.accept(status);
            //check the oven status again
            status = getCurrentStatus();
            System.out.println(status.getStatus());
        }
        //Pre heat is complete now move forward to the cooking process
        beginCooking.onNext(OvenStatus.newBuilder().setStatus(OvenStatus.Status.COOKING).build());
        System.out.println("starting to cook");
    }
}
