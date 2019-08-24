package virtualworldh8;

import java.util.Scanner;

/**
 * IT-511-X5381 Object Oriented App Develop 16TW5
 * 8-1 Java Homework: Word Up
 * Frank Jamison
 */

public class VirtualWorldH8 {

    public static void main(String[] args) {
        
        // Create boolean sentinel variable
        boolean shoutAgain = false;

        // Create RandomMessageGenerator object with lists containing 5 words
        RandomMessageGenerator randomObj = new RandomMessageGenerator(5);
        
        // Display random messages while user wishes to continue
        do {
        
            // Display random message
            System.out.print(randomObj.shoutOutRandomMessage());
            
            // Determine if user wants to display another message
            shoutAgain = randomObj.continueShouting();
            
        } while (shoutAgain);
    }
}
