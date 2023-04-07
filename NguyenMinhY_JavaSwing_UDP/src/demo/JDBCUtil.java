package demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/java_tuan4";
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
}
