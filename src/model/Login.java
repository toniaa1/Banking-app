package model;
import view.*;
import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;

public class Login {
	public boolean loginUser(String email, String password){
	    String sql = "SELECT passwordhash FROM users WHERE LOWER(email) = LOWER(?)";

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	         
	        email = email.trim();

	        pstmt.setString(1, email);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            String hashedPassword = rs.getString("passwordhash");
	            if (hashedPassword == null) {
	                System.out.println("No password found for user.");
	                return false;
	            }
	            return BCrypt.checkpw(password, hashedPassword);
	        } else {
	            System.out.println("Email not found.");
	            return false;
	        }
	    } catch (SQLException e) {
	        System.out.println("Error: " + e.getMessage());
	        return false;
	    }
	}
}
