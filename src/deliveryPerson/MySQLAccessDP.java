package deliveryPerson;

import java.sql.*;

public class MySQLAccessDP {

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
    
    public void createDeliveryPerson(String Name, String Delivery_address, String Contact_num, String town) throws SQLException {
    	try {
            if (stmt == null) 
                init_db(); 
            }catch(Exception e) {
            	e.printStackTrace();
            }
    	
        String query = "INSERT INTO delivery_person (name, address, Contact_num, town) VALUES (?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, Name);
            statement.setString(2, Delivery_address);
            statement.setString(3, Contact_num);
            statement.setString(4, town);
            statement.executeUpdate();
        }
    }
    
    public void updateDeliveryPerson(String Name, String newName ,String newDelivery_address, String newContact_num, String newtown) throws Exception {
    	try {
            if (stmt == null) 
                init_db(); 
            }catch(Exception e) {
            	e.printStackTrace();
            }
    	
        String query = "UPDATE delivery_person SET  name = ?,address = ?, Contact_num = ?, town = ? WHERE Name = ?";
        try{
        	PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newName);
            statement.setString(2, newDelivery_address);
            statement.setString(3, newContact_num);
            statement.setString(4, newtown);
            statement.setString(5, Name);
            statement.executeUpdate();
        }catch(Exception e) {
        	e.printStackTrace();
        }
        	 
    }
    
    public void deleteDeliveryPerson(int DP_id) throws SQLException {
    	try {
            if (stmt == null) 
                init_db(); 
            }catch(Exception e) {
            	e.printStackTrace();
            }
            
        String query = "DELETE FROM delivery_person WHERE DP_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, DP_id);
            statement.executeUpdate();
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }

    public static void printDeliveryPersonData() {
        try {
            if (stmt == null) {
                init_db(); 
            }

            rs = stmt.executeQuery("SELECT * FROM delivery_person");    
            System.out.println("               Driver List               ");
            System.out.println("");
            while (rs.next()) {
                int DP_id = rs.getInt(1);
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("Contact_num");
                String town = rs.getString("town");
                System.out.println(DP_id + "." + name + " - " + address + " - " + phoneNumber + " - " + town);
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
//        }
    }
    }
}
