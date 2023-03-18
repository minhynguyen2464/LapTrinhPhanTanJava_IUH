package bai2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Registry registry = LocateRegistry.createRegistry(1099); //Create registry port 1099
			registry.rebind("sort", new SortingObject()); //bind registry named "sort"
            System.out.println("Server is running...");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
