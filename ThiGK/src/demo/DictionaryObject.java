package demo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class DictionaryObject extends UnicastRemoteObject implements DictionaryInterface{

	protected DictionaryObject() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String searchWord(String english) throws RemoteException {
		String vietnamese = null;
		vietnamese = JDBCUtil.search(english);//Hàm search
		if(vietnamese!=null) {
			return  vietnamese;
		}
		return vietnamese;//Return null when not found
	}

}
