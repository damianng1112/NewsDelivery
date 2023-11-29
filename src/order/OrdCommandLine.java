package order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

public class OrdCommandLine {
	
	private static void listOrderFuctionalityAvailable() {
		
		//Present Customer with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create Order");
		System.out.println("2. View ALL Order Records");
		System.out.println("3. Update Order Records");		
		System.out.println("4. Delete Order Record by ID");
		System.out.println("99.Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}
	
	private static boolean printOrderTable(ResultSet rs) throws Exception {
	    // Print the contents of the Full Order Table

	    System.out.printf("%-10s%-15s%-20s%-25s%-20s%-15s%n",
	            "Order ID", "Customer ID", "Customer Name", "Customer Address", "Customer Number", "Publication");
	    System.out.println("-------------------------------------------------------------------------------------------------");

	    // Iterate through the result set
	    while (rs.next()) {
	        int orderId = rs.getInt("ord_id");
	        String customerId = rs.getString("cus_id");
	        String customerName = rs.getString("cus_name");
	        String customerAddress = rs.getString("cus_address");
	        String customerNumber = rs.getString("cus_number");
	        String publication = rs.getString("publication");

	        System.out.printf("%-10d%-15s%-20s%-25s%-20s%-15s%n",
	                orderId, customerId, customerName, customerAddress, customerNumber, publication);
	    }// end while
	    System.out.println("-------------------------------------------------------------------------------------------------");

	    return true;
	}


	public static void show() {
		
		//Create the Database Object
		
		try {
			
			MySQLAccess dao = new MySQLAccess();
		
			// Configure System for Running
			Scanner keyboard = new Scanner(System.in); 
			String functionNumber = "";
			boolean keepAppOpen = true;
		
			while (keepAppOpen == true) {
			
				//Present list of functionality and get selection
				listOrderFuctionalityAvailable();
				functionNumber = keyboard.next();
		
				switch (functionNumber) {
		
				case "1":
					//Get Customer Details from the User
					System.out.printf("Enter Customer Id: \n");
					String custId = keyboard.next();
					System.out.printf("Enter Customer Name: \n");
					String custName = keyboard.next();
					System.out.printf("Enter Customer Address: \n");
					String custAddr = keyboard.next();	
					System.out.printf("Enter Customer PhoneNumber: \n");
					String custphoneNumber = keyboard.next();				
					System.out.printf("Enter Customer Publication: \n");
					String custPub = keyboard.next();
					
					Order OrdObj = new Order(custId,custName,custAddr,custphoneNumber, custPub);
				
					//Insert Order Details into the database
					boolean insertResult = dao.insertOrderDetails(OrdObj);
					if (insertResult == true)
						System.out.println("Customer Details Saved");
					else 
						System.out.println("ERROR: Customer Details NOT Saved");
					break;
					
				case "2": 
					//Retrieve ALL Order Records
					ResultSet rSet = dao.retrieveAllOrderDetails();
					if (rSet == null) {
						System.out.println("No Records Found");
						break;
					}
					else {
						boolean tablePrinted = printOrderTable(rSet);
						if (tablePrinted == true)
							rSet.close();
					}
					break;
					
				case "3":
					//Update Order Record by ID
					System.out.println("Enter Order Id to be updated");
					String updateOrdId = keyboard.next();
					boolean updateResult = dao.updateOrderById(Integer.parseInt(updateOrdId));
					if (updateResult==true)
						System.out.println("Order Updated");
					else 
						System.out.println("ERROR: Order Details NOT updated or Do Not Exist");
					break;
					
				case "4":
					//Delete Order Record by ID
					System.out.println("Enter Order Id to be deleted or -99 to Clear all Rows");
					String deleteOrdId = keyboard.next();
					boolean deleteResult = dao.deleteOrderById(Integer.parseInt(deleteOrdId));
					if ((deleteResult == true) && (deleteOrdId.equals("-99")))
						System.out.println("Order Table Emptied");
					else if (deleteResult == true)
						System.out.println("Order Deleted");
					else 
						System.out.println("ERROR: Order Details NOT Deleted or Do Not Exist");
					break;
			
				case "99":
					keepAppOpen = false;
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
	
	public static void main (String[] args) {
		show();
	}

}
