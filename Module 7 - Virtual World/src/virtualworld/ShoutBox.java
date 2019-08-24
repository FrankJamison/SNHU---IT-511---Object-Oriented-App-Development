/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualworld;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author frank
 */
public class ShoutBox {
    private final HashMap<Integer, String> messages;
    private int numMessages;
    
    // Constructor
    public ShoutBox() {
        numMessages = 0;                // Initialize numMessages
        messages = new HashMap<>();     // Create new Hashmap
    }
    
    // Add message to hashmap
    public void addMessage(int key, String message) {
        // Add message to hashmap
        messages.put(key, message);
    }
    
    // Set messages in Hashmap
    public void setCannedMessages(int messageCount) {
        // Creates new scanner object
        Scanner input = new Scanner(System.in);
        
        // Sets the number of messages in messages Hashmap
        numMessages = messageCount;
        
        // Give user instructions
        System.out.printf("Please enter %d messages for the shoutbox.\n\n", 
                numMessages);
        
        // Prompts user for messages and adds them to messages Hashmap
        for (int index = 1; index <= numMessages; index++)  {
            // Prompt user for message
            System.out.printf("Enter Message %d: ", (index));
            
            // Store message in message variable
            String message = input.nextLine();
            
            // Add message to messages Hashmap
            addMessage(index, message);
        }
    }
    
    // Displays messages in messages Hashmap
    public void displayMessages() {
        // Create a hashmap entry set
        Set set = messages.entrySet();
        
        // Create an iterator for the entry set
        Iterator iterator = set.iterator();
        
        // Display next hashmap item while there are more items in hashmap
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.print(mentry.getKey() + ". ");
            System.out.println(mentry.getValue());
        }
    }
    
    // Select and return a specific message in messages Hashmap
    public String shoutOutCannedMessage() {
        // Creates new scanner object
        Scanner input = new Scanner(System.in);
        
        // Variable to hold user selection
        int selection;
        
        // Instructions for user
        System.out.println("\nPlease select one of the following messages "
                + "to shout out.\n");
        
        // Display messages in messages Hashmap
        displayMessages();
        
        // Prompt for message and repeat while selection is invalid
        do {
            // Prompt for input
            System.out.print("\nPlease enter the number of the message you "
                    + "want to shout out: ");
            
            // Store input in selection variable
            selection = input.nextInt();
            
            // If selection is < 1 or > than the number of messages
            if (selection < 1 || selection > numMessages) {
                // Print error message
                System.out.println("\nThat is not a valid selection.\n");
            }
        } while (selection < 1 || selection > numMessages);
        
        // Get and return the selected message
        return messages.get(selection);
    }
}
