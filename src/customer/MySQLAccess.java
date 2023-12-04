package customer;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;


public class MySQLAccess {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	final private String host ="localhost:3307";
	final private String user = "root";
	final private String password = "123";
	
	public MySQLAccess() throws Exception {
			
			try {
				
				//Load MySQL Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//Setup the connection with the DB
				connect = DriverManager.getConnection("jdbc:mysql://" + host + "/newsagentdb?" + "user=" + user + "&password=" + password);
			}
			catch (Exception e) {
				throw e;
			}
			
			
	}	

	public boolean insertCustomerDetailsAccount(Customer c) {
	
		boolean insertSucessfull = true;
	
		try {
			preparedStatement = connect.prepareStatement("insert into newsagentdb.customerdetails values (default, ?, ?, ?,?)");
			preparedStatement.setString(1, c.getName());
			preparedStatement.setString(2, c.getAddress());
			preparedStatement.setString(3, c.getPhoneNumber());
			preparedStatement.setString(4, c.getPublication());

			preparedStatement.executeUpdate();
		
	 
		}
		catch (Exception e) {
			insertSucessfull = false;
		}
	
		return insertSucessfull;
		
	} 

	public ResultSet retrieveAllCustomerAccounts() {
		
		//Add Code here to call embedded SQL to view Customer Details
	
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("Select * from newsagentdb.customerdetails");
		
		}
		catch (Exception e) {
			resultSet = null;
		}
		return resultSet;
	}
	
	public boolean deleteCustomerById(int custID) {

		boolean deleteSucessfull = true;
		
		//Add Code here to call embedded SQL to insert Customer into DB
		
		try {
			
			//Create prepared statement to issue SQL query to the database
			if (custID == -99)
				this.preparedStatement = connect.prepareStatement("delete from newsagentdb.customerdetails");
			else {
				//Delete a particular Customer
				this.preparedStatement = connect.prepareStatement("delete from newsagentdb.customerdetails where id = " + custID);	
		  }

        this.preparedStatement.executeUpdate();
     } catch (Exception var4) {
        deleteSucessfull = false;
     }

     return deleteSucessfull;
  }


}// end Class

