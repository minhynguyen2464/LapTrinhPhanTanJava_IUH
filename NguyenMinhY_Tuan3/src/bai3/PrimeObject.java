package bai3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

public class PrimeObject extends UnicastRemoteObject implements PrimeInterface{

	protected PrimeObject() throws RemoteException {
		super();
	}

	@Override
	public int[] stringToIntArray(String number) throws RemoteException {
		String[] stringNumbers = number.split(",");
		int[] numbers = new int[stringNumbers.length];
		for(int i=0; i<stringNumbers.length; i++) {
			numbers[i] = Integer.parseInt(stringNumbers[i]);
		}
		return numbers;
	}

	@Override
	public String findPrime(String stringNumber) throws RemoteException {
		int[] numbers = stringToIntArray(stringNumber);
		int[] primeNumbers = new int[0];
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0; i<numbers.length;i++) {
			if(isPrime(numbers[i])) {
				list.add(numbers[i]);
			}
		}
		primeNumbers = list.stream().mapToInt(i->i).toArray();
		String stringPrime = intToString(primeNumbers);
		return stringPrime;
		
		
	}

	@Override
	public String intToString(int[] number) throws RemoteException {
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
	
	public static boolean isPrime(int number) {
		if(number<=1) {
			return false;
		}
		for(int i=2; i<=Math.sqrt(number); i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}

}
