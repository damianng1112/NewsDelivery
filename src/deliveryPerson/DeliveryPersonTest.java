package deliveryPerson;

import static org.junit.Assert.assertThrows;

import junit.framework.TestCase;

public class DeliveryPersonTest extends TestCase{
		
		// Test #: 1
		// Test Objective: To create a Delivery Driver
		// Inputs: "John Doe", "123 Main St", "123-456-7890", "Anytown"
		// Expected Output: Driver Object created  "John Doe", "123 Main St", "123-456-7890", "Anytown"
		public void testValidDriver() throws Exception {

			DeliveryPerson DPObj = null;
			DPObj = new DeliveryPerson("John Doe", "123 Main St", "123-456-7890", "Anytown");
		 
			assertEquals("John Doe", DPObj.getName());
			assertEquals("123 Main St", DPObj.getAddress());
			assertEquals("123-456-7890", DPObj.getPhoneNumber());
			assertEquals("Anytown", DPObj.getTown());
		}
		
		// Test #: 2
		// Test Objective:	Create a delivery driver with an invalid name 
		// Inputs:	null, "123 Main St", "123-456-7890", "Anytown"
		// Expected Output:	 IllegalArgumentException
		public void testInvalidName() {
	        
			assertThrows(IllegalArgumentException.class, () -> {
	            new DeliveryPerson(null, "123 Main St", "123-456-7890", "Anytown");
	        });
	    }

		// Test #: 3
		// Test Objective:	Create a delivery driver with an invalid address
		// Inputs:	"John Doe", "", "123-456-7890", "Anytown"
		// Expected Output:	IllegalArgumentException
	    public void testInvalidAddress() {

	        assertThrows(IllegalArgumentException.class, () -> {
	            new DeliveryPerson("John Doe", "", "123-456-7890", "Anytown");
	        });
	    }

	    // Test #: 4
	 	// Test Objective:	Create a delivery driver with an invalid contact number 
	 	// Inputs:	"John Doe", "123 Main St", null, "Anytown"
		// Expected Output:	IllegalArgumentException
	    public void testInvalidContactNumber() {

	        DeliveryPerson driver = new DeliveryPerson("John Doe", "123 Main St", "123-456-7890", "Anytown");
	        assertThrows(IllegalArgumentException.class, () -> {
	            driver.setPhoneNumber(null);
	        });
	    }

	    // Test #: 5
	 	// Test Objective:	Create a delivery driver with an invalid town 
	 	// Inputs:	"John Doe", "123 Main St", "123-456-7890", null
		// Expected Output:	IllegalArgumentException
	    public void testInvalidTown() {

	        DeliveryPerson driver = new DeliveryPerson("John Doe", "123 Main St", "123-456-7890", "Anytown");
	        assertThrows(IllegalArgumentException.class, () -> {
	            driver.setTown(null);
	        });
	    }
}
