/**
 * Justin K
 * Assignment 3
 */

 import java.util.Scanner;

 public class Assignment3 {


    //LESSON LEARNED, STATIC AND NON STATIC DONT MIX!!!!
            //Static is to class
            //Non static is to object. 

    //Lesson learned, you dont need to extend classes to share variables.
    //Lesson learned #2 Why am I making extra classes for this assignment, totally unnessesary.


    public static  String UserQueuery;
    public static Scanner scanner = new Scanner(System.in);
    public static float ConvertNumber = 0;



    public static void main(String[] args) throws Exception {





        //Text when program starts
         System.out.println("     Welcome to the command line application metric converter!");
         System.out.println("                            Justin K");
         System.out.println("");
         System.out.println("            Please format your query like this");
         System.out.println("              Conversion Type : Unit Amount");
         System.out.println("                       KM = M : 5");
         System.out.println("");
         System.out.println("                 Type     EXIT   to finish! ");
         System.out.println("");
         System.out.println("             Type HELP for avalable conversions");
         MetricCalculationFunc();

        
    }

     // While making a function for this seems redundant, I was running into errors where the program would just terminate otherwise. 
     //Want to recursivly call self until finished
     //made a lot more work for myself because now I need to deal with global vars and whatnot. 

     public static void MetricCalculationFunc() {
        
        UserQueuery = scanner.nextLine();


       // I change queuery to upper case so I can check string easier later on.
       UserQueuery = UserQueuery.toUpperCase();

       // Also get rid of white space for easier switching later on. 

       //Note to self. doing UserQueuery.replaceAll("\\s","") wont update UserQueuery silly. You need to make sure to add assignment opperator
        UserQueuery = UserQueuery.replaceAll("\\s","");


       //If user says 'exit' or 'EXIT' it will exit the program with an error code of 0 / propper termination
        if (UserQueuery.contains("EXIT")) {
           scanner.close();
           System.exit(0); 
         }

       //propper syntax check
        if (UserQueuery.contains(":") == false && UserQueuery.contains("HELP") == false) {
            System.out.println("");
            System.out.println("");
           System.out.println("");
            System.out.println("              Error! Does not contain colon!");
            System.out.println("");
            System.out.println("            Please format your query like this");
            System.out.println("              Conversion Type : Unit Amount");
            System.out.println("                       KM = M : 5");
            System.out.println("");
            System.out.println("             Type HELP for avalable conversions");
            MetricCalculationFunc();
            return;
        }

        if (UserQueuery.contains("HELP")) {
            System.out.println("");
            System.out.println("");
            System.out.println("                 EXIT                    to close program ");
            System.out.println("                 M = KM : Number         Converts miles to kilometers");
            System.out.println("                 KM = M : Number         Converts kilometers to miles");
            System.out.println("                 LBS = KG : Number       Converts pounds to kilograms");
            System.out.println("                 KG = LBS : Number       Converts kilograms to pounds");
        }

        //Can use switch case or if/else statements to finish the rest
        //I already spent a lot of time on this asignment, if else statemtns are faster to write and copy paste so I will do that.
        //Im just going to copy paste code in intrest of my time since I've been here for so long. I know its not best practice but fast to prototype.

        System.out.println(UserQueuery);

        if (UserQueuery.contains("M=KM")){
            System.out.println("");
            System.out.println("");
            System.out.println("Converting Miles to Kilometers");
            //Splits user querey at the : into two parts, CAN CRASH AND UNSAFE, So I implemented a try / catch method I just learned about to prevent total crash.
            try {
             ConvertNumber = Float.parseFloat(UserQueuery.split(":")[1].trim());
            }
            catch (NumberFormatException e) {
              System.out.println("");
              System.out.println("Invalid number format. Use HELP for more info.");
              System.out.println("");
            }
            System.out.print(ConvertNumber);
            System.out.print(" Miles is equal to ");
            System.out.print(ConvertNumber*1.60934);
            System.out.print(" Kilometers! How neat!");
            System.out.println("");
        }



        else if (UserQueuery.contains("KM=M")){
          System.out.println("");
          System.out.println("");
          System.out.println("Converting Kilometers to Miles");
          //Splits user querey at the : into two parts, CAN CRASH AND UNSAFE, So I implemented a try / catch method I just learned about to prevent total crash.
          try {
           ConvertNumber = Float.parseFloat(UserQueuery.split(":")[1].trim());
          }
          catch (NumberFormatException e) {
            System.out.println("");
            System.out.println("Invalid number format. Use HELP for more info.");
            System.out.println("");
          }
          System.out.print(ConvertNumber);
          System.out.print(" Kilometers is equal to ");
          System.out.print(ConvertNumber*0.621371);
          System.out.print(" Miles! How neat!");
          System.out.println("");
      }
       

      else if (UserQueuery.contains("KG=LBS")){
        System.out.println("");
        System.out.println("");
        System.out.println("Converting Kilograms to Pounds");
        //Splits user querey at the : into two parts, CAN CRASH AND UNSAFE, So I implemented a try / catch method I just learned about to prevent total crash.
        try {
         ConvertNumber = Float.parseFloat(UserQueuery.split(":")[1].trim());
        }
        catch (NumberFormatException e) {
          System.out.println("");
          System.out.println("Invalid number format. Use HELP for more info.");
          System.out.println("");
          
        }
        System.out.print(ConvertNumber);
        System.out.print(" Kilograms is equal to ");
        System.out.print(ConvertNumber*2.20462);
        System.out.print(" Pounds! How neat!");
        System.out.println("");
    }

    else if (UserQueuery.contains("LBS=KG")){
      System.out.println("");
      System.out.println("");
      System.out.println("Converting Pounds to Kilograms");
      //Splits user querey at the : into two parts, CAN CRASH AND UNSAFE, So I implemented a try / catch method I just learned about to prevent total crash.
      try {
       ConvertNumber = Float.parseFloat(UserQueuery.split(":")[1].trim());
      }
      catch (NumberFormatException e) {
        System.out.println("");
        System.out.println("Invalid number format. Use HELP for more info.");
        System.out.println("");
        
      }
      System.out.print(ConvertNumber);
      System.out.print(" Pounds is equal to ");
      System.out.print(ConvertNumber*0.621371);
      System.out.print(" Kilograms! How neat!");
      System.out.println("");
  }



    else {
      System.out.println("");
      System.out.println("Invalid format. Use HELP for more info!");
      System.out.println("");

    }







      //Calls self till end of time until they exit.
       MetricCalculationFunc();

       }
     }

 