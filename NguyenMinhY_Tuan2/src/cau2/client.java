package cau2;
import java.net.*;
import java.io.*;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SERVER_PORT = 6666;
		final String SERVER_NAME = "localhost";
		Socket clientSocket = null;
		try {
			clientSocket = new Socket(SERVER_NAME,SERVER_PORT);
			//Input
			System.out.println("Enter number array divided by coma: ");
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			String stringNum = userInput.readLine();
			//Send
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
			out.println(stringNum);
			//Receive
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String receivedMsg = in.readLine();
			System.out.println("Sorted number: "+receivedMsg);
			clientSocket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
