package virtualworldm4;

import java.util.Scanner;

/**
 * IT-511-X5381 Object Oriented App Develop 16TW5
 * 8-2 Final Project Milestone Four: ShoutBox Class With Methods 
 * Frank Jamison
 */

public class VirtualWorldM4 {
    
    public static void main(String[] args) {
        
        // Boolean variable to shout again
        boolean shoutAgain = false;
        
        // Create ShoutBox object with 10 canned messages and lists of 5 words
        ShoutBox shoutObj = new ShoutBox(10, 5);
        
        // Display messages while user wishes to continue shouting
        do {
            
            // Get message type from user
            String messageType = shoutObj.getMessageType();
            
            // If message type is canned, display selected canned message
            if (messageType == "canned") {
                
                // Get message selection from user
                String message = shoutObj.shoutOutCannedMessage();
                
                // Display selected canned message
                System.out.printf("\nThe message you chose is: %s\n\n", message);
            }
            
            // Else if message type is random, display random message
            else {
                
                // Get random message
                String message = shoutObj.shoutOutRandomMessage();
                
                // Display random message
                System.out.printf("\nThe random message is: %s\n\n", message);
            }
            
            // Determine if user wishes to continue shouting
            shoutAgain = shoutObj.continueShouting();
            
        } while (shoutAgain);
    }    
}