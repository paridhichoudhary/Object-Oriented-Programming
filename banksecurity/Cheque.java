/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksecurity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 *Class takes in Cash String, converts into cash amount (double type) and provides a string representing the same amount
 * @author paridhichoudhary
 */
public class Cheque {

    /**
     * cash value: type double
     */
    public double cash;

    /**
     *cash value: type String
     */
    public String cashString;

    /**
     * Constant arrays to get corresponding name for each tens digits
     */    
    private static final String[] numTens = {
        "",
        "TEN",
        "TWENTY",
        "THIRTY",
        "FORTY",
        "FIFTY",
        "SIXTY",
        "SEVENTY",
        "EIGHTY",
        "NINETY"
    };
    
    /**
     * Constant arrays to get corresponding name for each digit up till twenty
     */
    private static final String[] numBelowTwenty = {
        "",
        "ONE",
        "TWO",
        "THREE",
        "FOUR",
        "FIVE",
        "SIX",
        "SEVEN",
        "EIGHT",
        "NINE",
        "TEN",
        "ELEVEN",
        "TWELVE",
        "THIRTEEN",
        "FOURTEEN",
        "FIFTEEN",
        "SIXTEEN",
        "SEVENTEEN",
        "EIGHTEEN",
        "NINETEEN"
    };
    
    Scanner input = new Scanner(System.in); // Scanner variable to get all inputs
    
    /**
     *Get function to extract cash value : type double from this class
     * @return cash value: double
     */
    public double getCash()
    {
        return cash;
    }
    
    /**
     *Method to break cash string into before and after decimal and converting them into integers
     *Error Handler: If the user puts more than 2 digits after decimal, he is asked to enter the whole number again.
     * @param cash: String cash which is to be broken into before decimal and after decimal
     * @return: array of long Integers, which will have before decimal number as 1st element and after decimal number as 2nd element
     */
    public long[] cashTokenizer(String cash)
    {   String beforeDecimal = ""; // Initializing before decimal strings
        String afterDecimal = "";// Initializing after decimal strings
        long[] cashDigits = new long[2]; // Initializing array of before and after decimal numbers as long
        do{
            cashDigits = new long[2]; // Re-defining cashDigits array in case user has to re-enter number because of error handler
            try {                       // Error Handler: to handle numbers if the user enters a number without decimal digits
            StringTokenizer str = new StringTokenizer(cash,"."); // Tokenizing cash string into two parts
            beforeDecimal = str.nextToken(); // Storing first token as before decimal
            cashDigits[0] = Long.parseLong(beforeDecimal); // Parsing the string token as a long integer to take up billion digit numbers
            afterDecimal = str.nextToken();// Storing second token as after decimal
            cashDigits[1] = Long.parseLong(afterDecimal); // Parsing the string token as a long integer to take  up long integers

            if (afterDecimal.length()>2){ // Error Handler: If the user enters more than 2 digits after decimal, it prints a message and calls the number entering code again
                System.out.println ("You can enter only 2 digits after decimal. Please re-enter number");
                setCash();
                beforeDecimal =""; // Re-Initializing before decimal number so that no previous memory is left
                afterDecimal =""; // Re-Initializing after decimal number so that no previous memory is left
            }
            else {
                break;
            }
            } catch(Exception e){
                System.out.printf("");
            }
        } while (afterDecimal.length()>2);
        
        return cashDigits;// returning array of cash digits
    }
    
    /**
     *Method asks user to enter a dollar amount and then uses CashTokenizer function to separate numbers before and after decimal
     * Cash double value is generated from those numbers and set to this class's field
     */
    public void setCash()
    {
        System.out.println("Please enter a dollar amount: ");
        String cashInit = input.nextLine();
        this.cashString = cashInit; // CashString is a string with digits
        long[] cashDigits = cashTokenizer(cashInit); // allotting before and after digits to an array to use them separately
        this.cash = cashDigits[0] + (cashDigits[1]/100); // setting cash value: double type using two digits
    }
    
    /**
     * Returns an array with first element as number after decimal, and all other elements as digits in number before decimal
     * @return an array of all digits in the number before decimal and first element as number after decimal
     */
    public List getCashDigits()
    {
        int n = 10;
        int b;
        long[] cashDigits = cashTokenizer(cashString);
        List<Integer> numbers = new ArrayList();
        long a = cashDigits[0];
        numbers.add((int)cashDigits[1]);
        do
        {
            b = (int)(a%n); // taking remainder to get last digit of the number
            numbers.add((int)b); // adding the remainder to the numbers array
            a=a/n;
        }
        while((int)a!=0); // A do while loop to keep extracting digits till the remainder is 0
        return numbers; // returns the numbers array
    }
    
    /**
     * This method takes in an Integer array with hundred's digit as last element and units digit as first element, and returns a string for that number
     * @param a: Integer array to be converted to String
     * @return: String representing that number
     */
    public String getLessThanThousandString(Integer[] a)
    {
        String strThree="";  // Initializing string for numbers below thousand
        int n = a.length-1; //First taking hundred's digit
        while(n>=0)
        {   
            if (n>1 && a[n]!= 0)
            {
            strThree = strThree + " "+numBelowTwenty[a[n]]+" hundred"; // If there are more than 2 digits in the array, hundred would be added to the string
            }
            else if (n==1 && a[n]<2)
            {
                int temp = a[n]*10+a[n-1];
                strThree = strThree+" " + numBelowTwenty[temp]; // If you have reached second integer of array, it is converted to a two digit number and, numbers below twenty are picked for names
            }
            else if (n==1 && a[n]>=2)
            {
                strThree = strThree +" "+ numTens[a[n]]+" "; // If the two digit number is greater than 20, converted to tens digit 
                if (n-1 == 0){
                    strThree = strThree +" "+ numBelowTwenty[a[n-1]]+" "; // for numbers like 23, three is added to twenty in this command
                }
            }
            else if (a.length==1 && n==0){
                strThree = strThree +" "+ numBelowTwenty[a[n]]+" "; // if its a single number array, number is directly picked in this command
            }
            n = n-1    ; // reducing n after every digit is studied
        }
        return strThree; // returning string for each 3 digit number
    }
    
    /**
     * Method calls getlessthanThousandString for each set of 3 integers possible in the number
     */
    public void  completeString()
    {
        List numbers = getCashDigits(); // Getting all digits in the number given
        String completeString = numbers.get(0) + "/100"; // Making string for the number after decimal
        List<Integer[]> numbers_matrix = new ArrayList(); // Initializing matrix that will have each of 3 integers possible in a number as elements
        int counter = 0; // Initializing a counter which will keep track of whether thousand, million, Billion is to be added after 3 digit string
        Integer[] temp;
        if ((numbers.size()-1)>2)
        {
            temp = new Integer[3]; // If there are more than 2 digits in number before decimal, making an Integer array of 3 for first set, because you can take maximum of 3
        }
        else
        {
            temp = new Integer[(numbers.size()-1)]; // If there are 2 or less digits in the number, it should not make 3 elements array 

        }
        for (int i=1;i<numbers.size();i++)
        {
            temp[counter]=(int) numbers.get(i); // adding integers to the temporary array
            counter+=1;
            if (counter==temp.length) // if the temp array length is equivalent to maximum possible set length, it should be added to the matrix. 
            {
            numbers_matrix.add(temp);
            counter =0;
            if ((numbers.size()-(i+1))>2) // Re-defining temp arrays based on digits remaining to be set into arrays now.
            {
                temp = new Integer[3];
            }
            else
            {
                temp = new Integer[(numbers.size()-(i+1))];
            }
            }
        }
        int n = 0;
        counter = 0; // Initializing counter to keep track of whether current set is for thousand, million or billion
        while(n<numbers_matrix.size())
        {
            boolean cond=false; // Checking if all the numbers in the current set are 0; if they are, that part of thousand, million , billion will not be added
            for (int i=0;i<numbers_matrix.get(n).length;i++){
                if (numbers_matrix.get(n)[i]!=0){
                    cond = true;
                }
            }
            if (counter == 0)
            {
                completeString = getLessThanThousandString(numbers_matrix.get(n))+" and "+completeString;
            }
            if (counter ==1 && cond) // if cond is true, that means atleast one of the digits in the array supplied was non-zero; this command will be executed
            {
                completeString = getLessThanThousandString(numbers_matrix.get(n))+" thousand "+completeString;
            }
            if (counter == 2 && cond) // if cond is true, that means atleast one of the digits in the array supplied was non-zero; this command will be executed
            {
                completeString = getLessThanThousandString(numbers_matrix.get(n))+" million "+completeString;
            }
            if (counter == 3 && cond) // if cond is true, that means atleast one of the digits in the array supplied was non-zero; this command will be executed
            {
                completeString = getLessThanThousandString(numbers_matrix.get(n))+" billion "+completeString;
            }
            n=n+1; // Incrementing n to read different sets of numbers with time
            if (n<numbers_matrix.size())
            {
                counter +=1; // Incrementing counter to satisfy conditions for thousand, million and billion alternatively
            }
        }
        
        System.out.println(completeString); // Printing the complete string
    }
    
    
            
}
