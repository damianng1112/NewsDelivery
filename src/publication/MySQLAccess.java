package publication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySQLAccess {
	
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




	


}// end Class

