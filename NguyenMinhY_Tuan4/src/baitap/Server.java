package baitap;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public Server(){
		try {
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("send", new HelloObject());//Bind with send
			System.out.println("Server is running");
		}
		catch(RemoteException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server();
	}

}
