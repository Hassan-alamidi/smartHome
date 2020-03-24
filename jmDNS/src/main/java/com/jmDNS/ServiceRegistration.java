package com.jmDNS;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;

public class ServiceRegistration {

    public static void main(String[] args){
        try {
            JmDNS jmDNS = JmDNS.create(InetAddress.getLocalHost());

            ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "SmartOven", 8080, "path=index.html");
            jmDNS.registerService(serviceInfo);

            serviceInfo = ServiceInfo.create("_http._tcp.local.", "SmartCoffeeMaker", 8000, "path=index.html");
            jmDNS.registerService(serviceInfo);

            serviceInfo = ServiceInfo.create("_http._tcp.local.", "Lights", 9000, "path=index.html");
            jmDNS.registerService(serviceInfo);
        } catch (IOException e) {
            //TODO handle this properly
            e.printStackTrace();
        }
    }
}
