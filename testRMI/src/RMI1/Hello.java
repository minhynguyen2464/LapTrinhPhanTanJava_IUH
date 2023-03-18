package RMI1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote{
	public String prtMsg(String string) throws RemoteException;
}