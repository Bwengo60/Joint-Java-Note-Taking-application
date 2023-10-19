
  import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
import org.mindrot.jbcrypt.BCrypt;
import java.util.ArrayList;
import java.util.regex.Pattern;

class NoteTakingApp{
    public static void main(String[] Args){
         System.out.println("Hello Welcome to our Note Taking App!");
         boolean start=true;
         Scanner scanner = new Scanner(System.in);
         

         while(start){
             System.out.println("1. Login\n2. Register\n3. To Quit\n\nPlease Login Or Register To Proceed: ");
             String choice = scanner.nextLine();
             switch(choice){
                 case "1":
                       System.out.println("Logged in!");
                       home();
                       break;
                 case "2":
                       System.out.println("Registered");//Replace me with a working registration function.
                       break;
                 case "3":
                       System.out.println("Bye!");
                       start = false;
                 default:
                        System.out.println("\nPlease Enter a valid command!\n");
             }
             
             
         }
    }
    void login(){ // Monde your task

       //Please enter the login code here!
      // And please make sure the code code is running in a loop so that if can tell the user that they have entered wrong information and give them provision to correct their mistake.

      // Monde your work is what to do after the user logs in,, you have to check if the user is an admin or a normal user
    }

public class SecureUserRegistration {
    static class User {
        String username;
        String email;
        String hashedPassword;

        public User(String username, String email, String hashedPassword) {
            this.username = username;
            this.email = email;
            this.hashedPassword = hashedPassword;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerUser(scanner, users);
                    break;
                case 2:
                    System.out.println("Exiting registration.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerUser(Scanner scanner, ArrayList<User> users) {
        System.out.print("Enter a username: ");
        String username = scanner.next();
        System.out.print("Enter an email address: ");
        String email = scanner.next();
        System.out.print("Enter a password: ");
        String password = scanner.next();

        if (isUserExists(users, username, email)) {
            System.out.println("Registration failed. Username or email already exists.");
        } else if (!isEmailValid(email) || !isPasswordStrong(password)) {
            System.out.println("Registration failed. Invalid email or weak password.");
        } else {
            // Hash the password before storing it
            String hashedPassword = hashPassword(password);
            User newUser = new User(username, email, hashedPassword);
            users.add(newUser);
            System.out.println("Registration successful!");
            // Send email verification code (not implemented in this example).
        }
    }

    private static boolean isUserExists(ArrayList<User> users, String username, String email) {
        for (User user : users) {
            if (user.username.equals(username) || user.email.equals(email)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEmailValid(String email) {
        // Use a regular expression for email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(emailRegex, email);
    }

    private static boolean isPasswordStrong(String password) {
        // Implement password strength criteria (e.g., minimum length, special characters)
        return password.length() >= 8 && password.matches(".*[!@#$%^&*].*");
    }

    private static String hashPassword(String password) {
        // Use BCrypt to hash the password
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }
}

  static void home(){// This was my task "Muhammadi Bwengo" 
      boolean homeLoop = true;
      Scanner scanner = new Scanner(System.in);
      
      while(homeLoop){
          System.out.println("Welcome to the Home page\n\n1. Create New Notes\n2. Read Notes\n3. Update Notes\n4. Delete Notes\n5. Logout");
      String homeChoice = scanner.nextLine();
      switch(homeChoice){
          case "1":
              //Add the create notes function here
              System.out.println("Notes Created!");
              break;
          case "2":
              //Add the read notes function here
              System.out.println("Read Notes");
              break;
          case "3":
              //Add the Update Notes function here
              System.out.println("");
              break;
          case "4":
              // Add the delete notes function here
              System.out.print("Delete notes");
              break;
          case "5":
              System.out.println("You logged out!");
              homeLoop = false;
       }
      }
      
   }

   static void createNotes(){// Webster your task is here 
        // Fill this function with working code to create notes remember we are storing the data in a collection
       Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your note:");
        String note = scanner.nextLine();
        notes.add(note);
        System.out.println("Note Created!");
   }

   static void readNotes(){ // Webster here again}
      System.out.println("Your Notes:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));

   static void updateNotes(){// Paul your task is here
        // Fill this function with working code
   }
   
   static void adminPanel(){ //Ntala your task is here
       // fill this function
   }
   
   
}

