package cau1;
import java.net.*;
import java.io.*;


public class client {
	public static void main(String[] args) {
		final int SERVER_PORT = 6666;
		final String SERVER_NAME = "localhost";
		Socket clientSocket = null;
		try {
			clientSocket = new Socket(SERVER_NAME,SERVER_PORT);
			//Input
			System.out.println("Enter messenge: ");
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			String msg = userInput.readLine();
			//Send
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			out.println(msg);
			//Receive
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String receivedMsg = in.readLine();
			System.out.println("Received from server: "+ receivedMsg);
			clientSocket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
}
