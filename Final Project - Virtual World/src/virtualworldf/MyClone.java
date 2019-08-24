/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualworldf;

import java.util.Scanner;

/**
 *
 * @author frank
 */
public class MyClone {
    private String firstName;               // First Name
    private String lastName;                // Last Name
    private int age;                        // Age in years
    private String gender;                  // Gender
    private int height;                     // Height in inches
    private int weight;                     // Weight in pounds
    private String hairColor;               // Hair color
    private String eyeColor;                // Eye color

    /* Constructors */
    
    // Default Constructor
    public MyClone() {
        this.setFirstName();
        this.setLastName();
        this.setAge();
        this.setGender();
        this.setHeight();
        this.setWeight();
        this.setHairColor();
        this.setEyeColor();
    }
    
    // Constructor for preset clone
    public MyClone(String preset) {
        if (preset == "Frank") {
            this.setFirstName("Frank");
            this.setLastName("Jamison");
            this.setAge(47);
            this.setGender("male");
            this.setHeight(65);
            this.setWeight(195);
            this.setHairColor("brown");
            this.setEyeColor("brown");
        }
        
        else {
            System.out.printf("\n%s is not a valid preset.\n\n");
        }
    }

    /* Get and return word from user */
    private static String getName (String type) {
        // Create scanner object
        Scanner reader = new Scanner(System.in);
        
        // Create boolean variable for English words.
        boolean isEnglishWord;
        
        // String variable to hold user input
        String input;
        
        do {
            // Prompt user for word
            System.out.printf("\nPlease enter your %s: ", type);
            
            // Store word in input variable
            input = reader.next();
            
            // Validate English Word...can contain apostophes
            isEnglishWord = input.matches("^[a-zA-Z]+('[a-zA-Z]+)?$");
            
            // If the input is not an English word...
            if(!isEnglishWord){
                // Display error message
                System.out.printf("\n%s is not an English word.\n", input);
            }
        } while (!isEnglishWord);
        
         // Return the input
        return input;
    }

    /* Get and return number from user */
    private static int getNumber (String type) {
        // Create scanner object
        Scanner reader = new Scanner(System.in);
        
        int maxNum;
        
        // Set maximum age limit
        if (type == "age") {
            maxNum = 150;
        }
        
        // Set maximum height limit
        else if (type == "height") {
            maxNum = 100;
        }
        
        // Set maximum weight limit
        else if (type == "weight") {
            maxNum = 1000;
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
            // Prompt user for word
            System.out.printf("\nPlease enter your %s", type);
            
            if(type == "age") {
                System.out.print(" in years: ");
            }
            
            else if (type == "height") {
                System.out.print(" in inches: ");
            }
            
            else if (type == "weight") {
                System.out.print(" in pounds: ");
            }
            
            else {
                System.out.print(": ");
            }
            
            // Store word in input variable
            input = reader.next();
            
            // Validate age between 1 and 150 years
            if (type == "age") {
                isInteger = input.matches("^([1-9]|[1-9][0-9]|"
                        + "1[0-4][0-9]|150)$");
            }
            
            // Validate height between 1 and 100 inches
            else if (type == "height") {
                isInteger = input.matches("^([1-9]|[1-9][0-9]|100)$");
            }

            // Validate weight between 1 and 1000 pounds
            else if (type == "weight") {
                isInteger = input.matches("^([1-9]|[1-9][0-9]|"
                        + "[1-9][0-9][0-9]|1000)$");
            }
            
            // Validate number as integer
            else {
                isInteger = input.matches("\\d+");
            }
            
            // If the input is not a number...
            if(!isInteger){
                // Display error message
                System.out.printf("\n%s is not a valid %s.\n", input, type);
                
                // Display valid range for age
                if (type == "age") {
                    System.out.printf("Valid range for %s is between "
                            + "1 and %s years.\n", type, maxNum);
                }
                
                // Display valid range for height
                else if (type == "height") {
                    System.out.printf("Valid range for %s is between "
                            + "1 and %s inches.\n", type, maxNum);
                }
                
                // Display valid range for weight
                else if (type == "weight") {
                    System.out.printf("Valid range for %s is between "
                            + "1 and %s pounds.\n", type, maxNum);
                }
                
                // Display valid range for weight
                else {
                    System.out.printf("Valid range is between "
                            + "1 and %s.\n", maxNum);
                }
            }
        } while (!isInteger);
        
         // Return the input
        return Integer.parseInt(input);
    }

    // Get and return gender/hair color/eye color selection
    private String getSelection(String type) {
        // Creates new scanner object
        Scanner reader = new Scanner(System.in);

        // Gender Array
        String [] gender = {"male", "female"};
        
        // Hair Color Array
        String [] hairColor = {"black", "brown", "blond", "auburn", "chestnut",
            "red", "gray", "white"};

        // Eye Color Array
        String [] eyeColor = {"amber", "blue", "brown", "gray", "green",
            "hazel", "red", "violet"};
       
        // Create boolean variable for integers.
        boolean isInteger = false;

        // String variable to hold user input
        String input = "";
        
        // String variable to hold user selection
        String selection = "";
        
        do {
            if (type == "gender") {
                for (int index = 0; index < gender.length; index++) {
                    System.out.printf("\n%d. %s", index + 1, gender[index]);
                }
            }
            
            if (type == "hair color") {
                for (int index = 0; index < hairColor.length; index++) {
                    System.out.printf("\n%d. %s", index + 1, hairColor[index]);
                }
            }

            if (type == "eye color") {
                for (int index = 0; index < eyeColor.length; index++) {
                    System.out.printf("\n%d. %s", index + 1, eyeColor[index]);
                }
            }

            // Prompt user for selection
            System.out.printf("\nPlease select your %s: ", type);
            
            // Store selection in input variable
            input = reader.next();
            
            if (type == "gender") {
                // Limit to 2 selections
                isInteger = input.matches("^[1-2]$");
            }
            
            if (type == "hair color" || type == "eye color") {
                // Limit to 8 selections
                isInteger = input.matches("^[1-8]$");
            }
            
            // If the input is not a number...
            if(!isInteger){
                // Display error message
                System.out.printf("\n%s is not a valid selection.\n", input);
            }
        } while (!isInteger); 
        
        if (type == "gender") {
            selection = gender[Integer.parseInt(input) - 1];
        }
        
        if (type == "hair color") {
            selection = hairColor[Integer.parseInt(input) - 1];
        }
        
        if (type == "eye color") {
            selection = eyeColor[Integer.parseInt(input) - 1];
        }
        
        // Return selection
        return selection;
    }

    /* Mutators */
    
    // Set first name as specified
    public void setFirstName(String cloneFirstName) {   
        this.firstName = cloneFirstName;
    }
    
    // Set first name
    public void setFirstName() {
        String cloneFirstName = getName("First Name");
        setFirstName(cloneFirstName);
    }
    
    // Set last name as specified
    public void setLastName(String cloneLastName) {
        this.lastName = cloneLastName;
    }
    
    // Set last name
    public void setLastName() {
        String cloneLastName = getName("Last Name");
        setLastName(cloneLastName);
    }
    
    // Set Age as Specified
    public void setAge(int cloneAge) {
        this.age = cloneAge;
    }
    
    // Set Age
    public void setAge() {
        int cloneAge = getNumber("age");
        setAge(cloneAge);
    }
    
    // Set Gender as specified
    public void setGender(String cloneGender) {
        this.gender = cloneGender;
    }
    
    // Set Gender
    public void setGender() {
        String cloneGender = getSelection("gender");
        setGender(cloneGender);
    }

    // Set Height as Specified
    public void setHeight(int cloneHeight) {
        this.height = cloneHeight;
    }
    
    // Set Height
    public void setHeight() {
        int cloneHeight = getNumber("height");
        setHeight(cloneHeight);
    }

    // Set Weight as Specified
    public void setWeight(int cloneWeight) {
        this.weight = cloneWeight;
    }
    
    // Set Weight
    public void setWeight() {
        int cloneWeight = getNumber("weight");
        setWeight(cloneWeight);
    }

    // Set hair color as specified
    public void setHairColor(String cloneHairColor) {   // Sets clone hair color
        this.hairColor = cloneHairColor;
    }
    
    // Set hair color
    public void setHairColor () {
        String cloneHairColor = getSelection("hair color");
        setHairColor(cloneHairColor);
    }
    
    // Set eye color as specified
    public void setEyeColor(String cloneEyeColor) {     // Sets clone eye color
        eyeColor = cloneEyeColor;
    }

    // Set eye color
    public void setEyeColor () {
        String cloneEyeColor = getSelection("eye color");
        setEyeColor(cloneEyeColor);
    }
    
      /* Accessors */
    
    // Get first name
    public String getFirstName() {      
        return this.firstName;
    }
    
    // Get last name
    public String getLastName() {       
        return this.lastName;
    }
    
    // Get age
    public int getAge() {               
        return this.age;
    }
    
    // Get gender
    public String getGender() {         
        return this.gender;
    }
    
    // Get height
    public int getHeight() {            
        return this.height;
    }
    
    // Get weight
    public int getWeight() {            
        return this.weight;
    }
    
    // Get hair color
    public String getHairColor() {      
        return this.hairColor;
    }
    
    // Get eye color
    public String getEyeColor() {       
        return this.eyeColor;
    }
    
    // Introduction
    public void introduction() {
        System.out.printf("Hello world! My name is %s %s. ", this.getFirstName(),
                this.getLastName());
        System.out.printf("I am a %d-year-old %s IT Graduate student at SNHU. ", 
                this.getAge(), this.getGender());
        System.out.printf("I have %s hair and %s eyes. ", this.getHairColor(), 
                this.getEyeColor());
        System.out.printf("I am %d inches tall and weigh %d pounds.\n", 
                this.getHeight(), this.getWeight());
        System.out.print("I have a loving wife named Julie and 4 grown children "
                + "named Sarah (25), Jessica (24), Brandon (22), and "
                + "Joshua (22).\n");
        System.out.print("I also have 3 dogs named Charger, Baby, and Moxxi. "     
                + "and 4 cats named Isabella, Shadow, Tanner, and Ollie.\n\n");
    }
    
        // Introduction
    public void confirmation() {
        System.out.printf("\nTo confirm, your name is %s %s. ", this.getFirstName(),
                this.getLastName());
        System.out.printf("You are a %d-year-old %s. ", 
                this.getAge(), this.getGender());
        System.out.printf("You have %s hair and %s eyes. ", this.getHairColor(), 
                this.getEyeColor());
        System.out.printf("You are %d inches tall and weigh %d pounds.\n\n", 
                this.getHeight(), this.getWeight());
    }

}