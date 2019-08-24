/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualworldh8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author frank
 */
public class RandomMessageGenerator {
    
    /* Instance Variables */
    private ArrayList<String> subjects;     // ArrayList to hold subjects
    private ArrayList<String> verbs;        // ArrayList to hold verbs
    private ArrayList<String> adjectives;   // ArrayList to hold adjectives
    private ArrayList<String> objects;      // ArrayList to hold objects
    private ArrayList<String> adverbs;      // ArrayList to hold adverbs
    private int listLength;                 // ArrayList length
    
    /* Constructor with listLength argument */
    public RandomMessageGenerator (int numWords) {
        
        // Create new ArrayLists
        subjects = new ArrayList<>();
        verbs = new ArrayList<>();
        adjectives = new ArrayList<>();
        objects = new ArrayList<>();
        adverbs = new ArrayList<>();
        
        // Set list length
        listLength = numWords;
        
        //Populate ArrayLists
        setList(subjects, "subject");
        setList(verbs, "verb");
        setList(adjectives, "adjective");
        setList(objects, "object");
        setList(adverbs, "adverb");
    }
    
    /* Get and return word from user */
    private static String getWord (String type, int count) {
        
        // Create scanner object
        Scanner reader = new Scanner(System.in);
        
        // Create boolean variable for English words.
        boolean isEnglishWord;
        
        // String variable to hold user input
        String input;
        
        // Repeat loop while input is not an English word 
        do {
            
            // Prompt user for word
            System.out.printf("Please enter %s %d: ", type, count);
            
            // Store word in input variable
            input = reader.next();
            
            // Validate English Word...can contain apostophes
            isEnglishWord = input.matches("^[a-zA-Z]+('[a-zA-Z]+)?$");
            
            // If the input is not an English word...
            if(!isEnglishWord){
                
                // Display error message
                System.out.printf("%s is not an English word.\n\n", input);
            }
        } while (!isEnglishWord);
        
         // Return the input
        return input;
    }
    
    // Set the contents of a list
    private void setList(ArrayList<String> list, String type) {
        
        // Display instructions
        System.out.printf("\nTo populate the %ss list, please enter %d "
                + "%ss\n\n", type, listLength, type);

        // Add number of words to list equal to listLength
        for (int index = 0; index < listLength; index++) {
            
            // Get a word of the specified type
            String word = getWord(type, index + 1);
            
            // Add word to list
            list.add(word);
        }
    }
    
    // Displays messages in messages ArrayList
    private void getList(ArrayList<String> list) {
        
        // Message index variable
        int index = 0;
        
        // Display words in ArrayList with numbers
        for (String word : list) {
            System.out.printf("%d. %s\n", ++index, word);
        }
    }
    
    private int getRandomNumber(int numElements) {
        
        // Random number integer variable
        int randomNumber = -1;
        
        // Generate and validate random number 
        do {
            randomNumber = (int) (Math.random() * numElements);
        } while (randomNumber < 0 || randomNumber >= numElements);
        
        // Return random number
        return randomNumber;
    }
    
    // Return a random message
    public String shoutOutRandomMessage() {
        
        // Build random message
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
