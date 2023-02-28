package ontap;
import java.net.*;
import java.io.*;
import java.util.Arrays;

public class Server {
	public static void main(String[] args) {
		final int SERVER_PORT = 8888;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("Waiting for connection...");
			while(true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("Connected");
				//Server receive
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String stringNumber = in.readLine();
				//Process
				//Turn String into Int array
				int[] number = turnStringIntoArr(stringNumber);
				//Sort Int array
				int[] sortedNumber = sortNumber(number);
 				//Turn Int Array into String
				String stringSortedNumber = turnArrIntoString(sortedNumber);
				//Server output
				System.out.println("The result in Server: "+stringSortedNumber);
				//Client send
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
				String sendMsg = "From Server: "+stringSortedNumber;
				out.println(sendMsg);
				//Close socket
				clientSocket.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int[] turnStringIntoArr(String stringNumber) {
		String[] stringNumbers = stringNumber.split(",");
		int[] number = new int[stringNumbers.length];
		for(int i=0; i<stringNumbers.length; i++) {
			number[i] = Integer.parseInt(stringNumbers[i]);
		}
		return number;
	}
	
	public static int[] sortNumber(int[] arr) {
		Arrays.sort(arr);
		return arr;
	}
	
	public static String turnArrIntoString(int[] arr) {
		StringBuilder stringNumber = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			stringNumber.append(arr[i]);
			if(i<arr.length-1) {
				stringNumber.append(", ");
			}
		}
		String result = stringNumber.toString();
		return result;
	}
}
