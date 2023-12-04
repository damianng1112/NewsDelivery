package publication;

public class PublicationExceptionHandler extends Exception{
	String message;
	
	public PublicationExceptionHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}
}
