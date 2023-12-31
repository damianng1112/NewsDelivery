package order;


import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
	private String ord_id;
	private String cus_id;
	private String cus_name;
	private String cus_number;
	private String cus_address;
	private String publication;
	private String date;
	
	public Order(String ord_id, String cus_id, String cus_name, String cus_address, String cus_number, String publication, String date) throws OrderExceptionHandler {
		try {
			validateCusName(cus_name);
			validateCusNumber(cus_number);
			validateCusAddress(cus_address);
			validatePublication(publication);
			validateDate(date);
		}catch(OrderExceptionHandler e) {
			throw e;
		}
		this.ord_id=ord_id;
		this.cus_id=cus_id;
		this.cus_name=cus_name;
		this.cus_number=cus_number;
		this.cus_address=cus_address;
		this.publication=publication;
		this.date=date;
	}
	
	public Order(String cus_id, String cus_name, String cus_address, String cus_number, String publication, String date) throws OrderExceptionHandler {
		try {
			validateCusName(cus_name);
			validateCusNumber(cus_number);
			validateCusAddress(cus_address);
			validatePublication(publication);
			validateDate(date);
		}catch(OrderExceptionHandler e) {
			throw e;
		}
		this.cus_id=cus_id;
		this.cus_name=cus_name;
		this.cus_number=cus_number;
		this.cus_address=cus_address;
		this.publication=publication;
		this.date=date;
	}

	public String getOrd_id() {
		return ord_id;
	}

	public void setOrd_id(String ord_id) {
		this.ord_id = ord_id;
	}

	public String getCus_id() {
		return cus_id;
	}

	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getCus_number() {
		return cus_number;
	}

	public void setCus_number(String cus_number) {
		this.cus_number = cus_number;
	}

	public String getCus_address() {
		return cus_address;
	}

	public void setCus_address(String cus_address) {
		this.cus_address = cus_address;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public static boolean containsNumber(String n) {
        Pattern pattern = Pattern.compile(".*\\d.*");
        Matcher matcher = pattern.matcher(n);
        return matcher.matches();
    }
	
	public static boolean isNumber(String input) {
        try {
            new BigInteger(input);
            return true;
        } catch (NumberFormatException e) {
            // The input is not a number
            return false;
        }
    }
	
	public static void validateCusName(String n) throws OrderExceptionHandler {
	    if (n.isBlank() || n.isEmpty()) {
	        throw new OrderExceptionHandler("Customer name NOT specified");
	    } else if (containsNumber(n)) {
	        throw new OrderExceptionHandler("Customer name CANNOT have a number");
	    } else if (n.length() < 2) {
	        throw new OrderExceptionHandler("Customer name does not meet minimum length requirements");
	    } else if (n.length() > 20) {
	        throw new OrderExceptionHandler("Customer name exceeds maximum length requirements");
	    }
	}
	
	public static void validateCusNumber(String num) throws OrderExceptionHandler {
		if (num.isBlank() || num.isEmpty())
			throw new OrderExceptionHandler("Customer number NOT specified");
		else if (isNumber(num)==false)
			throw new OrderExceptionHandler("Customer number CANNOT contain characters");
		else if (num.length() < 7)
			throw new OrderExceptionHandler("Customer number does not meet minimum length requirements");
		else if (num.length() > 15)
			throw new OrderExceptionHandler("Customer number exceeds maximum length");
				
	}
	
	public static void validateCusAddress(String address) throws OrderExceptionHandler {				
		if (address.isBlank() || address.isEmpty())
			throw new OrderExceptionHandler("Customer Address NOT specified");
		else if (address.length() < 2)
			throw new OrderExceptionHandler("Customer Address does not meet minimum length requirements");
		else if (address.length() > 40)
			throw new OrderExceptionHandler("Customer Address exceeds maximum length requirements");
		
	}
	
	public static void validatePublication(String publication) throws OrderExceptionHandler {
		if (publication.isBlank() || publication.isEmpty())
			throw new OrderExceptionHandler("Publication NOT specified");
		else if (publication.length() < 5)
			throw new OrderExceptionHandler("Publication does not meet minimum length requirements");
		else if (publication.length() > 40)
			throw new OrderExceptionHandler("Publication exceeds maximum length requirements");
	}
	
	public static boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);  // Ensure strict validation

        try {
            // Parse the date to check its validity
            Date parsedDate = dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            // If parsing fails, the date is invalid
            return false;
        }
    }
	
	public static void validateDate(String date) throws OrderExceptionHandler {
        if (date.isBlank() || date.isEmpty()) {
            throw new OrderExceptionHandler("Date NOT specified");
        } else if (!isValidDate(date)) {
            throw new OrderExceptionHandler("Invalid date format. Please use yyyy-MM-dd");
        }
    }
}