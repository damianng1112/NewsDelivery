package customer;

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
        // Agree Formatting Rules on "Customer Name"
        // E.G. Name String must be a minimum of 2 characters and a maximum of 20 characters

        if (name.isBlank() || name.isEmpty())
            throw new CustomerExceptionHandler("Customer Name NOT specified");
        else if (name.length() < 2 || name.length() > 20)
            throw new CustomerExceptionHandler("Customer Name does not meet length requirements");
    }

    public static void validateCustomerAddress(String address) throws CustomerExceptionHandler {
        // Agree Formatting Rules on "Customer Address"
        // E.G. Name String must be a minimum of 5 characters and a maximum of 40 characters

        if (address.isBlank() || address.isEmpty())
            throw new CustomerExceptionHandler("Customer Address NOT specified");
        else if (address.length() < 5 || address.length() > 40)
            throw new CustomerExceptionHandler("Customer Address does not meet length requirements");
    }

    public static void validateCustomerPhoneNumber(String phoneNumber) throws CustomerExceptionHandler {
        // Agree Formatting Rules on "Customer PhoneNumber"
        // E.G. PhoneNumber String must be a minimum of 7 characters and a maximum of 15 characters

        if (phoneNumber.isBlank() || phoneNumber.isEmpty())
            throw new CustomerExceptionHandler("Customer PhoneNumber NOT specified");
        else if (phoneNumber.length() < 7 || phoneNumber.length() > 15)
            throw new CustomerExceptionHandler("Customer PhoneNumber does not meet length requirements");
    }

    public String viewCustomer() {
        return name + " " + address + " " + phoneNumber + " " + publication;
    }
}
