package RMI1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Helloimp extends UnicastRemoteObject implements Hello{

	protected Helloimp() throws RemoteException {
		super();
	}

	public String prtMsg(String string) throws RemoteException {
		
		return "Xin chao "+string;
	}

}
