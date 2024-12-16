import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;;

public class ChatClient extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
     String username;
     String serverName;
     int port;
     Socket client;
     BufferedReader br;
     PrintWriter pw;
     JTextField textField = new JTextField(50);
     JTextArea messageArea = new JTextArea(16, 50);
     JButton sendButton , exitButton;
   
   
     public ChatClient (String username, String ServerName, int port) throws UnknownHostException, IOException {
        super(username);
        
         this.username = username;
         this.serverName = ServerName;
         this.port = port;

         client = new Socket(serverName, port);
            br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            pw = new PrintWriter(client.getOutputStream(), true);
            pw.println(username);
            buildInterface();
            new MessageThread().start();

        




     }



     public void buildInterface() {

        sendButton = new JButton("Send");
        exitButton = new JButton("Exit");
        JPanel panel = new JPanel(new FlowLayout());
        messageArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(messageArea , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scroll, BorderLayout.CENTER);

        panel.add(textField);
        panel.add(sendButton);
        panel.add(exitButton);
        add(panel, BorderLayout.SOUTH);

        sendButton.addActionListener(this);
        exitButton.addActionListener(this);
        setSize(600, 300);
        setVisible(true);
        pack();


     }
   
     @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitButton) {
            pw.println("end");
            System.exit(0);
        } else {
            pw.println(textField.getText());
            textField.setText("");
        }




    }


    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null, "Enter your name: ", "Username", JOptionPane.PLAIN_MESSAGE);
        String server = "localhost";
        int port = 9999;
        try {
            new ChatClient(name, server, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
    }

    
    
    }








    class MessageThread extends Thread {
        public void run() {
            String line;
            try {
                while(true) {
                    line = br.readLine();
                    messageArea.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}