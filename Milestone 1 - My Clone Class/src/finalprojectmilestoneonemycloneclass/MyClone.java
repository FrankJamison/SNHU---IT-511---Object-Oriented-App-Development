/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectmilestoneonemycloneclass;

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
    
    /* Mutators */
    
    public void setFirstName(String cloneFirstName) {   // Sets clone first name
        firstName = cloneFirstName;
    }
    
    public void setLastName(String cloneLastName) {     // Sets clone last name
        lastName = cloneLastName;
    }
    
    public void setAge(int cloneAge) {                  // Sets clone age
        age = cloneAge;
    }
    
    public void setGender(String cloneGender) {         // Sets clone gender
        gender = cloneGender;
    }
    
    public void setHeight(int cloneHeight) {            // Sets clone height
        height = cloneHeight;
    }
    
    public void setWeight(int cloneWeight) {            // Sets clone weight
        weight = cloneWeight;
    }
    
    public void setHairColor(String cloneHairColor) {   // Sets clone hair color
        hairColor = cloneHairColor;
    }
    
    public void setEyeColor(String cloneEyeColor) {     // Sets clone eye color
        eyeColor = cloneEyeColor;
    }
    
    /* Accessors */
    
    public String getFirstName() {      // Gets clone first name
        return firstName;
    }
    
    public String getLastName() {       // Gets clone last name
        return lastName;
    }
    
    public int getAge() {               // Gets clone age
        return age;
    }
    
    public String getGender() {         // Gets clone gender
        return gender;
    }
    
    public int getHeight() {            // Gets clone height
        return height;
    }
    
    public int getWeight() {            // Gets clone weight
        return weight;
    }
    
    public String getHairColor() {      // Gets clone hair color
        return hairColor;
    }
    
    public String getEyeColor() {       // Gets clone eye color
        return eyeColor;
    }
}

