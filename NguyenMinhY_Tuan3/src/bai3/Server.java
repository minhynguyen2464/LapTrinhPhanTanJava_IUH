package bai3;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws RemoteException {
		try {
			Registry registry = LocateRegistry.createRegistry(1099); //Create registry
			registry.rebind("prime", new PrimeObject()); //bind "prime"
			System.out.println("SERVER IS RUNNING...");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
