package baitap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			Registry registry = LocateRegistry.getRegistry(null);
			HelloInterface msg = (HelloInterface)registry.lookup("send");
			System.out.println("Please enter words: ");
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in));
			String clientSend = inFromClient.readLine();
			String result = msg.sendMessenge(clientSend);
			System.out.println("Vietnamese is: "+result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
