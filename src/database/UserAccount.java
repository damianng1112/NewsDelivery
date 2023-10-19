package database;

import java.sql.*;

public class UserAccount {
	static Statement stmt = null;
	static Connection c = null;

	public static void main(String[] args) {
		ConnectToDatabase.init_db();
		try {
			 stmt = c.createStatement();
			 //get user info here
	         stmt.close();
	         c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
