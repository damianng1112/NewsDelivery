package publication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySQLAccess {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	final private String host ="localhost:3306";
	final private String user = "root";
	final private String password = "";
	
	
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

	public boolean insertPublicationDetailsAccount(Publication publication) {
	
		boolean insertSucessfull = true;
	
		//Add Code here to call embedded SQL to insert Customer into DB
	
		try {
		
			//Create prepared statement to issue SQL query to the database
			preparedStatement = connect.prepareStatement("insert into newsagentdb.publication values (default, ?, ?)");
			preparedStatement.setString(1, publication.getPublicationName());
			preparedStatement.setDouble(2, publication.getPrice());
			preparedStatement.executeUpdate();
		
	 
		}
		catch (Exception e) {
			insertSucessfull = false;
		}
	
		return insertSucessfull;
		
	}// end insertCustomerDetailsAccount

	public ResultSet retrieveAllPublicationAccounts() {
		
		//Add Code here to call embedded SQL to view Customer Details
	
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("Select * from newsagentdb.publication");
		
		}
		catch (Exception e) {
			resultSet = null;
		}
		return resultSet;
	}
	
	 public boolean updatePublication(String pub_id, String NewName, Double newPrice) throws Exception {
		 	boolean updateSuccessful = true;
	        String query = "UPDATE publication SET  pub_name = ?, price = ? WHERE pub_id = ?";
	        try{
	        	PreparedStatement statement = connect.prepareStatement(query);
	        	statement.setString(1, NewName);
	        	statement.setDouble(2, newPrice);
	        	statement.setString(3, pub_id);

	            statement.executeUpdate();
	        }catch(Exception e) {
	        	updateSuccessful = false;
	        }
	        return updateSuccessful;
	    }
	
	public boolean deletePublicationById(String publicationID) {

		boolean deleteSucessfull = true;
		
		//Add Code here to call embedded SQL to insert Customer into DB
		
		try {
			
			//Create prepared statement to issue SQL query to the database
			if (publicationID.equals("-99"))
				//Delete all entries in Table
				preparedStatement = connect.prepareStatement("delete from newsagentdb.publication");
			else
				//Delete a particular Customer
				preparedStatement = connect.prepareStatement("delete from newsagentdb.publication where pub_id = " + publicationID);
			preparedStatement.executeUpdate();
		 
		}
		catch (Exception e) {
			deleteSucessfull = false;
		}
		
		return deleteSucessfull;
		
	}
	
	public boolean validateId(String id) {
        // SQL query to check the id 
        String query = "SELECT pub_id FROM publication";
        boolean res = false;
        try{
        	PreparedStatement statement = connect.prepareStatement(query);
            // Executing the query
            ResultSet rs = statement.executeQuery();

            // Checking if the user exists
            while(rs.next()) {
            	String dbId = rs.getString("pub_id");
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


}// end Class

