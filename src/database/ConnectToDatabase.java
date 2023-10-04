package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectToDatabase
{
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	public static void main(String[] args) 
	{
		init_db();  // open the connection to the database
		try
		{
			rs = stmt.executeQuery("SELECT * FROM customer_docket");
			while (rs.next()) {
				int empid = rs.getInt(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String address = rs.getString(4);
				int phoneNumber = rs.getInt(5);
				System.out.println(empid + " " + firstname + " " + lastname + " " + address+ " " + phoneNumber);
			}
		}
		catch (SQLException sqle)
		{
			System.out.println("Error: failed to print customer docket");
		}
		try
		{
			con.close();
		}
		catch (SQLException sqle)
		{
			System.out.println("Error: failed to close the database");
		}
	}
	
	
	public static void init_db()
	{
		try
		{
			String url="jdbc:mysql://localhost:3306/newsdelivery";
			con = DriverManager.getConnection(url, "root", "admin");
			System.out.println("Success");
			stmt = con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("Error: Failed to connect to database\n" + e.getMessage());
		}
	}
}