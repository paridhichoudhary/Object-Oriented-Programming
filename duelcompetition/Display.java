/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *This class simulates multiple duels with two strategies and displays their results; Also has the function to compare results from duels
 * @author paridhichoudhary
 */
public class Display {

    /**
     *Creates an object duel which calls single fights between each wizard
     */
    Duel match = new Duel();
    
    /**
     *Method takes in, number of fights and list of fighters who are participating
     * @param n: number of fights
     * @param fighters: wizards who will be fighting each other
     * @return: winCount with keys as wizards and corresponding values, which is the number of fights they win
     */
    public Hashtable multipleDuels(int n,List<Fighter> fighters){
        Hashtable winCount = new Hashtable(); // dictionary which will keep count of number of wins for each wizard
        Fighter winner = new Fighter();
        while (n>0){
            List<Fighter> newFighters = new ArrayList();
            for (int i=0;i<fighters.size();i++){
                Fighter newFighter = new Fighter();// making a new array so that while removing wizards from this one, original one should be unchanged
                newFighter.accuracy = fighters.get(i).accuracy; // assigning accuracy and other parameters to each wizard
                newFighter.name = fighters.get(i).name; 
                newFighter.alive = fighters.get(i).alive;
                newFighters.add(i,newFighter);
            }
            match.setWizards(newFighters); // Setting wizards to the duel class
            match.setWinner(newFighters); // Finding winner for each single fight
            winner = match.winner;
            
            if (winCount.containsKey(winner.name)){
                winCount.replace(winner.name,winCount.get(winner.name), (int) winCount.get(winner.name)+1); // adding winCount to wizards value
            } 
            else {
                winCount.put(winner.name, 1); // if the wizard is not there in the dictionary yet, add it 
            }
            n = n-1;
        }
        return winCount; // return the dictionary
        
    }    
    
    /**
     * Multiple duels with alternate strategy is the same function as Multiple duels but with fight function changed
     * @param n: number of fights
     * @param fighters: list of wizards fighting
     * @return: winCount
     */
    public Hashtable multipleDuelsAlternateStrategy(int n,List<Fighter> fighters){
        Hashtable winCount = new Hashtable();
        Fighter winner = new Fighter();
        while (n>0){
            List<Fighter> newFighters = new ArrayList();
            for (int i=0;i<fighters.size();i++){
                Fighter newFighter = new Fighter();
                newFighter.accuracy = fighters.get(i).accuracy;
                newFighter.name = fighters.get(i).name;
                newFighter.alive = fighters.get(i).alive;
                newFighters.add(i,newFighter);
            }
            match.setWizards(newFighters);
            winner = match.singleFightAlternateStrategy(newFighters);// Fighting with alternate strategy
            
            if (winCount.containsKey(winner.name)){
                winCount.replace(winner.name,winCount.get(winner.name), (int) winCount.get(winner.name)+1);
            } 
            else {
                winCount.put(winner.name, 1);
            }
            n = n-1;
        }
        return winCount;
        
    }    
    
    /**
     *Displays the results of whatever winCount you provide, along with wizards names
     * @param h: winCount dictionary with each wizard's wins corresponding to their names
     * @param fighters: Wizards which are fighting
     */
    public void displayDuelResults(Hashtable h,List<Fighter> fighters){
        System.out.printf("LEADERBOARD – AFTER 10000 DUELS"+"\n"); 
        System.out.printf("%-20s%-20s%-20s%n","Contestant","Number of Wins","Winning Percentag"); // Formatting the output
        for (int i=0;i<fighters.size();i++){
            String percentage = String.format("%.2f",(float) ((int)(h.get(fighters.get(i).name)) *100)/10000) + "%"; // Calculating winning percentage and converting it to a string
            System.out.printf("%-20s%-20d%-20s%n",fighters.get(i).name,h.get(fighters.get(i).name),percentage); // Printing wizards name, wins and percentage 
        }
        System.out.printf("\n\n");
        
    }
    
    /**
     *Method Answers specific questions which were asked in the assignment
     * @param fighters
     */
    public void CompareDuelResults(List<Fighter> fighters){
        Hashtable winCountNormal = multipleDuels(10000, fighters);
        Hashtable winCountAlternate = multipleDuelsAlternateStrategy(10000, fighters);
        String answerString = "Q. What strategy is better for Gandalf, to intentionally miss on the first shot or to try and hit the best shooter?: ";
        if ((int) winCountNormal.get(fighters.get(0).name) > (int) winCountAlternate.get(fighters.get(0).name) ){ // compares results from two strategies
            answerString = answerString + "\n" + "Ans: Try and hit the best shooter is the best Strategy for Gandalf";
        }
        else {
            answerString = answerString + "\n" + "Ans: To intentionally miss on the first shot is the best Strategy for Gandalf";
        }
        
        answerString = answerString + "\n\n" + "Q. Who has the best chance of winning, the best shooter or the worst shooter?: ";
        if ((int) winCountNormal.get(fighters.get(0).name) > (int) winCountNormal.get(fighters.get(2).name) ){ // compares results from two strategies
            answerString = answerString + "\n" + "Ans: The worst shooter has the best chance of winning";
        }
        else if ((int) winCountNormal.get(fighters.get(0).name) < (int) winCountNormal.get(fighters.get(2).name) ){// compares results from two strategies
            answerString = answerString + "\n" + "Ans: The best shooter has the best chance of winning";
        }
        else {
            answerString = answerString + "\n" + "Ans: Both shooters have equal chances of winning";
        }
        System.out.println(answerString); 
    }
    
    
}
