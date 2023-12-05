package invoice;
public class Invoice {
    private String price;
    private int cus_id;
    private int pub_id;
    public Invoice(String price, int cus_id,int pub_id) {
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
    	}
    }
}