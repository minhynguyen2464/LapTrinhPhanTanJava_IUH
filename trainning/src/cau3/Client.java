package cau3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Client {
	public static void main(String[] args) {
		final int SERVER_PORT = 8888;
		final String SERVER_NAME = "localhost";
		Socket clientSocket = null;
		try {
			//Connect
			clientSocket = new Socket(SERVER_NAME,SERVER_PORT);
			//In
			System.out.println("Enter number divided by coma: ");
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in));
			String stringNumber = inFromClient.readLine();
			//Send
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
			out.println(stringNumber);
			//Receive
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String sortedNumber = in.readLine();
			System.out.println("FROM SERVER: "+sortedNumber);
			clientSocket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
