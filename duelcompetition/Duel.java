/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Class contains get set methods for wizards participating in a duel and winners
 * @author paridhichoudhary
 */
public class Duel {
    Fighter winner;
    List<Fighter> wizards = new ArrayList();
    Scanner input = new Scanner(System.in);
    
    /**
     *Setting the winner of duel by calling singleFight function 
     * @param a : wizards which are fighting
     */
    public void setWinner(List<Fighter> a){
        winner = singleFight(a);
    }

    /**
     *Gets the winner of the class
     * @return: winner fighter
     */
    public Fighter getWinner(){
        return winner;
    }
    
    /**
     *Setting wizards in the class with fighters passed in as argument
     * @param a
     * @return
     */
    public List<Fighter> setWizards(List<Fighter> a){
        wizards.removeAll(wizards);
        for (int i=0;i<a.size();i++){
            wizards.add(i,a.get(i));
        }
        return wizards;
    }
    
    /**
     *Getting wizards of the class
     * @return
     */
    public List<Fighter> getWizards(){
        return wizards;
    }
    
    /**
     *Looks at the alive field of each fighter and returns a list of all live wizards
     * @return
     */
    public List<Fighter> wizardsAlive(){
        for (int i=0;i<wizards.size();i++){
            if (wizards.get(i).alive==false){
            wizards.remove(wizards.get(i));
        }
        }
        
        return wizards;
    }
    
    /**
     *Looks at the all wizards, except the one who is hitting, and find the most accurate wizard
     * @param a: The fighter who is hitting at the time
     * @return: Fighter who is the most accurate apart from the fighter who is hitting
     */
    public Fighter mostAccurate(Fighter a){
        int maxStrength=wizards.get(0).accuracy.length; // Initiating maxStrength which will be the measure of most accurate
        Fighter strongest=new Fighter();
        for (int i=0;i<wizards.size();i++){
            if (wizards.get(i).accuracy.length<=maxStrength && !(wizards.get(i).equals(a))){ // Max Strength is a function of length because if accuracy is 1/3, the accuracy array is [1,0,0], so the longer the array, the less accurate that wizard is
                strongest = wizards.get(i);
                maxStrength = wizards.get(i).accuracy.length; // if you find a more accurate wizard, assign his accuracy and name to variables
            }
        }
        return strongest;
    }
    
    /**
     * Method takes up the order of wizards in which they will get a chance to hit through arguments
     * It defines the strategy for each fight; each wizard, finds the most accurate wizard barring him, and hits him. As and when a wizard is hit, he is removed from the wizards list
     * @param fighters: order of fighters in which they will fight
     * @return: winner of the fight
     */
    public Fighter singleFight(List<Fighter> fighters){
        wizardsAlive();
        for (int i=0;i<fighters.size();i++){
            for (int j =0; j<wizards.size();j++){
                if (fighters.get(i).equals(wizards.get(j))){
                    fighters.remove(i);
                    fighters.add(i,wizards.get(j)); 
                }
            }
        }
        while(wizards.size()>1)
        {
            for (int i=0;i<fighters.size();i++){
                Fighter mostAccurate = new Fighter();
                mostAccurate = mostAccurate(fighters.get(i));
                if (fighters.get(i).alive==true && fighters.get(i).shootAtTarget(mostAccurate)==false){ // If the fighter at whom, the iteration has stopped is alive, he hits the most accurate wizard alive
                    wizardsAlive();
                    fighters.remove(mostAccurate);
            }
            }
        }
        return wizards.get(0);
    }
    
    /**
     *Method that calls the alternate strategy exactly as the earlier method, but at the first hit, first wizard is not able to hit
     * @param fighters: order of fighters in which they will fight 
     * @return: winner of the fight
     */
    public Fighter singleFightAlternateStrategy(List<Fighter> fighters){
        wizardsAlive();
        for (int i=0;i<fighters.size();i++){
            for (int j =0; j<wizards.size();j++){
                if (fighters.get(i).equals(wizards.get(j))){
                    fighters.remove(i);
                    fighters.add(i,wizards.get(j));
                }
            }
        }
        int counter = 0;
        while(wizards.size()>1)
        {
            for (int i=0;i<fighters.size();i++){
                Fighter mostAccurate = new Fighter();
                mostAccurate = mostAccurate(fighters.get(i));
                if (counter==0){
                    counter +=1;// for the first hit, first wizard gets, do nothing
                }
                else if (fighters.get(i).alive==true && fighters.get(i).shootAtTarget(mostAccurate)==false){
                    wizardsAlive();
                    fighters.remove(mostAccurate);
                    counter+=1;
                }
            }
        }
        return wizards.get(0);
    }
    
    /**
     *Method sets the wizards according to the assignment, with their names, accuracies and life status
     * @return
     */
    public List<Fighter> currentWizards(){
        List<Fighter> fighters= new ArrayList();
        //Adding Gandalf with its characteristics in fighters
        Fighter gandalf  = new Fighter();
        fighters.add(gandalf);
        //Defining Accuracy array for Gandalf in an array
        int[] a = {1, 0, 0};
        // Setting fields for Gandalf
        gandalf.setName("Gandalf");
        gandalf.setAccuracy(a);
        
        //Adding Merlin with its characteristics in fighters
        Fighter merlin  = new Fighter();
        fighters.add(merlin);
        //Setting Accuracy for Merlin in an array
        int[] b = {1,0};
        // Setting fields for Merlin
        merlin.setName("Merlin");
        merlin.setAccuracy(b);
        
        //Adding Dumbledore with its characteristics in fighters
        Fighter dumbledore  = new Fighter();
        fighters.add(dumbledore);
        //Setting Accuracy for Dumbledore in an array
        int[] c = {1};
        // Setting fields for Dumbledore
        dumbledore.setName("Dumbledore");
        dumbledore.setAccuracy(c);
        
        return fighters;
    }

    
}
