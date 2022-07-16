
import java.net.*;
import java.io.*;

/**
 * Program to Transfer Data from Client to Server
 */

public class ChatClient1 { // A Java Class for the Client

	public static void main(String[] args) {
		try {
			// initialize socket and input stream
			// establish a connection by providing host and port
			// number
			Socket socket = new Socket("localhost", 1234);
			// sends output to the socket
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

			DataInputStream dis = new DataInputStream(socket.getInputStream());

			// takes input from terminal
			// The BuffereReader helps us to receive information from the client
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (!br.readLine().equals("quit")) {
				dos.writeUTF(br.readLine());
				System.out.println("Chat Server responded: " + dis.readUTF());
				dos.flush();
			}
			// close the connection
			socket.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}