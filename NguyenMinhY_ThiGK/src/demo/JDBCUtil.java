package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCUtil {
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/myproductdb";
	private static final String DB_ADMIN = "admin";
	private static final String DB_PASSWORD = "123qwe!@#";
	
	public static Connection getConnect() {
		Connection conn = null;
		try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_ADMIN, DB_PASSWORD);
			if(conn!=null) {
				System.out.println("DATABASE CONNECTED");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static int update(int productsID, String products_name, String product_company, int product_price) {
		Connection conn = null;
		PreparedStatement pr = null;
		int result=0;
		try {
			conn = JDBCUtil.getConnect();
			pr = conn.prepareStatement("UPDATE products SET products_name=?, product_company=?,product_price=? WHERE products_id=?");
			pr.setString(1, products_name);
			pr.setString(2, product_company);
			pr.setLong(3, product_price);
			pr.setLong(4, productsID);
			if(pr.execute()) {
				return 1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
