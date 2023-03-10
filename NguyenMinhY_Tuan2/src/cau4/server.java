package cau4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class server {

    public static void main(String[] args) throws IOException {
        // Tạo một ServerSocket với cổng 5000
        ServerSocket serverSocket = new ServerSocket(5000);
        
        while (true) {
            // Chờ đợi kết nối từ Client
            System.out.println("Waiting for Client");
            Socket socket = serverSocket.accept();
            System.out.println("Connected");

            // Tạo một BufferedReader để đọc dữ liệu từ Client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Tạo một PrintWriter để ghi dữ liệu trả về cho Client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Đọc dữ liệu từ Client
            String inputLine = in.readLine();
            System.out.println("Client: " + inputLine);
            // Thống kê từ trong chuỗi
            Map<Character, Integer> countMap = new HashMap<>();
            for (char c : inputLine.toCharArray()) {
                if (Character.isLetter(c)) {
                    char key = Character.toLowerCase(c);
                    countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                }
            }

            // Ghi dữ liệu trả về cho Client
            out.println("Thông tin thống kê từ trong chuỗi:");
            for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Đóng kết nối
            in.close();
            out.close();
            socket.close();
        }
    }

}
