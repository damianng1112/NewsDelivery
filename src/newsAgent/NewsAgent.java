package newsAgent;

import java.util.regex.*;

public class NewsAgent {
	private String Nagent_id;
	private String user_id;
	private String cus_id;
	private String na_name;
	private String na_address;
	
	
	public NewsAgent(String Nagent_id, String na_name, String na_address) throws NewsAgentExceptionHandler{
		try {
			validateNAName(na_name);
			validateNAAddress(na_address);
		}catch(NewsAgentExceptionHandler e){
			throw e;
		}
		this.Nagent_id=Nagent_id;
		this.na_name=na_name;
		this.na_address=na_address;
	}

	public String getNagent_id() {
		return Nagent_id;
	}

	public void setNagent_id(String nagent_id) {
		Nagent_id = nagent_id;
	}

	public String getCus_id() {
		return cus_id;
	}

	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}

	public String getNa_name() {
		return na_name;
	}

	public void setNa_name(String na_name) {
		this.na_name = na_name;
	}

	public String getNa_address() {
		return na_address;
	}

	public void setNa_address(String na_address) {
		this.na_address = na_address;
	}
	
	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public static boolean containsNumber(String n) {
        Pattern pattern = Pattern.compile(".*\\d.*");
        Matcher matcher = pattern.matcher(n);
        return matcher.matches();
    }
	
	public static void validateNAName(String n) throws NewsAgentExceptionHandler {
	    if (n.isBlank() || n.isEmpty()) {
	        throw new NewsAgentExceptionHandler("News Agent name NOT specified");
	    } else if (containsNumber(n)) {
	        throw new NewsAgentExceptionHandler("News Agent name CANNOT have a number");
	    } else if (n.length() < 8) {
	        throw new NewsAgentExceptionHandler("News Agent name does not meet minimum length requirements");
	    } else if (n.length() > 20) {
	        throw new NewsAgentExceptionHandler("News Agent name exceeds maximum length requirements");
	    }
	}
	
	public static void validateNAAddress(String address) throws NewsAgentExceptionHandler {				
		if (address.isBlank() || address.isEmpty())
			throw new NewsAgentExceptionHandler("News Agent Address NOT specified");
		else if (address.length() < 2)
			throw new NewsAgentExceptionHandler("News Agent Address does not meet minimum length requirements");
		else if (address.length() > 40)
			throw new NewsAgentExceptionHandler("News Agent Address exceeds maximum length requirements");		
	}
	
}