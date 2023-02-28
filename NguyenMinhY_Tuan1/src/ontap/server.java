package ontap;
import java.net.*;

public class server {
	public static void main(String[] args) {
		final int SERVER_PORT = 5000;
		DatagramSocket serverSocket = null;
		try {
			serverSocket = new DatagramSocket(SERVER_PORT);
			while(true) {
				//Receive
				byte[] receiveBuffer = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,receiveBuffer.length);
				serverSocket.receive(receivePacket);
				//Process
				//Output to server
				String numberString = new String(receivePacket.getData(),0,receivePacket.getLength());
				System.out.println("Number from client: "+ numberString);
				//Turn String into Array
				String[] numberStrings = numberString.split(",");
				int[] number = new int[numberStrings.length];
				for(int i=0; i<numberStrings.length; i++) {
					number[i] = Integer.parseInt(numberStrings[i]);
				}
				//Check Prime
				StringBuilder primeNumber = new StringBuilder();
				for(int i=0; i<number.length; i++) {
					if(isPrime(number[i])) {
						primeNumber.append(number[i]).append(", ");
					}
				}
				//Send
				byte[] sendBuffer = primeNumber.toString().getBytes();
				InetAddress clientAddress = receivePacket.getAddress();
				int clientPort = receivePacket.getPort();
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
	
	private static boolean isPrime(int number){
		if(number<=1) {
			return false;
		}
		for(int i=2; i<Math.sqrt(number); i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}
	
}
