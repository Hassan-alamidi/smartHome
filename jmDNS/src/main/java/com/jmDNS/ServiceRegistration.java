package com.jmDNS;

import com.jmDNS.grpc.DnsServiceGrpc;
import com.jmDNS.grpc.Empty;
import com.jmDNS.grpc.details;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceRegistration extends DnsServiceGrpc.DnsServiceImplBase {

    private static final int PORT = 9090;
    private static JmDNS jmDNS;
    //the list of services in a key value pair, this is so we can find a registered service via name and unregister that service with the stored serviceInfo
    private static Map<String, ServiceInfo> listOfServices;

    public static void main(String[] args){
        listOfServices = new HashMap<String, ServiceInfo>();

        try {
            //create a server instance
            ServiceRegistration serviceRegistration = new ServiceRegistration();
            //build and start the server
            Server server = ServerBuilder.forPort(PORT)
                    .addService(serviceRegistration)
                    .build()
                    .start();
            //create a JmDNS instance
            jmDNS = JmDNS.create(InetAddress.getLocalHost());
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            //printing to terminal, no need to store in log file
            e.printStackTrace();
        }
    }

    @Override
    public void selfRegistration(details request, StreamObserver<Empty> responseObserver) throws io.grpc.StatusRuntimeException {
        try {
            System.out.println("Service Registered");
            //with information provided register the service
            ServiceInfo serviceInfo = ServiceInfo.create(request.getType(), request.getName(), request.getPort(), request.getPath());
            jmDNS.registerService(serviceInfo);
            //store information in a list for later retrieval
            listOfServices.put(request.getName(), serviceInfo);
            //respond to service
            Empty empty = Empty.newBuilder().build();
            responseObserver.onNext(empty);
            responseObserver.onCompleted();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selfUnregister(details request, StreamObserver<Empty> responseObserver) throws io.grpc.StatusRuntimeException {
        System.out.println("Unregistered");
        //get and remove the service information from the list
        ServiceInfo info = listOfServices.remove(request.getName());
        //with the service information retrieved from the list unregister the service
        jmDNS.unregisterService(info);
        //return empty response
        Empty empty = Empty.newBuilder().build();
        responseObserver.onNext(empty);
        responseObserver.onCompleted();
    }
}
