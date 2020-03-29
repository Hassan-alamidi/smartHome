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
        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port)
                .usePlaintext()
                .build();
        asyncStub = CoffeeMakerServiceGrpc.newStub(channel);
        blockingStub = CoffeeMakerServiceGrpc.newBlockingStub(channel);
    }

    public String setBrewingType(BrewType.type brewingType){
        BrewType brewType = BrewType.newBuilder().setBrewType(brewingType).build();
        return blockingStub.setBrewingType(brewType).getText();
    }

    public void beginBrewing(Consumer<String> output, Consumer<Double> progress){
        StreamObserver<Response> responseStreamObserver = new StreamObserver<Response>() {
            @Override
            public void onNext(Response response) {
                progress.accept(response.getProgress());
                output.accept(response.getText());
            }

            @Override
            public void onError(Throwable throwable) {
                progress.accept(0.0);
                output.accept("Disconnect From Service");
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
