package bai1;

import java.rmi.RemoteException;

public class MyRemoteObject extends java.rmi.server.UnicastRemoteObject implements MyRemoteInterface{
	public MyRemoteObject() throws RemoteException {
		super();
	}
	
	@Override
	public String sendMessenge(String messenge, String clientInfo) throws RemoteException {
		// TODO Auto-generated method stub
		String result = "Server received messenge: "+messenge+" from client: "+clientInfo;
		return result;
	}

}
