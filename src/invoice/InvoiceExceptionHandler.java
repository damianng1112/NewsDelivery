package invoice;

public class InvoiceExceptionHandler extends Exception{
<<<<<<< HEAD
	String message;
=======
	public String message;
>>>>>>> WeiBranch
	
	public InvoiceExceptionHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}
<<<<<<< HEAD
=======

	public void message(String message) {
		// TODO Auto-generated method stub
		this.message = message;
	}
>>>>>>> WeiBranch
}
