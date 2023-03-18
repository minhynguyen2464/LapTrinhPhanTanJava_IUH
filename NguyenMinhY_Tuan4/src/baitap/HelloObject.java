package baitap;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HelloObject extends UnicastRemoteObject implements HelloInterface{
	public HelloObject() throws RemoteException{
		super();
	}
	
	public String selectWord(String msg) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		String vietnamese="NOT FOUND";
		try {
			//Conn
			conn = JDBCUtil.getConnection();
			//PreparedStatment
			preparedStatement = conn.prepareStatement("SELECT * FROM dictonary WHERE english LIKE ?");
			preparedStatement.setString(1,msg);
			//Excute
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				vietnamese = result.getString("vietnamese");
			}
			preparedStatement.close();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return vietnamese;
	}
	
	@Override
	public String sendMessenge(String msg) throws RemoteException {
		msg = msg.trim().toLowerCase();
		String result = selectWord(msg);
		return result;
	}
}
