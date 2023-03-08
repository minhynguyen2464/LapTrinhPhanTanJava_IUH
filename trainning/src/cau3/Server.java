package cau3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Arrays;
public class Server implements SortingInterface{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SERVER_PORT = 8888;
		ServerSocket serverSocket = null;
		try {
			System.out.println("Waitting for connection...");
			serverSocket = new ServerSocket(SERVER_PORT);
			while(true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("Connect successfully!");
				//Receive
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String stringNumber = in.readLine();
				System.out.println("FROM CLIENT: "+stringNumber);
				//Proccess
				Server s = new Server();
				String sortedNumber = s.sorting(stringNumber);
				System.out.println("SERVER PROCESSED: "+sortedNumber);
				//Send
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
				String sendMsg = "THE SORTED NUMBER IS: "+sortedNumber;
				out.println(sendMsg);
				//Close
				clientSocket.close();
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String sorting(String number) {
		int[] numbers = stringToIntArray(number);
		Arrays.sort(numbers);
		String sortedNumber = intToString(numbers);
 		return sortedNumber;
	}

	@Override
	public int[] stringToIntArray(String number) {
		String[] stringNumbers = number.split(",");
		int[] numbers = new int[stringNumbers.length];
		for(int i=0; i<stringNumbers.length; i++) {
			numbers[i] = Integer.parseInt(stringNumbers[i]);
		}
		return numbers;
	}

	@Override
	public String intToString(int[] numbers) {
		StringBuilder stringNumber = new StringBuilder();
		for(int i=0; i<numbers.length; i++) {
			stringNumber.append(numbers[i]);
			if(i<numbers.length-1) {
				stringNumber.append(", ");
			}
		}
		String sortedNumber = stringNumber.toString();
		return sortedNumber;
	}

}
