package Customer;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for Customer
 */
public class CustomersTest {

    // Test cases for Customer creation with valid input
    // -----------------------------------------------

    // Test #: 1
    // Test Objective: To create a Customer Account
    // Inputs: custName = "Jack Daniels", custAddr = "Athlone", custPhone = "087-123123123"
    // Expected Output: Customer Object created with id = 0, "Jack Daniels", custAddr = "Athlone", custPhone = "087-123123123"
    @Test
    public void testCreateCustomerWithValidInput() {
        try {
            // Call method under test
            Customer custObj = new Customer("Jack Daniels", "Athlone", "087-123123123");

            // Use getters to check for object creation
            assertNotNull(custObj);
            assertEquals(0, custObj.getId());
            assertEquals("Jack Daniels", custObj.getName());
            assertEquals("Athlone", custObj.getAddress());
            assertEquals("087-123123123", custObj.getPhoneNumber());
        } catch (CustomerExceptionHandler e) {
            fail("Exception not expected");
        }
    }

    // Test cases for Customer Name validation
    // ---------------------------------------

    
	    
	 // Test #: 2
	 // Test Objective: To validate a valid customer name
	 // Inputs: custName = "John Doe", custAddr = "Athlone", custPhone = "087-123123123"
	 // Expected Output: No exception should be thrown
	 @Test
	 public void testValidateValidName() {
	     try {
	         // Call method under test
	         Customer.validateName("John Doe");
	     } catch (CustomerExceptionHandler e) {
	         fail("Exception not expected");
	     }
	 }
	
	// Test #: 3
    // Test Objective: To catch an invalid customer name
    // Inputs: custName = "J"
    // Expected Output: Exception Message: "Customer Name does not meet minimum length requirements"
    @Test
    public void testValidateNameWithInvalidInput() {
        try {
            // Call method under test
            Customer.validateName("J");
            fail("Exception expected");
        } catch (CustomerExceptionHandler e) {
            assertEquals("Customer Name does not meet minimum length requirements", e.getMessage());
        }
    }

    // Test #: 4
    // Test Objective: To catch a scenario where the customer name is empty
    // Inputs: custName = "", custAddr = "Athlone", custPhone = "087-123123123"
    // Expected Output: Exception Message: "Customer Name NOT specified"
    @Test
    public void testValidateEmptyName() {
        try {
            // Call method under test
            Customer.validateName("");
            fail("Exception expected");
        } catch (CustomerExceptionHandler e) {
            assertEquals("Customer Name NOT specified", e.getMessage());
        }
    }

    // Test cases for Customer Address validation
    // ------------------------------------------

    // Test #: 5
    // Test Objective: To catch an invalid customer address
    // Inputs: custName = "John Doe", custAddr = "123", custPhone = "087-123123123"
    // Expected Output: Exception Message: "Customer Address does not meet minimum length requirements"
    @Test
    public void testValidateAddressWithInvalidInput() {
        try {
            // Call method under test
            Customer.validateAddress("123");
            fail("Exception expected");
        } catch (CustomerExceptionHandler e) {
            assertEquals("Customer Address does not meet minimum length requirements", e.getMessage());
        }
    }

    // Test #: 6
    // Test Objective: To catch a scenario where the customer address is null
    // Inputs: custName = "John Doe", custAddr = null, custPhone = "087-123123123"
    // Expected Output: Exception Message: "Customer Address NOT specified"
    @Test
    public void testValidateNullAddress() {
        try {
            // Call method under test
            Customer.validateAddress(null);
            fail("Exception expected");
        } catch (CustomerExceptionHandler e) {
            assertEquals("Customer Address NOT specified", e.getMessage());
        }
    }

    // Test cases for Customer Phone Number validation
    // ------------------------------------------------

    // Test #: 7
    // Test Objective: To catch an invalid customer phone number
    // Inputs: custName = "John Doe", custAddr = "Athlone", custPhone = "087-123"
    // Expected Output: Exception Message: "Customer PhoneNumber does not meet minimum length requirements"
    @Test
    public void testValidatePhoneNumberWithInvalidInput() {
        try {
            // Call method under test
            Customer.validatePhoneNumber("087-123");
            fail("Exception expected");
        } catch (CustomerExceptionHandler e) {
            assertEquals("Customer PhoneNumber does not meet minimum length requirements", e.getMessage());
        }
    }

    // Test #: 8
    // Test Objective: To catch a scenario where the customer phone number is empty
    // Inputs: custName = "John Doe", custAddr = "Athlone", custPhone = ""
    // Expected Output: Exception Message: "Customer PhoneNumber NOT specified"
    @Test
    public void testValidateEmptyPhoneNumber() {
        try {
            // Call method under test
            Customer.validatePhoneNumber("");
            fail("Exception expected");
        } catch (CustomerExceptionHandler e) {
            assertEquals("Customer PhoneNumber NOT specified", e.getMessage());
        }
    }

    // Test #: 9
    // Test Objective: To validate a valid customer address
    // Inputs: custName = "John Doe", custAddr = "123 Main Street", custPhone = "087-123123123"
    // Expected Output: No exception should be thrown
    @Test
    public void testValidateValidAddress() {
        try {
            // Call method under test
            Customer.validateAddress("123 Main Street");
        } catch (CustomerExceptionHandler e) {
            fail("Exception not expected");
        }
    }

    // Test #: 10
    // Test Objective: To validate a valid customer phone number
    // Inputs: custName = "John Doe", custAddr = "Athlone", custPhone = "087-1234567"
    // Expected Output: No exception should be thrown
    @Test
    public void testValidateValidPhoneNumber() {
        try {
            // Call method under test
            Customer.validatePhoneNumber("087-1234567");
        } catch (CustomerExceptionHandler e) {
            fail("Exception not expected");
        }
    }
}
