/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualworldf;

import java.util.Scanner;

/**
 * IT-511-X5381 Object Oriented App Develop 16TW5
 * 9-2 Final Project: Virtual World Java Application 
 * Frank Jamison
 */
public class VirtualWorldF {

    // Get yes or no answer from user
    public static boolean answerYesNo() {
        
        // Creates new scanner object
        Scanner input = new Scanner(System.in);
        
        // Limit input to one character
        input.useDelimiter("");
        
        // Character variable to store user answer
        char answer;
        
        // Boolean variable to return response
        boolean response = false;
        
        // Repeat loop until Y/N response is received
        do {
            // Prompt user for y/n input
            System.out.print("\nPlease select Y or N: ");
            
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
            
            // Clear scanner buffer
            input.nextLine();
            
        } while (!(answer == 'Y' || answer == 'y' || 
                answer == 'N' || answer == 'n'));
        
        // Return user response
        return response;
    } 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create MyClone object of Frank Jamison
        MyClone frank = new MyClone("Frank");
        /* Tests the following methods:
            MyClone(String)
                setFirstName(String)
                setLastName(String)
                setAge(int)
                setGender(String)
                setHeight(int)
                setWeight(int)
                setHairColor(String)
                setEyeColor(String)
        */
        
        // Introduce Frank's clone
        frank.introduction();
        /* Tests the following methods:
            introduction()
                getFirstName()
                getLastName()
                getAge()
                getGender()
                getHairColor()
                getEyeColor()
                getHeight()
                getWeight()
        */
        
        // Prompt user for MyClone input
        System.out.println("Now tell me a little about you...");
        
        // Create MyClone object for user
        MyClone user = new MyClone();
        /* Tests the following methods:
            MyClone()
                setFirstName();
                    getName(String)
                    setFirstName(String)
                setLastName();
                    getName(String)
                    setLastName(String)
                setAge();
                    getNumber(String)
                    setAge(int)
                setGender();
                    getSelection(String)
                    setGender(String)
                setHeight();
                    getNumber(String)
                    setHeight(int)
                setWeight();
                    getNumber(String)
                    setWeight(int)
                setHairColor();
                    getSelection(String)
                    setHairColor(String)
                setEyeColor();
                    getSelection(String)
                    setEyeColor(String)
        */
        
        // Confirm user's clone data
        user.confirmation();
        /* Tests the following methods:
            confirmation()
                getFirstName()
                getLastName()
                getAge()
                getGender()
                getHairColor()
                getEyeColor()
                getHeight()
                getWeight()
        */
        
        // Create MyDog object of Frank's dog Baby
        MyDog baby = new MyDog("Baby");
        /* Tests the following methods:
            MyClone(String)
                setName(String)
                setsetBreed(String)
                setAge(int)
                setGender(String)
                setSize(String)
                setWeight(int)
                setHairColor(String)
                setEyeColor(String)
        */
        
        // Introduce Frank's dog Baby
        baby.introduction();
        /* Tests the following methods:
            introduction()
                getName()
                getAge()
                getGender()
                getBreed()
                getHairColor()
                getEyeColor()
                getSize()
                getWeight()
        */
        
        // Ask user if they own a dog
        System.out.print("Do you own a dog?");
        
        // Get user response
        Boolean ownsDog = answerYesNo();
        /* Tests the following methods:
            answerYesNo()
        */
        
        // if the user owns a dog
        if (ownsDog) {
            
            // Create MyDog object for user
            MyDog usersDog = new MyDog();
            /* Tests the following methods
                setName();
                    getWord (String)
                    setName(String)
                setBreed();
                    getWord (String)
                    setBreed(String)
                setAge();
                    getNumber (String)
                    setAge(int)
                setGender();
                    getSelection(String)
                    setGender(String)
                setSize();
                    getSelection(String)
                    setSize(String)
                setWeight();
                    getNumber (String)
                    setWeight(int)
                setHairColor();
                    getSelection(String)
                    setHairColor(String)
                setEyeColor();
                    getSelection(String)
                    setEyeColor(String)
            */
            
            // Confirm user's dog clone data
            usersDog.confirmation();
            /* Tests the following methods:
                confirmation()
                    getName()
                    getAge()
                    getGender()
                    getBreed()
                    getHairColor()
                    getEyeColor()
                    getSize()
                    getWeight()
            */
        }

        // Else display apology message
        else {
            System.out.println("That's too bad. Dogs make wonderful companions.\n");
        }
        
        
        
        // Ask user if they want to customize their shout box
        System.out.print("The ShoutBox allows you to shout out messages in "
                + "the virtual world. Would you like to customize your "
                + "ShoutBox?");
        
        // Get user response
        Boolean affirmative = answerYesNo();
        /* Tests the following methods:
            answerYesNo()
        */
        
        // ShoutBox variable to hold ShoutBox object
        ShoutBox shoutbox;
        
        // If user wants to customize use default constructor
        if (affirmative) {
            
            // Display selection
            System.out.println("\nYou have selected to customize your ShoutBox.");
            
            // Create ShoutBox object
            shoutbox = new ShoutBox();
            /* Tests the following methods:
                ShoutBox()
                    setNumMessages()
                        setNumMessages(int)
                    setListLength()
                        setListLength(int)
                    setCannedMessages()
                        setMessage(int, String)
                    setWords(ArrayList<String>, String)
                        getWord (String type, int count)
                        setWord(ArrayList<String>, String)
            */ 
        }
        
        // Else use preset shout box
        else {
            // Display selection
            System.out.println("\nYou have selected to use our preset ShoutBox.");
            
            shoutbox = new ShoutBox("preset");
            /* Tests the following methods:
                ShoutBox(String)
                    setNumMessages(int)
                    setListLength(int)
                    setMessage(int, String)
                    setWord(ArrayList<String>, String)
            */
        }
        
        // Boolean variable to shout again
        boolean shoutAgain = false;

        // Display messages while user wishes to continue shouting
        do {
            // Get message type from user
            String messageType = shoutbox.getMessageType();
            /* Tests the following methods:
                getMessageType()
                    isValidSelection(int, int, int)
            */
            
            // If message type is canned, display selected canned message
            if (messageType == "canned") {
                
                // Get message selection from user
                String message = shoutbox.shoutOutCannedMessage();
                /* Tests the following methods:
                    shoutOutCannedMessage()
                        getCannedMessages()
                        isValidSelection(int, int, int)
                */
                
                // Display selected canned message
                System.out.printf("\nThe message you chose is: \n%s\n\n", message);
            }
            
            // Else if message type is random, display random message
            else {
                
                // Get random message
                String message = shoutbox.shoutOutRandomMessage();
                /* Tests the following methods:
                    shoutOutRandomMessage()
                        getRandomNumber(int)
                */
                
                // Display random message
                System.out.printf("\nThe random message is: %s\n\n", message);
            }
            
            // Ask user if they want to shout out another message
            System.out.print("Would you like to shout out another message?");

            // Determine if user wishes to continue shouting
            shoutAgain = answerYesNo();
            /* Tests the following methods:
                answerYesNo()
            */
            
        } while (shoutAgain);
    }
}
