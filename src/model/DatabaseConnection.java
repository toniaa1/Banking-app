package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
		private static final String url="jdbc:postgresql://localhost:5432/bankoop";
		private static final String user="postgres";
	    private static final String password="achim";
	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, user, password);
	    }

}
