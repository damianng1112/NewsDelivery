package invoice;

public class InvoiceExceptionHandler extends Exception{
	public String message;
	
	public InvoiceExceptionHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}

	public void message(String message) {
		// TODO Auto-generated method stub
		this.message = message;
	}
}
