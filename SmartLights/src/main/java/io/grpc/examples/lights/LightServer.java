package io.grpc.examples.lights;

import com.jmDNS.grpc.DnsServiceGrpc;
import com.jmDNS.grpc.details;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.examples.lights.LightsServiceGrpc.LightsServiceImplBase;

import java.io.IOException;

public class LightServer extends LightsServiceImplBase {

    private static final int PORT = 9000;
    private static final String SERVER_NAME = "Lights";
    private static final String DEFAULT_TYPE = "_http._tcp.local.";
    private static final String DEFAULT_PATH = "path=index.html";
    private static final String DNS_SERVER_ADDRESS = "127.0.1.1";
    private static final int DNS_SERVER_PORT = 9090;

    private static DnsServiceGrpc.DnsServiceBlockingStub blockingStub;
    private static details serverDetails;
    private static int MAX_LUMENS = 1000;
    private static int MIN_LUMENS = 250;

    private int currentLuminosity = 1000;
    private boolean lightOn = false;

    public static void main(final String[] args){
        LightServer lightServer = new LightServer();

        try {
            //create server and start the server instance
            final Server server = ServerBuilder.forPort(PORT)
                                                .addService(lightServer)
                                                .build()
                                                .start();
            //connect to dns server
            DnsConnection();
            //create a message containing all of the servers details
            serverDetails = details.newBuilder()
                                    .setPort(PORT)
                                    .setType(DEFAULT_TYPE)
                                    .setName(SERVER_NAME)
                                    .setPath(DEFAULT_PATH)
                                    .build();
            //pass the server details on to the DNS server for registration
            blockingStub.selfRegistration(serverDetails);
            //create a shutdown hook to allow the server to unregister itself from the DNS services list
            createShutdownHook();
            System.out.println("Server is listening");
            server.awaitTermination();
        } catch(io.grpc.StatusRuntimeException e){
            System.out.println("Error: You must start the dns server first");
        } catch (IOException | InterruptedException e) {
            blockingStub.selfUnregister(serverDetails);
            e.printStackTrace();
        }

    }

    private static void createShutdownHook(){
        //this is a shutdown hook to ensure the service gets unregistered when shutting down
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println("shutdown");
                blockingStub.selfUnregister(serverDetails);
            }
        }));
    }

    private static void DnsConnection(){
        //create connection to dns server
        ManagedChannel channel = ManagedChannelBuilder.forAddress(DNS_SERVER_ADDRESS, DNS_SERVER_PORT)
                .usePlaintext()
                .build();
        blockingStub = DnsServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public void toggleLights(final Empty request, final StreamObserver<StringResponse> responseObserver) {
        //reverse the light status
        lightOn = !lightOn;
        String message;
        if(lightOn){
            message = "Lights have been turned on";
        }else {
            message = "Lights have been turned off";
        }
        //build a message response and return to client
        StringResponse response = StringResponse.newBuilder()
                                                .setText(message)
                                                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getLightsStatus(final Empty request, final StreamObserver<StringResponse> responseObserver) {
        //check light status
        String message;
        if(lightOn){
            message = "Lights turned on, current luminosity set to " + currentLuminosity;
        }else {
            message = "Lights are currently turned off";
        }
        //build a message response and return to client
        StringResponse response = StringResponse.newBuilder()
                                                .setText(message)
                                                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<SintRequest> changeLuminosity(final StreamObserver<StringResponse> responseObserver) {

        return new StreamObserver<SintRequest>() {
            int beforeRequest = currentLuminosity;
            @Override
            public void onNext(SintRequest value) {
                //make sure value passed from client is not out of bounds
                if(value.getValue() < MAX_LUMENS && value.getValue() > MIN_LUMENS){
                    currentLuminosity = value.getValue();
                }else {
                    //build a message response and return to client
                    responseObserver.onNext( StringResponse.newBuilder().setText("Out of bounds").build());
                    responseObserver.onCompleted();
                }
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                String message;
                if(currentLuminosity > beforeRequest){
                    message = "Luminosity has been increased to " + currentLuminosity;
                }else if(currentLuminosity < beforeRequest){
                    message = "Luminosity has been decreased to " + currentLuminosity;
                }else{
                    message = "no change";
                }
                //build a message response and return to client
                StringResponse response = StringResponse.newBuilder().setText(message).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }


        };
    }
}
