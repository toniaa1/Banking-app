package mainP;
import model.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int userid;
    private String username;
    private String email;
    private int balance;
    
    public User(String email) {
        
        String query = "SELECT userid, username, email, balance FROM users WHERE email = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, email); 
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                
                this.userid = resultSet.getInt("userid");
                this.username = resultSet.getString("username");
                this.email = resultSet.getString("email");
                this.balance=resultSet.getInt("balance");
            } else {
                System.out.println("User not found for email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
    	return this.userid;
    }
    
    public String getName() {
    	return this.username;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public int getBalance() {
    	return this.balance;
    }
    
}



