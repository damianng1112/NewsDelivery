package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import newsAgent.NewsAgent;

public class MySQLAccess {

    private Connection connection;

    public MySQLAccess() {
        try {
            String url = "jdbc:mysql://localhost:3306/newsagentdb";
            String user = "root";
            String password = "";
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();  // Handle connection errors
        }
    }

    // Method to create a newsagent
    public void createNewsagent(int userId, String name, String address) throws SQLException {
        String query = "INSERT INTO newsagent (user_id, name,address) VALUES (?, ?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.setString(2, name);
            statement.setString(3, address);
            statement.executeUpdate();
        }
    }
    
    public void readAllNewAgent() throws SQLException {
        String query = "SELECT * FROM newsagent";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Print table header
            System.out.printf("%-20s %-20s %-15s %-15s%n", "Name", "Address");

            // Print a line below the header
            System.out.println(new String(new char[70]).replace("\0", "-"));

            // Iterate through result set and print each row in a formatted way
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");   

                // Print each customer's details in a tabular format
                System.out.printf("%-20s %-20s %-15s %-15s%n", name, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }


    // Method to update a newsagent
    public void updateNewsagent(String name,String newName ,String address) throws Exception {
        String query = "UPDATE newsagent SET  name = ?,address = ? WHERE name = ?";
        try{
        	PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newName);
            statement.setString(2, address);
            statement.setString(3, name);
        	System.out.printf(newName,address,name);
            statement.executeUpdate();
        }catch(Exception e) {
        	e.printStackTrace();
        }
        	 
    }

    // Method to delete a newsagent
    public void deleteNewsagent(String name) throws SQLException {
        String query = "DELETE FROM newsagent WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.executeUpdate();
        }
    }
    
    
    public boolean validateName(String name) {
        // SQL query to check the username 
        String query = "SELECT NAME FROM newsagent";
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
    
    public boolean validateAdminLogin(String name, String password) {
        // SQL query to check the username and password
        String query = "SELECT COUNT(*) FROM admin WHERE admin_name = ? AND admin_password = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, password);

            // Executing the query
            ResultSet rs = statement.executeQuery();

            // Checking if the user exists
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // You may want to handle or log this exception more gracefully
        }

        return false;
    }


    // Ensure to close the connection when done
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

 
}
