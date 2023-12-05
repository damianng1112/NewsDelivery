package invoice;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class InvoiceTest extends TestCase{
	//Test #: 1
	//Test Objective: To create an invoice
	//Inputs: price = "1000" cus_id = 1, pub_id=1
	//Expected Output: Invoice Object created with price = 1000.0, cus_id = 1,pub_id=1
	@Test
	public void testValidInvoice001() {
		try {
			Invoice invoice = new Invoice("1000",1,1);
			assertEquals(1000.0,invoice.getPrice());
			assertEquals(1,invoice.getCus_id());
			assertEquals(1,invoice.getPub_id());
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
	//Test Objective: To test if the customer id is valid
	//Inputs: cus_id = null
	//Expected Output: can not set id to null
		@Test
		public void testValidCus_id001() {
			try {
				Invoice.validCus_id(null);
				fail("Exception Expected");
			}catch(Exception e){
				assertEquals("can not set id to null", e.getMessage());
			}
					
		}
	
	//Test #: 5
	//Test Objective: To test if the publication id is valid
	//Inputs: pub_id = null
	//Expected Output: invalid publication id
		@Test
		public void testValidPub_id001() {
			try {
				Invoice.validPub_id(null);
				fail("Exception Expected");
			}catch(Exception e){
				assertEquals("invalid publication id", e.getMessage());
			}
							
		}

}
