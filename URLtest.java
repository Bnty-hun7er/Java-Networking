
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class URLtest {

    public static void main(String[] args) throws MalformedURLException {
        // String web = "";

        // URL url = new URL(web);




         try {
            URI uri = new URI("https://en.wikipedia.org/wiki/URL#Citations");
            URL url = uri.toURL();
            URLConnection myUrlConnection = url.openConnection();
            getURLInfo(url);


           
        } catch (IOException  e) {
            System.out.println(e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }




    }


static void getURLInfo(URL url) {
    System.out.println("Protocol is " + url.getProtocol());
    System.out.println("Host is " + url.getHost());
    System.out.println("Port is " + url.getPort());
    System.out.println("Path is " + url.getPath());
    System.out.println("Authority is " + url.getAuthority());
    System.out.println("Query is " + url.getQuery());
    System.out.println("Ref is " + url.getRef());

}


}
