package Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import Customer.CustomerExceptionHandler;


public class CustomerCommandLine {
	
	
	public static void CustomerMenu(){
        System.out.println(" ");
        System.out.println("==================");
        System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Customer-Menu-Options:---------------|");
		System.out.println("|                                                       |");
		System.out.println("|  1. Create Customer.                                  |");
		System.out.println("|  2. View All Customers.                               |");                                
		System.out.println("|  3. View Select Customer.                             |");
		System.out.println("|  4. Update Customer.                                  |");
		System.out.println("|  5. Delete Customer.                                  |");
		System.out.println("|  6. Exit.            .                                |");
		System.out.println("|                                                       |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");

    }
	
	 public static void PrintAllCustomer(ResultSet resultSet){
         int count = 0;
         try{
             while(resultSet.next()){
                 count++;
                 String id = resultSet.getString("CUSTOMERID");
                 String name = resultSet.getString("NAME");
                 String phoneNumber = resultSet.getString("CUSTOMERNUMBER");
                 String address = resultSet.getString("ADDRESS");
                 String publication = resultSet.getString("PUBLICATION");

                 System.out.println("No: " + count);
                 System.out.println("Customer ID: " + id);
                 System.out.println("Name: " + name);
                 System.out.println("Phone Number: " + phoneNumber);
                 System.out.println("Address: " + address);
                 System.out.println("Publication: " + publication);
                 
             }
         }catch(SQLException e){
             e.printStackTrace();
         }
     }
	 
	 public static void PrintAllDeliveryPerson(ResultSet resultSet){
         int count = 0;
         try{
             while(resultSet.next()){
                 count++;
                 String id = resultSet.getString("DELIVERYMANID");
                 String phoneNumber = resultSet.getString("DELIVERYPHONENUMBER");
                 int deliveryDocketId = resultSet.getInt("DELIVERYDOCKET");
                 String area = resultSet.getString("AREA");
                 int userId = resultSet.getInt("USERID");

                 System.out.println("No: " + count);
                 System.out.println("delivery man Id: " + id);
                 System.out.println("Phone Number: " + phoneNumber);
                 System.out.println("Delivery docket id: " + deliveryDocketId);
                 System.out.println("Area: " + area);
                 System.out.println("User id: " + userId);
             }
         }catch(SQLException e){
             e.printStackTrace();
         }
     }
     
     
     //show in the main
     public static void CustomerMain() throws SQLException {
     MySQLAccess a = new MySQLAccess();
     // Get user input
     Scanner scanner = new Scanner(System.in);
     int choice;

     do{
    	 
	    	 MySQLAccess create = new MySQLAccess();
	    	 MySQLAccess update = new MySQLAccess();
             Scanner inserting = new Scanner(System.in);
             Scanner updating = new Scanner(System.in);
             Scanner deleting = new Scanner(System.in);
             
             // Display the menu
             DeliveryPersonMenu();

             choice = scanner.nextInt();


             // Process user's choice
             switch (choice) {
                     case 1:
                         System.out.println("=======");
                         System.out.print("Enter id: ");
                         String dpId = inserting.next();
                         
                         System.out.print("Enter phone number:");
                         String dpPhoneNumber = inserting.next();
                         
                         System.out.print("Enter delivery docket id:");
                         int docketId = inserting.nextInt();
                         DeliveryDocket dpDeliveryDocketId = new DeliveryDocket();
                         dpDeliveryDocketId.setDeliverydocketid(docketId);
                         
                         System.out.print("Enter area: ");
                         String dpArea = inserting.next();
                         
                         System.out.print("Enter user id: ");
                         int userId = inserting.nextInt();
                         User dpUserId = new User();
                         dpUserId.setUserId(userId);
                         
                         DeliveryPerson newPerson = new DeliveryPerson(dpId, dpPhoneNumber, dpDeliveryDocketId, dpArea, dpUserId);
                         boolean addedResult = create.insertDeliveryPerson(newPerson);
                         if(addedResult == true){
                             System.out.println("Record added successfully");
                         }else{
                             System.out.println("Record added unsuccessfull");
                         }
                             break;
                     case 2:
                             // Retrieve and print all delivery persons
                             System.out.println(" ");
                             ResultSet resultSet = dbHelper.getAllDeliveryPersonDetails();
                             PrintAllDeliveryPerson(resultSet);
                             break;
                     case 3:
                             // Edit account logic
                                 ResultSet resultSet2 = dbHelper.getAllDeliveryPersonDetails();
                                 int count = 0;
                                 System.out.println("IDs");

                                 while (resultSet2.next()) {
                                     count++;
                                     String idToDisplay = resultSet2.getString("DELIVERYMANID");
                                     System.out.println(" " + idToDisplay);
                                 }
                             System.out.println("=======");
                             System.out.print("Enter id: ");
                             String dpUpdateId = updating.next();

                             System.out.print("Enter phone number:");
                             String dpUpdatePhoneNumber = updating.next();

                             System.out.print("Enter delivery docket id:");
                             int updateDocketId = updating.nextInt();
                             DeliveryDocket dpUpdateDeliveryDocketId = new DeliveryDocket();
                             dpUpdateDeliveryDocketId.setDeliverydocketid(updateDocketId);

                             System.out.print("Enter area: ");
                             String dpUpdateArea = updating.next();

                             System.out.print("Enter user id: ");
                             int updateUserId = updating.nextInt();
                             User dpUpdateUserId = new User();
                             dpUpdateUserId.setUserId(updateUserId);

                             DeliveryPerson editPerson = new DeliveryPerson(dpUpdateId, dpUpdatePhoneNumber, dpUpdateDeliveryDocketId, dpUpdateArea, dpUpdateUserId);
                             boolean updateResult = update.updateDeliveryPerson(editPerson);
                             if(updateResult == true){
                                 System.out.println("Record updated successfully");
                             }else{
                                 System.out.println("Record updated unsuccessfull");
                             }
                             break;
                     case 4:
                             // Delete account logic
                                 ResultSet resultSet3 = dbHelper.getAllDeliveryPersonDetails();
                                 
                                 System.out.println("IDs");

                                 while (resultSet3.next()) {
                                     String idToDisplay = resultSet3.getString("DELIVERYMANID");
                                     System.out.println(" " + idToDisplay);
                                 }

                                 System.out.println("Select 1 id to delete:");
                                 String idDelete = deleting.next();

                                 // Pass the String ID to deleteDeliveryPerson
                                 boolean deleteResult = dbHelper.deleteDeliveryPerson(idDelete);

                                 if (deleteResult) {
                                     System.out.println("Record deleted successfully");
                                 } else {
                                     System.out.println("Record deletion unsuccessful");
                                 }
                     case 5:
                             System.out.print("Ended");
                             break;
                     default:
                         if(choice == 5){
                             System.out.print("Ended");
                         }
                     System.out.println("Invalid choice. Please select a valid option.");
             }
     }while(choice != 5);
     // Close the scanner
     scanner.close();
     
 }
    
}
     
 

	 
