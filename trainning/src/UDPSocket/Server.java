package UDPSocket;
import java.net.*;
import java.util.*;

public class Server implements SortingInterface{
	public static void main(String[] args) {
		final int SERVER_PORT = 8888;
		DatagramSocket serverSocket = null;
		try {
			System.out.println("Waiting for connection...");
			serverSocket = new DatagramSocket(SERVER_PORT);
			System.out.println("Connected!");
			while(true) {
				//Receive
				byte[] receiveBuffer = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,receiveBuffer.length);
				serverSocket.receive(receivePacket);
				//Get info
				InetAddress clientAddress = receivePacket.getAddress();
				int clientPort = receivePacket.getPort();
				String stringNumber = new String(receivePacket.getData(),0,receivePacket.getLength());
				//Process
				Server s = new Server();
				String sortedNumber = s.sorting(stringNumber);
				System.out.println("SERVER PROCESS: "+sortedNumber);
				//Send
				String sendMsg = "SERVER ACEPTED: "+sortedNumber;
				byte[] sendBuffer = sendMsg.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendBuffer,sendBuffer.length,clientAddress,clientPort);
				serverSocket.send(sendPacket);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(serverSocket!=null) {
				serverSocket.close();
			}
		}
	}

	@Override
	public int[] stringToIntArray(String number) {
		String[] stringNumbers = number.split(",");
		int[] numbers = new int[stringNumbers.length];
		for(int i=0; i<stringNumbers.length; i++) {
			numbers[i] = Integer.parseInt(stringNumbers[i]);
		}
		return numbers;
	}
	
	@Override
	public String intToString(int[] number) {
		StringBuilder stringNumber = new StringBuilder();
		for(int i=0; i<number.length; i++) {
			stringNumber.append(number[i]);
			if(i<number.length-1) {
				stringNumber.append(", ");
			}
		}
		String sortedNumber = stringNumber.toString();
		return sortedNumber;
	}
	
	@Override
	public String sorting(String stringNumber) {
		int[] numbers = stringToIntArray(stringNumber);
		Arrays.sort(numbers);
		String sortedNumber = intToString(numbers);
		return sortedNumber;
	}

	
}
