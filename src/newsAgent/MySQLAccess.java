package newsAgent;

import java.sql.*;

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
	public static void init_db(){
		try{
			String url="jdbc:mysql://localhost:3306/newsagentdb";
			con = DriverManager.getConnection(url, "root", "");
			System.out.println("Success");
			stmt = con.createStatement();
		}catch(Exception e){
			System.out.println("Error: Failed to connect to database\n" + e.getMessage());
		}
	}
	
	public boolean insertCustomerDetailsAccount(NewsAgent c) {
		
		boolean insertSucessfull = true;
	
		//Add Code here to call embedded SQL to insert Customer into DB
	
		try {
		
			//Create prepared statement to issue SQL query to the database
			pstmt = con.prepareStatement("insert into newagentdb.customerdetails values (default, ?, ?, ?,?,?)");
			pstmt.setString(1, c.getCus_name());
			pstmt.setString(2, c.getCus_address());
			pstmt.setString(3, c.getCus_number());
			pstmt.setString(4, c.getPublication());
			pstmt.executeUpdate();
		
	 
		}
		catch (Exception e) {
			insertSucessfull = false;
		}
	
		return insertSucessfull;
		
	}// end insertCustomerDetailsAccount
	
	public ResultSet retrieveAllCustomerAccounts() {
		
		//Add Code here to call embedded SQL to view Customer Details
	
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from newsagentdb.customerdetails");		
		}
		catch (Exception e) {
			rs = null;
		}
		return rs;
	}
	
	public boolean updateCustomerById(int custId) {
		
		boolean updateSuccessful = true;
		
		//Add Code here to call embedded SQL to insert Customer into DB
		try {
			//Create prepared statement to issue SQL query to the database
			pstmt = con.prepareStatement("update newsagentdb.customerdetails set namewhere id = " + custId);
			pstmt.executeUpdate();
		 
		}
		catch (Exception e) {
			updateSuccessful = false;
		}
		
		return updateSuccessful;
	}

	public boolean deleteCustomerById(int custID) {

		boolean deleteSucessfull = true;
		//Add Code here to call embedded SQL to delete Customer		
		try {
			
			//Create prepared statement to issue SQL query to the database
			if (custID == -99)
				//Delete all entries in Table
				pstmt = con.prepareStatement("delete from newsagentdb.customerdetails");
			else
				//Delete a particular Customer
				pstmt = con.prepareStatement("delete from newsagentdb.customerdetails where id = " + custID);
			pstmt.executeUpdate();
		 
		}
		catch (Exception e) {
			deleteSucessfull = false;
		}
		
		return deleteSucessfull;
	
	}

}