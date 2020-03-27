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

    public void getSystemTempSetting(){
        Heating.FloatResponse response = blockingStub.getSystemTempSetting(EMPTY);
        System.out.println(response.getValue());
    }

    public void changeSystemTempSettings(){

    }

    public void toggleHeatingSystemStatus(){

    }

}
