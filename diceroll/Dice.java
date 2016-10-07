/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceroll;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;
/**
 *Creates a dice object with roll sum as the sum of dice roll outcomes on two dices
 * @author paridhichoudhary
 */
public class Dice {
    Random rand;
    int d1,d2,i;
    
    Scanner input = new Scanner(System.in);
    Hashtable rollSum = new Hashtable();//Creates a dictionary of sum of 2 dice rolls with key as roll-count and value as sum corresponding to that roll
    
    /**
     *
     * @param 
     * @return
     */
    public Hashtable roll()
    {
        int n;
        System.out.println("Please enter number of rolls: ");// takes input of number of rolls
        
        n = input.nextInt();
        input.nextLine();// error handling: inputs a line to be able to provide an input a new line next time
        
        if(n<=0) // error handling: if n is inputted as 0 or less than 0, ask to input a valid number
            System.out.println("Please enter a valid value for n i.e. an integer >0");
        else
            for (i=1; i<=n;i++)
            {
            rand =  new Random();//uses random number to simulate dice roll's probability
            d1 = 1+ rand.nextInt(6);//adds 1 as rand.nextInt generates random numbers between 1 to 5
            d2 = 1+ rand.nextInt(6);//simulates dice roll for second dice as well
            rollSum.put("roll"+i, d1+d2);//Putting the key and its corresponding value in the dictionary
            }
        
        return rollSum;
    }
    
    
}
