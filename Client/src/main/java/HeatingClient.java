import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.coffee_maker.CoffeeMakerServiceGrpc;


public class HeatingClient {

    private static final Heating.Empty EMPTY = Heating.Empty.newBuilder().build();

    private static HeatingServiceGrpc.HeatingServiceBlockingStub blockingStub;

    public void setupClient(final String name, final int port){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port)
                .usePlaintext()
                .build();
        blockingStub = HeatingServiceGrpc.newBlockingStub(channel);
    }

    public int getSystemTempSetting() throws io.grpc.StatusRuntimeException{
        Heating.IntResponse response = blockingStub.getSystemTempSetting(EMPTY);
        return response.getValue();
    }

    public void changeSystemTempSettings(int value) throws io.grpc.StatusRuntimeException{
        Heating.IntRequest request = Heating.IntRequest.newBuilder().setValue(value).build();
        blockingStub.changeSystemTempSettings(request);
    }

    public String toggleHeatingSystemStatus() throws io.grpc.StatusRuntimeException{
        Heating.StringResponse response = blockingStub.toggleHeatingSystemStatus(EMPTY);
        return response.getText();
    }

}
