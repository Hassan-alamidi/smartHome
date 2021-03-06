package io.grpc.examples.coffee_maker;

import com.jmDNS.grpc.DnsServiceGrpc;
import com.jmDNS.grpc.details;
import io.grpc.*;
import io.grpc.examples.coffee_maker.CoffeeMakerServiceGrpc.CoffeeMakerServiceImplBase;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;

public class CoffeeMakerServer extends CoffeeMakerServiceImplBase {

    private static final int PORT = 8000;
    private static final String SERVER_NAME = "SmartCoffeeMaker";
    private static final String DEFAULT_TYPE = "_http._tcp.local.";
    private static final String DEFAULT_PATH = "path=index.html";
    private static final String DNS_SERVER_ADDRESS = "127.0.1.1";
    private static final int DNS_SERVER_PORT = 9090;
    private static final int FULL_CARAFE_BREW_TIME = 600;
    private static final int HALF_CARAFE_BREW_TIME = 300;
    private static final int SINGLE_CUP_BREW_TIME = 180;

    private static DnsServiceGrpc.DnsServiceBlockingStub blockingStub;
    private static details serverDetails;
    private int timer;
    private Response response;

    public static void main(final String[] args){
        CoffeeMakerServer coffeeMakerServer = new CoffeeMakerServer();

        try {
            //create server and start the server instance
            Server server = ServerBuilder.forPort(PORT)
                                        .addService(coffeeMakerServer)
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
    public void setBrewingType(BrewType request, StreamObserver<Response> responseObserver) {
        //get the brewing type and set it
        BrewType.type brewType = request.getBrewType();
        String message;
        //set timer based on brewType passed in
        switch (brewType){
            case CARAFE:
                timer = FULL_CARAFE_BREW_TIME;
                message = "Coffee maker set to brew full carafe";
                break;
            case HALF_CARAFE:
                timer = HALF_CARAFE_BREW_TIME;
                message = "Coffee maker set to brew half carafe";
                break;
            default:
                timer = SINGLE_CUP_BREW_TIME;
                message = "Coffee maker set to brew single cup";
        }
        //build a message response and return to client
        response = Response.newBuilder().setText(message).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void beginBrewing(Empty request, StreamObserver<Response> responseObserver) {

        if(timer > 0){
            //let the client know the brewing process has begun
            response = Response.newBuilder().setText("Your coffee is being brewed").build();
            responseObserver.onNext(response);
            response = Response.newBuilder().setText("Please Wait").build();
            responseObserver.onNext(response);
            for (float i = 0; i < timer; i++) {
                try {
                    //every second update the client to let them know the current status of the brewing process, passing back the completion percentage
                    Thread.sleep(1000);
                    double percent = Math.ceil((i/timer)*100);
                    response = Response.newBuilder().setText("Brewing").setProgress(percent).build();
                    responseObserver.onNext(response);
                    System.out.println(percent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //let the client know the coffee has been brewed
            response = Response.newBuilder().setText("Your coffee has been brewed").setProgress(100).build();
        }else {
            response = Response.newBuilder().setText("brew type not set").build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
