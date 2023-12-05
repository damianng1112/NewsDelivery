package deliveryDocket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import deliveryPerson.MySQLAccessDP;

public class DeliveryDocketCommandLine {

	public static void main(String[] args) throws Exception {
			
		DeliveryDocket();
	
	}
	
	public static void DeliveryDocket() throws Exception {
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
		System.out.println("1. To view Delivery Docket press 1");
		System.out.println("2. To create new Docket press 2");
		System.out.println("3. To update Docket press 3");
		System.out.println("4. To delete Docket press 4");
		System.out.println("+====================================+");
		int num;
		num = sc.nextInt();
		
		if (num == 1) {
			MySQLAccess mySQLAccess = new MySQLAccess();
            mySQLAccess.printDeliveryDocketData();
           
        }  else if (num == 2) { 

            System.out.println("Enter Customer id:");
            int cus_id = sc.nextInt();
            sc.nextLine(); 
            
            System.out.println("Enter Publication:");
            String publication = sc.nextLine();
            
            System.out.println("Enter Driver name:");
            String Dname = sc.nextLine();
            
            System.out.println("Enter Address:");
            String town = sc.nextLine();

            try {
            	MySQLAccess mySQLAccess = new MySQLAccess(); 
                mySQLAccess.createDeliveryDocket(cus_id, publication, Dname, town);
                System.out.println("Delivery Docket created successfully!");
            } catch (SQLException e) {
                System.out.println("Error occurred while creating Delivery Docket: " + e.getMessage());
            }
            
        } else if(num == 3){
        	System.out.println("Enter Customer's current id:");
            int cus_id = sc.nextInt();
            sc.nextLine();
            
            System.out.println("Enter new publication:");
            String newPublication = sc.nextLine();
            
            System.out.println("Enter new Driver name:");
            String newDname = sc.nextLine();
                        
            System.out.println("Enter new Address:");
            String newtown = sc.nextLine();
            try {
            	MySQLAccess mySQLAccess = new MySQLAccess(); 
                mySQLAccess.updateDeliveryDocket(cus_id,newPublication, newDname, newtown);
                System.out.println("Delivery Docket details updated successfully!");
               
            } catch (SQLException e) {
                System.out.println("Error occurred while updating Delivery Person: " + e.getMessage());
            }
        }else if(num ==4){
            System.out.println("Enter Customer id to delete:");
            int dDoc_id = sc.nextInt();

            try {
            	MySQLAccess mySQLAccess = new MySQLAccess(); 
                mySQLAccess.deleteDeliveryDocket(dDoc_id);
                System.out.println("Delivery Docket deleted successfully!");
            } catch (SQLException e) {
                System.out.println("Error occurred while deleting Delivery Docket: " + e.getMessage());
            }

        }else {
        	System.out.println("Please enter a valid number");
        }
	}
}
