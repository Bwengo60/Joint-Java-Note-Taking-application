
  import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

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
 

public class NoteTakingRegistrationWithOTP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    System.out.println("Exiting registration.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static int getUserChoice(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number (1 or 2).");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter a username: ");
        String username = scanner.next();
        System.out.print("Enter an email address: ");
        String email = scanner.next();
        System.out.print("Enter a password: ");
        String password = scanner.next();

        // Simulate sending an OTP code via email
        int otpCode = generateOTP();
        System.out.println("An OTP code has been sent to your email.");

        // Simulate user input of the OTP code
        System.out.print("Enter the OTP code: ");
        int userEnteredOTP = getUserChoice(scanner);

        if (userEnteredOTP == otpCode) {
            // You should implement a method to store the user information in your data storage system.
            boolean registrationSuccess = storeUserInformation(username, email, password);

            if (registrationSuccess) {
                System.out.println("Registration successful!");
            } else {
                System.out.println("Registration failed. Please try a different username or email.");
            }
        } else {
            System.out.println("OTP verification failed. Please enter the correct OTP code.");
        }
    }

    private static int generateOTP() {
        // Simulate OTP code generation (a random 6-digit number)
        return 100000 + new Random().nextInt(900000);
    }

    private static boolean storeUserInformation(String username, String email, String password) {
        // In a real application, you would save user information to your database.
        // For this example, we simply return true to simulate success.
        return true;
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

