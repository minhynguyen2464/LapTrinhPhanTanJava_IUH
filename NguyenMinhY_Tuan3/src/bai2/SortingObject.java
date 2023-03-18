package bai2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class SortingObject extends UnicastRemoteObject implements SortingRemoteInterface{
	

	public SortingObject() throws RemoteException {
		super();
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
	public String sorting(String number) {
		int[] numbers = stringToIntArray(number);
		Arrays.sort(numbers);
		String sortedNumber = intToString(numbers);
		return sortedNumber;
	}

	@Override
	public String intToString(int[] number) {
		StringBuilder stringNumber = new StringBuilder();
		for(int i=0; i<number.length; i++) {
			stringNumber.append(number[i]);
			if(i<number.length-1) {
				stringNumber.append(", ");
			}
		}
		String sortedNumber = stringNumber.toString();
		return sortedNumber;
	}
	
}
