package deliveryPerson;

import java.sql.*;

public class MySQLAccessDP {

    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static void init_db() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/newsagentdb?";
            con = DriverManager.getConnection(url, "root", "");
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printDeliveryPersonData() {
        try {
            if (stmt == null) {
                init_db(); // Ensure the database connection is initialized
            }

            rs = stmt.executeQuery("SELECT * FROM delivery_person");            
            System.out.println("________________Driver list_____________________");
            while (rs.next()) {
                int DP_id = rs.getInt(1);
                String name = rs.getString("Name");
                String address = rs.getString("Delivery_address");
                String phoneNumber = rs.getString("Contact_num");
                String town = rs.getString("town");
                System.out.println(DP_id + "." + name + " - " + address + " - " + phoneNumber + " - " + town);
            }
        } catch (SQLException sqle) {
            System.out.println("Error: Failed to retrieve data from delivery_person table\n" + sqle.getMessage());
        } finally {
            // Close resources in a finally block
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error while closing resources: " + e.getMessage());
            }
        }
    }
}
