package baitap;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HelloObject extends UnicastRemoteObject implements HelloInterface{
	public HelloObject() throws RemoteException{
		super();
	}
	
	@Override
	public String selectWord(String msg) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		String vietnamese="NOT FOUND";
		msg = msg.trim().toLowerCase();
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
	public ArrayList<MyDictionary> listWord() throws RemoteException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pre = null;
		ArrayList<MyDictionary> myList = new ArrayList<MyDictionary>();
		try {
			conn = JDBCUtil.getConnection();
			pre = conn.prepareStatement("SELECT word_key,english,vietnamese FROM dictonary");
			ResultSet result = pre.executeQuery();
			while(result.next()) {
				myList.add(new MyDictionary(result.getInt("word_key"),result.getString("english"),result.getString("vietnamese")));
			}
			pre.close();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return myList;
	}

	@Override
	public void deleteWord(int index) throws RemoteException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			conn = JDBCUtil.getConnection();
			pre = conn.prepareStatement("DELETE FROM dictonary WHERE word_key = ?");
			pre.setInt(1, index);
			pre.execute();
			//Close
			pre.close();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
