package newsAgent;

import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NewsAgentTest extends TestCase {

		// Test #: 1
		// Test Objective: To create a News Agent Account
		// Inputs: cus_id = "1", name = "DamianNg", address = "Athlone", Contact = "0871234567"
		// Expected Output: News Agent Object created with cus_id = 1, "DamianNg", Addr = "Athlone"
		public void testNewsAgent001() {
			NewsAgent NAObj = null;
			try {

				// Call method under test
				NAObj = new NewsAgent("1", "DamianNg", "Athlone");

				// Use getters to check for object creation
				assertEquals("1", NAObj.getNagent_id());
				assertEquals("DamianNg", NAObj.getNa_name());
				assertEquals("Athlone", NAObj.getNa_address());
			} catch (NewsAgentExceptionHandler e) {
				// TODO Auto-generated catch block
				fail("Exception not expected");
			}

		}
		
		// Test #: 2
		// Test Objective: To catch an invalid News Agent Name
		// Inputs: name = "D"
		// Expected Output: Exception Message: "News Agent Name does not meet
		// minimum length requirements"
		
		public void testValidateNAName001() {
		    try {
		        // Call method under test
		        NewsAgent.validateNAName("D");
		        fail("Exception expected");
		    } catch (NewsAgentExceptionHandler e) {
		        // TODO Auto-generated catch block
		        assertEquals("News Agent name does not meet minimum length requirements", e.getMessage());
		    }
		}
		
		// Test #: 3
		// Test Objective: To catch a invalid News Agent Name
		// Inputs: name = "123Damian"
		// Expected Output: Exception Message: "News Agent name CANNOT have number"

		public void testValidateNAName002() {

			try {

				// Call method under test
				NewsAgent.validateNAName("123Damian");
				fail("Exception expected");
			} catch (NewsAgentExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("News Agent name CANNOT have a number", e.getMessage());

			}
		}
		
		// Test #: 4
		// Test Objective: To catch a invalid News Agent Name
		// Inputs: name = "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"
		// Expected Output: Exception Message: "News Agent Name does not exceeds
		// maximum length requirements"

		public void testValidateNAName003() {
			try {
				// Call method under test
				NewsAgent.validateNAName("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
				fail("Exception expected");
			} catch (NewsAgentExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("News Agent name exceeds maximum length requirements", e.getMessage());
			}
		}
		
		// Test #: 5
		// Test Objective: To catch a invalid News Agent Name
		// Inputs: name = ""
		// Expected Output: Exception Message: "News Agent name NOT specified"

		public void testValidateNAName004() {

			try {

				// Call method under test
				NewsAgent.validateNAName("");
				fail("Exception expected");
			} catch (NewsAgentExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("News Agent name NOT specified", e.getMessage());
			}

		}
		
		// Test #: 6
		// Test Objective: To catch a valid News Agent Name
		// Inputs: name = "Damian Ng"
		// Expected Output: No exception should be thrown

		public void testValidateNAName005() {
		    try {
		        // Call method under test
		        NewsAgent.validateNAName("Damian Ng");
		        // If no exception is thrown, the test passes
		    } catch (NewsAgentExceptionHandler e) {
		        fail("Exception not expected: " + e.getMessage());
		    }
		}
		
		// Test #: 7
	    // Test Objective: To catch an invalid News Agent Address
	    // Inputs: address = ""
	    // Expected Output: Exception Message: "News Agent Address NOT specified"

	    public void testValidateNAAddress001() {
	        try {
	            // Call method under test
	            NewsAgent.validateNAAddress("");
	            fail("Expected NewsAgentExceptionHandler for an empty address");
	        } catch (NewsAgentExceptionHandler e) {
	            assertEquals("News Agent Address NOT specified", e.getMessage());
	        }
	    }

	    // Test #: 8
	    // Test Objective: To catch an invalid News Agent Address
	    // Inputs: address = "A"
	    // Expected Output: Exception Message: "News Agent Address does not meet minimum length requirements"

	    public void testValidateNAAddress002() {
	        try {
	            // Call method under test
	            NewsAgent.validateNAAddress("A");
	            fail("Expected NewsAgentExceptionHandler for a short address");
	        } catch (NewsAgentExceptionHandler e) {
	            assertEquals("News Agent Address does not meet minimum length requirements", e.getMessage());
	        }
	    }

	    // Test #: 9
	    // Test Objective: To catch an invalid News Agent Address
	    // Inputs: address = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
	    // Expected Output: Exception Message: "News Agent Address does not exceed maximum length requirements"

	    public void testValidateNAAddress003() {
	        try {
	            // Call method under test
	            NewsAgent.validateNAAddress("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	            fail("Expected NewsAgentExceptionHandler for a long address");
	        } catch (NewsAgentExceptionHandler e) {
	            assertEquals("News Agent Address exceeds maximum length requirements", e.getMessage());
	        }
	    }

	    // Test #: 10
	    // Test Objective: To catch a valid News Agent Address
	    // Inputs: address = "Valid Address"
	    // Expected Output: No exception should be thrown

	    public void testValidateNAAddress004() {
	        try {
	            // Call method under test
	            NewsAgent.validateNAAddress("Valid Address");
	            // If no exception is thrown, the test passes
	        } catch (NewsAgentExceptionHandler e) {
	            fail("Exception not expected for a valid address");
	        }
	    }

}
