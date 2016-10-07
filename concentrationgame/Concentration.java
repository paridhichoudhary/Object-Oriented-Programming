/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concentration;

/**
 * This class plays a game with user where an unopened card matrix is given to them, and they have to guess coordinates where matching cards are kept
 * @author paridhichoudhary
 */
public class Concentration {

    /**
     * Main function to play the game
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CardMatrix newGame = new CardMatrix(); // Creating new object of CardMatrix
        newGame.setCardMatrix(); // Setting constand cards in the matrix
        newGame.playGame(newGame.cardMatrix); //Playing the game
    }
    
}
