
import java.net.InetAddress;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


 



public class ClientTCP {

    private static InetAddress host;
    private static final int PORT = 2847;


    public static void main(String[] args) {
        try {
            host = InetAddress.getLocalHost();
        } catch (Exception e) {
            System.out.println("HOST NOT FOUND ! EXCEPTION : " + e.getMessage());
            System.exit(1);
        }

        accessServer();

    }

    private static void accessServer() {
        Socket link = new Socket();

        try {
            link = new Socket(host, PORT);

            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output = new PrintWriter(link.getOutputStream(), true);

            Scanner userEntry = new Scanner(System.in);
            String message, response;
            do {
                System.out.println("ENTER MESSAGE : ");
                message = userEntry.nextLine();
                output.println(message);
                response = input.nextLine();
                System.out.println("\nSERVER> " + response);
            } while (!message.equals("***CLOSES***"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                System.out.println("\n* CLOSING CONNECTION . . . *");
                link.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
     
}
