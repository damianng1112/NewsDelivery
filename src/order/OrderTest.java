package order;

import junit.framework.TestCase;

public class OrderTest extends TestCase {

    // Test #: 1
    // Test Objective: To create an order
    // Inputs: ord_id = "1", cus_id = "1", name = "DamianNg", address = "Athlone", contact = "0871234567"
    // publication = "Newspaper", date = "2023-11-30"
    // Expected Output: Order Object created with cus_id = "1", "Damian Ng", Addr
    // = "Athlone", Contact = "0871234567", publication = "Newspaper", date = "2023-11-30"

    public void testOrder001() {
        Order ordObj = null;

        try {
            // Call method under test
            ordObj = new Order("1", "1", "DamianNg", "Athlone", "0871234567", "Newspaper", "2023-11-30");

            // Use getters to check for object creation
            assertEquals("1", ordObj.getOrd_id());
            assertEquals("1", ordObj.getCus_id());
            assertEquals("DamianNg", ordObj.getCus_name());
            assertEquals("Athlone", ordObj.getCus_address());
            assertEquals("0871234567", ordObj.getCus_number());
            assertEquals("Newspaper", ordObj.getPublication());
            assertEquals("2023-11-30", ordObj.getDate());

        } catch (OrderExceptionHandler e) {
            fail("Exception not expected: " + e.getMessage());
        }
    }

    // Test #: 2
    // Test Objective: To catch an invalid order with a short customer name
    // Inputs: ord_id = "2", cus_id = "2", name = "A", address = "Dublin", contact = "0831234567"
    // publication = "Magazine", date = "2023-11-30"
    // Expected Output: Exception Message: "Customer name does not meet minimum length requirements"

    public void testOrder002() {
        try {
            // Call method under test
            new Order("2", "2", "A", "Dublin", "0831234567", "Magazine", "2023-11-30");
            fail("Expected OrderExceptionHandler for a short customer name");
        } catch (OrderExceptionHandler e) {
            assertEquals("Customer name does not meet minimum length requirements", e.getMessage());
        }
    }

    // Test #: 3
    // Test Objective: To catch an invalid order with a long customer name
    // Inputs: ord_id = "3", cus_id = "3", name = "JohnDoeJohnDoeJohnDoeJohnDoeJohnDoe", address = "Galway", contact = "0869876543"
    // publication = "Newspaper", date = "2023-11-30"
    // Expected Output: Exception Message: "Customer name exceeds maximum length requirements"

    public void testOrder003() {
        try {
            // Call method under test
            new Order("3", "3", "JohnDoeJohnDoeJohnDoeJohnDoeJohnDoe", "Galway", "0869876543", "Newspaper", "2023-11-30");
            fail("Expected OrderExceptionHandler for a long customer name");
        } catch (OrderExceptionHandler e) {
            assertEquals("Customer name exceeds maximum length requirements", e.getMessage());
        }
    }

    // Test #: 4
    // Test Objective: To catch an invalid order with a number in the customer name
    // Inputs: ord_id = "4", cus_id = "4", name = "John123", address = "Limerick", contact = "0858765432"
    // publication = "Magazine", date = "2023-11-30"
    // Expected Output: Exception Message: "Customer name CANNOT have a number"

    public void testOrder004() {
        try {
            // Call method under test
            new Order("4", "4", "John123", "Limerick", "0858765432", "Magazine", "2023-11-30");
            fail("Expected OrderExceptionHandler for a customer name with a number");
        } catch (OrderExceptionHandler e) {
            assertEquals("Customer name CANNOT have a number", e.getMessage());
        }
    }

    // Test #: 5
    // Test Objective: To catch an invalid order with a short customer number
    // Inputs: ord_id = "5", cus_id = "5", name = "Alice", address = "Cork", contact = "123"
    // publication = "Newspaper", date = "2023-11-30"
    // Expected Output: Exception Message: "Customer number does not meet minimum length requirements"

    public void testOrder005() {
        try {
            // Call method under test
            new Order("5", "5", "Alice", "Cork", "123", "Newspaper", "2023-11-30");
            fail("Expected OrderExceptionHandler for a short customer number");
        } catch (OrderExceptionHandler e) {
            assertEquals("Customer number does not meet minimum length requirements", e.getMessage());
        }
    }

    // Test #: 6
    // Test Objective: To catch an invalid order with a long customer number
    // Inputs: ord_id = "6", cus_id = "6", name = "Bob", address = "Derry", contact = "1234567890123456"
    // publication = "Magazine", date = "2023-11-30"
    // Expected Output: Exception Message: "Customer number exceeds maximum length"

    public void testOrder006() {
        try {
            // Call method under test
            new Order("6", "6", "Bob", "Derry", "1234567890123456", "Magazine", "2023-11-30");
            fail("Expected OrderExceptionHandler for a long customer number");
        } catch (OrderExceptionHandler e) {
            assertEquals("Customer number exceeds maximum length", e.getMessage());
        }
    }

    // Test #: 7
    // Test Objective: To catch an invalid order with a non-numeric customer number
    // Inputs: ord_id = "7", cus_id = "7", name = "Eve", address = "Belfast", contact = "abc123"
    // publication = "Newspaper", date = "2023-11-30"
    // Expected Output: Exception Message: "Customer number CANNOT contain characters"

    public void testOrder007() {
        try {
            // Call method under test
            new Order("7", "7", "Eve", "Belfast", "abc123", "Newspaper", "2023-11-30");
            fail("Expected OrderExceptionHandler for a customer number with characters");
        } catch (OrderExceptionHandler e) {
            assertEquals("Customer number CANNOT contain characters", e.getMessage());
        }
    }

    // Test #: 8
    // Test Objective: To catch an invalid order with a short customer address
    // Inputs: ord_id = "8", cus_id = "8", name = "Frank", address = "A", contact = "0897654321"
    // publication = "Magazine", date = "2023-11-30"
    // Expected Output: Exception Message: "Customer Address does not meet minimum length requirements"

    public void testOrder008() {
        try {
            // Call method under test
            new Order("8", "8", "Frank", "A", "0897654321", "Magazine", "2023-11-30");
            fail("Expected OrderExceptionHandler for a short customer address");
        } catch (OrderExceptionHandler e) {
            assertEquals("Customer Address does not meet minimum length requirements", e.getMessage());
        }
    }

    // Test #: 9
    // Test Objective: To catch an invalid order with a long customer address
    // Inputs: ord_id = "9", cus_id = "9", name = "Grace", address = "ThisIsAVeryLongAddressThatExceedsMaxLength", contact = "0865432109"
    // publication = "Newspaper", date = "2023-11-30"
    // Expected Output: Exception Message: "Customer Address exceeds maximum length requirements"

    public void testOrder009() {
        try {
            // Call method under test
            new Order("9", "9", "Grace", "ThisIsAVeryLongAddressThatExceedsMaxLength", "0865432109", "Newspaper", "2023-11-30");
            fail("Expected OrderExceptionHandler for a long customer address");
        } catch (OrderExceptionHandler e) {
            assertEquals("Customer Address exceeds maximum length requirements", e.getMessage());
        }
    }

    // Test #: 10
    // Test Objective: To catch an invalid order with a short publication name
    // Inputs: ord_id = "10", cus_id = "10", name = "Harry", address = "Waterford", contact = "0876543210"
    // publication = "Mag", date = "2023-11-30"
    // Expected Output: Exception Message: "Publication does not meet minimum length requirements"

    public void testOrder010() {
        try {
            // Call method under test
            new Order("10", "10", "Harry", "Waterford", "0876543210", "Mag", "2023-11-30");
            fail("Expected OrderExceptionHandler for a short publication name");
        } catch (OrderExceptionHandler e) {
            assertEquals("Publication does not meet minimum length requirements", e.getMessage());
        }
    }

    // Test #: 11
    // Test Objective: To catch an invalid order with a long publication name
    // Inputs: ord_id = "11", cus_id = "11", name = "Ivy", address = "Drogheda", contact = "0834321098"
    // publication = "ThisIsAVeryLongPublicationThatExceedsMaxLength", date = "2023-11-30"
    // Expected Output: Exception Message: "Publication exceeds maximum length requirements"

    public void testOrder011() {
        try {
            // Call method under test
            new Order("11", "11", "Ivy", "Drogheda", "0834321098", "ThisIsAVeryLongPublicationThatExceedsMaxLength", "2023-11-30");
            fail("Expected OrderExceptionHandler for a long publication name");
        } catch (OrderExceptionHandler e) {
            assertEquals("Publication exceeds maximum length requirements", e.getMessage());
        }
    }

    // Test #: 12
    // Test Objective: To catch an invalid order with a missing customer name
    // Inputs: ord_id = "12", cus_id = "12", name = "", address = "Cavan", contact = "0890123456"
    // publication = "Newspaper", date = "2023-11-30"
    // Expected Output: Exception Message: "Customer name NOT specified"

    public void testOrder012() {
        try {
            // Call method under test
            new Order("12", "12", "", "Cavan", "0890123456", "Newspaper", "2023-11-30");
            fail("Expected OrderExceptionHandler for a missing customer name");
        } catch (OrderExceptionHandler e) {
            assertEquals("Customer name NOT specified", e.getMessage());
        }
    }

    // Test #: 13
    // Test Objective: To catch an invalid order with a missing customer number
    // Inputs: ord_id = "13", cus_id = "13", name = "Jack", address = "Sligo", contact = "", publication = "Magazine", date = "2023-11-30"
    // Expected Output: Exception Message: "Customer number NOT specified"

    public void testOrder013() {
        try {
            // Call method under test
            new Order("13", "13", "Jack", "Sligo", "", "Magazine", "2023-11-30");
            fail("Expected OrderExceptionHandler for a missing customer number");
        } catch (OrderExceptionHandler e) {
            assertEquals("Customer number NOT specified", e.getMessage());
        }
    }

    // Test #: 14
    // Test Objective: To catch an invalid order with a missing customer address
    // Inputs: ord_id = "14", cus_id = "14", name = "Katie", address = "", contact = "0861234567", publication = "Newspaper", date = "2023-11-30"
    // Expected Output: Exception Message: "Customer Address NOT specified"

    public void testOrder014() {
        try {
            // Call method under test
            new Order("14", "14", "Katie", "", "0861234567", "Newspaper", "2023-11-30");
            fail("Expected OrderExceptionHandler for a missing customer address");
        } catch (OrderExceptionHandler e) {
            assertEquals("Customer Address NOT specified", e.getMessage());
        }
    }

    // Test #: 15
    // Test Objective: To catch an invalid order with a missing publication name
    // Inputs: ord_id = "15", cus_id = "15", name = "Liam", address = "Ennis", contact = "0859876543", publication = "", date = "2023-11-30"
    // Expected Output: Exception Message: "Publication NOT specified"

    public void testOrder015() {
        try {
            // Call method under test
            new Order("15", "15", "Liam", "Ennis", "0859876543", "", "2023-11-30");
            fail("Expected OrderExceptionHandler for a missing publication name");
        } catch (OrderExceptionHandler e) {
            assertEquals("Publication NOT specified", e.getMessage());
        }
    }
    
    // Test #: 16
    // Test Objective: To catch an invalid order with a missing date
    // Inputs: ord_id = "16", cus_id = "16", cus_name = "Tom", cus_address = "Dublin", cus_number = "0898765432", publication = "Magazine", date = ""
    // Expected Output: Exception Message: "Date NOT specified"

    public void testOrder016() {
        try {
            // Call method under test
            new Order("16", "16", "Tom", "Dublin", "0898765432", "Magazine", "");
            fail("Expected OrderExceptionHandler for a missing date");
        } catch (OrderExceptionHandler e) {
            assertEquals("Date NOT specified", e.getMessage());
        }
    }
    
    // Test #: 17
    // Test Objective: To catch an invalid order with an invalid date format
    // Inputs: ord_id = "17", cus_id = "17", cus_name = "Sam", cus_address = "Galway", cus_number = "0876543210", publication = "Newspaper", date = "2023-30-15"
    // Expected Output: Exception Message: "Invalid date format. Please use yyyy-MM-dd"

    public void testOrder017() {
        try {
            // Call method under test
            new Order("17", "17", "Sam", "Galway", "0876543210", "Newspaper", "2023-30-15");
            fail("Expected OrderExceptionHandler for an invalid date format");
        } catch (OrderExceptionHandler e) {
            assertEquals("Invalid date format. Please use yyyy-MM-dd", e.getMessage());
        }
    }
    
    


}
