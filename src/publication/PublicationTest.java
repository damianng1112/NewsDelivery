package publication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
class PublicationTest extends TestCase{
	//Test #: 1
		//Test Objective: To create a publication 
		//Inputs: publicationName = "Publication1", price=1000.0, schedule='Monday'
		//Expected Output: Publication Object created with publicationName = "Publication1",price=1000.0,schedule = "Monday"
	@Test
	public void testValidPublication001() {
		try {
			Publication publication = new Publication("Publication1",1000.0,"Monday");
			assertEquals(1000.0,publication.getPrice());
			assertEquals("publication1",publication.getPublicationName());
		}catch(Exception e){
			fail("Exception not expected");
		}
		
	}
	//Test #: 2
			//Test Objective: To test customer name is valid or not valid
			//Inputs: customerName = ""
			//Expected Output:Customer Name does not meet minimum length requirements
	public void testValidCustomerName001() {
		try {
			Publication.validCustomerName("");
			fail("Exception Expected");
		}catch(Exception e) {
			assertEquals("Customer Name does not meet minimum length requirements", e.getMessage());	
		}
	}
	//Test #:3
			//Test Objective: To test price
			//Inputs: price = 0
			//Expected Output:price of this publication can not lower than 0
	public void testValidPrice() {
			try {
				Publication.validPrice(0);
				fail("Exception Expected");
			}catch(Exception e) {
				assertEquals("price of this publication can not lower than 0", e.getMessage());	
			}
		}
	//Test #:4
	//Test Objective: To test schedule
	//Inputs: schedule = ""
	//Expected Output:schedule can not be set to null
	public void testValidSchedule() {
		try {
			Publication.validSchedule("");
			fail("Exception Expected");
		}catch(Exception e) {
			assertEquals("schedule can not be set to null", e.getMessage());	
		}
	}
}