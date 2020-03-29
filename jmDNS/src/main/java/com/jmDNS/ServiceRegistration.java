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
    private static Map<String, ServiceInfo> listOfServices;

    public static void main(String[] args){
        listOfServices = new HashMap<String, ServiceInfo>();

        try {
            ServiceRegistration serviceRegistration = new ServiceRegistration();
            Server server = ServerBuilder.forPort(PORT)
                    .addService(serviceRegistration)
                    .build()
                    .start();
            jmDNS = JmDNS.create(InetAddress.getLocalHost());

            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            //TODO handle this properly
            e.printStackTrace();
        }
    }

    @Override
    public void selfRegistration(details request, StreamObserver<Empty> responseObserver) throws io.grpc.StatusRuntimeException {
        try {
            System.out.println("Service Registered");
            ServiceInfo serviceInfo = ServiceInfo.create(request.getType(), request.getName(), request.getPort(), request.getPath());
            jmDNS.registerService(serviceInfo);
            listOfServices.put(request.getName(), serviceInfo);
            Empty empty = Empty.newBuilder().build();
            responseObserver.onNext(empty);
            responseObserver.onCompleted();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selfUnregister(details request, StreamObserver<Empty> responseObserver) throws io.grpc.StatusRuntimeException {
        ServiceInfo info = listOfServices.remove(request.getName());
        jmDNS.unregisterService(info);
        Empty empty = Empty.newBuilder().build();
        responseObserver.onNext(empty);
        responseObserver.onCompleted();
    }
}
