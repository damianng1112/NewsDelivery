package deliveryPerson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import deliveryDocket.*;

public class DeliveryPersonCommandLine {

	public static void main(String[] args) throws Exception {

		DeliveryPerson();
		
    }
	
	public static void DeliveryPerson() throws Exception {
			
			try {
				String url = "jdbc:mysql://localhost:3307/newsagentdb";
				Connection con = DriverManager.getConnection(url, "root", "123");
				System.out.println("Success");
				Statement stmt = con.createStatement();
			}catch (Exception e) {
				System.out.println("Error: Failed to connect to database\n" + e.getMessage());
			}
			
			Scanner sc = new Scanner(System.in);
			System.out.println("+====================================+");
			System.out.println("1. To view your all Drivers enter");
			System.out.println("2. To create new driver enter");
			System.out.println("3. To update driver enter");
			System.out.println("4. To delete driver enter");
			System.out.println("5. To CRUD DOCKET");
			System.out.println("+====================================+");
			int num;
			num = sc.nextInt();
			
			if (num == 1) {
				MySQLAccessDP mySQLAccess = new MySQLAccessDP(); 
	            mySQLAccess.printDeliveryPersonData();
	           
	        } else if (num == 2) {
	            System.out.println("Enter Delivery Person Name:");
	            String Name = sc.next();
	
	            System.out.println("Enter Delivery Person Address:");
	            String Delivery_address = sc.next();
	            
	            System.out.println("Enter Delivery Person Contact Number:");
	            String Contact_num = sc.next();
	            
	            System.out.println("Enter Delivery Person Town:");
	            String town = sc.next();
	
	            try {
	            	MySQLAccessDP mySQLAccess = new MySQLAccessDP(); 
	                mySQLAccess.createDeliveryPerson(Name, Delivery_address, Contact_num, town);
	                System.out.println("Delivery Person created successfully!");
	            } catch (SQLException e) {
	                System.out.println("Error occurred while creating Delivery Person: " + e.getMessage());
	            }
	            
	        } else if(num == 3){
	        	System.out.println("Enter Delivery Person's current Name:");
	            String Name = sc.next();
	            sc.nextLine();
	
	            System.out.println("Enter new Name for the Delivery Person:");
	            String newName = sc.nextLine();
	
	            System.out.println("Enter new Address for the Delivery Person:");
	            String Delivery_address = sc.nextLine();
	            
	            System.out.println("Enter new Contact Number for the Delivery Person:");
	            String Contact_num = sc.nextLine();
	                        
	            System.out.println("Enter new Town for the Delivery Person:");
	            String town = sc.nextLine();
	            try {
	            	MySQLAccessDP mySQLAccess = new MySQLAccessDP(); 
	                mySQLAccess.updateDeliveryPerson(Name, newName, Delivery_address, Contact_num, town);
	                System.out.println("Delivery Person details updated successfully!");
	            } catch (SQLException e) {
	                System.out.println("Error occurred while updating Delivery Person: " + e.getMessage());
	            }
	        }else if(num ==4){
	            System.out.println("Enter Delivery Person ID to delete:");
	            int DP_id = sc.nextInt();
	
	            try {
	            	MySQLAccessDP mySQLAccess = new MySQLAccessDP(); 
	                mySQLAccess.deleteDeliveryPerson(DP_id);
	                System.out.println("Delivery Person deleted successfully!");
	                
	            } catch (SQLException e) {
	                System.out.println("Error occurred while deleting Delivery Person: " + e.getMessage());
	            }
	        }else if(num == 5){
	        	deliveryDocket.DeliveryDocketCommandLine.DeliveryDocket();
	        	
	
	        }else {
	        	System.out.println("Please enter a valid number");
	        }
	            
	        
		}
		
}
