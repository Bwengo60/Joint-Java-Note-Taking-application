import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Collections;
import java.util.List;


public class NoteTakingApp {
    static ArrayList<Note> notes = new ArrayList<>();
    static List<User> users = Collections.synchronizedList(new ArrayList<>());
    //static ArrayList<User> admins = new ArrayList<>();
    static String loggedInUser;
    

    public static void main(String[] args) {
        System.out.println("Hello Welcome to our Note Taking App!");
        boolean start = true;
        Scanner scanner = new Scanner(System.in);
        User admin = new User("admin", "admin@admin","1234", true);
        users.add(admin); //Adding admin for chalimo

        while (start) {
            System.out.println("1. Login\n2. Register\n3. To Quit\n\nPlease Login Or Register To Proceed: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    login(scanner);
                    break;
                case "2":
                    registerUser(scanner);
                    break;
                case "3":
                    System.out.println("Bye!");
                    start = false;
                    break;
                default:
                    System.out.println("\nPlease Enter a valid command!\n");
            }
        }
    }
//======================================Login========================================
    static boolean login(Scanner scanner) {
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            System.out.println("Enter your username: ");
            String username = scanner.nextLine();
            if (isUserExists(username)) {
                for (User user : users) {
                    if (user.username.equals(username)) {
                        System.out.println("Enter your password: ");
                        String password = scanner.nextLine();
                        if (user.password.equals(password)) {
                            if (user.isAdmin) {
                                System.out.println("Welcome, Admin!");
                                adminPanel();
                            } else {
                                loggedInUser = username;
                                System.out.println("Welcome, User!");
                                home(scanner);
                            }
                            System.out.println("Do you want to try again? (y/n)");
                            String answer = scanner.nextLine();
                            if (answer.equals("n")) {
                                isLoggedIn = true;
                            }
                        } else {
                            System.out.println("Incorrect password. Please try again.");
                            return false;
                        }
                    }
                }
            } else {
                System.out.println("User does not exist. Please try again or register.");
                return false;
            }
        }
        return !isLoggedIn;
    }
//===============================Registration=============================================

   static class User {
        String username;
        String email;
        String password;
        boolean isAdmin;

        public User(String username, String email, String password, boolean isAdmin) {
            this.username = username;
            this.email = email;
            this.password = password;
            this.isAdmin = isAdmin;
        }
    }
   
   static class Note{ 
        String title;
        String body;
        String date;
        String madeBy;

        public Note(String title, String body, String date, String madeBy){
            this.title = title;
            this.body = body;
            this.date = date;
            this.madeBy = madeBy;
        }
   }
 
    private static void registerUser(Scanner scanner) {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        System.out.print("Enter an email address: ");
        String email = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        if (isUserExists(username)) {
            System.out.println("Registration failed. Username already exists.");
        
        } else {
            User newUser = new User(username, email, password, false);
            users.add(newUser);
            System.out.println("Registration successful!");
        }
    }


    private static boolean isUserExists(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return true;
            }
        }
        return false;
    }

    static void home(Scanner scanner) {
        boolean homeLoop = true;
        while (homeLoop) {
            System.out.println("Welcome to the Home page "+loggedInUser+"\n\n1. Create New Notes\n2. Read Notes\n3. Update Notes\n4. Delete Notes\n5. Logout");
            String homeChoice = scanner.nextLine();
            switch (homeChoice) {
                case "1":
                    createNotes(scanner);
                    break;
                case "2":
                    readNotes();
                    break;
                case "3":
                    updateNotes(scanner);
                    break;
                case "4":
                    deleteNotes(scanner);
                    break;
                case "5":
                    System.out.println("You logged out!");
                    loggedInUser="";
                    homeLoop = false;
                    break;
                
            }
        }
    }
//===========================Creating Notes ====================================
   static void createNotes(Scanner scanner) {
        System.out.println("Enter your note title:");
        String title = scanner.nextLine();

        System.out.println("Enter your note body:");
        String body = scanner.nextLine();
        
        LocalDate currentDate = LocalDate.now();
        String date = currentDate.toString();

        Note note = new Note(title, body, date, loggedInUser);
        
        notes.add(note);
        System.out.println("Note Created!");

        
    }

    static void readNotes() {
  if (notes.isEmpty()) {
    System.out.println("You have no notes.");
  } else {
    System.out.println("Your Notes:");
    for (int i = 0; i < notes.size(); i++) {
      if (notes.get(i).madeBy.equals(loggedInUser)) {
        System.out.println((i + 1) + ". Title: " + notes.get(i).title + " | Body: " + notes.get(i).body + " | Date: " + notes.get(i).date);
      }
    }
  }
}

//=====================================Updating the notes======================================================
    static void updateNotes(Scanner scanner) {
    System.out.println("Your Notes:");
    for (int i = 0; i < notes.size(); i++) {
        System.out.println((i + 1) + ". Title: " + notes.get(i).title + " | Body: " + notes.get(i).body + " | Date: " + notes.get(i).date);
    }

    System.out.println("Enter the index of the note you want to update: ");
    int index = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character

    if (index >= 1 && index <= notes.size()) {
        System.out.println("Enter the updated note title: ");
        String updatedTitle = scanner.nextLine();

        System.out.println("Enter the updated note body: ");
        String updatedBody = scanner.nextLine();

        LocalDate currentDate = LocalDate.now();
        String date = currentDate.toString();
        for(User user:users){
            notes.set(index - 1, new Note(updatedTitle, updatedBody,date, user.username));
            System.out.println("Note updated successfully!");
        }
    } else {
        System.out.println("Invalid index!");
    }
}

//==================================Deleting the Notes========================================
    static void deleteNotes(Scanner scanner) {
        System.out.println("Enter the index of the note you want to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        if (index >= 1 && index <= notes.size()) {
            notes.remove(index - 1);
            System.out.println("Note deleted successfully!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    static void adminPanel() {
        boolean adminLoop = true;
        Scanner scanner = new Scanner(System.in);

        while (adminLoop) {
            System.out.println("Admin Panel\n\n1. View Users\n2. Promote User to Admin\n3. Demote Admin to User\n4. Add User\n 5. Remove User\n6. Exit Admin Panel");
            String adminChoice = scanner.nextLine();

            switch (adminChoice) {
                case "1":
                    viewUsers();
                    break;
                case "2":
                    promoteUserToAdmin();
                    break;
                case "3":
                    demoteAdminToUser();
                    break;
                case "4":
                    addUser();
                    break;
                case "5":
                    removeUser();
                case "6":
                    adminLoop = false;
                    break;
                default:
                    System.out.println("Please enter a valid command.");
            }
        }
    }

    static void viewUsers() {
        System.out.println("User List:");
        for (User user : users) {
            System.out.println("Username: " + user.username + " | Email: " + user.email);
        }
    }

    static void promoteUserToAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the username of the user to promote to admin: ");
        String username = scanner.nextLine();

        for (User user : users) {
            if (user.username.equals(username)) {
                user.isAdmin = true;
                System.out.println("User " + username + " has been promoted to admin.");
                return;
            }
        }
        System.out.println("User not found.");
    }

    static void demoteAdminToUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the username of the admin to demote to user: ");
        String username = scanner.nextLine();

        for (User user : users) {
            if (user.username.equals(username)) {
                System.out.println("Admin " + username + " has been demoted to a user.");
                return;
            }
        }
        System.out.println("Admin not found.");
    }

    static void addUser() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter username:");
    String username = scanner.nextLine();
    System.out.println("Enter email:");
    String email = scanner.nextLine();
    System.out.println("Is user Admin? y/n");
    String isAdmin = scanner.nextLine();
    boolean admin = false;
    if (isAdmin.equals("y")) {
        admin = true;
    }
    System.out.println("Enter password:");
    String password = scanner.nextLine();
    if (!isUserExists(username)) {
        users.add(new User(username, email, password, admin));
        System.out.println("User added successfully.");
    } else {
        System.out.println("Username already exists.");
    }
}

    static void removeUser() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter username");
    String username = scanner.nextLine();

    Iterator<User> iterator = users.iterator();
    while (iterator.hasNext()) {
        User user = iterator.next();
        if (user.username.equals(username)) {
            iterator.remove();
            System.out.println("User removed successfully.");
            return;
        }
    }
    System.out.println("User not found.");
}

}

