package demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends DicObject{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DicObject dic = new DicObject();
		ServerSocket serverSocket = null;
		final int SERVER_PORT = 6666;
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("Server is running...");
			while(true){
				Socket clientSocket = serverSocket.accept();
				//Receive
				BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String english = input.readLine();
				//Process
				String vietnamese = dic.searchWord(english);
				//Send
				PrintWriter output = new PrintWriter(clientSocket.getOutputStream(),true);
				output.println(vietnamese);
				clientSocket.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
