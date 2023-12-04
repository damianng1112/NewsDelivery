package invoice;
public class Invoice {
    private String price;
    private String customername;
    private String publication;
    private String address;
    private String number;
    public Invoice(String price, String  customername, String publication,String address,String number) {
        this.price = price;
        this.customername = customername;
        this.publication = publication;
        this.address = address;
        this.number=number;
    }
    public void setPublication(String publication) {
        this.publication = publication;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setCustomerName(String customername) {
        this.customername = customername;
    }
    public void setAddress(String address) {
    	this.address = address;
    }
    public void setNumber(String number) {
    	this.number = number;
    }
    public String getPrice() {
        return this.price;
    }
    public String getCustomerName() {
        return this.customername;
    }
    public String getPublication() {
        return this.publication;
    }
    public String getAddress() {
    	return this.address;
    }
    public String getNumber() {
    	return this.number;
    }
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
    public static void validCustomerName(String name) throws InvoiceExceptionHandler{
    	if(name.length()<1) {
    		throw new InvoiceExceptionHandler("can not set name to null");
    	}
    }
    public static void validAddress(String address) throws InvoiceExceptionHandler{
    	if(address.equals(null)) {
    		throw new InvoiceExceptionHandler("can not set address to null");
    	}
    }
    public static void validPhoneNumber(String number) throws InvoiceExceptionHandler{
    	if(number.length()<8) {
    		throw new InvoiceExceptionHandler("invalid phone number length");
    	}
    }
}