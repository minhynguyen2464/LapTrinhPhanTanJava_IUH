package cau1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SERVER_PORT = 6666;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("SERVER IS RUNNING");
			while(true) {
				Socket clientSocket = serverSocket.accept();
				//Get info
				InetAddress clientAddress = clientSocket.getInetAddress();
				int clientPort = clientSocket.getPort();
				//Received
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String receiveMsg = in.readLine();
				//Send
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
				String sendMsg = "Server received "+receiveMsg+" from "+ clientAddress.getHostAddress();
				out.println(sendMsg);
				clientSocket.close();
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
