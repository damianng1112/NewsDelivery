package publication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySQLAccess {
	
<<<<<<< HEAD
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
	
	public boolean validatePub(String pub) {
        // SQL query to check the id 
        String query = "SELECT * FROM publication";
        boolean res = false;
        try{
        	PreparedStatement statement = connect.prepareStatement(query);
            // Executing the query
            ResultSet rs = statement.executeQuery();

            // Checking if the user exists
            while(rs.next()) {
            	String dbName = rs.getString("pub_name");
            	if (dbName.equals(pub)) {
            		res = true;
            		break;
            	}
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return res;
    }
	
	public Double getPubPriceByName(String n) {
	    Double p = 0.0;
	    String query = "SELECT price FROM newsagentdb.publication WHERE pub_name = ?";
	    try {
	        PreparedStatement statement = connect.prepareStatement(query);
	        statement.setString(1, n);  // Set the parameter using setString

	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	            p = rs.getDouble("price");
	            return p;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();  // Handle the exception appropriately
	    }
	    return p;
	}

		
=======
	private static Connection connection = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static void init_db() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3308/newsagentdb?";
            connection = DriverManager.getConnection(url, "root", "");
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void insertPublicationDetailsAccount(Publication publication) throws SQLException {
		try {
            if (stmt == null) 
                init_db(); 
            }catch(Exception e) {
            	e.printStackTrace();
            }
    	
        String query = "INSERT INTO Publication(pub_name,price,schedule) VALUES (?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, publication.getPublicationName());
            statement.setDouble(2, publication.getPrice());
            statement.setString(3,publication.getSchedule());
            statement.executeUpdate();
        }
		
	}// end insertPublicationDetailsAccount

	public ResultSet retrieveAllPublicationAccounts() {

		try {
			if (stmt == null) {
                init_db();
            }
			stmt = connection.createStatement();
			rs= stmt.executeQuery("Select * from newsagentdb.publication");
		
		}
		catch (Exception e) {
			rs = null;
		}
		return rs;
	}
	
	public void deletePublicationById(int pub_id) throws SQLException {
		
		//Add Code here to call embedded SQL to delete data from DB
		
		try {
            if (stmt == null) 
                init_db(); 
            }catch(Exception e) {
            	e.printStackTrace();
            }
    	
        String query = "DELETE FROM publication WHERE pub_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, pub_id);
            statement.executeUpdate();
        }
		
	}
	public void updatePublication(int id,String name, double price, String schedule) throws Exception {    
		try {
            if (stmt == null) 
                init_db(); 
            }catch(Exception e) {
            	e.printStackTrace();
            }
    	
        String query = "UPDATE publication SET  pub_name = ?, price = ?, schedule = ? WHERE pub_id = ?";
        try{
        	PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.setString(3, schedule);
            statement.setInt(4, id);
            statement.executeUpdate();
        }catch(Exception e) {
        	e.printStackTrace();
        }
        	 
    }




	
>>>>>>> WeiBranch


}// end Class

