package login;
import java.util.Scanner;

public class LoginActivity {

	public void loginUser(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

//        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
//            System.out.println("Login successful!");
//        } else {
//            System.out.println("Login failed. Please check your username and password.");
//        }
	}

}
