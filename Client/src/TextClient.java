import java.net.*;
import java.io.*;

public class TextClient {
public static final String SERVERNAME = "127.0.0.1";
public static final String PORTNUMBER = "5555";	
	
    public static void main(String [] args) {
        int port = Integer.parseInt(PORTNUMBER);
        try {
            System.out.println("Connecting to " + SERVERNAME + " on port " + port);
            Socket client = new Socket(SERVERNAME, port);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
           
            String textFromServer = in.readUTF();
            System.out.println("\nServer sent this text:\n \"" + textFromServer +"\"");
            Statistics.findMostCommonWords(textFromServer);
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
