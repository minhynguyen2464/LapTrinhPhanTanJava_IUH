package UDPSocketPrimeNumber;
import java.net.*;
import java.io.*;

public class Client {
	public static void main(String[] args) {
		final int SERVER_PORT = 8888;
		final String SERVER_NAME = "localhost";
		DatagramSocket clientSocket = null;
		try {
			clientSocket = new DatagramSocket();
			//Input
			System.out.println("Enter number divided by coma: ");
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in));
			String stringNumber = inFromClient.readLine();
			//Send
			byte[] sendBuffer = stringNumber.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendBuffer,sendBuffer.length,InetAddress.getByName(SERVER_NAME),SERVER_PORT);
			clientSocket.send(sendPacket);
			//Receive
			byte[] receiveBuffer = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,receiveBuffer.length);
			clientSocket.receive(receivePacket);
			String primeNumber = new String(receivePacket.getData(),0,receivePacket.getLength());
			System.out.println(primeNumber);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			if(clientSocket!=null) {
				clientSocket.close();
			}
		}
	}
}
