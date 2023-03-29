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

	@Override
	public void insertWord(String vietnamese, String english) throws RemoteException {
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			conn = JDBCUtil.getConnection();
			pre = conn.prepareStatement("INSERT INTO dictonary(english,vietnamese) VALUES(?,?)");
			pre.setString(1, english);
			pre.setString(2, vietnamese);
			pre.execute();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void listWord() throws RemoteException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			conn = JDBCUtil.getConnection();
			pre = conn.prepareStatement("SELECT english,vietnamese FROM dictonary");
			ResultSet result = pre.executeQuery();
			while(result.next()) {
				System.out.println(result.getString("english")+" | "+result.getString("vietnamese"));
			}
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteWord(int index) throws RemoteException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			conn = JDBCUtil.getConnection();
			pre = conn.prepareStatement("DELETE FROM dictonary WHERE iddictonary = ?");
			pre.setLong(1, index);
			pre.execute();
			System.out.println("DELETE SUCCESSFULLY");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
