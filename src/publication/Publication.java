package publication;
public class Publication {
    private String publicationName;
    private double price;

    
    public Publication(String publicationName, double price) {
        this.publicationName = publicationName;
        this.price = price;
    }
    
    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getPublicationName() {
        return this.publicationName;
    }
    public double getPrice() {
        return this.price;
    }
    public static void validCustomerName(String customerName) throws PublicationExceptionHandler{
        if(customerName.length()>0) {
            throw new PublicationExceptionHandler("customer name can not be null");
        }
    }
    public static void validPrice(double price) throws PublicationExceptionHandler{
       if(price <= 0) {
    	   throw new PublicationExceptionHandler("price of this publication can not lower than 0");
       }
    }
}