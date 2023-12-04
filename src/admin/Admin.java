<<<<<<< HEAD
<<<<<<<< HEAD:src/admin/Admin.java
package admin;

public class Admin {
<<<<<<< HEAD

    public void createStaff(String name, String address, String phoneNumber, String publication) {
		
=======
	
	private String admin_id;
	private String NagentName;
	private String NagentAddress;
	private String NagentNumber;

    public  Admin(String admin_id, String NagentName, String NagentAddress, String NagentNumber) {
		 
>>>>>>> main
	}
	
	public String readStaff() {
		return "";
	}
	
	public void updateStaff(String name, String address, String phoneNumber, String publication) {
		
	}
	
	public void deleteStaff() {
		
	}
    
}
========
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
>>>>>>>> FaithfulBranch:src/entities/Admin.java
=======
package admin;

public class Admin {
	
	private String adminId;
	private String name;
	private String password;
	private String NagentId;
	
	public Admin(String adminId, String name, String password, String nagentId) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.password = password;
		this.NagentId = nagentId;
	}

    
	
	public String getAdminId() {
		return this.adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNagentId() {
		return this.NagentId;
	}

	public void setNagentId(String nagentId) {
		this.NagentId = nagentId;
	}
    
	
	public void validateAdminUsername(String adminUsername) throws AdminExceptionHandler {
		
		if (adminUsername.isEmpty() || adminUsername.isEmpty()) 
			throw new AdminExceptionHandler ("Admin username NOT specified");
		else if (adminUsername.length() < 2)
			throw new AdminExceptionHandler ("Admin username does not meet minimum length requirements");
		else if (adminUsername.length() > 30)
			throw new AdminExceptionHandler ("Admin username exceeds maximum length requirements");
		 
	}
	

	public void validateAdminPassword(String adminPassword) throws AdminExceptionHandler {
		
		if (adminPassword.isEmpty() || adminPassword.isEmpty()) 
			throw new AdminExceptionHandler ("Admin password NOT specified");
		else if (adminPassword.length() < 2)
			throw new AdminExceptionHandler ("Admin password does not meet minimum length requirements");
		else if (adminPassword.length() > 30)
			throw new AdminExceptionHandler ("Admin password exceeds maximum length requirements");
		 	
	}

	 
}
>>>>>>> FaithfulBranch
