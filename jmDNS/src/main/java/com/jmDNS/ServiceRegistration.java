package com.jmDNS;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;

public class ServiceRegistration {

    private static final String DEFAULT_TYPE = "_http._tcp.local.";
    private static final String DEFAULT_PATH = "path=index.html";
    private static JmDNS jmDNS;

    public static void main(String[] args){
        try {
            jmDNS = JmDNS.create(InetAddress.getLocalHost());

            ServiceInfo serviceInfo = ServiceInfo.create(DEFAULT_TYPE, "SmartOven", 8080, DEFAULT_PATH);
            jmDNS.registerService(serviceInfo);

            serviceInfo = ServiceInfo.create(DEFAULT_TYPE, "SmartCoffeeMaker", 8000, DEFAULT_PATH);
            jmDNS.registerService(serviceInfo);

            serviceInfo = ServiceInfo.create(DEFAULT_TYPE, "Lights", 9000, DEFAULT_PATH);
            jmDNS.registerService(serviceInfo);

            serviceInfo = ServiceInfo.create(DEFAULT_TYPE, "Heating", 4000, DEFAULT_PATH);
            jmDNS.registerService(serviceInfo);
        } catch (IOException e) {
            //TODO handle this properly
            e.printStackTrace();
        }
    }

    private void unregister(String name){
        ServiceInfo serviceInfo = jmDNS.getServiceInfo(DEFAULT_TYPE,name);
        if(serviceInfo != null){
            jmDNS.unregisterService(serviceInfo);
        }
    }
}
