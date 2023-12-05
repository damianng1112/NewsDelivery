package order;

import java.sql.Connection;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.Scanner;
import publication.*;

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
		System.out.println("5. Print Customer Outstanding Payments");
		System.out.println("99.Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}
	
	private static boolean printOrderTable(ResultSet rs) throws Exception {
	    // Print the contents of the Full Order Table

	    System.out.printf("%-10s%-15s%-20s%-20s%-15s%-10s%-15s%n",
	            "Order ID", "Customer ID", "Customer Name", "Customer Address", "Customer Number", "Publication", "Date");
	    System.out.println("-------------------------------------------------------------------------------------------------");

	    // Iterate through the result set
	    while (rs.next()) {
	        int orderId = rs.getInt("ord_id");
	        String customerId = rs.getString("cus_id");
	        String customerName = rs.getString("cus_name");
	        String customerAddress = rs.getString("cus_address");
	        String customerNumber = rs.getString("cus_number");
	        String publication = rs.getString("publication");
	        String date = rs.getString("date");

	        System.out.printf("%-10s%-15s%-20s%-20s%-15s%-10s%-15s%n",
	                orderId, customerId, customerName, customerAddress, customerNumber, publication, date);
	    }// end while
	    System.out.println("-------------------------------------------------------------------------------------------------");

	    return true;
	}


	public static void show() {
		
		//Create the Database Object
		
		try {
			
			MySQLAccess dao = new MySQLAccess();
			customer.MySQLAccess cusDAO = new customer.MySQLAccess();
			publication.MySQLAccess pubDAO = new publication.MySQLAccess();
		
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
					if (cusDAO.validateId(custId)) {
						System.out.printf("Enter Date of Order (yyyy-mm-dd): \n");
						String date = keyboard.next();
						ResultSet rs = cusDAO.readCustomerById(custId);
						while(rs.next()) {
							String custName = rs.getString("name");
							String custAddr = rs.getString("address");
							String custPhoneNumber = rs.getString("phoneNo");
							String custPub = rs.getString("publication");
							Order OrdObj = new Order(custId,custName,custAddr,custPhoneNumber, custPub, date);
							//Insert Order Details into the database
							boolean insertResult = dao.insertOrderDetails(OrdObj);
							if (insertResult == true)
								System.out.println("Customer Order Saved");
							else 
								System.out.println("ERROR: Customer Order NOT Saved");
						}
					}else {
						System.out.println("Customer Id don't exist");
					}
					
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
					if (dao.validateId(updateOrdId)) {
						System.out.printf("Enter Customer Id to be entered to order: \n");
						String updateCustId = keyboard.next();
						if (cusDAO.validateId(updateCustId)) {
							System.out.printf("Enter Date of Order (yyyy-mm-dd): \n");
							String date = keyboard.next();
							ResultSet rs = cusDAO.readCustomerById(updateCustId);
							while(rs.next()) {
								String custName = rs.getString("name");
								String custAddr = rs.getString("address");
								String custPhoneNumber = rs.getString("phoneNo");
								String custPub = rs.getString("publication");
								Order updateOrdObj = new Order(updateCustId,custName,custAddr,custPhoneNumber, custPub, date);
								boolean updateResult = dao.updateOrderById(updateOrdObj, updateOrdId);
								if (updateResult==true)
									System.out.println("Order Updated");
								else 
									System.out.println("ERROR: Order Details NOT updated or Do Not Exist");
							}
						}
					
					}else {
						System.out.println("WHYYYYYYYYYYYYY");
					}
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
					
				case "5":
					//Print outstanding payments
					System.out.println("Enter Order Id to be calculated");
					String ordIdPay = keyboard.next();
					if(dao.validateId(ordIdPay)) {
						ResultSet rsPay = dao.readOrderById(ordIdPay);
						while(rsPay.next()) {
							String date = rsPay.getString("date");
							String pubName = rsPay.getString("publication");
							Double pubPrice = pubDAO.getPubPriceByName(pubName);
							// Convert the order date string to LocalDate
			                   LocalDate orderDate = LocalDate.parse(date);

			                // Get today's date
			                LocalDate today = LocalDate.now();

			                // Calculate the difference in days
			                long daysDifference = java.time.temporal.ChronoUnit.DAYS.between(orderDate, today);

			                // Assuming your Publication class has a getPrice() method
			                double totalPayment = daysDifference * pubPrice;
			                System.out.println("Number of days since order: " + daysDifference);
			                System.out.println("Price of Publication: $" + pubPrice);
			                System.out.println("Outstanding payment for customer "+rsPay.getString("cus_name")+" is: $"+totalPayment);
							
						}
					}else {
						System.out.println("Order Id don't exist");
					}
					break;
			
				case "99":
					keepAppOpen = false;
					break;
			
				default:
					System.out.println("No Valid Function Selected");
					break;
				} // end switch
		
			}// end while
		
		
		}

		catch(Exception e) {
			System.out.println("PROGRAM TERMINATED - ERROR MESSAGE:" + e.getMessage());
		} // end try-catch
		

	} // end main

	public static void main (String[] args) {
		show();
	}

}
