
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Code which support multi -user chat sessions, where the server allows
 * multiple clients to create socket connections, and messages sent by one user
 * are sent out to all connected clients
 *
 */
class ChatClient2 { // A Java Class for the Client

	public static void main(String[] args) {
		// establish a connection by providing host and port
		// number
		try (Socket socket = new Socket("localhost", 2000)) {

			// sends output to the socket
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			// takes input from terminal
           //The BuffereReader helps us to receive information from the client
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// initialize socket and input stream
			// We use the Scanner to get the input from the user and send the data to the
			// server using the PrintWriter object.
			Scanner sc = new Scanner(System.in);
			String line = null;

			while (!"exit".equalsIgnoreCase(line)) {
				// reading from user
				line = sc.nextLine();

				// sending the user input to server
				out.println(line);
				out.flush();

				// string to read message from input
				System.out.println("Chat Server replied " + in.readLine());
			}

			// close the connection
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}