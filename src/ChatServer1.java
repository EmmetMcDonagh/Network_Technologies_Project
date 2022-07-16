
import java.net.*;
import java.io.*;

public class ChatServer1 { // A Java Class for the Server

	public static void main(String[] args) {
		try {
			// establish a connection by providing host and port
			// number
			System.out.println("Server started");
			System.out.println("Waiting for a client ...");
			ServerSocket ss = new ServerSocket(1234);
			Socket s = ss.accept();
			System.out.println("New Chat Client connected");

			// get the outputstream of Chat Client
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());

			// takes input from the Chat client socket
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (!br.readLine().equals("quit")) {
				System.out.println("Chat Client responded: " + dis.readUTF());
				dos.writeUTF(br.readLine());
			}
			// close connection
			ss.close();
		} catch (Exception ie) {
			ie.printStackTrace();
		}
	}
}