import java.util.InputMismatchException;
import java.util.Scanner;

public class GarageAR {
  // Required Constants
   private static final double MIN_HOURS = 0.0;
   private static final double MIN_CHARGE = 2.0;
   private static final double MAX_HOUR = 3.0;
   private static final double ADD_CHARGE = 0.5;
   private static final double MAX_CHARGE = 10.0;

   // Static Void Function
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      double totalCharges = 0.0;
      // Print Welcome Message
      System.out.println("Welcome to the Parking Garage!");

      while (true) 
      {
         try {
            System.out.print("Enter the number of hours (-1 to quit): ");
            double hours = input.nextDouble();

            if (hours < 0) { // if input is negative, quit
               break;
             }

            double charge = calculateCharges(hours);
            totalCharges += charge;
            // Calculates current charge
            System.out.printf("Current charge: $%.2f%n", charge);
            // Calculates total charge
            System.out.printf("Total receipts: $%.2f%n", totalCharges);
            }

         catch (InputMismatchException e) { // Check for invalid input
            System.out.println("Invalid input. Enter a valid number.");
            input.nextLine(); // Clear the invalid input from the scanner
            }

      }
         // Print Goodbye Message before quitting
         System.out.println("Thank you for using Parking Garage, Goodbye!");
   }
      // Calculates for hours charged
      public static double calculateCharges(double hours) {
         double charge = MIN_CHARGE;

      if (hours > MAX_HOUR) {
         charge += Math.ceil(hours - MAX_HOUR) * ADD_CHARGE;
      }

      return (charge > MAX_CHARGE) ? MAX_CHARGE : charge;
      }
}