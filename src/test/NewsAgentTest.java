package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entities.Customers;

class NewsAgentTest {
	Customers cus1 = new Customers();

	@Test
	void testCreateCustomer() {
		cus1.setName("John");
		cus1.setAddress("Athlone");
		cus1.setPhoneNumber("0871234567");
		cus1.setPublication("Irish Times");
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
