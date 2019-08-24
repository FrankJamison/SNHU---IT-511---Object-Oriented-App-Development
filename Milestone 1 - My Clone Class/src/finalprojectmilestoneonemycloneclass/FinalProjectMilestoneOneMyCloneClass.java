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

public class FinalProjectMilestoneOneMyCloneClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* Create Object */
        MyClone frank = new MyClone();
        
        /* Set Clone Instance Variables */
        frank.setFirstName("Frank");            // Sets clone first name
        frank.setLastName("Jamison");           // Sets clone last name
        frank.setAge(47);                       // Sets clone age
        frank.setGender("male");                // Sets clone gender
        frank.setHeight(65);                    // Sets clone height in inches
        frank.setWeight(192);                   // Sets clone weight in pounds
        frank.setHairColor("brown");            // Sets clone hair color
        frank.setEyeColor("brown");             // Sets clone eye color
        
        /* Display Clone Information */
        System.out.println("This clone's name is: " + 
                frank.getFirstName() + " " + 
                frank.getLastName());
        
        System.out.println("It is a " + 
                frank.getAge() + "-year-old " + 
                frank.getGender() + ".");
        
        System.out.println(frank.getFirstName() + 
                " is " + frank.getHeight() + 
                " inches tall and weighs " + 
                frank.getWeight() + " pounds.");
        
        System.out.println(frank.getFirstName() + 
                " has " + frank.getHairColor() + 
                " hair and " + frank.getEyeColor() + 
                " eyes.");
    }
    
}
