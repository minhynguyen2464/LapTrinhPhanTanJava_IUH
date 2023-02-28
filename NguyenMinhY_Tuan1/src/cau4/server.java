package cau4;
import java.net.*;

public class server {
	public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData(),0,receivePacket.getLength());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String[] words = sentence.trim().split("\\s+");
            int length = words.length;
            int letters = 0, digits = 0, whitespaces = 0;
            for (int i = 0; i < length; i++) {
                String word = words[i];
                int wordLength = word.length();
                for (int j = 0; j < wordLength; j++) {
                    char c = word.charAt(j);
                    if (Character.isLetter(c)) {
                        letters++;
                    } else if (Character.isDigit(c)) {
                        digits++;
                    } else if (Character.isWhitespace(c)) {
                        whitespaces++;
                    }
                }
            }
            String stats = String.format("Letters: %d, Digits: %d, Whitespaces: %d", letters, digits, whitespaces);
            sendData = stats.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}
