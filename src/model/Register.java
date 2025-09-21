package model;
import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;

public class Register {
    public boolean registerUser(String username, String email, String password){
    	String hashedPassword=BCrypt.hashpw(password, BCrypt.gensalt());
    	String sql = "INSERT INTO users (username, email, passwordhash) VALUES (?, ?, ?)";
    	try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
               pstmt.setString(1, username);
               pstmt.setString(2, email);
               pstmt.setString(3, hashedPassword);
               int rows = pstmt.executeUpdate();
               return rows > 0;
           } catch (SQLException e) {
               System.out.println("Error: " + e.getMessage());
               return false;
           }
    }
}
