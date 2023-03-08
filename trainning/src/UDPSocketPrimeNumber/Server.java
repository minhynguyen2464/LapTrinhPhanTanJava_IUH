package UDPSocketPrimeNumber;
import java.util.*;
import java.net.*;

public class Server implements PrimeNumberInterFace{
	public static void main(String[] args) {
		final int SERVER_PORT = 8888;
		DatagramSocket serverSocket = null;
		try {
			serverSocket = new DatagramSocket(SERVER_PORT);
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
			String primeNumber = s.findPrimeNumber(stringNumber);
			String sendMsg = "Prime number is: "+primeNumber;
			//Send
			byte[] sendBuffer = sendMsg.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendBuffer,sendBuffer.length,clientAddress,clientPort);
			serverSocket.send(sendPacket);
 			
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
	public int[] stringToInt(String stringNumber) {
		String[] stringNumbers = stringNumber.split(",");
		int[] numbers = new int[stringNumbers.length];
		for(int i=0; i<stringNumbers.length; i++) {
			numbers[i] = Integer.parseInt(stringNumbers[i]);
		}
		return numbers;
	}

	@Override
	public String findPrimeNumber(String stringNumber) {
		int[] numbers = stringToInt(stringNumber);
		int[] primeNumbers = new int[0];
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<numbers.length; i++) {
			if(isPrime(numbers[i])) {
				list.add(numbers[i]);
			}
		}
		primeNumbers = list.stream().mapToInt(i->i).toArray();
		String result = IntToString(primeNumbers);
		return result;
	}

	@Override
	public String IntToString(int[] numbers) {
		StringBuilder stringNumber = new StringBuilder();
		for(int i=0; i<numbers.length; i++) {
			stringNumber.append(numbers[i]);
			if(i<numbers.length-1) {
				stringNumber.append(", ");
			}
		}
		String primeNumber = stringNumber.toString();
		return primeNumber;
	}
	
	public static boolean isPrime(int number) {
		if(number<=1) {
			return false;
		}
		for(int i=2; i<=Math.sqrt(number); i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}
}
