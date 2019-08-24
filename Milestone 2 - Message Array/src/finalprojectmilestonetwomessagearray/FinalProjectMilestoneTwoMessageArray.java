/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectmilestonetwomessagearray;

/**
 *
 * @author frank jamison
 */

// Import the scanner class from the java.util package
import java.util.ArrayList;
import java.util.Scanner;


public class FinalProjectMilestoneTwoMessageArray {

    // Instance Variables //
    private final ArrayList<String> messages;   // ArrayList to hold messages
    private int numMessages = 0;                // Number of messages in ArrayList
    
    // Constructor //
    private FinalProjectMilestoneTwoMessageArray () {
        // Creates new ArrayList
        messages = new ArrayList<>();
    }

    // Adds a message to ArrayList //
    public void addMessage(String message) {
        // Add a message to messages ArrayList
        messages.add(message);
    }
    
    // Set messages in ArrayList
    public void setMessages(int messageCount) {
        // Creates new scanner object
        Scanner input = new Scanner(System.in);
        
        // Sets the number of messages in messages ArrayList
        numMessages = messageCount;
        
        // Give user instructions
        System.out.printf("Please enter %d messages for the shoutbox.\n\n", 
                numMessages);
        
        // Prompts user for messages and adds them to messages ArrayList
        for (int index = 0; index < numMessages; index++)  {
            // Prompt user for message
            System.out.printf("Enter Message %d: ", (index + 1));
            
            // Store message in message variable
            String message = input.nextLine();
            
            // Add message to messages ArrayList
            addMessage(message);
        }
    }

    // Displays messages in messages ArrayList
    public void displayMessages() {
        // Message index variable
        int messageIndex = 0;
        
        // Display mesages in message ArrayList with numbers
        for (String message : messages) {
            System.out.printf("%d. %s\n", ++messageIndex, message);
        }
    }
    
    // Select and return a specific message in messages ArrayList
    public String shoutOutCannedMessage() {
        // Creates new scanner object
        Scanner input = new Scanner(System.in);
        
        // Variable to hold user selection
        int selection;
        
        // Instructions for user
        System.out.println("\nPlease select one of the following messages "
                + "to shout out.\n");
        
        // Display messages in messages ArrayList
        displayMessages();
        
        // Prompt for message and repeat while selection is < 1 or 
        // selection > than the number of messages
        do {
            // Prompt for input
            System.out.print("\nPlease enter the number of the message you want "
                    + "to shout out: ");
            
            // Store input in selection variable
            selection = input.nextInt();
            
            // If selection is < 1 or > than the number of messages
            if (selection < 1 || selection > numMessages) {
                // Print error message
                System.out.println("\nThat is not a valid selection.\n");
            }
        } while (selection < 1 || selection > numMessages);
        
        // Get and return the selected message
        return messages.get(selection - 1);
    }
    
    public boolean continueShouting() {
        // Creates new scanner object
        Scanner input = new Scanner(System.in);
        
        // Limit input to one character
        input.useDelimiter("");
        
        // Character variable to store user answer
        char answer;
        
        // Boolean variable to return response
        boolean response = false;
        
        do {
            // Prompt user for y/n input
            System.out.print("\nWould you like to shout out another message? "
                + "(Y/N): ");
            
            // Get answer from user
            answer = input.next().charAt(0);
            
            // if answer is yes, return true
            if (answer == 'Y' || answer == 'y') {
                response = true;
            }
            
            else if (answer == 'N' || answer == 'n') {
                response = false;
            }
            
            else {
                System.out.printf("\n%c is not a valid answer.\n", answer);
            }
            
        } while (!(answer == 'Y' || answer == 'y' || 
                answer == 'N' || answer == 'n'));
        
        return response;
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a FinalProjectMilestoneTwoMessageArray object
        FinalProjectMilestoneTwoMessageArray obj = 
                new FinalProjectMilestoneTwoMessageArray();
        
        // Create boolean sentinel variable
        boolean shoutAgain = false;
        
        // Have the user set 10 messages
        obj.setMessages(10);
        
        // Shout out messages while shoutMessage sentinel is true
        do {
        
            // Have the user select a message to shout out
            String message = obj.shoutOutCannedMessage();

            // Display selected message
            System.out.printf("\nThe message you chose is: %s\n\n", message);
            
            shoutAgain = obj.continueShouting();
            
        } while (shoutAgain);
    }
}