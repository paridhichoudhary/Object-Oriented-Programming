/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concentration;

import java.util.Random;

/**
 *Class is for a card that has a label
 * @author paridhichoudhary
 */
public class Card {

    /**
     *Field Label for each card
     */
    public String cardLabel;
    
    /**
     *Getting label on each card
     * @return
     */
    public String getCard(){
        return cardLabel;
    }
    
    /**
     *Setting label of each card
     * @param s
     */
    public void setCard(String s){
        cardLabel = s;
    }
    
}
