package newsAgent;

import java.sql.*;

import customer.Customer;

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
	
	public boolean insertCustomerDetailsAccount(Customer custObj) throws Exception{
		
		boolean insertSucessfull = true;
	
		//Add Code here to call embedded SQL to insert Customer into DB
	
		try {
		
			//Create prepared statement to issue SQL query to the database
			pstmt = con.prepareStatement("insert into newsagentdb.customerdetails (name,address,phoneNo,publication) values (?, ?, ?,?)");
			pstmt.setString(1, custObj.getName());
			pstmt.setString(2, custObj.getAddress());
			pstmt.setString(3, custObj.getPhoneNumber());
			pstmt.setString(4, custObj.getPublication());
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
	
	public boolean updateCustomerById(String updateCustId, String name, String address, String phoneNum, String pub) {
		
		boolean updateSuccessful = true;
		
		//Add Code here to call embedded SQL to update Customer into DB
		try {
			//Create prepared statement to issue SQL query to the database
			pstmt = con.prepareStatement("update newsagentdb.customerdetails set name=?, address=?, phoneNo=?, publication=? where cus_id = ?");
			pstmt.setString(1, name);
			pstmt.setString(2, address);
			pstmt.setString(3, phoneNum);
			pstmt.setString(4, pub);
			pstmt.setString(5, updateCustId);
			pstmt.executeUpdate();
		 
		}
		catch (Exception e) {
			updateSuccessful = false;
			e.printStackTrace();
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
				pstmt = con.prepareStatement("delete from newsagentdb.customerdetails where cus_id = " + custID);
				pstmt.executeUpdate();
		 
		}
		catch (Exception e) {
			deleteSucessfull = false;
		}
		
		return deleteSucessfull;
	
	}
	
    public boolean validateId(String id) {
        // SQL query to check the id 
        String query = "SELECT cus_id FROM customerdetails";
        boolean res = false;
        try{
        	PreparedStatement statement = con.prepareStatement(query);
            // Executing the query
            ResultSet rs = statement.executeQuery();

            // Checking if the user exists
            while(rs.next()) {
            	String dbId = rs.getString("cus_id");
            	if (dbId.equals(id)) {
            		res = true;
            		break;
            	}
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return res;
    }

}