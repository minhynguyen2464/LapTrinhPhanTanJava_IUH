package baitap;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface HelloInterface extends Remote{
	public ArrayList<MyDictionary> listWord() throws RemoteException;
	public void insertWord(String vietnamese, String english) throws RemoteException;
	public void deleteWord(int index) throws RemoteException;
	public String selectWord(String english) throws RemoteException;
}
