import java.util.Scanner;

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
   void register(){// Clevis this is your task
      //Please enter the register code here!
      // And please make sure the code code is running in a loop so that if can tell the user that they have entered wrong information and give them provision to correct their mistake.

      // Remember we are putting the users in a temporary database made using a collection
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
   }
}

