/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceroll;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *Compliments dice class with functions to be performed on the dictionary having sum of all rolls
 * Finds frequency of each sum in the rolls and plots it against the sum in a horizontal bar graph
 * @author paridhichoudhary
 */
public class Utilities {
    
    int i,j;
    Hashtable sumCount = new Hashtable();
    
    /**
     *Taking rollSum dictionary as input and calculating frequency of each sum 
     * @param h
     * @return: dictionary having possible sum as key and frequency of each sum as value
     */
    public Hashtable sumCount(Hashtable h)
    {
        for (i=1;i<=h.size();i++)// iterates through all elements of rollsum to count frequency
        {
            Object key = h.get("roll"+i);// taking the key to calculate frequency against each key
            if(sumCount.containsKey(key))// if the sum is already present in the dictionary, increment its frequency by 1 else add a new key to the dictionary
            {
               sumCount.replace(key,sumCount.get(key),(int) sumCount.get(key)+1); 
            }
            else
            {
                sumCount.put(key,1);
            }
        }
        
        int[] keys = hashtableToArray(sumCount);// converts keys of dictionary to an array to use sorting abilities
        
        for(i=0;i<keys.length;i++)// replaces all frequencies by percentage of rolls so as to limit number of stars
        {
            sumCount.replace(keys[i],sumCount.get(keys[i]),((int) sumCount.get(keys[i])*100)/h.size());
        }
         
        return sumCount;// returns roll sum frequency dictionary
    }
    
    /**
     *Converting a KeySet of a dictionary to an array of keys; this function helps us exploit some Array functions like sort
     * @param h: dictionary of which keyset has to be converted to an array
     * @return the array having keys
     */
    public int[] hashtableToArray(Hashtable h)
    {
        Iterator itr = h.keySet().iterator();//creates iterator object to iterate through keyset
        int[] keys = new int[h.keySet().size()];
        int counter =0;
        while(itr.hasNext())
        {
            Object element = itr.next();
            int value = (int) element;
            keys[counter] = value; // adds value of keyset object of dictionary to key arrays 
            counter+=1;
        }
        return keys;
                
    }
    
    /**
     * Displays graph with all possible sums in dice rolls and their frequency as a percentage of total rolls (frequency is represented by stars)
     * @param h
     */
    public void displayGraph(Hashtable h)
    {   
        sumCount = sumCount(h);
        int[] keys = hashtableToArray(sumCount);// converting hashtable object's keyset to an array
        Arrays.sort(keys);// sorts keys to display in an increasing order 
        System.out.println("\n\n\n\n"+"Below graph shows frequency(x-axis) of sum(y-axis) in each dice roll");// initiates printing of the bar graph
        for (i=0;i<keys.length;i++)//iterates through elements of frequency dictionary to print bar graph
        {   
            String star = "*";
            for (j=0;j< (int) sumCount.get(keys[i]);j++)
            {
                star = star + "*";// creates a string of stars based on frequency
            }
            System.out.printf("%2d%s%s%n",keys[i],"| ",star);// prints String of stars along with sum 
        }
    }
    
}
