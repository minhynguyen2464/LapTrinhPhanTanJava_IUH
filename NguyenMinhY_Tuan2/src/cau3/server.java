package cau3;
import java.net.*;
import java.util.Arrays;
import java.io.*;
import java.util.ArrayList;

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
				//Find prime number
				int[] sortedArray = findPrimeNumber(intArray);
				//Turn int array to string
				String sortedNumberString = intArrToString(sortedArray);
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
	
	private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
	
	public static int[] findPrimeNumber(int[] arr) {
		int[] primeNumber = new int[0];
		ArrayList<Integer> list = new ArrayList<>();
		int j=0;
		for(int i=0; i<arr.length;i++) {
			if(isPrime(arr[i])) {
				list.add(arr[i]);
			}

		}
		primeNumber = list.stream().mapToInt(i -> i).toArray();
		return primeNumber;
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

