
import java.io.*;
import java.net.*;

//A Java Class for the Server
class ChatServer2 {
	public static void main(String[] args) {
		ServerSocket server = null;

		try {
			// starts server and waits for a connection
			// server is listening to port 2000
			System.out.println("Server started");
			System.out.println("Waiting for a client ...");
			server = new ServerSocket(2000);
			server.setReuseAddress(true);

			// running infinite loop for getting
			// client request
			while (true) {

				// socket object to receive incoming client
				// requests
				Socket client = server.accept();

				// Displaying that new client is connected
				// to server
				
				System.out.println("New Chat Client connected" + client.getInetAddress().getHostAddress());

				// create a new thread object
				ClientChatHandler clientSock = new ClientChatHandler(client);
				// This thread will handle the client
				// separately
				new Thread(clientSock).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// initialize socket and input stream
			if (server != null) {
				try {
					// close connection
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ClientHandler class
	private static class ClientChatHandler implements Runnable {
		private final Socket ChatClientSocket;

		// Constructor
		public ClientChatHandler(Socket socket) {
			this.ChatClientSocket = socket;
		}

		public void run() {
			PrintWriter out = null;
			BufferedReader in = null;
			try {

				// get the outputstream of Chat Client
				out = new PrintWriter(ChatClientSocket.getOutputStream(), true);

				// takes input from the Chat client socket

				in = new BufferedReader(new InputStreamReader(ChatClientSocket.getInputStream()));

				String line;
				while ((line = in.readLine()) != null) {

					// starts server and waits for a connection
					System.out.printf(" Sent from Chat Client: %s\n", line);
					out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (out != null) {
						out.close();
					}
					if (in != null) {
						in.close();
						ChatClientSocket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}