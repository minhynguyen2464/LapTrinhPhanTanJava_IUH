package ontap;
import java.net.*;
import java.util.Scanner;


public class client {

	public static void main(String[] args) {
		final String SERVER_ADDRESS = "localhost";
		final int SERVER_PORT = 5000;
		DatagramSocket clientSocket = null;
		try {
			clientSocket = new DatagramSocket();
			//Input 
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter number by coma");
			String numberString = sc.nextLine();
			//Send
			byte[] sendBuffer = numberString.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendBuffer,sendBuffer.length,InetAddress.getByName(SERVER_ADDRESS),SERVER_PORT);
			clientSocket.send(sendPacket);
			//Receive
			byte[] receiveBuffer = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,receiveBuffer.length);
			clientSocket.receive(receivePacket);
			String primeString = new String(receivePacket.getData(),0,receivePacket.getLength());
			primeString = primeString.substring(0,primeString.length()-2);
			System.out.println("Prime number is: "+primeString);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(clientSocket!=null) {
				clientSocket.close();
			}
		}
	}

}
