package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class AddFunds {
	public boolean addFunds(int amount, int user_id){
    	String sql = "UPDATE users SET balance = balance + ?  WHERE userid = ?";
    	try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
               pstmt.setInt(1, amount);
               pstmt.setInt(2, user_id);
               int rows = pstmt.executeUpdate();
               return rows > 0;
           } catch (SQLException e) {
               System.out.println("Error: " + e.getMessage());
               return false;
           }
    }
}
