package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
	private static final String DB_USERNAME = "admin";
	private static final String DB_PASSWORD = "123qwe!@#";
	
	public static Connection getConnect() {
		Connection conn = null;
		try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			if(conn!=null) {
				System.out.println("DATABASE CONNECTED");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static String search(String english) {
		Connection conn = null;
		PreparedStatement pr = null;
		String vietnamese = null;
		english = english.trim().toLowerCase();
		try {
			conn = JDBCUtil.getConnect();
			pr = conn.prepareStatement("SELECT * FROM dictionary WHERE english = ?");
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
