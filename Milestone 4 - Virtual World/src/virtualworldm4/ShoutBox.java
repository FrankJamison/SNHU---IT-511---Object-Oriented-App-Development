/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualworldm4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author frank
 */
public class ShoutBox {
    private HashMap<Integer, String> messages;  // Canned Messages
    private int numMessages;                    // Number of canned messages
    private ArrayList<String> subjects;         // ArrayList to hold subjects
    private ArrayList<String> verbs;            // ArrayList to hold verbs
    private ArrayList<String> adjectives;       // ArrayList to hold adjectives
    private ArrayList<String> objects;          // ArrayList to hold objects
    private ArrayList<String> adverbs;          // ArrayList to hold adverbs
    private int listLength;                     // Number of words in ArrayLists
    
    // Constructor with message count and word count arguments
    public ShoutBox(int messageCount, int wordCount) {
        
        // Initialize numMessages and listLength variables
        numMessages = messageCount;
        listLength = wordCount;
        
        // Create new hashmap and arraylist objects
        messages = new HashMap<>();
        subjects = new ArrayList<>();
        verbs = new ArrayList<>();
        adjectives = new ArrayList<>();
        objects = new ArrayList<>();
        adverbs = new ArrayList<>();
        
        // Input canned messages
        setCannedMessages(numMessages);
        
        // Input words for random messages
        setList(subjects, "subject");
        setList(verbs, "verb");
        setList(adjectives, "adjective");
        setList(objects, "object");
        setList(adverbs, "adverb");
    }
    
    // Add message to hashmap
    private void addMessage(int key, String message) {
        
        // Add message to hashmap
        messages.put(key, message);
    }
    
    // Input canned messages
    private void setCannedMessages(int messageCount) {
        
        // Creates new scanner object
        Scanner input = new Scanner(System.in);
        
        // Sets the number of messages to input
        numMessages = messageCount;
        
        // Display user instructions
        System.out.printf("Please enter %d messages for the shoutbox.\n\n", 
                numMessages);
        
        // Get messages from user
        for (int index = 1; index <= numMessages; index++)  {
            
            // Prompt user for message
            System.out.printf("Enter Message %d: ", (index));
            
            // Get message from user
            String message = input.nextLine();
            
            // Add message hashmap
            addMessage(index, message);
        }
    }
    
    // Display canned message list
    private void displayMessages() {
        
        // Create a hashmap entry set
        Set set = messages.entrySet();
        
        // Create an iterator for the entry set
        Iterator iterator = set.iterator();
        
        // Iterate through hashmap and display canned messages
        while(iterator.hasNext()) {
            
            // Get next item in hashmap
            Map.Entry mentry = (Map.Entry)iterator.next();
            
            // Display the item's key and value
            System.out.print(mentry.getKey() + ". ");
            System.out.println(mentry.getValue());
        }
    }
    
    // Get and validate an English word from the user
    private static String getWord (String type, int count) {
        
        // Create scanner object
        Scanner reader = new Scanner(System.in);
        
        // Boolean variable for English word validation.
        boolean isEnglishWord;
        
        // String variable for user input
        String input;
        
        // Prompt user for input until they enter a valid word
        do {
            
            // Prompt user for word
            System.out.printf("Please enter %s %d: ", type, count);
            
            // Get word from user
            input = reader.next();
            
            // Validate word (can contain apostophes)
            isEnglishWord = input.matches("^[a-zA-Z]+('[a-zA-Z]+)?$");
            
            // Display error message if validation fails
            if(!isEnglishWord){
                System.out.printf("%s is not an English word.\n\n", input);
            }
        } while (!isEnglishWord);
        
         // Return user input
        return input;
    }
    
    // Input words for random messages
    private void setList(ArrayList<String> list, String type) {
        
        // Display user instructions
        System.out.printf("\nTo populate the %ss list, please enter %d "
                + "%ss\n\n", type, listLength, type);

        // Get words from user and add to list
        for (int index = 0; index < listLength; index++) {
            
            // Get a word of the specified type
            String word = getWord(type, index + 1);
            
            // Add word to list
            list.add(word);
        }
    }
    
    // Generate random number
    private int getRandomNumber(int numElements) {
        
        // Integer variable to hold random number
        int randomNumber = -1;
        
        // Generate and validate random number 
        do {
            
            // Generate random number between 0 and specified number
            randomNumber = (int) (Math.random() * numElements);
            
        } while (randomNumber < 0 || randomNumber >= numElements);
        
        // Return random number
        return randomNumber;
    }

    // Validate user selection
    private boolean isValidSelection(int min, int max, int selection) {
        return (selection >= min && selection <= max);
    }
    
    // Get type of message to display
    public String getMessageType() {
        
        // Creates new scanner object
        Scanner input = new Scanner(System.in);
        
        // String Variable for message type
        String messageType = "";
        
        // Boolean variable for selection validation
        Boolean isValid = false;

        // Integer variable for user selection
        int selection;

        do {
            
            // Display message type options
            System.out.println("\n1. Canned Message");
            System.out.println("2. Random Message\n");
            
            // Prompt user for selection
            System.out.println("Please enter the number of the type of "
                    + "message you would like to shout out: ");
            
            // Get selection from user
            selection = input.nextInt();
            
            // Validate selection
            isValid = isValidSelection(1, 2, selection);
            
            // Display error message if selection is invalid
            if (!isValid) {
                System.out.println("\nThat is not a valid selection.\n");
            }
            
        } while (!isValid);
        
        // If selection 1, set type to canned
        if (selection == 1) {
            messageType = "canned";
        }
        
        // If selection is 2, set type to random
        else {
            messageType = "random";
        }
        
        // Return message type
        return messageType;
    } 

    // Return canned message
    public String shoutOutCannedMessage() {
        
        // Creates new scanner object
        Scanner input = new Scanner(System.in);
        
        // Integer variable for user selection
        int selection;
        
        // Boolean variable for selection validation
        Boolean isValid = false;
        
        // Display instructions for user
        System.out.println("\nPlease select one of the following messages "
                + "to shout out.\n");
        
        // Display message list
        displayMessages();
        
        // Prompt user for selection while input is invalid
        do {
            
            // Prompt user for input
            System.out.print("\nPlease enter the number of the message you "
                    + "want to shout out: ");
            
            // Get user input
            selection = input.nextInt();
            
            // Validate selection
            isValid = isValidSelection(1, numMessages, selection);
            
            // Display error message if input is invalid
            if (!isValid) {
                System.out.println("\nThat is not a valid selection.\n");
            }
            
        } while (!isValid);
        
        // Return the selected message
        return messages.get(selection);
    }
    
    // Return random message
    public String shoutOutRandomMessage() {
        
        // Construct random message
        String message = "\n" + subjects.get(getRandomNumber(listLength)) + 
                " " + verbs.get(getRandomNumber(listLength)) + 
                " " + adjectives.get(getRandomNumber(listLength)) + 
                " " + objects.get(getRandomNumber(listLength)) + 
                " " + adverbs.get(getRandomNumber(listLength)) + ".\n";
        
        // Return random message
        return message;
    } 
    
    // Determine if user wants to shout out another message
    public boolean continueShouting() {
        
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
        
        // Return user response
        return response;
    } 
}
