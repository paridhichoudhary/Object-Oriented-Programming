/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adelaidefarm;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *Creates a box with a Tray array with 4 tray objects and 1 String ArrayList and 1 list of all possible options of fruits and vegetables
 * This class comes with a constructor which requires names of all elements to be kept in 4 trays
 * Provides functions to set and get recipes from the box, modify trays in the box
 * Provides functions to checkContents of trays in the box and adds recipes automatically if required
 * Provides functions to display contents in lines and as a string
 */
public class FreshBox {
    
    /**
     *Introduces a 4-tray array which will have 4 tray objects
     * Introduces 1 attribute of recipe String ArrayList to keep multiple recipes if required
     * Introduces a list of all options of fruits and vegetables available to the user
     */
    public static ArrayList<String> recipe = new ArrayList<>();
    Tray[] trays = new Tray[5];
    String[] list = new String[5];
    
    /**
     *Makes a list of all possible options for fruits and vegetables
     * @return
     */
    public String[] getOptionsList()// defines a list with all the options of fruits and vegetables
    {
        list[0] = "Banana";
        list[1] = "Apple";
        list[2] = "Cauliflower";
        list[3] = "Potato";
        list[4] = "Capsicum";
        return list;
    }
    
    /**
     *
     * this adds any recipe,which is passed as a string argument, to the arraylist recipe
     * @param s
     */
    public final void setRecipe(String s)
    {
        recipe.add(s);
    }
    
    /**
     *
     * this provides recipe in the form of a string but in two different lines, if there are two recipes
     * @return: String containing one or two recipes
     */
    public String getRecipe()
    {
        int i;
        StringBuilder s= new StringBuilder();
        for (i=0;i<recipe.size();i++)
        {
            s.append(recipe.get(i));// if more than 1 recipe is present, 2nd recipe gets added in next Line
            s.append("\n");

        }
        return s.toString();
    }
    
    /**
     *takes the recipe array and returns a string from it (Difference from getRecipe: returns both recipes in the same line whereas latter returns them in 2 different lines)
     * @return: returns recipes in the form of a string
     */
    public String getRecipeString()
    {
        int i;
        StringBuilder s= new StringBuilder();// String Builder used to use append function
        for (i=0;i<recipe.size();i++)
        {
            s.append(recipe.get(i));
            s.append(" ");// appends space instead of a new line as compared to previous one

        }
        return s.toString();
    }
    
    /**
     *Takes FreshBox and Fruit name to be set and modifies trays in a box
     * @param b: FreshBox whose trays are to be modified
     * @param t:  Name of the tray which has to be changed
     * @param s: Name of the fruit which has to be kept instead of element which is being  modified
     */
    public void traySelector(FreshBox b,String t, String s)
    {
        for (int i=0;i<4;i++)
        {
            
            if(t.contentEquals(trays[i].getName()))
                trays[i].setFruitName(s);
        }
    }
    
    /**
     *Asks user if they want to change an element of the tray and change the element to the fruit name provided
     *Keeps asking the user if they want to change any more elements till they enter 'No'
     * @param b: FreshBox for which tray elements are to be changed
     */
    public void modifyTray(FreshBox b)
    {   
        int n=0;
        Scanner input = new Scanner(System.in);
        String ans = "";// Initializes the string to use in the first do loop
        String[] list1 = getOptionsList();// creates list of all fruits and vegetables options
        do
        {
        System.out.println("If you want to change any element of tray, please enter 'Yes', else press 'No':");// After every substitution, ask user again if they want to change any more tray
        ans = input.nextLine();// inputs user's choice of Yes or No from the question asked
        switch (ans) {
            case "Yes": 
                System.out.println("Which tray is to be modified?(Eg: Tray 4 for Tray 4): "); //takes input for the tray for which element has to be modified
                String t = input.nextLine(); // uses nextLine so that the pointer goes in next line before it is called again
                System.out.println("Which fruit/vegetable do you want to keep, you can choose from: " + Arrays.toString(list)); // takes input from user for the element to be added and providing the option to choose from
                String s = input.nextLine();
                if (list1[0].equals(s)||list1[1].equals(s)||list1[2].equals(s)||list1[3].equals(s)||list1[4].equals(s)) // Error Handling: checks whether input provided by user is one of the provided options
                {
                    traySelector(b,t,s);
                    break;
                }
                else
                {
                    System.out.println("Invalid Input"); //If ErrorCheck fails, give out "Invalid Input" statement 
                    continue;
                }
            case "No":
                System.out.println("Printing contents....");// If user enters No, break the loop and print Freshbox contents 
                break;
            default:
                System.out.println("Please enter a valid input.");//If user enters neither Yes not No in the first input
                continue; 
        }
        } while(ans.equals("Yes")); //uses a while loop to iterate modification process till the user says no
    }
    
    /**
     *Constructor to make an object of FreshBox class
     * 
     */
    public FreshBox ()
    {
        Random rand = new Random();
        String[] list1 = getOptionsList();
        for (int i=0;i<4;i++)
        {
            trays[i] = new Tray();
            trays[i].setName("Tray "+(i+1));
            trays[i].setFruitName(list1[rand.nextInt(5)]);
        }
    }
    
    /**
     *Checks contents of the Freshbox and if any 2 or more trays have same fruit/vegetable, a relevant recipe is added to the FreshBox
     * @param b: FreshBox which is to be checked
     */
    public void checkContents(FreshBox b)  
    {
        String list[] = new String[4];// adds all elements of trays in a list to check their match with known elements
        for (int i=0;i<4;i++)
        {
            list[i] = b.trays[i].getFruitName(); // Stores names of all current items of FreshBox in a list
        }
        
        Arrays.sort(list);// sorts the list alphabatically so that to compare two adjacent names for match eg.) Banana and Banana will be next to each other after we sort array which will turn check into true
        
        int i=0;
        
        while(i<3)// creates a while loop so it checks if 2 elements are present in any tray, as there are only 4 trays
        {
            if(list[i].contentEquals(list[i+1]))
            {
                if (list[i].contentEquals("Banana") && (!recipe.contains("How to make banana shake?")))// if there are 2 Bananas present, but the banana recipe is already there, there is no need to add it to recipe list
                    b.setRecipe("How to make banana shake?");
                
                if (list[i].contentEquals("Potato") && (!recipe.contains("How to make Potato Flatbread?")))
                    b.setRecipe("How to make Potato Flatbread?");
                
                if (list[i].contentEquals("Capsicum") && (!recipe.contains("How to make Chilly Paneer with capsicum?")))
                    b.setRecipe("How to make Chilly Paneer with capsicum?");
                
                if (list[i].contentEquals("Apple") && (!recipe.contains("How to make Apple Pie?")))
                    b.setRecipe("How to make Apple Pie?");
                
                if (list[i].contentEquals("Cauliflower") && (!recipe.contains("How to make mix vegetable curry?")))
                    b.setRecipe("How to make mix vegetable curry?");
            }
            
            i+=1;// increments i for while loop
        }
    }
    
    /**
     *Displays elements of a FreshBox in the form of a string
     * @param b: FreshBox of whose elements are to be displayed in form of a String
     * @return
     */
    public String toString(FreshBox b)
    {   
        String s="";// Initializes the string
        for (int i=0;i<4;i++)
        {
           s = s +b.trays[i].getFruitName() + ", "; // Iterates through the trays of FreshBox and add fruit names
        }
        s = s + b.getRecipeString();// adds all elements at the end and using getRecipeString instead of getRecipe to print everything in one line
        return s;
    }
    
    /**
     *Displays contents of the freshBox one by one along with recipes
     * @param b
     */
    public void displayContents(FreshBox b)
    {
        System.out.println("The Freshbox currently has the following items: ");
        for (int i=0;i<4;i++)
        {
            System.out.println(b.trays[i].getFruitName());// Iterates through the trays of FreshBox and add fruit names
        }
        System.out.println(b.getRecipe());// prints recipe with a new line in between
    }
    
}
