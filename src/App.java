import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.channels.ReadableByteChannel;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;

public class App {

    

    public static void main(String[] args) throws UnknownHostException, IOException{
        // InetAddress mikebenWebsite = InetAddress.getByName("mikeben.me");
        // System.out.println(mikebenWebsite);

        // InetAddress heckTimouet = InetAddress.getByName("club4hackers.42web.io");
        // System.out.println("Host Address    : " + heckTimouet.getHostAddress());
        // System.out.println("Host Name       : " + heckTimouet.getHostName());
        // heckTimouet.isReachable(10000) ;
        // System.out.println("Host Reachable   " );


        try {
            URI uri = new URI("http://mikeben.me");
            URL url = uri.toURL();
            URLConnection myUrlConnection = url.openConnection();
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(myUrlConnection.getInputStream()));

            String inputLine;

            while ((inputLine = br.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }
    }


    

        



}



}
