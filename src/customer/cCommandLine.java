package customer;

import customer.MySQLAccess;

import java.util.Scanner;
import java.sql.SQLException;

public class cCommandLine {

    private static MySQLAccess dbAccess;
    private static Scanner scanner;

    public static void main(String[] args) throws Exception {
        dbAccess = new MySQLAccess();
        scanner = new Scanner(System.in);
        generateMainMenu();

        try {
            dbAccess.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();  // Handle closing connection errors
        }
    }

    private static void generateMainMenu() throws Exception {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Main Menu:");
            System.out.println("1. Create Customer");
            System.out.println("2. Read All Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    createCustomer();
                    break;
                case 2:
                	readAllCustomers();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void readAllCustomers() {
        try {
            dbAccess.readAllCustomers();
        } catch (SQLException e) {
            System.out.println("Error reading customers: " + e.getMessage());
        }
    }
    private static void createCustomer() {
        System.out.println("Creating a new Customer:");
        
      

        System.out.println("Enter Cusotmer Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Address:");
        String address = scanner.nextLine();
        
        System.out.println("Enter Number:");
        String phoneNumber = scanner.nextLine();
        
        System.out.println("Enter Publication:");
        String publication = scanner.nextLine();

        try {
            dbAccess.createCustomer(name,address,phoneNumber,publication);
            System.out.println("Customer created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating newsagent: " + e.getMessage());
        }
    }


    private static void updateCustomer() throws Exception {
        System.out.println("Updating a Newsagent:");

        System.out.println("Enter Newsagent name:");
        String name = scanner.nextLine();
        
        if (dbAccess.validateName(name)) {

            System.out.println("Enter new Name:");
            String newName = scanner.nextLine();

            System.out.println("Enter new Address:");
            String newAddress = scanner.nextLine();
            
            System.out.println("Enter Number:");
            String phoneNumber = scanner.nextLine();
            
            System.out.println("Enter Publication:");
            String publication = scanner.nextLine();

            try {
                dbAccess.updateCustomer(name,newName, newAddress, phoneNumber, publication);
                System.out.println("Newsagent updated successfully.");
            } catch (SQLException e) {
                System.out.println("Error updating newsagent: " + e.getMessage());
            }
        }else {
        	System.out.println("unknow");
        }

    }


    private static void deleteCustomer() {
        System.out.println("Deleting a Newsagent:");

        System.out.println("Enter Customer Namr to delete:");
        String name = scanner.nextLine();
        scanner.nextLine(); // Consume the newline

        try {
            dbAccess.deleteCustomer(name);
            System.out.println("Newsagent deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting newsagent: " + e.getMessage());
        }
    }


    // Implement other methods as needed...
}
