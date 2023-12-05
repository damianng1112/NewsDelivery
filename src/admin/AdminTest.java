package admin;

 

import customer.Customer;
import customer.CustomerExceptionHandler;
import junit.framework.TestCase;

public class AdminTest extends TestCase {
	

		// Test #: 1
		// Test Objective: To catch a invalid Admin Name
		// Inputs: name = "A"
		// Expected Output: Exception Message: "Admin Name does not meet minimum length requirements"

		public void validateAdminUserName001() throws AdminExceptionHandler {

			try {

				// Call method under test
				Admin.validateAdminUsername("A");
				fail("Exception expected");
			} catch (AdminExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Admin Name does not meet minimum length requirements", e.getMessage());

			}

		}

		// Test #: 2
		// Test Objective: To catch a invalid Admin Name
		// Inputs: name = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
		// Expected Output: Exception Message: "Admin Name exceeds maximum length requirements"

		public void validateAdminUserName002() throws AdminExceptionHandler {

			try {

				 
				Admin.validateAdminUsername("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
				fail("Exception expected");
			} catch (AdminExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Admin Name exceeds maximum length requirements", e.getMessage());

			}

		}

		// Test #: 3
		// Test Objective: To catch a invalid Admin name
		// Inputs: name = ""
		// Expected Output: Exception Message: "Admin Name cannot be left empty"

		public void validateAdminUserName003() {

			try {

				// Call method under test
				Customer.validateCustomerName("");
				fail("Exception expected");
			} catch (CustomerExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Admin Name cannot be left empty", e.getMessage());
			}

		}
		

		// Test #: 4
		// Test Objective: To catch a invalid Admin name
		// Inputs: name = "3"
		// Expected Output: Exception Message: "Admin Name cannot be have a number in it"

		public void validateAdminUserName004() {

			try {

				// Call method under test
				Customer.validateCustomerName("3");
				fail("Exception expected");
			} catch (CustomerExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Admin Name cannot be have a number in it", e.getMessage());
			}

		}



		// Test #: 5
		// Test Objective: To catch a invalid Admin Name
		// Inputs: name = "A"
		// Expected Output: Exception Message: "Admin Name does not meet minimum length requirements"

		public void validateAdminPassword001() throws AdminExceptionHandler {

			try {

				// Call method under test
				Admin.validateAdminPassword("A");
				fail("Exception expected");
			} catch (AdminExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Admin Name does not meet minimum length requirements", e.getMessage());

			}

		}

		// Test #: 6
		// Test Objective: To catch a invalid Admin Name
		// Inputs: name = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
		// Expected Output: Exception Message: "Admin Name exceeds maximum length requirements"

		public void validateAdminPassword002() throws AdminExceptionHandler {

			try {

				 
				Admin.validateAdminPassword("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
				fail("Exception expected");
			} catch (AdminExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Admin Name exceeds maximum length requirements", e.getMessage());

			}

		}

		// Test #: 7
		// Test Objective: To catch a invalid Admin name
		// Inputs: name = ""
		// Expected Output: Exception Message: "Admin Name cannot be left empty"

		public void validateAdminPassword003() throws AdminExceptionHandler {

			try {

				// Call method under test
				Admin.validateAdminPassword("");
				fail("Exception expected");
			} catch (AdminExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Admin Name cannot be left empty", e.getMessage());
			}

		}
 

	 
}
