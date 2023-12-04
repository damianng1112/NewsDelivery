package deliveryDocket;

import java.sql.*;

public class MySQLAccess {

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

    public static void printDeliveryDocketData() {
        try {
            if (stmt == null) {
                init_db(); // Ensure the database connection is initialized
            }

            rs = stmt.executeQuery("SELECT * FROM delivery_docket");            
            System.out.println("________________Driver Docket_____________________");
            while (rs.next()) {
                String Cname = rs.getString("Cname");
                String publication = rs.getString("publication");
                String Dname = rs.getString("Dname");
                String town = rs.getString("town");
                System.out.println(Cname + " - " + publication + " - " + Dname + " - " + town);
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
