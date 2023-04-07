package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DicObject implements DicInterface{

	@Override
	public String searchWord(String english) {
		Connection conn = null;
		PreparedStatement pr = null;
		String vietnamese = null;
		try {
			conn = JDBCUtil.getConnect();
			pr = conn.prepareStatement("SELECT vietnamese FROM dictonary WHERE english=?");
			pr.setString(1, english);
			ResultSet result = pr.executeQuery();
			while(result.next()) {
				vietnamese = result.getString("vietnamese");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return vietnamese;
	}

}
