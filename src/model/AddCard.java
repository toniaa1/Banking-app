package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCard {
	public boolean addCard(String cardNumber, String cvv, String expiration_date, String iban, String card_id, int userid){
    	String sql = "UPDATE users SET cardnumber = ?, cvv = ?, iban = ?, expirationdate = ?, card_id = ?  WHERE userid = ?";
    	try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
               pstmt.setString(1, cardNumber);
               pstmt.setString(2, cvv);
               pstmt.setString(3, iban);
               pstmt.setString(4, expiration_date);
               pstmt.setString(5, card_id);
               pstmt.setInt(6, userid);
               int rows = pstmt.executeUpdate();
               return rows > 0;
           } catch (SQLException e) {
               System.out.println("Error: " + e.getMessage());
               return false;
           }
    }
}
