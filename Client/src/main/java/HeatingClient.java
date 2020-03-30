import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.coffee_maker.CoffeeMakerServiceGrpc;


public class HeatingClient {

    private static final Heating.Empty EMPTY = Heating.Empty.newBuilder().build();

    private static HeatingServiceGrpc.HeatingServiceBlockingStub blockingStub;

    //setup resolved server and connect client upto server
    public void setupClient(final String name, final int port){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port)
                .usePlaintext()
                .build();
        blockingStub = HeatingServiceGrpc.newBlockingStub(channel);
    }

    //get the systems current temperature setting
    public int getSystemTempSetting() throws io.grpc.StatusRuntimeException{
        Heating.IntResponse response = blockingStub.getSystemTempSetting(EMPTY);
        return response.getValue();
    }

    //change the systems temperature setting
    public void changeSystemTempSettings(int value) throws io.grpc.StatusRuntimeException{
        Heating.IntRequest request = Heating.IntRequest.newBuilder().setValue(value).build();
        blockingStub.changeSystemTempSettings(request);
    }

    //toggle the system on/off
    public String toggleHeatingSystemStatus() throws io.grpc.StatusRuntimeException{
        Heating.StringResponse response = blockingStub.toggleHeatingSystemStatus(EMPTY);
        return response.getText();
    }

}
