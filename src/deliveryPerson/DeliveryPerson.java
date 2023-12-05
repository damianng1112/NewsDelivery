package deliveryPerson;

import java.sql.*;


import java.util.Scanner;

public class DeliveryPerson {
	
	private String driverID;
	private String name; 
	private String address; 
	private String phoneNumber; 
	private String town;
	
	public DeliveryPerson(String name,String address,String phoneNumber, String town) {
		this.driverID = driverID;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.town = town;
	}	
	
	public String getDriverID() {
		return driverID;
	}

	public void setDriverID(String driverID) {
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
