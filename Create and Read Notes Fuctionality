import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NoteTakingApp {
    private Map<String, String> users; // For simplicity, we're using a Map to store user credentials.
    private List<String> notes;

    public NoteTakingApp() {
        users = new HashMap<>();
        notes = new ArrayList<>();
    }

    public static void main(String[] args) {
        NoteTakingApp app = new NoteTakingApp();
        System.out.println("Hello! Welcome to our Note Taking App!");
        boolean start = true;
        Scanner scanner = new Scanner(System.in);

        while (start) {
            System.out.println("1. Login\n2. Register\n3. Create Note\n4. View Notes\n5. Quit");
            System.out.print("\nPlease choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    app.login(scanner);
                    break;
                case "2":
                    app.register(scanner);
                    break;
                case "3":
                    app.createNote(scanner);
                    break;
                case "4":
                    app.viewNotes();
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    start = false;
                    break;
                default:
                    System.out.println("\nPlease enter a valid command!\n");
            }
        }
    }

    private void login(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Logged in!");
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private void register(Scanner scanner) {
        System.out.print("Enter a new username: ");
        String username = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        users.put(username, password);
        System.out.println("Registered!");
    }

    private void createNote(Scanner scanner) {
        if (users.isEmpty()) {
            System.out.println("You need to log in or register first.");
        } else {
            System.out.print("Enter your note: ");
            String note = scanner.nextLine();
            notes.add(note);
            System.out.println("Note created!");
        }
    }

    private void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("You have no notes yet.");
        } else {
            System.out.println("Your Notes:");
            for (int i = 0; i < notes.size(); i++) {
                System.out.println((i + 1) + ". " + notes.get(i));
            }
        }
    }
}
