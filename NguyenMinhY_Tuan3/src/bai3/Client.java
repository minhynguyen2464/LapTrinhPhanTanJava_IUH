package bai3;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) throws RemoteException {
		try {
			Registry registry = LocateRegistry.getRegistry(null);
			PrimeInterface prime = (PrimeInterface) registry.lookup("prime");
			String msg = "1,2,3,4,5,6";
			String stringPrime = prime.findPrime(msg);
			System.out.println("Prime nubmers is: "+ stringPrime);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
