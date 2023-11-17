package database;

import java.sql.*;

public class UserAccount {
	public static void createUserTable() {
		Connection c = ConnectToDatabase.getConnection();;
	    try {
	        Statement stmt = c.createStatement();
	        String sql = "CREATE TABLE IF NOT EXISTS user_accounts (" +
	                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
	                "username TEXT NOT NULL," +
	                "password TEXT NOT NULL,"+ 
	                "roles TEXT NOT NULL)";
	        stmt.executeUpdate(sql);
	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static void insertUser(String username, String password, String role) {
        Connection c = ConnectToDatabase.getConnection();
        try {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO user_accounts (username, password, role) VALUES (?, ?, ?)");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}