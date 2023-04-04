package demo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DicObject extends UnicastRemoteObject implements DicInterface{

	protected DicObject() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String searchWord(String english) throws RemoteException {
		Connection conn = null;
		PreparedStatement pr = null;
		String vietnamese = null;
		try {
			conn = JDBCUlti.getConnection();
			pr = conn.prepareStatement("SELECT * FROM dictonary WHERE english = ?");
			pr.setString(1, english);
			ResultSet result = pr.executeQuery();
			while(result.next()) {
				vietnamese = result.getString("vietnamese");
			}
			pr.close();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return vietnamese;
	}
	
}
