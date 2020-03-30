import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.coffee_maker.BrewType;
import io.grpc.examples.coffee_maker.CoffeeMakerServiceGrpc;
import io.grpc.examples.coffee_maker.Empty;
import io.grpc.examples.coffee_maker.Response;
import io.grpc.stub.StreamObserver;
;
import java.util.function.Consumer;

public class CoffeeMakerClient {

    private static CoffeeMakerServiceGrpc.CoffeeMakerServiceStub asyncStub;
    private static CoffeeMakerServiceGrpc.CoffeeMakerServiceBlockingStub blockingStub;
    private static boolean connected = false;

    public void setupClient(final String name, final int port){
        //setup client, create a managed channel connecting client to server
        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port)
                .usePlaintext()
                .build();
        asyncStub = CoffeeMakerServiceGrpc.newStub(channel);
        blockingStub = CoffeeMakerServiceGrpc.newBlockingStub(channel);
    }

    public String setBrewingType(BrewType.type brewingType){
        //this method makes a request to the server to set the brew type
        BrewType brewType = BrewType.newBuilder().setBrewType(brewingType).build();
        return blockingStub.setBrewingType(brewType).getText();
    }

    //this method is the begin brewing method
    public void beginBrewing(Consumer<String> output, Consumer<Double> progress){
        //create a streamObserver
        StreamObserver<Response> responseStreamObserver = new StreamObserver<Response>() {
            @Override
            public void onNext(Response response) {
                //this is callback which updates the UI progress bar
                progress.accept(response.getProgress());
                //this is a callback which updates the UI with any outputs necessary
                output.accept(response.getText());
            }

            @Override
            public void onError(Throwable throwable) {
                //connection to server failed reset and tell user what has happened
                progress.accept(0.0);
                output.accept("Disconnect From Service");
                System.out.println("Disconnect From Service");
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
