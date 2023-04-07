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
			conn = JDBCFunc.getConnect();
			pr = conn.prepareStatement("SELECT vietnamese FROM dictonary WHERE english = ?");
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
	
	public static int[] stringToIntArr(String stringNum) {
		String[] stringNums = stringNum.split(",");
		int[] number = new int[stringNums.length];
		for(int i=0; i<stringNums.length; i++) {
			number[i] = Integer.parseInt(stringNums[i]);
		}
		return number;
	}
	
	public static String intArrToString(int[] arr) {
		StringBuilder sortedNumberString = new StringBuilder();
		for(int i=0; i<arr.length;i++) {
			sortedNumberString.append(arr[i]);
			if(i<arr.length-1) {
				sortedNumberString.append(", ");
			}
		}
		String result = sortedNumberString.toString();
		return result;
	}

}
