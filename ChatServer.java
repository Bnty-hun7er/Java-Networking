import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;
import java.net.ServerSocket;
import static java.lang.System.out;

public class ChatServer {

    static Vector<String> users = new Vector<String>();
    static Vector<HandleClient> clients = new Vector<HandleClient>();

    public void process() throws Exception {
        java.net.ServerSocket server = new java.net.ServerSocket(9999, 10);
        System.out.println("Server Started...");
        while (true) {
            Socket client = server.accept();
            HandleClient c = new HandleClient(client);
            clients.add(c);
        }
    }




    public static void main(String[] args) throws Exception {
        new ChatServer().process();
    }


    public void broadcast(String user, String message) {
        for (HandleClient c : clients) {
            if (!c.getUsernames().equals(user)) {
                c.sendMessage(user, message);
            }
        }
    }
  
    class HandleClient extends Thread {
    
        String name = "" ; 
         BufferedReader input;
         PrintWriter output;
        
         public HandleClient(Socket client ) throws IOException {
        
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            output = new PrintWriter(client.getOutputStream(), true); 
           
            name = input.readLine();
            users.add(name);
        start();
        
     }


     public  void sendMessage(String uname , String message) {
        output.println(uname + "-> " + message);

     }

     public String getUsernames() {

        return name ;
       
     }

     public void run() {
       String Line ; 

       try {
        while(true) {
            Line = input.readLine();
           if (Line.equals("end")) {
               clients.remove(this);
               users.remove(name);
               break;
           }
              broadcast(name, Line);

        }
       } catch (Exception e) {
              System.out.println(e.getMessage());
        
       }
        
    }
    
    
    

    }}
