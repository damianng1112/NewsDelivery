package newsAgent;

import java.util.regex.*;

public class NewsAgent {
	private int Nagent_id;
	private int cus_id;
	private String na_name;
	private String na_number;
	private String na_address;
	
	public NewsAgent(int cus_id, String na_name, String na_address, String na_number) throws NewsAgentExceptionHandler{
		try {
			validateNAName(na_name);
			validateNANumber(na_number);
			validateNAAddress(na_address);
		}catch(NewsAgentExceptionHandler e){
			throw e;
		}
		this.cus_id=cus_id;
		this.na_name=na_name;
		this.na_number=na_number;
		this.na_address=na_address;
	}

	public int getNagent_id() {
		return Nagent_id;
	}

	public void setNagent_id(int nagent_id) {
		Nagent_id = nagent_id;
	}

	public int getCus_id() {
		return cus_id;
	}

	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}

	public String getNa_name() {
		return na_name;
	}

	public void setNa_name(String na_name) {
		this.na_name = na_name;
	}

	public String getNa_number() {
		return na_number;
	}

	public void setNa_number(String na_number) {
		this.na_number = na_number;
	}

	public String getNa_address() {
		return na_address;
	}

	public void setNa_address(String na_address) {
		this.na_address = na_address;
	}
	
	public static boolean containsNumber(String n) {
        Pattern pattern = Pattern.compile(".*\\d.*");
        Matcher matcher = pattern.matcher(n);
        return matcher.matches();
    }
	
	public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            // The input is not a number
            return false;
        }
    }
	
	public static void validateNAName(String n) throws NewsAgentExceptionHandler {
		if (n.isBlank() || n.isEmpty())
			throw new NewsAgentExceptionHandler("News Agent name NOT specified");
		else if (containsNumber(n))
			throw new NewsAgentExceptionHandler("News Agent name CANNOT have number");
		else if (n.length()<8){
			throw new NewsAgentExceptionHandler("News Agent name does not meet minimum length requirements");
		}
		else if (n.length()>20){
			throw new NewsAgentExceptionHandler("News Agent name exceeds max length requirements");
		}
	}

	public static void validateNANumber(String num) throws NewsAgentExceptionHandler {
		if (num.isBlank() || num.isEmpty())
			throw new NewsAgentExceptionHandler("News Agent number NOT specified");
		else if (!isNumber(num))
			throw new NewsAgentExceptionHandler("News Agent number CANNOT contain characters");
		else if (num.length() < 7)
			throw new NewsAgentExceptionHandler("News Agent ContactNumber does not meet minimum length requirements");
		else if (num.length() > 15)
			throw new NewsAgentExceptionHandler("News Agent ContactNumber exceeds maximum length");
				
	}
	
	public static void validateNAAddress(String address) throws NewsAgentExceptionHandler {				
		if (address.isBlank() || address.isEmpty())
			throw new NewsAgentExceptionHandler("News Agent Address NOT specified");
		else if (address.length() < 2)
			throw new NewsAgentExceptionHandler("News Agent Address does not meet minimum length requirements");
		else if (address.length() > 40)
			throw new NewsAgentExceptionHandler("News Agent Address does not exceeds maximum length requirements");
		
	}

}
