package cau3;
import java.io.IOException;
import java.net.*;

public class server {

	 public static void main(String[] args) {
	        // Số cổng mà server sẽ lắng nghe
	        final int SERVER_PORT = 5000;

	        DatagramSocket serverSocket = null;

	        try {
	            // Tạo DatagramSocket để lắng nghe dữ liệu
	            serverSocket = new DatagramSocket(SERVER_PORT);

	            while (true) {
	                // Nhận gói tin từ client
	                byte[] receiveBuffer = new byte[1024];
	                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
	                serverSocket.receive(receivePacket);

	                // Chuyển đổi dữ liệu nhận được thành chuỗi và in ra màn hình
	                String numberString = new String(receivePacket.getData(), 0, receivePacket.getLength());
	                System.out.println("Numbers received from client: " + numberString);

	                // Tách các số từ chuỗi và chuyển đổi chúng thành một mảng số nguyên
	                String[] numberStrings = numberString.split(", ");
	                int[] numbers = new int[numberStrings.length];
	                for (int i = 0; i < numberStrings.length; i++) {
	                    numbers[i] = Integer.parseInt(numberStrings[i]);
	                }

	                // Tìm các số nguyên tố trong mảng số nguyên
	                StringBuilder primeNumbers = new StringBuilder();
	                for (int number : numbers) {
	                    if (isPrime(number)) {
	                        primeNumbers.append(number).append(", ");
	                    }
	                }

	                // Chuyển đổi chuỗi số nguyên tố thành mảng byte và gửi nó đến client
	                byte[] sendBuffer = primeNumbers.toString().getBytes();
	                InetAddress clientAddress = receivePacket.getAddress();
	                int clientPort = receivePacket.getPort();
	                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
	                serverSocket.send(sendPacket);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            // Đóng kết nối và giải phóng tài nguyên
	            if (serverSocket != null) {
	                serverSocket.close();
	            }
	        }
	    }

	    // Phương thức kiểm tra số nguyên tố
	    private static boolean isPrime(int number) {
	        if (number <= 1) {
	            return false;
	        }
	        for (int i = 2; i <= Math.sqrt(number); i++) {
	            if (number % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }

}
