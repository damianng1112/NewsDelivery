package order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import newsAgent.NewsAgent;


public class MySQLAccess{
	private PreparedStatement pstmt = null;
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	final private String host ="localhost:3306";
	final private String user = "root";
	final private String password = "";
		
	public MySQLAccess() throws Exception {
		
		try {
			
			//Load MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Setup the connection with the DB
			con = DriverManager.getConnection("jdbc:mysql://" + host + "/newsagentdb?" + "user=" + user + "&password=" + password);
		}
		catch (Exception e) {
			throw e;
		}
		
		
}
	
public boolean insertOrderDetails(Order o) {
		
		boolean insertSucessfull = true;
	
		//Add Code here to call embedded SQL to insert order into DB
	
		try {
		
			//Create prepared statement to issue SQL query to the database
			pstmt = con.prepareStatement("insert into newsagentdb.order values (default, ?, ?, ?,?,?)");
			pstmt.setString(1, o.getCus_id());
			pstmt.setString(2, o.getCus_name());
			pstmt.setString(3, o.getCus_address());
			pstmt.setString(4, o.getCus_number());
			pstmt.setString(5, o.getPublication());

			pstmt.executeUpdate();
		
	 
		}
		catch (Exception e) {
			insertSucessfull = false;
		}
	
		return insertSucessfull;
		
	}// end insertOrderDetails

	public ResultSet retrieveAllOrderDetails() {
		
		//Add Code here to call embedded SQL to view Order Details
	
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from newsagentdb.order");
		
		}
		catch (Exception e) {
			rs = null;
		}
		return rs;
	}

	public boolean updateOrderById(int ordId) {
		
		boolean updateSuccessful = true;
		
		//Add Code here to call embedded SQL to update order into DB
		try {
			//Create prepared statement to issue SQL query to the database
			pstmt = con.prepareStatement("update from newsagentdb.order where id = " + ordId);
			pstmt.executeUpdate();
		 
		}
		catch (Exception e) {
			updateSuccessful = false;
		}
		
		return updateSuccessful;
	}
	
	public boolean deleteOrderById(int ordID) {

		boolean deleteSucessfull = true;
		
		//Add Code here to call embedded SQL to delete order into DB
		
		try {
			
			//Create prepared statement to issue SQL query to the database
			if (ordID == -99)
				//Delete all entries in Table
				pstmt = con.prepareStatement("delete from newsagentdb.order");
			else
				//Delete a particular order
				pstmt = con.prepareStatement("delete from newsagentdb.order where id = " + ordID);
			pstmt.executeUpdate();
		 
		}
		catch (Exception e) {
			deleteSucessfull = false;
		}
		
		return deleteSucessfull;
	
	}
	
}