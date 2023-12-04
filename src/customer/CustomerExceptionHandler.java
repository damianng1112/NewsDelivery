<<<<<<< HEAD
package customer;
=======
package Customer;
>>>>>>> FaithfulBranch

public class CustomerExceptionHandler extends Exception {
	String message;
	
	public CustomerExceptionHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}
}