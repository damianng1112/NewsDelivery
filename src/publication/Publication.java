package publication;
public class Publication {
    private String publicationName;
    private double price;
    private String schedule;

    
    public Publication(String publicationName, double price , String schedule) {
        this.publicationName = publicationName;
        this.price = price;
        this.schedule = schedule;
    }
    
    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setSchedule(String schedule) {
    	this.schedule = schedule;
    }
    public String getPublicationName() {
        return this.publicationName;
    }
    public double getPrice() {
        return this.price;
    }
    public String getSchedule() {
    	return this.schedule;
    }
    public static void validCustomerName(String customerName) throws PublicationExceptionHandler{
        if(customerName.length()<1) {
            throw new PublicationExceptionHandler("customer name can not be null");
        }
    }
    public static void validPrice(double price) throws PublicationExceptionHandler{
       if(price <= 0) {
    	   throw new PublicationExceptionHandler("price of this publication can not lower than 0");
       }
    }
    public static void validSchedule(String schedule) throws PublicationExceptionHandler{
    	if(schedule.length()<1) {
    		throw new PublicationExceptionHandler("schedule can not be null");
    	}
    }
}