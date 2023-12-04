package deliveryPerson;

import java.sql.*;


import java.util.Scanner;

public class DeliveryPerson {
	
	private int driverID;
	private String name; 
	private String address; 
	private String phoneNumber; 
	private String town;
	
	public DeliveryPerson() {
		this.driverID = driverID;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.town = town;
	}


	public void DeliveryPerson() {
		
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
		System.out.println("1. To view your all Drivers enter 1");
		System.out.println("2. To set Delivery status enter 2");
		System.out.println("+====================================+");
		int num;
		num = sc.nextInt();
		
		if (num == 1) {
			MySQLAccessDP mySQLAccess = new MySQLAccessDP(); // Create an instance of MySQLAccess
            mySQLAccess.printDeliveryPersonData();
           
        } else if (num == 2) {
            // Access database to see the delivery docket
       
        } else {
            System.out.println("Please enter a valid number");
        }
	}
	
	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
}
