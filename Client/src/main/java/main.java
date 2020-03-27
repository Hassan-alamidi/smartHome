
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import java.io.IOException;
import java.net.InetAddress;

public class main {

    public static CoffeeMakerClient coffeeMakerClient = new CoffeeMakerClient();
    public static OvenClient ovenClient = new OvenClient();
    public static LightClient lightClient = new LightClient();
    public static HeatingClient heatingClient = new HeatingClient();
    //PLANNN all services on GUI are grayed out but as they are resolved they will nolonger be grayed out
    //this will probably solve the issue with java skipping if statements in loops for initializations as no loop will be required

    public static void main(String[] args){
        JFrame frame = new MainMenu();
        frame.setVisible(true);
        JmDNS jmdns = null;
        try {
            jmdns = JmDNS.create(InetAddress.getLocalHost());
        } catch (final IOException e) {
            //TODO handle this properly, in other words, if fails whats plan B
            e.printStackTrace();
        }

        // Add a service listener
        jmdns.addServiceListener("_http._tcp.local.", new SampleListener());

        try {
            Thread.sleep(300000);
        } catch (final InterruptedException e) {
            // TODO remove when GUI implemented
            e.printStackTrace();
        }
    }

    private static class SampleListener implements ServiceListener {
        //TODO move this into its own file when GUI has been implemented
        public void serviceAdded(final ServiceEvent event) {
            System.out.println(event.getInfo().getName());
        }

        public void serviceRemoved(final ServiceEvent event) {
            final ServiceInfo info = event.getInfo();
            if (info.getName().equals("SmartOven")) {
                //TODO
            }else if(info.getName().equals("SmartCoffeeMaker")){
                coffeeMakerClient.toggleConnected();
                System.out.println("coffee maker has been disconnected");
            }else if(info.getName().equals("Lights")){

            }
        }

        public void serviceResolved(final ServiceEvent event) {
            final ServiceInfo info = event.getInfo();
            if (info.getName().equals("SmartOven")) {
                ovenClient.setupClient(info.getHostAddresses()[0],info.getPort());
                //ovenClient.setTemp();
                //ovenClient.setTimer();
                //ovenClient.startCooking();
                System.out.println("oven sever resolved");
            }else if(info.getName().equals("SmartCoffeeMaker")){
                coffeeMakerClient.setupClient(info.getHostAddresses()[0],info.getPort());
                //coffeeMakerClient.toggleConnected();
                System.out.println("coffee sever resolved");
                //coffeeMakerClient.setBrewingType();
                //coffeeMakerClient.beginBrewing();
            }else if(info.getName().equals("Lights")){
                lightClient.setupClient(info.getHostAddresses()[0],info.getPort());
                //lightClient.changeLuminosity();
                //lightClient.getLightsStatus();
            }else if(info.getName().equals("Heating")){
                System.out.println("Heating sever resolved");
                heatingClient.setupClient(info.getHostAddresses()[0],info.getPort());
                //heatingClient.getSystemTempSetting();
            }else {
                System.out.println("Service not implemented");
            }
        }
    }
}