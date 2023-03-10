package cau2;
import java.net.*;
import java.util.Arrays;
import java.io.*;

public class server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SERVER_PORT=6666;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("TCP SERVER IS RUNNING");
			while(true) {
				Socket clientSocket = serverSocket.accept();
				//Get info
				InetAddress clientAddress = clientSocket.getInetAddress();
				int clientPort = clientSocket.getPort();
				//Receive
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String stringNum = in.readLine();
				//Process
				//Turn String into Int Array
				int[] intArray = stringToIntArr(stringNum);
				int[] sortedArray = sortNumber(intArray);
				String sortedNumberString = intArrToString(sortedArray);
				//Out from server side
				System.out.println(sortedNumberString);
				//Send
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
				String sendMsg = "Server recevied: "+sortedNumberString;
				out.println(sendMsg);
 				clientSocket.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int[] stringToIntArr(String stringNum) {
		String[] stringNums = stringNum.split(",");
		int[] number = new int[stringNums.length];
		for(int i=0; i<stringNums.length; i++) {
			number[i] = Integer.parseInt(stringNums[i]);
		}
		return number;
	}
	
	public static int[] sortNumber(int[] arr) {
		Arrays.sort(arr);
		return arr;
	}
	
	public static String intArrToString(int[] arr) {
		StringBuilder sortedNumberString = new StringBuilder();
		for(int i=0; i<arr.length;i++) {
			sortedNumberString.append(arr[i]);
			if(i<arr.length-1) {
				sortedNumberString.append(", ");
			}
		}
		String result = sortedNumberString.toString();
		return result;
	}

}
