package login;

import java.util.Scanner;

public class RegisterActivity {

<<<<<<< HEAD
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
=======
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String username, password;
		username = sc.next();
		password = sc.next();
	}
>>>>>>> FaithfulBranch
	
}
