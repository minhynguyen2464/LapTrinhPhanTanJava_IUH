package demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;

public class Server extends DicObject{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DicObject dic = new DicObject();
		final int SERVER_PORT = 5000;
		DatagramSocket serverSocket = null;
		try {
			serverSocket = new DatagramSocket(SERVER_PORT);
			while(true) {
				//Receive
				System.out.println("SERVER IS RUNNING");
				byte[] receiveBuffer = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
				serverSocket.receive(receivePacket);
				//Process
				String english = new String(receivePacket.getData(),0,receivePacket.getLength());
				english = english.trim().toLowerCase();
				String vietnamese = dic.searchWord(english);
				//Send
				InetAddress clientAddress = receivePacket.getAddress();
				int clientPort = receivePacket.getPort();
				byte[] sendBuffer = vietnamese.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendBuffer,sendBuffer.length,clientAddress,clientPort);
				serverSocket.send(sendPacket);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		    if (serverSocket != null) {
		    	serverSocket.close();
		    }
		}
	}

}
