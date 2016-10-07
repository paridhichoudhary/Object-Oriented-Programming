/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceroll;
import java.util.Scanner;
import java.util.Hashtable;

/**
 *Class presents bar graph of frequencies of sum of outcome of 2 dice-rolls together when rolled n times
 * @author paridhichoudhary
 */
public class DiceRoll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Dice d = new Dice();//creates an object of the dice class to get sum of outcome of dice rolls for n rolls
        Utilities graph = new Utilities();  //creates an object of Utility class to access frequency count and display graph functions
        graph.displayGraph(d.roll());//displays graph using displaygraph function of utility class


    }
    
}
