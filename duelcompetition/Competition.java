/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author paridhichoudhary
 */
public class Competition {

    /**
     * Class displays results of two different strategies of fights between three wizards
     * First it displays how many duels each wizard wins when the 1st Strategy is adopted
     * Second it displays how many duels each wizards wins when the 2nd strategy is adopted
     * Then, it compares the results of the two strategies
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Display display = new Display(); // Creating object of display class to call display functions
        Duel tempMatch = new Duel(); // Creating an object of Duel class to get current wizards which are to compete
        display.displayDuelResults(display.multipleDuels(10000, tempMatch.currentWizards()),tempMatch.currentWizards()); // displays the results of 1st strategy 
        display.displayDuelResults(display.multipleDuelsAlternateStrategy(10000, tempMatch.currentWizards()),tempMatch.currentWizards()); //displays the results of 2nd strategy 
        display.CompareDuelResults(tempMatch.currentWizards()); //Compare duels  with different strategies and answer specific questions
    }
    
}
