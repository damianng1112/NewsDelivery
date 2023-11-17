package newsAgent;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import customer.Customers;

class NewsAgentTest {

	/*
	 * Test case 1
	 * Method: create a customer
	 * Input: name, address, phoneNumber, publication
	 * Expected Output: True
	 */
	@Test
	void testCreateCustomer() {
		Customers cus1 = new Customers();
		cus1.setName("John");
		cus1.setAddress("Athlone");
		cus1.setPhoneNumber("0871234567");
		cus1.setPublication("Irish Times");
		
		NewsAgent newsAgent = new NewsAgent();
		newsAgent.createCustomer(cus1);
		
		assertEquals(cus1.getName(), newsAgent);
		assertEquals(cus1.getAddress(), newsAgent);
		assertEquals(cus1.getPhoneNumber(), newsAgent);
		assertEquals(cus1.getPublication(), newsAgent);
	}

	@Test
	void testReadCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteCustomer() {
		fail("Not yet implemented");
	}

}
