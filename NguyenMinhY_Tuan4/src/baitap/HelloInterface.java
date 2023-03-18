package baitap;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloInterface extends Remote{
	public String sendMessenge(String msg) throws RemoteException;
}
