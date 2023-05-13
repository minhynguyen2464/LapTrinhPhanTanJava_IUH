import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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
    
    public String delete(String deleteWord) {
    	Connection conn = null;
    	String result=null;
    	try {
    		conn = JDBCUtil.getConnect();
    		PreparedStatement pr = conn.prepareStatement("DELETE FROM dictonary WHERE english LIKE ?");
    		pr.setString(1, deleteWord);
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
    
    public String maxWord() {
	    	Connection conn = null;
	    	int max_length = 0;
	    	String max_word = null;
        try {
        	String sql = "SELECT * FROM dictonary";
        	conn = JDBCUtil.getConnect();
        	PreparedStatement pr = conn.prepareStatement(sql);
        	ResultSet result = pr.executeQuery();
        	while(result.next()) {
        		int compare = result.getString("english").length();
        		if(max_length<compare) {
        			max_word = result.getString("english");
        		}
        	}
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
		return max_word;
    }
}
