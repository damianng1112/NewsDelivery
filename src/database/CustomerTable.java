package database;

import java.sql.*;

public class CustomerTable {
	static Statement stmt = null;
	static Connection c = null;

	public static void main(String[] args) {
		ConnectToDatabase.init_db();
		try {
			 stmt = c.createStatement();
	         String sql = "CREATE TABLE customer " +
	                        "(id INTEGER PRIMARY KEY NOT NULL," +
	                        " name VARCHAR(30) NOT NULL, " +
	                        " address VARCHAR(50) NOT NULL, " + 
	                        " phoneNumber INTEGER NOT NULL, " + 
	                        " paidStatus BIT)"; 
	         stmt.executeUpdate(sql);
	         stmt.close();
	         c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
