package invoice;
public class Invoice {
    private String price;
    private int cus_id;
    private int pub_id;
<<<<<<< HEAD
    public Invoice(String price, int cus_id,int pub_id) {
=======
    public Invoice(String price, int cus_id,int pub_id) throws InvoiceExceptionHandler {
    	// Validate Input
    			try {
    				
    				validPrice(price);
    				validCus_id(cus_id);
    				validPub_id(pub_id);
    				
    			}
    			catch (InvoiceExceptionHandler e) {
    				throw e;
    			}
>>>>>>> WeiBranch
        this.price = price;
        this.pub_id = pub_id;
        this.cus_id = cus_id;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }
    public void setPub_id(int pub_id) {
    	this.pub_id = pub_id;
    }
    public String getPrice() {
        return this.price;
    }
    public int getCus_id() {
        return this.cus_id;
    }
    public int getPub_id() {
    	return this.pub_id;
    }
<<<<<<< HEAD
    public static void valid30Days(int days) throws InvoiceExceptionHandler{
        int thirtyDays = 30;
        if(days>thirtyDays) {
            throw new InvoiceExceptionHandler("30 days has passed");
        }
    }
    public static void validPrice(double price) throws InvoiceExceptionHandler{
    	if(price <=0) {
    		throw new InvoiceExceptionHandler("price can not be 0 or lower");
    	}
    }
    public static void validCus_id(Integer cus_id) throws InvoiceExceptionHandler{
    	if(cus_id == null) {
    		throw new InvoiceExceptionHandler("can not set customer id to null");
    	}
    }
    public static void validPub_id(Integer pub_id) throws InvoiceExceptionHandler{
    	if(pub_id == null) {
    		throw new InvoiceExceptionHandler("invalid Publication id");
=======
    public static void valid30Days(Integer days) throws InvoiceExceptionHandler{
    	// Verify input "days" is valid or it is lower 0
        // E.G. days cant be negative
        int thirtyDays = 30;
        if(days>thirtyDays) {
            throw new InvoiceExceptionHandler("30 days has passed");
        }else if(days<0) {
        	throw new InvoiceExceptionHandler("invalid days input");
        }
    }
    public static void validPrice(String price) throws InvoiceExceptionHandler{
    	// Verify price is not empty and must higher than negative number
        // E.G. price must be higher than negative and can not be set to null
    	if(price.isBlank()||price.isEmpty()) {
    		throw new InvoiceExceptionHandler("invalid input");
    	}else if(Integer.parseInt(price)<0){
    		throw new InvoiceExceptionHandler("invalid price input");
    	}
    }
    public static void validCus_id(Integer cus_id) throws InvoiceExceptionHandler{
    	// Verify customer id
        // E.G. customer id can not lower than 1
    	if(cus_id == null) {
    		throw new InvoiceExceptionHandler("can not set customer id to null");
    	}else if(cus_id<1) {
    		throw new InvoiceExceptionHandler("invalid customer id");
    	}
    }
    public static void validPub_id(Integer pub_id) throws InvoiceExceptionHandler{
    	// Verify publication id
        // E.G. publication id can not lower than 1
    	if(pub_id == null) {
    		throw new InvoiceExceptionHandler("can not set publication id to null");
    	}else if(pub_id <1) {
    		throw new InvoiceExceptionHandler("invalid publication id");
    	}
    }
    public static void displayTotalPrice(String Tprice) {
    	try {
    		validPrice(Tprice);
    		System.out.println("Total Price is: "+Tprice);
    	}catch(InvoiceExceptionHandler e){
    		e.message("price is not valid");
>>>>>>> WeiBranch
    	}
    }
}