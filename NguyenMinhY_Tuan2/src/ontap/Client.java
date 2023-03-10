package ontap;
import java.net.*;
import java.io.*;

public class Client {
	public static void main(String[] args) {
		final int SERVER_PORT = 8888;
		final String SERVER_NAME = "localhost";
		Socket clientSocket = null;
		try {
			clientSocket = new Socket(SERVER_NAME,SERVER_PORT);
			//Client Input
			System.out.println("Enter number divided by coma");
			BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
			String stringNumber = clientInput.readLine();
			//Client send
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
			out.println(stringNumber);
			//Client receive
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String receivedMsg = in.readLine();
			System.out.println("Sorted number is: "+ receivedMsg);
			//Close socket
			clientSocket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
