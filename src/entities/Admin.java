package entities;

public class Admin {

    public String createStaff(String name, String address, String phoneNumber) {
    	
    	return "Staff has been created";
		
	}
	
    //change back to string and return info
	public void readStaff() {
		
//		return "Name: "+name+" Address: "+address+" Number: "+phoneNumber;
	}
	
	public String updateStaff(String name, String address, String phoneNumber, String publication) {
		
		return "Information sucessfully changed";
		
	}
	
	public String deleteStaff() {
		
		return "Staff succesfully deleted";
		
	}
    
}
