package newsAgent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import Customer.Customer;
import Customer.MySQLAccess;
import index.Managerindex;


public class NaCommandLine {
	
private static void listNewsAgentFuctionalityAvailable() {
		
		//Present News Agent with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create Customer Account");
		System.out.println("2. View ALL Customer Records");
		System.out.println("3. Update Customer Records");
		System.out.println("4. Delete Customer Record by ID");
		System.out.println("99.Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}

private static boolean printCustomerTable(ResultSet rs) throws Exception {
	
	//Print The Contents of the Full Customer Table
	
	System.out.printf("%-5s%-20s%-30s%-15s%-15s%-15s%n",
            "ID", "Name", "Address", "Phone Number", "Town", "Publication");
    System.out.println("--------------------------------------------------------------");

    // Iterate through the result set
    while (rs.next()) {
        int cusId = rs.getInt("cus_id");
        String name = rs.getString("name");
        String address = rs.getString("address");
        String phoneNo = rs.getString("phoneNo");
        String town = rs.getString("town");
        String publication = rs.getString("publication");

        System.out.printf("%-5d%-20s%-30s%-15s%-15s%-15s%n",
                cusId, name, address, phoneNo, town, publication);
    
	}// end while
    System.out.println("--------------------------------------------------------------");
	
	return true;
	
}

public void show() {
	
	//Create the Database Object
	
	try {
		
		MySQLAccess dao = new MySQLAccess();
	
		// Configure System for Running
		Scanner keyboard = new Scanner(System.in); 
		String functionNumber = "";
		boolean keepAppOpen = true;
	
		while (keepAppOpen == true) {
		
			//Present list of functionality and get selection
			listNewsAgentFuctionalityAvailable();
			functionNumber = keyboard.next();
	
			switch (functionNumber) {
	
			case "1":
				//Get Customer Details from the User
				System.out.printf("Enter Customer Name: \n");
				String custName = keyboard.next();
				System.out.printf("Enter Customer Address: \n");
				String custAddr = keyboard.next();
				System.out.printf("Enter Customer PhoneNumber: \n");
				String custphoneNumber = keyboard.next();
				System.out.printf("Enter Customer Area: \n");
				String custArea = keyboard.next();
				System.out.printf("Enter Customer Publication: \n");
				String custPub = keyboard.next();
				
				Customer custObj = new Customer(custName,custAddr,custphoneNumber,custArea);
			
				//Insert Customer Details into the database
				boolean insertResult = dao.insertCustomerDetailsAccount(custObj);
				if (insertResult == true)
					System.out.println("Customer Details Saved");
				else 
					System.out.println("ERROR: Customer Details NOT Saved");
				break;
				
			case "2": 
				//Retrieve ALL Customer Records
				ResultSet rSet = dao.retrieveAllCustomerAccounts();
				if (rSet == null) {
					System.out.println("No Records Found");
					break;
				}
				else {
					boolean tablePrinted = printCustomerTable(rSet);
					if (tablePrinted == true)
						rSet.close();
				}
				break;
				
			case "3":
				//Update Customer Record by ID
				System.out.println("Enter Customer Id to be updated");
				String updateCustId = keyboard.next();
				boolean updateResult = dao.updateCustomerById(Integer.parseInt(updateCustId));
				if(updateResult==true)
					System.out.println("Customer Updated");
				else 
					System.out.println("ERROR: Customer Details NOT updated or Do Not Exist");
				break;
				
			case "4":
				//Delete Customer Record by ID
				System.out.println("Enter Customer Id to be deleted or -99 to Clear all Rows");
				String deleteCustId = keyboard.next();
				boolean deleteResult = dao.deleteCustomerById(Integer.parseInt(deleteCustId));
				if ((deleteResult == true) && (deleteCustId.equals("-99")))
					System.out.println("Customer Table Emptied");
				else if (deleteResult == true)
					System.out.println("Customer Deleted");
				else 
					System.out.println("ERROR: Customer Details NOT Deleted or Do Not Exist");
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

}
