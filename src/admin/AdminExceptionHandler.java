package admin;

public class AdminExceptionHandler extends Exception {
	String message;
	
	public AdminExceptionHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}

}
