package deliveryDocket;

import java.sql.*;

public class MySQLAccess {

    private static Connection connection = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static void init_db() {
     
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3307/newsagentdb?";
            connection = DriverManager.getConnection(url, "root", "123");
            stmt = connection.createStatement();
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void createDeliveryDocket(int cus_id, String publication, String Dname, String address) throws SQLException {
    	try {
            if (stmt == null) 
                init_db(); 
            }catch(Exception e) {
            	e.printStackTrace();
            }
    	
        String query = "INSERT INTO delivery_docket (cus_id, publication, Dname, address) VALUES (?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cus_id);
            statement.setString(2, publication);
            statement.setString(3, Dname);
            statement.setString(4, address);
            statement.executeUpdate();
        }
    }
    
    public void updateDeliveryDocket(int cus_id, String newpublication, String newDname, String address) throws Exception {
    	try {
            if (stmt == null) 
                init_db(); 
            }catch(Exception e) {
            	e.printStackTrace();
            }
    	
        String query = "UPDATE delivery_docket SET   publication = ?, Dname = ?, address = ? WHERE cus_id = ?";
        try{
        	PreparedStatement statement = connection.prepareStatement(query);
        	statement.setString(1, newpublication);  
        	statement.setString(2, newDname);       
        	statement.setString(3, address);         
        	statement.setInt(4, cus_id);            
        	statement.executeUpdate();

        }catch(Exception e) {
        	e.printStackTrace();
        }
        	 
    }
    
    public void deleteDeliveryDocket(int dDoc_id) throws SQLException {
    	try {
            if (stmt == null) 
                init_db(); 
            }catch(Exception e) {
            	e.printStackTrace();
            }
    	
        String query = "DELETE FROM delivery_docket WHERE dDoc_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, dDoc_id);
            statement.executeUpdate();
        }
    }
    

    public static void printDeliveryDocketData() {
        try {
            if (stmt == null) {
                init_db();
            }

            rs = stmt.executeQuery("SELECT * FROM delivery_docket");            
            System.out.println("________________Driver Docket_____________________");
            while (rs.next()) {
            	int dDoc_id = rs.getInt("dDoc_id");
            	int cus_id = rs.getInt("cus_id");
                String publication = rs.getString("publication");
                String Dname = rs.getString("Dname");
                String town = rs.getString("address");
                System.out.println(dDoc_id + " - "+cus_id + " - " + publication + " - " + Dname + " - " + town);
            }
        } catch (SQLException sqle) {
            System.out.println("Error: Failed to retrieve data from delivery_person table\n" + sqle.getMessage());
//        } finally {
//            // Close resources in a finally block
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (stmt != null) {
//                    stmt.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                System.out.println("Error while closing resources: " + e.getMessage());
//            }
        }
    }
}
