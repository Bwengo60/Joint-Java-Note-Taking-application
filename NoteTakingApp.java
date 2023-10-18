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
    void login(){
       //Please enter the login code here!
      // And please make sure the code code is running in a loop so that if can tell the user that they have entered wrong information and give them provision to correct their mistake.

      // Monde your work is what to do after the user logs in,, you have to check if the user is an admin or a normal user
    }
   void register(){
      //Please enter the register code here!
      // And please make sure the code code is running in a loop so that if can tell the user that they have entered wrong information and give them provision to correct their mistake.
   }
}

