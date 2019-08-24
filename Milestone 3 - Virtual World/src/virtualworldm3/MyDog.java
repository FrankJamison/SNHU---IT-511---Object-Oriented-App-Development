/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualworldm3;

import java.util.Scanner;

/**
 *
 * @author frank
 */
class MyDog {
    private String name;                    // Name
    private String breed;                   // Breed
    private int age;                        // Age in years
    private String gender;                  // Gender
    private String size;                    // Size
    private int weight;                     // Weight in pounds
    private String hairColor;               // Hair color
    private String eyeColor;                // Eye color
    
    // Default Constructor
    public MyDog() {
        this.setName();
        this.setBreed();
        this.setAge();
        this.setGender();
        this.setSize();
        this.setWeight();
        this.setHairColor();
        this.setEyeColor();
        
        this.introduction();
    }

    // Constructor for Frank's Dog Baby
    public MyDog(String name) {
        if (name == "Baby") {
            this.setName("Baby");
            this.setBreed("mutt");
            this.setAge(4);
            this.setGender("female");
            this.setSize("large");
            this.setWeight(60);
            this.setHairColor("brown");
            this.setEyeColor("brown");
            
            this.introduction();
        }
        
    }

    /* Get and return word from user */
    private static String getWord (String type) {
        
        // Create scanner object
        Scanner reader = new Scanner(System.in);
        
        // Create boolean variable for English words.
        boolean isEnglishWord;
        
        // String variable to hold user input
        String input;
        
        do {
            // Prompt user for word
            System.out.printf("Please enter your dog's %s: ", type);
            
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
    
    /* Get and return number from user */
    private static int getNumber (String type) {
        // Create scanner object
        Scanner reader = new Scanner(System.in);
        
        int maxNum;
        
        // Set maximum age limit
        if (type == "age") {
            maxNum = 20;
        }
        
        // Set maximum weight limit
        else if (type == "weight") {
            maxNum = 300;
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
            System.out.printf("Please enter your dog's %s", type);
            
            if(type == "age") {
                System.out.print(" in years: ");
            }
            
            else if (type == "weight") {
                System.out.print(" in pounds: ");
            }
            
            else {
                System.out.print(": ");
            }
            
            // Store word in input variable
            input = reader.next();
            
            // Validate age between 1 and 20 years
            if (type == "age") {
                isInteger = input.matches("^([1-9]|1[0-9]|20)$");
            }
            
            // Validate weight between 1 and 300 pounds
            else if (type == "weight") {
                isInteger = input.matches("^([1-9]|[1-9][0-9]|"
                        + "[1-2][0-9][0-9]|300)$");
            }
            
            // Validate number as integer
            else {
                isInteger = input.matches("\\d+");
            }
            
            // If the input is not a number...
            if(!isInteger){
                // Display error message
                System.out.printf("\n%s is not a valid dog's %s.\n", 
                        input, type);
                
                // Display valid range for age
                if (type == "age") {
                    System.out.printf("Valid range for a dog's %s is between "
                            + "1 and %s years.\n\n", type, maxNum);
                }
                
                // Display valid range for weight
                else if (type == "weight") {
                    System.out.printf("Valid range for a dog's %s is between "
                            + "1 and %s pounds.\n\n", type, maxNum);
                }
                
                // Display valid range for weight
                else {
                    System.out.printf("Valid range is between "
                            + "1 and %s.\n\n", maxNum);
                }
            }
        } while (!isInteger);
        
         // Return the input
        return Integer.parseInt(input);
    }
    
    // Get and return size/gender/hair color/eye color selection
    private String getSelection(String type) {
        
        // Creates new scanner object
        Scanner reader = new Scanner(System.in);

        // Gender Array
        String [] gender = {"male", "female"};
        
        // Size Array
        String [] size = {"small", "medium", "large"};
        
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
                    System.out.printf("%d. %s\n", index + 1, gender[index]);
                }
            }
            
            if (type == "size") {
                for (int index = 0; index < size.length; index++) {
                    System.out.printf("%d. %s\n", index + 1, size[index]);
                }
            }
            
            if (type == "hair color") {
                for (int index = 0; index < hairColor.length; index++) {
                    System.out.printf("%d. %s\n", index + 1, hairColor[index]);
                }
            }

            if (type == "eye color") {
                for (int index = 0; index < eyeColor.length; index++) {
                    System.out.printf("%d. %s\n", index + 1, eyeColor[index]);
                }
            }

            // Prompt user for selection
            System.out.printf("\nPlease select your dog's %s: ", type);
            
            // Store selection in input variable
            input = reader.next();
            
            if (type == "gender") {
                // Limit to 2 selections
                isInteger = input.matches("^[1-2]$");
            }
            
            if (type == "size") {
                // Limit to 3 selections
                isInteger = input.matches("^[1-3]$");
            }
            
            if (type == "hair color" || type == "eye color") {
                // Limit to 8 selections
                isInteger = input.matches("^[1-8]$");
            }
            
            // If the input is not a number...
            if(!isInteger){
                // Display error message
                System.out.printf("\n%s is not a valid selection.\n\n", input);
            }
        } while (!isInteger); 
        
        if (type == "gender") {
            selection = gender[Integer.parseInt(input) - 1];
        }
        
        if (type == "size") {
            selection = size[Integer.parseInt(input) - 1];
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
    
    // Set name as specified
    public void setName(String cloneName) {   
        this.name = cloneName;
    }
    
    // Set name
    public void setName() {
        String cloneName = this.getWord("name");
        this.setName(cloneName);
    }
    
    // Set breed as specified
    public void setBreed(String cloneBreed) {   
        this.breed = cloneBreed;
    }
    
    // Set breed name
    public void setBreed() {
        String cloneBreed = this.getWord("breed");
        this.setBreed(cloneBreed);
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
    
    // Set size as specified
    public void setSize(String cloneSize) {
        this.size = cloneSize;
    }
    
    // Set Gender
    public void setSize() {
        String cloneSize = getSelection("size");
        setSize(cloneSize);
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
    
    // Get name
    public String getName() {   
        return this.name;
    }
    
    // Get breed
    public String getBreed() {   
        return this.breed;
    }
    
    // Get breed
    public int getAge() {   
        return this.age;
    }
    
    // Get breed
    public String getGender() {   
        return this.gender;
    }
    
    // Get breed
    public String getSize() {   
        return this.size;
    }
    
    // Get breed
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
    private void introduction() {
        System.out.printf("This is my dog %s. ", this.getName());
        System.out.printf("%s is a %d-year-old %s. ", 
                this.getName(), this.getAge(), this.getBreed());
        System.out.printf("%s has %s hair and %s eyes. ", this.getName(), 
                this.getHairColor(), this.getEyeColor());
        System.out.printf("%s is a %s-size dog and weighs %d pounds.\n", 
                this.getName(), this.getSize(), this.getWeight());
        System.out.printf("%s always likes to sleep next to me and gets "
                + "excited to see me whenever I come home.\n\n", 
                this.getName());
    }
}
