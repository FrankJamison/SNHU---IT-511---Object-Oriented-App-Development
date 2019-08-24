/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usingstrings;

// Import the scanner class from the java.util package
import java.util.Scanner;

/**
 *
 * @author frank
 */
public class UsingStrings {

    /* Get and return word from user */
    public static String getWord (String type) {
        // Create scanner object
        Scanner reader = new Scanner(System.in);
        
        // Create boolean variable for English words.
        boolean isEnglishWord;
        
        // String variable to hold user input
        String input;
        
        do {
            // Prompt user for word
            System.out.printf("Please enter a(n) %s: ", type);
            
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
    
    /* Capitalize word */
    public static String capitalizeWord(String word) {
        // Capitalize first letter of sentence
        return word.substring(0, 1).toUpperCase() + 
                word.substring(1).toLowerCase();
    }
    
    /* Make word lowercase */
    public static String lowercaseWord(String word) {
        // Make word all lowercase
        return word.toLowerCase();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Get words from user
        String subject = getWord("subject");
        String verb = getWord("verb");
        String adjective = getWord("adjective");
        String object = getWord("object");
        String adverb = getWord("adverb");
        
        // Capitalize subject
        subject = capitalizeWord(subject);
        
        // Make remaining words all lowercase
        verb = lowercaseWord(verb);
        adjective = lowercaseWord(adjective);
        object = lowercaseWord(object);
        adverb = lowercaseWord(adverb);
        
        // Display sentence
        System.out.printf("\n%s %s %s %s %s.\n\n", 
                subject, verb, adjective, object, adverb);
    }
    
}
