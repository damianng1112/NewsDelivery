package publication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PublicationCommandLine {
	
	private static void listPublicationFuctionalityAvailable() {
		
		//Present Customer with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. View ALL Publication Records");
		System.out.println("2. Create a Publication Record");
		System.out.println("3. Update a Publication Record");
		System.out.println("4. Delete a Publication Record");
		System.out.println("99. Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}

	
	private static boolean printPublicationTable(ResultSet rs) throws Exception {
		
		//Print The Contents of the Full Customer Table
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			int id = rs.getInt("pub_id");
			String name = rs.getString("pub_name");
			double price = rs.getDouble("price");
			String schedule = rs.getString("schedule");
			
			System.out.printf("%30s", id);
			System.out.printf("%30s", name);
			System.out.printf("%30s", price);
			System.out.printf("%30s", schedule);
			System.out.println();
		}// end while
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		
		return true;
		
	}

	public static void main(String[] args) {
		
		//Create the Database Object
		
		try {
			
			MySQLAccess dao = new MySQLAccess();
		
			// Configure System for Running
			Scanner keyboard = new Scanner(System.in); 
			String functionNumber = "-99";
			boolean keepAppOpen = true;
		
			while (keepAppOpen == true) {
			
				//Present list of functionality and get selection
				listPublicationFuctionalityAvailable();
				functionNumber = keyboard.next();
		
				switch (functionNumber) {				
				case "1": 
					//Retrieve ALL Publication Records
					ResultSet rSet = dao.retrieveAllPublicationAccounts();
					if (rSet == null) {
						System.out.println("No Records Found");
						break;
					}
					else {
						boolean tablePrinted = printPublicationTable(rSet);
						if (tablePrinted == true)
							rSet.close();
					}
					break;	
					
				case "2":
		            System.out.println("Enter Publication Name:");
		            String name = keyboard.next();
		            
		            System.out.println("Enter price:");
		            double price = keyboard.nextDouble();
		            
		            System.out.println("Enter Schedule:");
		            String schedule = keyboard.next();
		            try {
		            	MySQLAccess CmySQLAccess = new MySQLAccess();
		            	Publication publication = new Publication(name,price,schedule);
		            	CmySQLAccess.insertPublicationDetailsAccount(publication);
		                System.out.println("publication created successfully!");
		            } catch (SQLException e) {
		                System.out.println("Error occurred while creating Publication: " + e.getMessage());
		            }
		            break;
				case "3":
					System.out.println("Enter Publication Id:");
		            int id = keyboard.nextInt();
		            
					System.out.println("Enter Publication Name:");
		            String newName = keyboard.next();
		            
		            System.out.println("Enter price:");
		            double newPrice = keyboard.nextDouble();
		            
		            System.out.println("Enter Schedule:");
		            String newSchedule = keyboard.next();
		            try {
		            	MySQLAccess UmySQLAccess = new MySQLAccess();
		            	UmySQLAccess.updatePublication(id, newName,newPrice,newSchedule);
		                System.out.println("publication update successfully!");
		            } catch (SQLException e) {
		                System.out.println("Error occurred while updateing Publication: " + e.getMessage());
		            }
		            break;
				case "4":
					System.out.println("Enter Publication id to delete:");
		            int pub_id = keyboard.nextInt();

		            try {
		            	MySQLAccess DmySQLAccess = new MySQLAccess(); 
		                DmySQLAccess.deletePublicationById(pub_id);
		                System.out.println("Publication deleted successfully!");
		            } catch (SQLException e) {
		                System.out.println("Error occurred while deleting Publication: " + e.getMessage());
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