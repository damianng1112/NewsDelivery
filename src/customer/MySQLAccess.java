package customer;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySQLAccess {
	
	  private Connection connection;

	    public MySQLAccess() {
	        try {
	            String url = "jdbc:mysql://localhost:3307/newsagentdb";
	            String user = "root";
	            String password = "123";
	            this.connection = DriverManager.getConnection(url, user, password);
	        } catch (SQLException e) {
	            e.printStackTrace();  //  
	        }
	    }
	    

	    // Method to create a newsagent
	    public void createCustomer(String name, String address,String phoneNo,String publicaion) throws SQLException {
	        String query = "insert into customerdetails(name,address,phoneNo,publication) values (?, ?, ?,?)";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, name);
	            statement.setString(2, address);
	            statement.setString(3, phoneNo);
	            statement.setString(4, publicaion);
	            statement.executeUpdate();
	        }
	    }
	    
	    public void readAllCustomers() throws SQLException {
	        String query = "SELECT * FROM customerdetails";
	        try (Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {

	            // Print table header
	            System.out.printf("%-20s %-20s %-15s %-15s%n", "Name", "Address", "Phone Number", "Publication");

	            // Print a line below the header
	            System.out.println(new String(new char[70]).replace("\0", "-"));

	            // Iterate through result set and print each row in a formatted way
	            while (resultSet.next()) {
	                String name = resultSet.getString("name");
	                String address = resultSet.getString("address");
	                String phoneNo = resultSet.getString("phoneNo");
	                String publication = resultSet.getString("publication");

	                // Print each customer's details in a tabular format
	                System.out.printf("%-20s %-20s %-15s %-15s%n", name, address, phoneNo, publication);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
	        }
	    }


	    // Method to update a newsagent
	    public void updateCustomer(String name,String Newname, String Newaddress,String NewphoneNo,String Newpublicaion) throws Exception {
	        String query = "UPDATE customerdetails SET  name = ?,address = ?,phoneNo = ?,publication = ? WHERE name = ?";
	        try{
	        	PreparedStatement statement = connection.prepareStatement(query);
	        	statement.setString(1, Newname);
	        	statement.setString(2, Newaddress);
	        	statement.setString(3, NewphoneNo);
	        	statement.setString(4, Newpublicaion);
	        	statement.setString(5, name); // The old name for the WHERE clause

	            statement.executeUpdate();
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }
	        	 
	    }

	    // Method to delete a customer
	    public void deleteCustomer(String name) throws SQLException {
	        String query = "DELETE FROM customerdetails WHERE name = ?";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, name);
	            statement.executeUpdate();
	        }
	    }
	    
	    
	    public boolean validateName(String name) {
	        // SQL query to check the username 
	        String query = "SELECT NAME FROM customerdetails";
	        boolean res = false;
	        try{
	        	PreparedStatement statement = connection.prepareStatement(query);
	            // Executing the query
	            ResultSet rs = statement.executeQuery();

	            // Checking if the user exists
	            while(rs.next()) {
	            	String dbName = rs.getString("name");
	            	if (dbName.equals(name)) {
	            		res = true;
	            		break;
	            	}
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();

	        }

	        return res;
	    }
	    
//	    public boolean validateAdminLogin(String name, String password) {
//	        // SQL query to check the username and password
//	        String query = "SELECT COUNT(*) FROM admin WHERE admin_name = ? AND admin_password = ?";
//
//	        try (PreparedStatement statement = connection.prepareStatement(query)) {
//	            statement.setString(1, name);
//	            statement.setString(2, password);
//
//	            // Executing the query
//	            ResultSet rs = statement.executeQuery();
//
//	            // Checking if the user exists
//	            if (rs.next()) {
//	                int count = rs.getInt(1);
//	                return count > 0;
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	            // You may want to handle or log this exception more gracefully
//	        }
//
//	        return false;
//	    }


	    // Ensure to close the connection when done
	    public void closeConnection() throws SQLException {
	        if (connection != null && !connection.isClosed()) {
	            connection.close();
	        }
	    }


	 

}// end Class

