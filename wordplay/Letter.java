/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordplay;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Provides function to get a specific Letter from an array and creating array after removing a specific character from the parent array
 * @author paridhichoudhary
 */
public class Letter 
{
    Scanner input = new Scanner(System.in);
    
    public void getThreeLetter()
    {
        System.out.printf("Please enter a 5 lettered word: ");
        String wordInit = input.next();// takes input of the 5 Letter word
        
        String finalWord; //3 Letter word made in each iteration
        
        ArrayList<String> finalArray = new ArrayList();//final_array containing all possible 3 Letter words
        
        char[] letters = wordInit.toCharArray();// stores all characters of inputted word in an array
        
        if (wordInit.length()==5)// error handling: checks if the word entered by user is 5 lettered or not
        {
        for (int i=0;i<letters.length;i++)//uses 2 nested for loops inside a for loop to iterate through all combination of 3 characters
        {
            char firstLetter = letters[i];// first_letter at ith location is picked up
            
            char[] lettersNew = getArray(letters, firstLetter, i);// the letter picked up has to be removed from the array so its not picked up again, hence calling getArray function
            
            for (int j=0;j<lettersNew.length;j++)
            {
                char secondLetter = lettersNew[j];// repeats above steps for nested loop to pick second Letter
                
                char[] lettersNew2 = getArray(lettersNew, secondLetter, j);// creates another array after removing second Letter picked in above step
                
                for (int k=0;k<lettersNew2.length;k++)
                {
                    char thirdLetter = lettersNew2[k];//picks third Letter for the word
                    
                    finalWord = Character.toString(firstLetter) + Character.toString(secondLetter) + Character.toString(thirdLetter);// creates string out of the three letters
                    
                    finalArray.add(finalWord);//adds the string to the final_array
                }
            }
            
        }
        System.out.println(finalArray.toString()); // prints the array together
        System.out.println(finalArray.size()); // counts the number of words made out of the array
        }
        else
        {
            System.out.println("Please enter a valid 5 letter word.");// error handling: If user inputs word having less or more than 5 characters
        }
    }

    
    /**
     *Returns array having characters accept one which is asked to be removed
     * @param a: parent character array out of which char c has to be removed
     * @param c: Character to be removed from given array
     * @param i: position of Letter chosen in the previous loop determining which characters to keep and which to be shifted
     * @return: returns the new array with that character removed
     */
    public char[] getArray(char[] a,char c,int i)
    {
        char[] lettersNew = new char[a.length-1];//reduces the size of array by 1
        int counter = 0,l; 
        for (l=0;l<a.length;l++)
            {
                if(l<i && counter < lettersNew.length)//error handling: since letters_new is smaller in size than letters, l should not be greater than letters_new length
                {
                    
                    lettersNew[counter] = a[l];//if the Letter removed in the previous step is at ith location, all letters from 0 to i-1 are picked into new array as it is
                    
                    counter +=1;
                }
                else if(l>=i && counter < lettersNew.length)//error handling: since letters_new is smaller in size than letters, l should not be greater than letters_new length
                {
                    lettersNew[counter] = a[l+1];//if the Letter removed in the previous step is at ith location, all letters from i+1 to letters_new.length will shift one place left as we delete a character from the array
                    counter +=1;
                }   
                else {
                }
            }
        return lettersNew;// returns letters_new array
    }
     
}
