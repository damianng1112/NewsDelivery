package invoice;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class InvoiceTest extends TestCase{
	//Test #: 1
	//Test Objective: To create an invoice
	//Inputs: price = "1000" customername = "Man1", publication = "Publication1",address = "Athlone",number="087123456"
	//Expected Output: Invoice Object created with price = 1000.0, customername = "Man1", publication = "Publication1",address = "Athlone",number="087123456"
	@Test
	public void testValidInvoice001() {
		try {
			Invoice invoice = new Invoice("1000","Man1","Publication1","Athlone","087123456");
			assertEquals(1000.0,invoice.getPrice());
			assertEquals(1000.0,invoice.getCustomerName());
			assertEquals(1000.0,invoice.getPublication());
			assertEquals(1000.0,invoice.getAddress());
			assertEquals(1000.0,invoice.getNumber());
		}catch(Exception e){
			fail("Exception not expected");
		}
		
	}
	//Test #: 2
	//Test Objective: To test if 30 days have passed
	//Inputs: days=30
	//Expected Output: Exception Expected
		@Test
		public void testValid30Days001() {
			try {
				Invoice.valid30Days(30);
				fail("Exception Expected");
			}catch(Exception e){
				assertEquals("30 days have passed", e.getMessage());
			}
			
		}
	//Test #: 3
	//Test Objective: To test if the price is valid
	//Inputs: price=0
	//Expected Output: price can not be 0 or lower
		@Test
		public void testValidPrice001() {
			try {
				Invoice.validPrice(0);
				fail("Exception Expected");
			}catch(Exception e){
				assertEquals("price can not be 0 or lower", e.getMessage());
			}
					
		}
	//Test #: 4
	//Test Objective: To test if the customer name is valid
	//Inputs: name = ""
	//Expected Output: can not set name to null
		@Test
		public void testValidCustomerName001() {
			try {
				Invoice.validCustomerName("");
				fail("Exception Expected");
			}catch(Exception e){
				assertEquals("can not set name to null", e.getMessage());
			}
					
		}
	
	//Test #: 5
	//Test Objective: To test if the address is valid
	//Inputs: address = ""
	//Expected Output: can not set address to null
		@Test
		public void testValidAddress001() {
			try {
				Invoice.validCustomerName("");
				fail("Exception Expected");
			}catch(Exception e){
				assertEquals("can not set address to null", e.getMessage());
			}
						
		}
	
	//Test #: 6
	//Test Objective: To test if the phone number is valid
	//Inputs: number = "123456"
	//Expected Output: invalid phone number length
		@Test
		public void testValidPhoneNumber001() {
			try {
				Invoice.validCustomerName("123456");
				fail("Exception Expected");
			}catch(Exception e){
				assertEquals("invalid phone number length", e.getMessage());
			}
							
		}

}
