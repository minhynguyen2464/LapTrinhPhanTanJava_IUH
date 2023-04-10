package demo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DictionaryInterface extends Remote{
	public String searchWord(String english) throws RemoteException;
}
