package cau2;
import java.net.*;
import java.util.Arrays;

public class server {
	 public static void main(String[] args) {
	        final int PORT = 5000;
	        final int BUFFER_SIZE = 1024;

	        try {
	            DatagramSocket serverSocket = new DatagramSocket(PORT);

	            byte[] receiveBuffer = new byte[BUFFER_SIZE];
	            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, BUFFER_SIZE);

	            while (true) {
	                serverSocket.receive(receivePacket);

	                String numberString = new String(receivePacket.getData(), 0, receivePacket.getLength());
	                String[] numberArray = numberString.split(",");
	                int[] numbers = new int[numberArray.length];
	                for (int i = 0; i < numberArray.length; i++) {
	                    numbers[i] = Integer.parseInt(numberArray[i]);
	                }

	                Arrays.sort(numbers);

	                StringBuilder sortedNumberString = new StringBuilder();
	                for (int i = 0; i < numbers.length; i++) {
	                    sortedNumberString.append(numbers[i]);
	                    if (i < numbers.length - 1) {
	                        sortedNumberString.append(",");
	                    }
	                }

	                byte[] sendBuffer = sortedNumberString.toString().getBytes();
	                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
	                serverSocket.send(sendPacket);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
