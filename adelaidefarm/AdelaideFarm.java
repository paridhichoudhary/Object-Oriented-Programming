/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adelaidefarm;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 Creates a FreshBox object with tray elements randomly chosen from 5 options, then providing option to user to substitute any number of elements they want but one at a time
 * After substitution is complete by the user, the class gives list of all elements in the tray with any recipes if present.
 * 
 * Parameters: none
 * 
 * Return: List of all tray elements with recipes
 */
public class AdelaideFarm {

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        FreshBox box = new FreshBox();// Creating Freshbox object using its constructor
        
        //Printing the elements of the box
        box.displayContents(box);// Display contenst of the box
        box.modifyTray(box);//modifies tray elements based on user choices
        box.checkContents(box);// Check the trays of the box, add recipes if there are more than 1 element of each type
        box.displayContents(box);// Display contents of the box 
        
        
        
    }
    
}
