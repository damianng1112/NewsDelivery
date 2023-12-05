package invoice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class InvoiceCommandLine {
	
	private static void listInvoiceFuctionalityAvailable() {
		
		//Present Customer with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. View ALL invoice Records");
		System.out.println("2. create an invoice Record");
		System.out.println("3. update an invoice Record");
		System.out.println("4. delete an invoice Record");
		System.out.println("99. Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}

	
	private static boolean printInvoiceTable(ResultSet rs) throws Exception {
		
		//Print The Contents of the Full Customer Table
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			int id = rs.getInt("inv_id");
			int cus_id = rs.getInt("cus_id");
			int pub_id= rs.getInt("pub_id");
			String price = rs.getString("price");
			
			System.out.printf("%30s", id);
			System.out.printf("%30s", cus_id);
			System.out.printf("%30s", pub_id);
			System.out.printf("%30s", price);
			System.out.println();
		}// end while
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		
		return true;
		
	}

	public static  void main(String[] args) {
		
		//Create the Database Object
		
		try {
			
			MySQLAccess dao = new MySQLAccess();
		
			// Configure System for Running
			Scanner keyboard = new Scanner(System.in); 
			String functionNumber = "-99";
			boolean keepAppOpen = true;
		
			while (keepAppOpen == true) {
			
				//Present list of functionality and get selection
				listInvoiceFuctionalityAvailable();
				functionNumber = keyboard.next();
		
				switch (functionNumber) {				
				case "1": 
					//Retrieve ALL Invoice Records
					ResultSet rSet = dao.retrieveAllInvoiceAccounts();
					if (rSet == null) {
						System.out.println("No Records Found");
						break;
					}
					else {
						boolean tablePrinted = printInvoiceTable(rSet);
						if (tablePrinted == true)
							rSet.close();
					}
					break;	
				case "2":
		            System.out.println("Enter Customer id:");
		            int cus_id = keyboard.nextInt();
		            
		            System.out.println("Enter Publication id:");
		            int pub_id = keyboard.nextInt();
		            
		            System.out.println("Enter price:");
		            String price = keyboard.next();
		            try {
		            	MySQLAccess CmySQLAccess = new MySQLAccess();
		            	Invoice invoice = new Invoice(price,pub_id,cus_id);
		            	CmySQLAccess.insertInvoiceDetailsAccount(invoice);
		                System.out.println("invoice created successfully!");
		            } catch (SQLException e) {
		                System.out.println("Error occurred while creating Invoice: " + e.getMessage());
		            }
		            break;
				case "3":
					System.out.println("Enter Invoice Id:");
		            int id = keyboard.nextInt();
		            
					System.out.println("Enter Customer Id:");
		            int newcus_id = keyboard.nextInt();
		            
		            System.out.println("Enter Publication Id:");
		            int newpub_id = keyboard.nextInt();
		            
		            System.out.println("Enter price:");
		            String newPrice = keyboard.next();
		            try {
		            	MySQLAccess UmySQLAccess = new MySQLAccess();
		            	UmySQLAccess.updateInvoice(id, newcus_id,newpub_id,newPrice);
		                System.out.println("Invoice update successfully!");
		            } catch (SQLException e) {
		                System.out.println("Error occurred while updateing Invoice: " + e.getMessage());
		            }
		            break;
				case "4":
					System.out.println("Enter Invoice id to delete:");
		            int inv_id = keyboard.nextInt();

		            try {
		            	MySQLAccess DmySQLAccess = new MySQLAccess(); 
		                DmySQLAccess.deleteInvoiceById(inv_id);
		                System.out.println("Invoice deleted successfully!");
		            } catch (SQLException e) {
		                System.out.println("Error occurred while deleting Invoice: " + e.getMessage());
		            }
		            break;
				case "99":
					keepAppOpen = false;
					System.out.println("Closing the Application");
					break;
			
				default:
					System.out.println("No Valid Function Selected");
					break;
				} // end switch
		
			}// end while
		
			//Tidy up Resources
			keyboard.close();
		
		}
	
		catch(Exception e) {
			System.out.println("PROGRAM TERMINATED - ERROR MESSAGE:" + e.getMessage());
		} // end try-catch
		

	} // end main
	
	
}