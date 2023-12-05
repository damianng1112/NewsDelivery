package deliveryDocket;

import static org.junit.Assert.assertThrows;
import junit.framework.TestCase;

public class DeliveryDocketTest extends TestCase{
	// Test #: 1
			// Test Objective: To create a Delivery Docket
			// Inputs: "Magazine", "Kilbeggan", "Frank", "5"
			// Expected Output: Driver Object created  "Magazine", "Kilbeggan", "Frank", "5"
			public void testValidDocket() throws Exception {

				DeliveryDocket DDObj = null;
				DDObj = new DeliveryDocket("Magazine", "Kilbeggan", "Frank", "5");
			 
				assertEquals("Magazine", DDObj.getPublication());
				assertEquals("Kilbeggan", DDObj.getDeliveryLocation());
				assertEquals("Frank", DDObj.getDriverName());
				assertEquals("5", DDObj.getQuantity());
			}
			
			// Test #: 2
			// Test Objective:	Create a delivery docket with an invalid publication
			// Inputs:	null, "Kilbeggan", "Frank", "5"
			// Expected Output:	 IllegalArgumentException
			public void testInvalidPublication() {
		        
				assertThrows(IllegalArgumentException.class, () -> {
		            new DeliveryDocket(null, "Kilbeggan", "Frank", "5");
		        });
		    }

			// Test #: 3
			// Test Objective:	Create a delivery docket with an driverLocation
			// Inputs:	"Magazine", "", "Frank", "5"
			// Expected Output:	IllegalArgumentException
		    public void testInvalidLocation() {

		        assertThrows(IllegalArgumentException.class, () -> {
		            new DeliveryDocket("Magazine", "", "Frank", "5");
		        });
		    }

		    // Test #: 4
		 	// Test Objective:	Create a delivery docket with an invalid name 
		 	// Inputs:	"Magazine", "Kilbeggan", null, "5"
			// Expected Output:	IllegalArgumentException
		    public void testInvalidName() {

		        DeliveryDocket docket = new DeliveryDocket("Magazine", "Kilbeggan", "Frank", "5");
		        assertThrows(IllegalArgumentException.class, () -> {
		            docket.setDriverName(null);
		        });
		    }

		    // Test #: 5
		 	// Test Objective:	Create a delivery docket with an invalid quantity
		 	// Inputs:	"Magazine", "Kilbeggan", "Frank", null
			// Expected Output:	IllegalArgumentException
		    public void testInvalidQuantity() {

		        DeliveryDocket docket = new DeliveryDocket("Magazine", "Kilbeggan", "Frank", "5");
		        assertThrows(IllegalArgumentException.class, () -> {
		            
					docket.setQuantity(null);
		        });
		    }

}
