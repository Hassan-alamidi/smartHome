package io.grpc.examples.oven;

import com.jmDNS.grpc.DnsServiceGrpc;
import com.jmDNS.grpc.details;
import io.grpc.*;
import io.grpc.examples.oven.OvenServiceGrpc.OvenServiceImplBase;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class OvenServer extends OvenServiceImplBase {

    private static final int MAX_TEMP = 250;
    private static final int MIN_TEMP = 0;
    private static final int PORT = 8080;
    private static final String SERVER_NAME = "SmartOven";
    private static final String DEFAULT_TYPE = "_http._tcp.local.";
    private static final String DEFAULT_PATH = "path=index.html";
    private static final String DNS_SERVER_ADDRESS = "127.0.1.1";
    private static final int DNS_SERVER_PORT = 9090;

    private static DnsServiceGrpc.DnsServiceBlockingStub blockingStub;
    private static details serverDetails;
    private static OvenStatus.Status ovenStatus = OvenStatus.Status.OFF;
    private float desiredTemp = 0;
    private float currentTemp = 0;
    private int timer = 0;
    private OvenSetting.Setting setting;
    private StringResponse response;


    public static void main(String[] args){
        OvenServer ovenServer = new OvenServer();

        try {
            //create server and start the server instance
            Server server = ServerBuilder.forPort(PORT)
                    .addService(ovenServer)
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
            System.out.println("server is listening");
            server.awaitTermination();
        } catch(io.grpc.StatusRuntimeException e){
            System.out.println("Error: You must start the dns server first");
        }catch (IOException | InterruptedException e) {
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
    public void changeTemp(IntRequest request, StreamObserver<StringResponse> responseObserver) {
        //get value passed from client and ensure it is within the permitted range if not take min or max value
        float val = request.getValue();
        val = val >= MAX_TEMP ? MAX_TEMP : val;
        val = val <= MIN_TEMP ? MIN_TEMP : val;
        desiredTemp = val;
        //respond to client with new value
        response = StringResponse.newBuilder().setText("desired temp has been set to: " + desiredTemp).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void setTimer(IntRequest request, StreamObserver<StringResponse> responseObserver) {
        //get value from client and respond
        timer = request.getValue();
        response = StringResponse.newBuilder().setText("timer has been set").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void changeSetting(OvenSetting request, StreamObserver<StringResponse> responseObserver) {
        //get value from client and respond
        setting = request.getSetting();
        response = StringResponse.newBuilder().setText("oven has been set to " + setting).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getCurrentStatus(Empty request, StreamObserver<OvenStatus> responseObserver) {
        //return the current status to client
        OvenStatus resp = OvenStatus.newBuilder().setStatus(ovenStatus).build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<OvenStatus> startCooking(StreamObserver<OvenStatus> responseObserver) {
        return new StreamObserver<OvenStatus>() {

            @Override
            public void onNext(OvenStatus status) {
                OvenStatus currentStatus = OvenStatus.newBuilder().build();
                OvenStatus.Status newStatus = status.getStatus();
                try {
                    //if status is currently on preheat go through preheat process
                    if(newStatus.equals(OvenStatus.Status.PRE_HEAT)){
                        ovenStatus = newStatus;
                        while (currentTemp < desiredTemp){
                            //raise temp every 100 milli-seconds
                            currentStatus = OvenStatus.newBuilder().setStatus(ovenStatus).setCurrentTemp(currentTemp).build();
                            responseObserver.onNext(currentStatus);
                           Thread.sleep(100);
                           currentTemp++;

                           System.out.println("the temp is: " + currentTemp);
                        }
                        //preheat complete set oven status to ready and notify the client
                        ovenStatus = OvenStatus.Status.READY;
                        currentStatus = OvenStatus.newBuilder().setCurrentTemp(currentTemp).setRemainingTime(timer).setStatus(ovenStatus).build();
                    }else if(timer > 0 && newStatus.equals(OvenStatus.Status.COOKING)){
                        ovenStatus = newStatus;
                        // if timer is greater than 0 and oven status is set to cooking then begin cooking process
                        for (int i = timer; i > 0 && ovenStatus.equals(OvenStatus.Status.COOKING); i--) {
                            //loop evey second pretending 1 second equals 1 min
                            Thread.sleep(1000);
                            //update the client
                            currentStatus = OvenStatus.newBuilder().setCurrentTemp(currentTemp).setRemainingTime(i).setStatus(ovenStatus).build();
                            responseObserver.onNext(currentStatus);
                            System.out.println(i);
                            //if temp has not reached the desired temp increase by 5 else keep current temp
                            currentTemp = currentTemp < desiredTemp ? (currentTemp + 5) : currentTemp;
                        }
                    }else {
                        //set oven status to off and respond to client
                        ovenStatus = OvenStatus.Status.OFF;
                        currentStatus = OvenStatus.newBuilder().setStatus(ovenStatus).build();
                        response = StringResponse.newBuilder().setText("Timer not set or oven is turned off").build();
                        responseObserver.onNext(currentStatus);
                        responseObserver.onCompleted();
                    }
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
                responseObserver.onNext(currentStatus);
            }

            @Override
            public void onError(Throwable throwable) {
                //server has lost connection to client print message and stacktrace to console
                System.out.println("Lost connection to client");
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                //process is complete reset oven
                ovenStatus = OvenStatus.Status.OFF;
                OvenStatus currentStatus = OvenStatus.newBuilder().setStatus(ovenStatus).build();
                responseObserver.onNext(currentStatus);
                responseObserver.onCompleted();
                timer = 0;
                currentTemp = 0;
            }
        };
    }
}
