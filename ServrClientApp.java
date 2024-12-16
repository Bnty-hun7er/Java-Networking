

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



class ServerClietApp {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(1236);

        Socket link = serverSocket.accept(); // STEP 2


        Scanner input = new Scanner(link.getInputStream());     //STEP 3
        PrintWriter output = new PrintWriter(link.getOutputStream());  //STEP 3


        output.println("Awating for data...");    //STEP 4
        String myinput = input.nextLine();           //STEP 4

        link.close();  //STEP 5


    }
}