package cau1;
import java.net.*;
import java.io.*;

public class client {
	public static void main(String[] args) {
        // Địa chỉ và số cổng của server
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 5000;

        DatagramSocket clientSocket = null;

        try {
            // Tạo DatagramSocket để gửi dữ liệu
            clientSocket = new DatagramSocket();

            // Chuỗi gửi đến server
            String message = "Hello from client";
            byte[] sendBuffer = message.getBytes();

            // Địa chỉ của server
            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);

            // Tạo gói tin và gửi đến server
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, SERVER_PORT);
            clientSocket.send(sendPacket);

            // Nhận gói tin từ server
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            // Chuyển đổi dữ liệu nhận được thành chuỗi và in ra màn hình
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Message received from server: " + receivedMessage);

            // In ra địa chỉ của server
            InetAddress serverAddressReceived = receivePacket.getAddress();
            System.out.println("Server address: " + serverAddressReceived.getHostAddress());

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
