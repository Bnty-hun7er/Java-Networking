// import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Collections; 



public class NetworkInterface {

    public static void main(String[] args) {
        System.out.println("MyNetworkInterface class is running.");
        

        try {


            Enumeration<java.net.NetworkInterface> networkIe = java.net.NetworkInterface.getNetworkInterfaces(); 
            System.out.println("Network Interfaces :\n " );

            for (java.net.NetworkInterface element : Collections.list(networkIe)) {
                System.out.printf("%-8s %-32s \n" , element.getName(), element.getDisplayName());
            }



        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    
}
