package model;
import java.sql.*;

public class Transfer {

    public boolean transfer(int amount, int userid1, String user2email2) {
        String checkBalanceSQL = "SELECT balance FROM users WHERE userid = ?";
        String getUserIdSQL = "SELECT userid FROM users WHERE email = ?";
        String deductSQL = "UPDATE users SET balance = balance - ? WHERE userid = ?";
        String addSQL = "UPDATE users SET balance = balance + ? WHERE userid = ?";
        Connection conn = null;

        try {
            
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankoop", "postgres", "achim");
            conn.setAutoCommit(false); 

            try (PreparedStatement psCheckBalance = conn.prepareStatement(checkBalanceSQL)) {
                psCheckBalance.setInt(1, userid1);
                try (ResultSet rs = psCheckBalance.executeQuery()) {
                    if (rs.next()) {
                        int balance = rs.getInt("balance");
                        if (balance < amount) {
                            System.out.println("Insufficient balance.");
                            return false;
                        }
                    } else {
                        System.out.println("Sender user not found.");
                        return false;
                    }
                }
            }

            
            int userid2;
            try (PreparedStatement psGetUserId = conn.prepareStatement(getUserIdSQL)) {
                psGetUserId.setString(1, user2email2);
                try (ResultSet rs = psGetUserId.executeQuery()) {
                    if (rs.next()) {
                        userid2 = rs.getInt("userid");
                    } else {
                        System.out.println("Recipient user not found.");
                        return false;
                    }
                }
            }

            
            try (PreparedStatement psDeduct = conn.prepareStatement(deductSQL)) {
                psDeduct.setInt(1, amount);
                psDeduct.setInt(2, userid1);
                psDeduct.executeUpdate();
            }

           
            try (PreparedStatement psAdd = conn.prepareStatement(addSQL)) {
                psAdd.setInt(1, amount);
                psAdd.setInt(2, userid2);
                psAdd.executeUpdate();
            }

            
            conn.commit();
            System.out.println("Transfer successful.");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback(); // Rollback transaction on error
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            return false;
        } finally {
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }

}
