
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

    public static void main(String[] args){
        try {
            //create an instance of jmDns
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            // Add a service listener, to listen out for services to become available or unavailable
            jmdns.addServiceListener("_http._tcp.local.", new SampleListener());
        } catch (final IOException e) {
            //print exception to console, might change this to sl4j logger and store in log file
            e.printStackTrace();
        }
        //setup the GUI
        JFrame frame = new MainMenu();
        frame.setVisible(true);
    }

    private static class SampleListener implements ServiceListener {
        public void serviceAdded(final ServiceEvent event) {
            //print to console a service being added
            System.out.println(event.getInfo().getName() + " has been added");
        }

        public void serviceRemoved(final ServiceEvent event) {
            //get the removed service information
            final ServiceInfo info = event.getInfo();
            //print the service information
            System.out.println(info.getName() + " sever removed");
        }

        public void serviceResolved(final ServiceEvent event) {
            //get the resolved service information
            final ServiceInfo info = event.getInfo();
            //check the service name, this switch is only really to check if service is recognised
            switch (info.getName()) {
                case "SmartOven":
                    ovenClient.setupClient(info.getHostAddresses()[0], info.getPort());
                    System.out.println("Oven sever resolved");
                    break;
                case "SmartCoffeeMaker":
                    coffeeMakerClient.setupClient(info.getHostAddresses()[0], info.getPort());
                    System.out.println("Coffee sever resolved");
                    break;
                case "Lights":
                    lightClient.setupClient(info.getHostAddresses()[0], info.getPort());
                    System.out.println("Light sever resolved");
                    break;
                case "Heating":
                    System.out.println("Heating sever resolved");
                    heatingClient.setupClient(info.getHostAddresses()[0], info.getPort());
                    break;
                default:
                    System.out.println("Service not implemented");
                    break;
            }
        }
    }
}
