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
	
	public DeliveryDocket(String publication,String driverName,String deliveryLocation,String quantity) {
		
		this.publication = publication;
		this.driverName = driverName;
		this.deliveryLocation = deliveryLocation;
		this.quantity = quantity;
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
