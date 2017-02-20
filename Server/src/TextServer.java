import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TextServer extends Thread {
	public static final int SOCKET_TIMEOUT = 100000;
	public static final String PORTNUMBER = "5555";
	private ServerSocket serverSocket;

	public TextServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(SOCKET_TIMEOUT);
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Reading the text file! Clients can connect to get it!");
				String textFromFile = TextProcessor.readText();

				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();

				System.out.println("Just connected to " + server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());

				System.out.println("Message from Client: " + in.readUTF());
				DataOutputStream out = new DataOutputStream(server.getOutputStream());

				out.writeUTF(textFromFile);
				server.close();

			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public static void main(String[] args) {
		int port = Integer.parseInt(PORTNUMBER);
		try {
			Thread t = new TextServer(port);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
