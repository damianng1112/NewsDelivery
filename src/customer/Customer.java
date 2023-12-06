package customer;

import customer.CustomerExceptionHandler;
 
 
 

public class Customer {
    private String cusId;
    private String name;
    private String address;
    private String phoneNumber;
    private String publication;

    public Customer(String name, String address, String phoneNumber, String publication) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.publication = publication;
    }

    public Customer(String cusId, String name, String address, String phoneNumber, String publication) {
        this.cusId = cusId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.publication = publication;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPublication() {
        return this.publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public static void validateCustomerName(String name) throws CustomerExceptionHandler {
       

        if (name.isBlank() || name.isEmpty())
            throw new CustomerExceptionHandler("Customer Name NOT specified");
        else if (name.length() < 2 || name.length() > 20)
            throw new CustomerExceptionHandler("Customer Name does not meet length requirements");
    }
    

    public static void validateCustomerAddress(String address) throws CustomerExceptionHandler {
        

        if (address.isBlank() || address.isEmpty())
            throw new CustomerExceptionHandler("Customer Address NOT specified");
        else if (address.length() < 5 || address.length() > 40)
            throw new CustomerExceptionHandler("Customer Address does not meet length requirements");
    }

    public static void validateCustomerPhoneNumber(String phoneNumber) throws CustomerExceptionHandler {
         

        if (phoneNumber.isBlank() || phoneNumber.isEmpty())
            throw new CustomerExceptionHandler("Customer PhoneNumber NOT specified");
        else if (phoneNumber.length() < 7 || phoneNumber.length() > 15)
            throw new CustomerExceptionHandler("Customer PhoneNumber does not meet length requirements");
    }
 
 
    
    public static void validatePublication(String publication) throws CustomerExceptionHandler {
      

        if (publication.isBlank() || publication.isEmpty())
            throw new CustomerExceptionHandler("Customer PhoneNumber NOT specified");
        else if (publication.length() < 7 || publication.length() > 15)
            throw new CustomerExceptionHandler("Customer PhoneNumber does not meet length requirements");
    }
 

    public String viewCustomer() {
        return name + " " + address + " " + phoneNumber + " " + publication;
    }
}
