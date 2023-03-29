package baitap;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloInterface extends Remote{
	public void listWord() throws RemoteException;
	public String sendMessenge(String msg) throws RemoteException;
	public void insertWord(String vietnamese, String english) throws RemoteException;
	public void deleteWord(int index) throws RemoteException;
}
