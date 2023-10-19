import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private final Map<String, String> users;

    public Main() {
        this.users = new HashMap<>();
    }

    public void addUser(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, password);
            System.out.println("User added successfully.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    public void removeUser(String username) {
        if (users.containsKey(username)) {
            users.remove(username);
            System.out.println("User removed successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    public void displayAllUsers() {
        System.out.println("List of Users:");
        for (String username : users.keySet()) {
            System.out.println("Username: " + username);
        }
    }

    public void authenticateUser(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed.");
        }
    }

    public static void main(String[] args) {
        Main ums = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add User");
            System.out.println("2. Remove User");
            System.out.println("3. Display All Users");
            System.out.println("4. Authenticate User");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    ums.addUser(username, password);
                }
                case 2 -> {
                    System.out.print("Enter username to remove: ");
                    String userToRemove = scanner.nextLine();
                    ums.removeUser(userToRemove);
                }
                case 3 -> ums.displayAllUsers();
                case 4 -> {
                    System.out.print("Enter username: ");
                    String authUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String authPassword = scanner.nextLine();
                    ums.authenticateUser(authUsername, authPassword);
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
