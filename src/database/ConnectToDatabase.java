package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectToDatabase{
	static Connection con = null;

	public static Connection getConnection(){
		if (con == null) {
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/newsAgent";
				con = DriverManager.getConnection(url, "root", "");
				System.out.println("Success");
			}catch(Exception e){
				System.out.println("Error: Failed to connect to database\n" + e.getMessage());
			}
		}
		return con;
	}
	
	public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	public static void main (String[] args) {
		getConnection();
	}
}