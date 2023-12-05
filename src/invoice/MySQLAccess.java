package invoice;
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
            String url = "jdbc:mysql://localhost:3307/newsagentdb?";
            connection = DriverManager.getConnection(url, "root", "123");
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void insertInvoiceDetailsAccount(Invoice invoice) throws SQLException {
		try {
            if (stmt == null) 
                init_db(); 
            }catch(Exception e) {
            	e.printStackTrace();
            }
    	
        String query = "INSERT INTO invoice(cus_id,pub_id,price) VALUES (?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, invoice.getCus_id());
            statement.setInt(2, invoice.getPub_id());
            statement.setString(3,invoice.getPrice());
            statement.executeUpdate();
        }
		
	}// end insertInvoiceDetailsAccount

	public ResultSet retrieveAllInvoiceAccounts() {
		
		try {
			if (stmt == null) {
                init_db();
            }
			stmt = connection.createStatement();
			rs= stmt.executeQuery("Select * from newsagentdb.invoice");
		
		}
		catch (Exception e) {
			rs = null;
		}
		return rs;
	}
	
	public void deleteInvoiceById(int inv_id) throws SQLException {

		try {
            if (stmt == null) 
                init_db(); 
            }catch(Exception e) {
            	e.printStackTrace();
            }
    	
        String query = "DELETE FROM invoice WHERE inv_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, inv_id);
            statement.executeUpdate();
        }
		
	}
	public void updateInvoice(int id,int cus_id, int pub_id,String price) throws Exception {    
		try {
            if (stmt == null) 
                init_db(); 
            }catch(Exception e) {
            	e.printStackTrace();
            }
    	
        String query = "UPDATE invoice SET  cus_id = ?, pub_id = ?, price = ? WHERE inv_id = ?";
        try{
        	PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cus_id);
            statement.setInt(2, pub_id);
            statement.setString(3, price);
            statement.setInt(4, id);
            statement.executeUpdate();
        }catch(Exception e) {
        	e.printStackTrace();
        }
        	 
    }

	


}// end Class

