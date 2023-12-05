package User;

import java.util.*;

// ... other imports ...

public class UCommandLine {

    public static void main(String[] args) throws Exception {
        Scanner c = new Scanner(System.in);
        boolean isRun = true;

        while (isRun) {
            try {
                listUserOptions();
                String choice = c.next();
                c.nextLine();

                switch (choice) {
                    case "1":
                        admin.aCommandLine.main(args);
                        break;
                    case "2":
                        newsAgent.NaCommandLine.show();
                        break;
                    case "3":
                        deliveryPerson.DeliveryPersonCommandLine.main(args);
                        break;
                    case "4":
                        isRun = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Input error. Please try again.");
                if (c.hasNextLine()) {
                    c.nextLine(); 
                }
            }
        }

        c.close();
    }

    public static void listUserOptions() {
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as NewsAgent");
        System.out.println("3. Login as DeliveryPerson");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
}
