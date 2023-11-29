package Customer;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {
	// Test #: 1
	// Test Objective: To create a Customer Account
	// Inputs: name = "Faithful", address = "Athlone", Contact = "0870934352"
	// Expected Output: Customer Object created with id = 0, "Faithful", custAddr = "Athlone", custContact = "087-0870934352" 
	public void testCustomer001() throws CustomerExceptionHandler {

		// Create the Customer Object

		Customer CusObj = null;

		// Call method under test
		CusObj = new Customer("Faithful", "Athlone", "0870934352", "magazin");

	 
		assertEquals("Faithful", CusObj.getName());
		assertEquals("Athlone", CusObj.getAddress());
		assertEquals("0870934352", CusObj.getPhoneNumber());
		assertEquals("magazin", CusObj.getPublication());

	}

	// Test #: 2
	// Test Objective: To catch a invalid Customer Name
	// Inputs: name = "H"
	// Expected Output: Exception Message: "Customer Name does not meet
	// minimum length requirements"

	public void validateCustomerName() {

		try {

			// Call method under test
			Customer.validateCustomerName("H");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer Name does not meet minimum length requirements", e.getMessage());

		}

	}

	// Test #: 3
	// Test Objective: To catch a invalid Customer Name
	// Inputs: name = "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
	// Expected Output: Exception Message: "Customer Name does not exceeds
	// maximum length requirements"

	public void validateCustomerName002() {

		try {

			// Call method under test
			Customer.validateCustomerName("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer Name does not exceeds maximum length requirements", e.getMessage());

		}

	}

	// Test #: 4
	// Test Objective: To catch a invalid Customer Name
	// Inputs: name = ""
	// Expected Output: Exception Message: "Customer Name does not exceeds
	// maximum length requirements"

	public void validateCustomerName003() {

		try {

			// Call method under test
			Customer.validateCustomerName("");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer Name NOT specified", e.getMessage());
		}

	}


	// Test #: 5
	// Test Objective: To catch a invalid Customer Address
	// Inputs: address = ""
	// Expected Output: Exception Message: "Customer Name does not exceeds
	// maximum length requirements"

	public void testValidateAddress001() {

		try {

			// Call method under test
			Customer.validateCustomerAddress("");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer Address NOT specified", e.getMessage());
		}

	}

	// Test #: 6
	// Test Objective: To catch a invalid Customer Address
	// Inputs: address = "Athl"
	// Expected Output: Exception Message: "Customer Name does not exceeds
	// maximum length requirements"

	public void testValidateAddress002() {

		try {

			// Call method under test
			Customer.validateCustomerAddress("A");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer Address does not meet minimum length requirements", e.getMessage());
		}

	}

	// Test #: 7
	// Test Objective: To catch a invalid Customer Address
	// Inputs: address =
	// "Athloneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
	// Expected Output: Exception Message: "Customer Name does not exceeds
	// maximum length requirements"

	public void testValidateAddress003() {

		try {

			// Call method under test
			Customer.validateCustomerAddress("Athloneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer Address does not exceeds maximum length requirements", e.getMessage());
		}

	}

	// Test #: 8
	// Test Objective: To catch a invalid Customer ContactNumber
	// Inputs: Contact = ""
	// Expected Output: Exception Message: "Customer Name does not exceeds
	// maximum length requirements"

	public void testvalidateCustomer_Contact001() {

		try {

			// Call method under test
			Customer.validateCustomerPhoneNumber("");
			;
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer ContactNumber NOT specified", e.getMessage());
		}

	}

	// Test #: 9
	// Test Objective: To catch a invalid Customer ContactNumber
	// Inputs: Contact = "123456"
	// Expected Output: Exception Message: "Customer ContactNumber does not
	// meet minimum length requirements"

	public void testvalidateCustomer_Contact002() {

		try {

			// Call method under test
			Customer.validateCustomerPhoneNumber("123456");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer ContactNumber does not meet minimum length requirements", e.getMessage());
		}

	}

	// Test #: 10
	// Test Objective: To catch a invalid Customer ContactNumber
	// Inputs: Contact = "123456789123456"
	// Expected Output: Exception Message: "Customer ContactNumber does not
	// exceeds maximum length requirement"

	public void testvalidateCustomerPhoneNumber003() {

		try {

			// Call method under test
			Customer.validateCustomerPhoneNumber("1234567891234567");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer ContactNumber does not exceeds maximum length requirements", e.getMessage());
		}

	}

	// Test #: 11
	// Test Objective: Success to view the Customer details
	// Inputs: name = "Hong", address = "Athlone", Contact = "087-123123123", area=
	// "Garry"
	// Expected Output: The content of view method is similar to the "Hong Athlone
	// 087-123123123 Garry 10 Work"

	public void testViewCustomer001() throws CustomerExceptionHandler {

		Customer CusObj = new Customer("Hong", "Athlone", "087-123123123", "Garry");
		String a = CusObj.viewCustomer();
		System.out.print(a);
		assertEquals("Hong Athlone 087-123123123 Garry", a);

	}
}
