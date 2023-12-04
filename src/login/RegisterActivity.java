package login;

import java.util.Scanner;

public class RegisterActivity {

	public void registerUser(Scanner scanner) {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

//        if (userDatabase.containsKey(username)) {
//            System.out.println("Username already exists. Please choose a different one.");
//        } else {
//            userDatabase.put(username, password);
//            System.out.println("Registration successful!");
//        }
    }
	
}
