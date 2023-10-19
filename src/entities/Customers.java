package entities;

public class Customers {
	private String name;
	private String address;
	private String phoneNumber;
	private String publication;
	private boolean holStatus;
	private boolean paidStatus;
	
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
	public boolean isPaidStatus() {
		return paidStatus;
	}
	public void setPaidStatus(boolean paidStatus) {
		this.paidStatus = paidStatus;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public boolean isHolStatus() {
		return holStatus;
	}
	public void setHolStatus(boolean holStatus) {
		this.holStatus = holStatus;
	}
}
