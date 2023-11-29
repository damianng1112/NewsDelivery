package newsAgent;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NewsAgentTest {

	// Test #: 1
		// Test Objective: To create a News Agent Account
		// Inputs: cus_id = "1", name = "Damian", address = "Athlone", Contact = "0871234567"
		// Expected Output: News Agent Object created with cus_id = 1, "Damian", Addr
		// = "Athlone", Contact = "0871234567"

		public void testNewsAgent001() {

			// Create the Customer Object

			NewsAgent NAObj = null;

			try {

				// Call method under test
				NAObj = new NewsAgent(1, "Damian", "Athlone", "0871234567");

				// Use getters to check for object creation
				assertEquals(1, NAObj.getCus_id());
				assertEquals("Damian", NAObj.getNa_name());
				assertEquals("Athlone", NAObj.getNa_address());
				assertEquals("0871234567", NAObj.getNa_number());

			} catch (NewsAgentExceptionHandler e) {
				// TODO Auto-generated catch block
				fail("Exception not expected");
			}

		}
		
		// Test #: 2
		// Test Objective: To catch a invalid News Agent Name
		// Inputs: name = "D"
		// Expected Output: Exception Message: "News Agent Name does not meet
		// minimum length requirements"

		public void validateNewsAgent_Name() {

			try {

				// Call method under test
				NewsAgent.validateNAName("D");
				fail("Exception expected");
			} catch (NewsAgentExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("News Agent Name does not meet minimum length requirements", e.getMessage());

			}

		}
		
		// Test #: 3
		// Test Objective: To catch a invalid News Agent Name
		// Inputs: name = "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"
		// Expected Output: Exception Message: "News Agent Name does not exceeds
		// maximum length requirements"

		public void validateNewsAgent_Name002() {

			try {

				// Call method under test
				NewsAgent.validateNAName("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
				fail("Exception expected");
			} catch (NewsAgentExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("News Agent name exceeds max length requirements", e.getMessage());

			}
		}
		
		

}
