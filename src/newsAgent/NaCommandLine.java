package newsAgent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import customer.Customer;
import publication.Publication;
import publication.PublicationCommandLine;
import order.*;

import deliveryPerson.*;


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
		System.out.println("5. Create Publication");
		System.out.println("6. View ALL Publication");
		System.out.println("7. Update Publication");
		System.out.println("8. Delete Publication");
		System.out.println("9. CRUD DeliveryPerson");	 
		System.out.println("10. CRUD Order");	 
		System.out.println("99.Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}

private static boolean printCustomerTable(ResultSet rs) throws Exception {
	
	//Print The Contents of the Full Customer Table
	
	System.out.printf("%-5s%-20s%-35s%-20s%-20s%n",
            "ID", "Name", "Address", "Phone Number", "Publication");
    System.out.println("--------------------------------------------------------------");

    // Iterate through the result set
    while (rs.next()) {
        int cusId = rs.getInt("cus_id");
        String name = rs.getString("name");
        String address = rs.getString("address");
        String phoneNo = rs.getString("phoneNo");
        String publication = rs.getString("publication");

        System.out.printf("%-5d%-20s%-35s%-20s%-20s%n",
                cusId, name, address, phoneNo, publication);
    
	}// end while
    System.out.println("--------------------------------------------------------------");
	
	return true;
	
}

public static void show() {
	
	//Create the Database Object
	
	try {
		
		MySQLAccess dao = new MySQLAccess();
		publication.MySQLAccess pubDAO = new publication.MySQLAccess();
		customer.MySQLAccess custDAO = new customer.MySQLAccess();
	
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
				ResultSet pubRSet = pubDAO.retrieveAllPublicationAccounts();
				if (pubRSet == null) {
					System.out.println("No Records Found");
					break;
				}
				else {
					boolean tablePrinted = PublicationCommandLine.printPublicationTable(pubRSet);
					if (tablePrinted == true)
						pubRSet.close();
				}
				System.out.printf("Enter Customer Publication of choice: \n");
				String custPub = keyboard.next();
				
				if (pubDAO.validatePub(custPub)) {
					Customer custObj = new Customer(custName,custAddr,custphoneNumber, custPub);
					//Insert Customer Details into the database
					boolean insertResult = dao.insertCustomerDetailsAccount(custObj);
					if (insertResult == true)
						System.out.println("Customer Details Saved");
					else 
						System.out.println("ERROR: Customer Details NOT Saved");
				}else {
					System.out.println("Publication does not exist");
				}
				break;
//				//Get Customer Details from the User
//				System.out.printf("Enter Customer Name: \n");
//				String custName = keyboard.next();
//				System.out.printf("Enter Customer Address: \n");
//				String custAddr = keyboard.next();
//				System.out.printf("Enter Customer PhoneNumber: \n");
//				String custphoneNumber = keyboard.next();
//				System.out.printf("Enter Customer Publication: \n");
//				String custPub = keyboard.next();
//							
//				//Insert Customer Details into the database
//				boolean insertResult = custDAO.createCustomer(custName,custAddr,custphoneNumber, custPub);
//				if (insertResult == true)
//					System.out.println("Customer Details Saved");
//				else 
//					System.out.println("ERROR: Customer Details NOT Saved");
//				break;
				
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
				if (dao.validateId(updateCustId)) {
					System.out.printf("Enter Customer New Name: \n");
					String newName = keyboard.next();
					System.out.printf("Enter Customer New Address: \n");
					String newAddr = keyboard.next();
					System.out.printf("Enter Customer New PhoneNumber: \n");
					String newPhoneNumber = keyboard.next();
					ResultSet pub11RSet = pubDAO.retrieveAllPublicationAccounts();
					if (pub11RSet == null) {
						System.out.println("No Records Found");
						break;
					}
					else {
						boolean tablePrinted = PublicationCommandLine.printPublicationTable(pub11RSet);
						if (tablePrinted == true)
							pub11RSet.close();
					}
					System.out.printf("Enter Customer New Publication of choice: \n");
					String newPub = keyboard.next();
					if (pubDAO.validatePub(newPub)) {
						boolean updateResult = dao.updateCustomerById(updateCustId, newName, newAddr, newPhoneNumber, newPub);
						if(updateResult==true)
							System.out.println("Customer Updated");
						else 
							System.out.println("ERROR: Customer Details NOT updated");
						}
					else {
					System.out.println("Customer Id don't Exist");
					}
				}
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
			
			case "5":
				//Create Publication
				System.out.printf("Enter Publication Name: \n");
				String pubName = keyboard.next();
				System.out.printf("Enter Publication Price: \n");
				Double price = keyboard.nextDouble();
				Publication pubObj = new Publication(pubName, price);
				
				//Insert Publication Details into the database
				boolean insertPubResult = pubDAO.insertPublicationDetailsAccount(pubObj);
				if (insertPubResult == true)
					System.out.println("Publication Details Saved");
				else 
					System.out.println("ERROR: Publication Details NOT Saved");
				break;
				
			case "6":
				//Get All Publication
				ResultSet pubR2Set = pubDAO.retrieveAllPublicationAccounts();
				if (pubR2Set == null) {
					System.out.println("No Records Found");
					break;
				}
				else {
					boolean tablePrinted = PublicationCommandLine.printPublicationTable(pubR2Set);
					if (tablePrinted == true)
						pubR2Set.close();
				}
				break;
				
			case "7":
				//update publication
				System.out.println("Enter publication Id to be updated");
				String updatePubId = keyboard.next();
				if (pubDAO.validateId(updatePubId)) {
					System.out.printf("Enter Publication Name: \n");
					String pubNewName = keyboard.next();
					System.out.printf("Enter Publication Price: \n");
					Double newPrice = keyboard.nextDouble();
					boolean updatePubRes = pubDAO.updatePublication(updatePubId, pubNewName, newPrice);
					if (updatePubRes==true)
						System.out.println("Update Publication Success");
					else
						System.out.println("Fail to update Publication");
				}
				break;
				
			case "8":
				//delete publication
				System.out.println("Enter publication Id to be deleted or -99 to Clear all Rows");
				String deletePubId = keyboard.next();
				boolean deletePubResult = pubDAO.deletePublicationById(deletePubId);
				if ((deletePubResult == true) && (deletePubId.equals("-99")))
					System.out.println("Publication Table Emptied");
				else if (deletePubResult == true)
					System.out.println("Publication Deleted");
				else 
					System.out.println("ERROR: Publication Details NOT Deleted or Do Not Exist");
				break;
			case"9":
				deliveryPerson.DeliveryPersonCommandLine.DeliveryPerson();
				break;
			case"10":
				order.OrdCommandLine.show();
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
