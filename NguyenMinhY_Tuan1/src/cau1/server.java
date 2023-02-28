package cau1;
import java.io.IOException;
import java.net.*;

public class server {
	public static void main(String[] args) {
        final int SERVER_PORT = 5000;

        DatagramSocket serverSocket = null;

        try {
            // Tạo DatagramSocket để nhận dữ liệu
            serverSocket = new DatagramSocket(SERVER_PORT);

            while (true) {
                // Tạo gói tin để nhận dữ liệu từ client
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);

                // Chuyển đổi dữ liệu nhận được thành chuỗi và in ra màn hình
                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Message received from client: " + receivedMessage);

                // In ra địa chỉ IP của client
                InetAddress clientAddress = receivePacket.getAddress();
                System.out.println("Client address: " + clientAddress.getHostAddress());

                // Trả về thông tin cho client
                String sendMessage = "Message received successfully";
                byte[] sendBuffer = sendMessage.getBytes();

                // Tạo gói tin để gửi về client
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, receivePacket.getPort());
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
}
