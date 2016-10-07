/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noniteration;

import java.util.Scanner;

/**
 *Class contains a recursive function which has been written iteratively 
 * @author paridhichoudhary
 */
public class Calculator {
    int m;
    
    /**
     *Function returns specific value if number supplied is <0,=0 or 1; otherwise goes into a loop to calculate value for each n, progressively to ultimately reach number n, asked for.
     * @param n
     * @return
     */
    public void thisIsIterative() // n is the number for which return has to be calculated
    {   
        Scanner input = new Scanner(System.in);
        int n;
        System.out.println("Please enter n: ");
        n = input.nextInt();// takes input of integer for which iterations is to be done
        if(n<=1)
        {
        if (n<0) //returns specific values if n <0; =0 or 1
            m = (-10);
        if(n==0)
            m = (2);
        if (n==1)
            m = (5);
        } 
        else 
        {
            int a=2, b = 5, x;// initializes a, b to values when n=0 and 1 which will be used to calculate value when n=2, which is then used for n=3 and so on until n asked for is reached
            for (int i=2;i<=n;i++)  // condition: starts at 2 because when n=1 or 0, we can return without this iteration
            { 
                x = a; //uses a temporary variable x to store value of a to re-use it for calculating new b
                a = b;// reassigns b's value to a before b's value is changed to the sum of present b and temporary
                b = b+3*x+2*i;
                m = b; 
            }
        }
        System.out.println(m);// returns the value after iterations
    } 
    

}