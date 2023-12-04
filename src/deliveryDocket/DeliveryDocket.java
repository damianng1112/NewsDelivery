package deliveryDocket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import deliveryPerson.MySQLAccessDP;

public class DeliveryDocket {
    
	private String publication;
	private String driverName;
	private String deliveryLocation;
	private String quantity;
	
	public DeliveryDocket() {
		
		this.publication = publication;
		this.driverName = driverName;
		this.deliveryLocation = deliveryLocation;
		this.quantity = quantity;
	}
	
	public void DeliveryDocket() {
		try {
			String url = "jdbc:mysql://localhost:3306/newsagentdb";
			Connection con = DriverManager.getConnection(url, "root", "");
			System.out.println("Success");
			Statement stmt = con.createStatement();
		}catch (Exception e) {
			System.out.println("Error: Failed to connect to database\n" + e.getMessage());
		}
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("+====================================+");
		System.out.println("1. To view Delivery Docket press 1");
		System.out.println("2. ");
		System.out.println("+====================================+");
		int num;
		num = sc.nextInt();
		
		if (num == 1) {
			MySQLAccess mySQLAccess = new MySQLAccess(); // Create an instance of MySQLAccess
            mySQLAccess.printDeliveryDocketData();
           
        } else if (num == 2) {
            // Access database to see the delivery docket
       
        } else {
            System.out.println("Please enter a valid number");
        }
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverID) {
		this.driverName = driverName;
	}

	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
