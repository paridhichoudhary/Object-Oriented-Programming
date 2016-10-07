/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordplay;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *Takes a 5 lettered word and returns all possible three Letter combinations from it
 * @author paridhichoudhary
 */
public class WordPlay 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Letter word = new Letter();// creates object of the class Letter to access its functions
        word.getThreeLetter();//prints all possible three Letter words and the number of words printed
 
    }
    
}