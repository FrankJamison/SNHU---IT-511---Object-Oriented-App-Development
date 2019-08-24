/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualworldf;

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
    
    // **********************
    // * INSTANCE VARIABLES *
    // **********************
    private int numMessages;                    // Number of canned messages
    private int listLength;                     // Number of random words in lists
    private HashMap<Integer, String> messages;  // Canned Messages
    private ArrayList<String> subjects;         // ArrayList to hold subjects
    private ArrayList<String> verbs;            // ArrayList to hold verbs
    private ArrayList<String> adjectives;       // ArrayList to hold adjectives
    private ArrayList<String> objects;          // ArrayList to hold objects
    private ArrayList<String> adverbs;          // ArrayList to hold adverbs
    
    // ****************
    // * CONSTRUCTORS *
    // ****************
    
    // Constructor w/o arguments
    public ShoutBox() {
        
        // Create new hashmap and arraylist objects
        messages = new HashMap<>();
        subjects = new ArrayList<>();
        verbs = new ArrayList<>();
        adjectives = new ArrayList<>();
        objects = new ArrayList<>();
        adverbs = new ArrayList<>();
        
        // Set number of canned messages
        setNumMessages();
        
        // Set word list length
        setListLength();
        
        // Set canned messages
        setCannedMessages();
        
        // Input words for random messages
        setWords(subjects, "subject");
        setWords(verbs, "verb");
        setWords(adjectives, "adjective");
        setWords(objects, "object");
        setWords(adverbs, "adverb");
    }
    
    // Constructor with preset argument
    public ShoutBox(String preset) {
        
        if (preset == "preset") {
            
            // Create new hashmap and arraylist objects
            messages = new HashMap<>();
            subjects = new ArrayList<>();
            verbs = new ArrayList<>();
            adjectives = new ArrayList<>();
            objects = new ArrayList<>();
            adverbs = new ArrayList<>();
            
            // Set number of canned messages
            setNumMessages(10);
            
            // Set word list length
            setListLength(5);
            
            // Set canned messages
            setMessage(1, "I love you like an Amercan loves apple pie!");
            setMessage(2, "I love you like a smart kid loves learning!");
            setMessage(3, "I love you like a bear lives honey!");
            setMessage(4, "I love you like a hipster loves Starbucks!");
            setMessage(5, "I love you like Donald Trump loves attention!");
            setMessage(6, "I love you like a sailor loves swearing!");
            setMessage(7, "I love you like a kitten loves a ball of yarn!");
            setMessage(8, "I love you like a rabbit loves carrots!");
            setMessage(9, "I love you like a philatelist loves the post office!");
            setMessage(10, "I love you like a worm loves apples!");
            
            // Set subjects for random messages
            setWord(subjects, "I");
            setWord(subjects, "Others");
            setWord(subjects, "They");
            setWord(subjects, "We");
            setWord(subjects, "You");
            
            // Set verbs for random messages
            setWord(verbs, "drink");
            setWord(verbs, "eat");
            setWord(verbs, "hate");
            setWord(verbs, "love");
            setWord(verbs, "vomit"); 
            
            // Set adjectives for random messages
            setWord(adjectives, "dark");
            setWord(adjectives, "green");
            setWord(adjectives, "rotten");
            setWord(adjectives, "sour");
            setWord(adjectives, "sweet");
            
            // Set objects for random messages
            setWord(objects, "food");
            setWord(objects, "fruit");
            setWord(objects, "grapes");
            setWord(objects, "juice");
            setWord(objects, "vegetables");
            
            // Set adverbs for random messages
            setWord(adverbs, "especially");
            setWord(adverbs, "exclusively");
            setWord(adverbs, "only");
            setWord(adverbs, "regularly");
            setWord(adverbs, "willingly");
        }
        
        else {
            System.out.printf("%s is not a valid ShoutBox preset.\n", preset);
        }
    }

    /**************
     * USER INPUT *
     **************/
    
    /* Get and return number from user */
    private static int getNumber (String type) {
        // Create scanner object
        Scanner reader = new Scanner(System.in);
        
        // Integer variable to hold maximum value
        int maxNum;
        
        // Set maximum message limit
        if (type == "canned messages") {
            maxNum = 20;
        }
        
        // Set maximum word limit
        else if (type == "random words") {
            maxNum = 10;
        }
        
        // Set maximum integer value
        else {
            maxNum = 2147483647;
        }
        
        // Create boolean variable for integers.
        boolean isInteger;

        // String variable to hold user input
        String input;
        
        do {
            // Prompt user for number of messages to create
            System.out.printf("\nPlease enter the number of %s", type);
            
            if(type == "canned messages") {
                System.out.print(" you wish to enter: ");
            }
            
            else if (type == "random words") {
                System.out.print(" you wish to enter for each list: ");
            }
            
            else {
                System.out.print(": ");
            }
            
            // Store word in input variable
            input = reader.next();
            
            // Validate canned messages between 1 and 20
            if (type == "canned messages") {
                isInteger = input.matches("^([1-9]|1[0-9]|20)$");
            }
            
            // Validate random words between 1 and 10
            else if (type == "random words") {
                isInteger = input.matches("^([1-9]|10)$");
            }
            
            // Validate number as integer
            else {
                isInteger = input.matches("\\d+");
            }
            
            // If the input is not a number...
            if(!isInteger){
                // Display error message
                System.out.printf("\n%s is not a valid value for %s.\n", 
                        input, type);
                
                // Display valid range
               System.out.printf("The valid input range for %s is between "
                            + "1 and %s.\n\n", type, maxNum);
            }
        } while (!isInteger);
        
         // Return the input
        return Integer.parseInt(input);
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
            System.out.print("Please enter the number of the type of "
                    + "message you would like to shout out: ");
            
            // Get selection from user
            selection = input.nextInt();
            
            // Validate selection
            isValid = isValidSelection(1, 2, selection);
            
            // Display error message if selection is invalid
            if (!isValid) {
                System.out.println("\nThat is not a valid selection.");
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
    
    /************
     * MUTATORS *
     ************/
    
    // Set number of messages with argument
    public void setNumMessages(int messageCount) {
        numMessages = messageCount;
    }
    
    // Set number of messages w/o arguments
    public void setNumMessages() {
        
        // Get number of canned messages from user
        int messageCount = getNumber("canned messages");
        
        // Set number of messages
        setNumMessages(messageCount);
    }
    
    // Set length of word lists with argument
    public void setListLength(int wordCount) {
        listLength = wordCount;
    }
    
    // Set length of word lists w/o arguments
    public void setListLength() {
        
        // Get number of canned messages from user
        int wordCount = getNumber("random words");
        
        // Set number of messages
        setListLength(wordCount);
    }
    
    // Set message in hashmap
    private void setMessage(int key, String message) {
        
        // Put message in hashmap
        messages.put(key, message);
    }
    
    // Set canned messages w/o argument
    public void setCannedMessages() {
        
        // Creates new scanner object
        Scanner input = new Scanner(System.in);
        
        // Clear current hashmap
        messages.clear();

        // Display user instructions
        System.out.printf("\nPlease enter %d messages for the shoutbox.\n\n", 
                numMessages);
        
        // Get messages from user
        for (int index = 1; index <= numMessages; index++)  {
            
            // Prompt user for message
            System.out.printf("Enter Message %d: ", (index));
            
            // Get message from user
            String message = input.nextLine();
            
            // Add message hashmap
            setMessage(index, message);
        }
    }
    
    // Set word in ArrayList
    public void setWord(ArrayList<String> list, String word) {
        // Add word to list
        list.add(word);
    }

    // Set words for random word list
    private void setWords(ArrayList<String> list, String type) {
        
        // Display user instructions
        System.out.printf("\nTo populate the %ss list, please enter %d "
                + "%ss\n\n", type, listLength, type);

        // Get words from user and add to list
        for (int index = 0; index < listLength; index++) {
            
            // Get a word of the specified type
            String word = getWord(type, index + 1);
            
            // Add word to list
            setWord(list, word);
        }
    }
    
    /*************
     * ACCESSORS *
     *************/
    
    // Get number of messages
    public int getNumMessages() {
        return numMessages;
    }
    
    // Get number of words in each list
    public int getListLength() {
        return listLength;
    }
    
    // Get message from hashmap
    public void getMessage(int key) {
        messages.get(key);
    }
    
    // Get canned messages
    public void getCannedMessages() {
        
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
        
        // Line spacer
        System.out.println("");
    }
    
    // Get words from random word list
    public void getList(String type) {
        
        int index = 1;
        ArrayList<String> wordList;
        
        if (type == "Subject") {
            wordList = subjects;
        }
        
        else if (type == "Verb") {
            wordList = verbs;
        }

        else if (type == "Adjective") {
            wordList = adjectives;
        }
        
        else if (type == "Object") {
            wordList = objects;
        }
        
        else {
            wordList = adverbs;
        }
        
        System.out.printf("%s List\n", type);
        
        for (String word : wordList) {
            System.out.printf("%d. %s\n", index, word);
            index++;
        }
    }
    
    /******************
     * HELPER METHODS *
     ******************/
    
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
    
    /*********************
     * SHOUT OUT METHODS *
     *********************/
    
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
        
        // Prompt user for selection while input is invalid
        do {
            
            // Display message list
            getCannedMessages();
        
            // Prompt user for input
            System.out.print("Please enter the number of the message you "
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
                " " + adverbs.get(getRandomNumber(listLength)) + ".";
        
        // Return random message
        return message;
    } 
}
