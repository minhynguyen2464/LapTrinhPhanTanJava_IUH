import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


public class DictionaryService implements DictionaryInterface{
    public String lookup(String word) {
        String vietnamese = null;
        Connection conn = null;
        try {
        	conn = JDBCUtil.getConnect();
            PreparedStatement pstmt = conn.prepareStatement("SELECT vietnamese FROM dictonary WHERE english = ?");
            pstmt.setString(1, word.trim().toLowerCase());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                vietnamese = rs.getString(1);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vietnamese;
    }
   
    public String add(String english, String vietnamese) {
    	Connection conn = null;
    	String result=null;
    	try {
    		conn = JDBCUtil.getConnect();
    		PreparedStatement pr = conn.prepareStatement("INSERT INTO dictonary(english,vietnamese) VALUES(?,?)");
    		pr.setString(1, english);
    		pr.setString(2, vietnamese);
    		if(pr.execute()) {
    			result = "FAILED";
    		}
    		
    		else {
    			result = "ADD SUCCESSFULLY";
    		}
    		conn.close();
    		pr.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
    }
}
