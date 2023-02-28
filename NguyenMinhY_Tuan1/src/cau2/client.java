package cau2;

import java.net.*;
import java.util.Arrays;
import java.util.Scanner;

public class client {

	public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 5000;
        final int BUFFER_SIZE = 1024;

        try {
            DatagramSocket clientSocket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a comma-separated list of numbers: ");
            String numberString = scanner.nextLine();

            byte[] sendBuffer = numberString.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(SERVER_ADDRESS), SERVER_PORT);
            clientSocket.send(sendPacket);

            byte[] receiveBuffer = new byte[BUFFER_SIZE];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, BUFFER_SIZE);
            clientSocket.receive(receivePacket);

            String sortedNumberString = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Sorted numbers: " + sortedNumberString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
