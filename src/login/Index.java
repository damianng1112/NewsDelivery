package userInterface;

import java.util.Scanner;

public class Index {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		LoginActivity la = new LoginActivity();
		RegisterActivity ra = new RegisterActivity();
		
		while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    ra.registerUser(sc);
                    break;
                case 2:
                    la.loginUser(sc);
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
		}
		
	}
}
