/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aforkinthecode;

/**
 *
 * @author frank
 */

// Import the scanner class from the java.util package
import java.util.Scanner;

public class AForkInTheCode {

    /**
     * @param args the command line arguments
     */
    
    /* Get and return number from user */
    public static int getNumber () {
        // Create scanner object
        Scanner reader = new Scanner(System.in);
        
        // Prompt user for number
        System.out.print("Please enter a number between "
                 + "1 and 10 inclusive: ");
         
        // Store number in input variable
        int input = reader.nextInt(); 
        
        // Return the input
        return input;
    }
    
   /* Display success message and number input */ 
    public static void success(int number) {
        // Display success message
            System.out.printf("Good job! The number you entered is: %2d\n", 
                    number);
    }
    
    /* Display error message */
    public static void failure() {
        // Display error message
            System.out.print("The number entered was not between "
                    + "1 and 10!\n\n");
    }
    
    public static void main(String[] args) {
        
        // Get number from user
        int number = getNumber();
        
        // If the number is between 1 and 10 inclusive call success method
        if (number >= 1 && number <= 10) 
            success(number);
        
        // Else call failure method
        else
            failure();
        
        // While the number is not between 1 and 10 inclusive...
        while (number < 1 || number > 10) {
            // Get a new number
            number = getNumber();
            
            // If the number is between 1 and 10 inclusive call success method
            if (number >= 1 && number <= 10) 
                success(number);

            // Else call failure method
            else
                failure();
        }
    }
}
