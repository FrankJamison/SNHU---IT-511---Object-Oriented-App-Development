/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualworld;

import java.util.Scanner;

/**
 *
 * @author frank
 */
public class VirtualWorld {
    
    public static boolean continueShouting() {
        // Creates new scanner object
        Scanner input = new Scanner(System.in);
        
        // Limit input to one character
        input.useDelimiter("");
        
        // Character variable to store user answer
        char answer;
        
        // Boolean variable to return response
        boolean response = false;
        
        // do the following while receiving an invalid response
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
            
            // else if answer is no, return false
            else if (answer == 'N' || answer == 'n') {
                response = false;
            }
            
            // else display error message
            else {
                System.out.printf("\n%c is not a valid answer.\n", answer);
            }
            
        } while (!(answer == 'Y' || answer == 'y' || 
                answer == 'N' || answer == 'n'));
        
        // Return user response
        return response;
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create ShoutBox object
        ShoutBox obj = new ShoutBox();
        
        // Create boolean sentinel variable
        boolean shoutAgain = false;
        
        // Have the user set 10 messages
        obj.setCannedMessages(10);
        
        // Shout out messages while shoutMessage sentinel is true
        do {
        
            // Have the user select a message to shout out
            String message = obj.shoutOutCannedMessage();
            
            // Display selected message
            System.out.printf("\nThe message you chose is: %s\n\n", message);
            
            // Ask user if they want to pick another sentence
            shoutAgain = continueShouting();
            
        } while (shoutAgain);
    }
 }
