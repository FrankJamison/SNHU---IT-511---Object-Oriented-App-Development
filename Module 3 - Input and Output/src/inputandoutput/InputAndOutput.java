/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputandoutput;

/**
 *
 * @author frank
 */

// Import the scanner class from the java.util package
import java.util.Scanner;

public class InputAndOutput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create scanner object
        Scanner reader = new Scanner(System.in);
        
        // Prompt the user for their first name
        System.out.print("Please enter your first name: ");
        
        // Store the first name in memory
        String firstName = reader.next();
        
        // Prompt the user for their last name
        System.out.print("Please enter your last name: ");
        
        // Store the first name in memory
        String lastName = reader.next();
        
        // Prompt the user for a number between 1 and 100
        System.out.print("Enter a number between 1 and 100: ");
        
        // Store the number in memory
        int number = reader.nextInt();
        
        // Display greeting to user
        System.out.println("Hello " + firstName + " " + lastName + ".");
        
        // Display number chosen
        System.out.printf("The number you chose is: %3d\n", number);
    }
    
    
    
}
