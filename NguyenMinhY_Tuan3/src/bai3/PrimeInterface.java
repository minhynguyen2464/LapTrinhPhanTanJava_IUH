package bai3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PrimeInterface extends Remote{
	public int[] stringToIntArray(String number) throws RemoteException;
	public String findPrime(String number) throws RemoteException;
	public String intToString(int[] number) throws RemoteException;
}
