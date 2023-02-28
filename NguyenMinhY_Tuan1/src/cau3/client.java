package cau3;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class client {

	public static void main(String[] args) {
        // Địa chỉ IP và số cổng của server
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 5000;

        DatagramSocket clientSocket = null;

        try {
            // Tạo DatagramSocket để gửi và nhận dữ liệu
            clientSocket = new DatagramSocket(SERVER_PORT);

            // Chuỗi số được gửi đến server
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number by coma");
            String numberString = sc.nextLine();

            // Chuyển đổi chuỗi thành mảng byte và gửi nó đến server
            byte[] sendBuffer = numberString.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(SERVER_ADDRESS), SERVER_PORT);
            clientSocket.send(sendPacket);

            // Nhận gói tin từ server
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            // Chuyển đổi dữ liệu nhận được thành chuỗi và in ra màn hình
            String primeNumbers = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Prime numbers in the input: " + primeNumbers);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và giải phóng tài nguyên
            if (clientSocket != null) {
                clientSocket.close();
            }
        }
    }
}
