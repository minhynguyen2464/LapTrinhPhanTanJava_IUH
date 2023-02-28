package cau4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {

	public static void main(String[] args) throws IOException {
        // Kết nối tới Server đang lắng nghe trên cổng 5000
        Socket socket = new Socket("localhost", 5000);

        // Tạo một BufferedReader để đọc dữ liệu từ Server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Tạo một PrintWriter để ghi dữ liệu đến Server
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Gửi chuỗi đến Server
        String message = "Welcome to Java Programming";
        out.println(message);

        // Đọc dữ liệu trả về từ Server và in ra màn hình
        String response;
        while ((response = in.readLine()) != null) {
            System.out.println(response);
        }

        // Đóng kết nối
        in.close();
        out.close();
        socket.close();
    }

}
