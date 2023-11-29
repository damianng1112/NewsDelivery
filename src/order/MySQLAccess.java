package order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQLAccess{
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
		
	public static void init_db(){
		try{
			String url="jdbc:mysql://localhost:3306/newsdelivery";
			con = DriverManager.getConnection(url, "root", "");
			System.out.println("Success");
			stmt = con.createStatement();
		}catch(Exception e){
			System.out.println("Error: Failed to connect to database\n" + e.getMessage());
		}
	}
}