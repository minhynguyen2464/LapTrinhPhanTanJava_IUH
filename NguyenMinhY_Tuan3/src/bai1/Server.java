package bai1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public Server() {
		try {
			MyRemoteInterface m = new MyRemoteObject();
			Naming.rebind("rmi://localhost/MsgService", m);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		new Server();
	}

}
