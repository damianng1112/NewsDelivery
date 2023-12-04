package newsAgent;

public class NewsAgentExceptionHandler extends Exception {
	String message;
	
	public NewsAgentExceptionHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}
<<<<<<< HEAD

=======
>>>>>>> main
}

