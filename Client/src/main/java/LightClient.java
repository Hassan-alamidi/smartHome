import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.lights.LightsServiceGrpc;
import io.grpc.examples.lights.Empty;
import io.grpc.examples.lights.SintRequest;
import io.grpc.examples.lights.StringResponse;
import io.grpc.examples.oven.OvenStatus;
import io.grpc.stub.StreamObserver;

import java.util.function.Consumer;


public class LightClient {

    private static final Empty EMPTY = Empty.newBuilder().build();

    private static LightsServiceGrpc.LightsServiceStub asyncStub;
    private static LightsServiceGrpc.LightsServiceBlockingStub blockingStub;
    private static StreamObserver<SintRequest> changeLumin;

    private boolean isStreamActive = false;

    //setup resolved server and connect client and server up
    public void setupClient(final String name, final int port){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port)
                .usePlaintext()
                .build();
        asyncStub = LightsServiceGrpc.newStub(channel);
        blockingStub = LightsServiceGrpc.newBlockingStub(channel);
    }

    //toggle lights on/off
    public String toggleLights() throws io.grpc.StatusRuntimeException{
        StringResponse response = blockingStub.toggleLights(EMPTY);
        return response.getText();
    }

    //get the current status of the lights
    public String getLightsStatus() throws io.grpc.StatusRuntimeException{
        StringResponse response = blockingStub.getLightsStatus(EMPTY);
        return response.getText();
    }

    //change the current luminosity outputted by the light
    public void changeLuminosity(int value, Consumer<String> callback) throws io.grpc.StatusRuntimeException {
        //if stream is not already active then start a new strea,
        if (!isStreamActive){
            isStreamActive = true;
            StreamObserver<StringResponse> responseStreamObserver = new StreamObserver<StringResponse>() {
                @Override
                public void onNext(StringResponse response) {
                    //this callback displays the server response to the user
                    callback.accept(response.getText());
                }

                @Override
                public void onError(Throwable throwable) {
                    //this is a callback that displays the error to the user in the output panel
                    callback.accept("Disconnect From Service");
                    System.out.println("Disconnect From Service");
                }

                @Override
                public void onCompleted() {

                }
            };
            changeLumin = asyncStub.changeLuminosity(responseStreamObserver);
        }
        //Sint is no longer really needed but originally using a signed int to allow negative values to be sent to server
        SintRequest sintRequest = SintRequest.newBuilder().setValue(value).build();
        changeLumin.onNext(sintRequest);
    }

    public void endStream(){
        //this ends the stream
        System.out.println("Stream Ended");
        isStreamActive = false;
        changeLumin.onCompleted();
    }

    public boolean isStreamActive(){
        //check if stream is active
        return isStreamActive;
    }


}
