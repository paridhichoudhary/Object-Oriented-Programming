/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concentration;

import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *Class which creates a constant matrix with possible card options, and then takes coordinates from users to open cards
 * and then shows them cards, if the cards match, keeps the matrix as it is. If it does not turns back the cards.
 * @author paridhichoudhary
 */
public class CardMatrix {

    /**
     *
     */
    public Card[][] cardMatrix; // Defining 2D Card Array, a field of matrix
    // Static list of card options out of which labels of cards can be chosen
    private static final String[] cards = {
        "A", 
        "Q", 
        "K", 
        "J", 
        "2", 
        "5", 
        "6", 
        "9"
    };
    
    private static final ArrayList<String> cardOptions = new ArrayList(Arrays.asList(cards)); // Making an arraylist so that cards which have been taken up can be removed from matrix
    
    Scanner input = new Scanner(System.in); // Defining input for the function
    
    /**
     * Method chooses cards out of the possible options and removes the chosen card from the passed arraylist of strings
     * @param cardOptions: Possible options to choose card label from
     * @return: Name of the card chosen
     */
    public String chooseCard(ArrayList<String> cardOptions){
        Random rand = new Random();
        String cardChosen  = cardOptions.get(rand.nextInt(cardOptions.size()));
        cardOptions.remove(cardChosen);
        return cardChosen;
    }
    
    /**
     * Setting the constant card Matrix which will have answers for each coordinates.
     */
    public void setCardMatrix(){
        cardMatrix = new Card[4][4]; // Initializing new Card Matrix
        List<Integer[]> coordinates = new ArrayList(); // Making a coordinates List, which will have a list of all possible coordinates in the matrix, out of which 2 can be randomly chosen which will have same card
        Random rand = new Random();
        boolean a=true;
        for (Integer i=0;i<4;i++){
            for (Integer j=0;j<4;j++){
                Integer[] temp = new Integer[2];
                temp[0] = i;
                temp[1] = j;
                coordinates.add(temp); // All possible coordinates of the matrix being added to the array
            }
        }
        while (!coordinates.isEmpty()){ //If any of the coordinates is remaining to be filled, complete the while loop
            int k = rand.nextInt(coordinates.size()); // randomly picking coordinates
            String chosenCard = chooseCard(cardOptions); // randomly picking one card out of possible options
            cardMatrix[coordinates.get(k)[0]][coordinates.get(k)[1]] = new Card(); // Defining a new card at the selected coordinate
            cardMatrix[coordinates.get(k)[0]][coordinates.get(k)[1]].cardLabel = chosenCard; // Assigning label of the card at that coordinate to the one choosen above
            coordinates.remove(coordinates.get(k)); // removing that coordinate from the coordinate array
            
            k = rand.nextInt(coordinates.size());// randomly picking another coordinate to place the same card
            cardMatrix[coordinates.get(k)[0]][coordinates.get(k)[1]]  = new Card(); // Defining a new card at the selected coordinate
            cardMatrix[coordinates.get(k)[0]][coordinates.get(k)[1]].cardLabel = chosenCard; // Assigning label of the card at that coordinate to the one choosen above
            coordinates.remove(coordinates.get(k));// removing that coordinate from the coordinate array
        }
    }
    
    /**
     * Method displays the matrix that is passed in as argument
     * @param a Card Matrix, which is to be displayed
     */
    public void displayMatrix(Card[][] a){
        String matrix = " "+" 1"+" 2"+" 3"+" 4"; // Printing first row as provided in the example
        for (int i=0;i<a.length;i++){
            matrix = matrix + "\n" + ((int)i+1); // Printing each row with row number at the start
            for (int j=0;j<a[i].length;j++){
                matrix = matrix +" " +a[j][i].cardLabel; // Printing label of each card in the matrix
            }
        }
        System.out.println(matrix); // printing string matrix which has been built till now
    }
    
    /**
     * Updating current matrix with values from Answer matrix, at the coordinates which have been asked by the user
     * @param a: Current Matrix which is to be updated
     * @param p: Column Label for the first coordinate set
     * @param q: Row Label for the first coordinate set
     * @param r: Column Label for the second coordinate set
     * @param s: Row Label for the second coordinate set
     * @return: The updates card matrix at these locations
     */
    public Card[][] updateDisplayMatrix(Card[][] a,int p, int q,int r, int s){
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[i].length;j++){
                if (i==p && j==q){
                    a[i][j].cardLabel = cardMatrix[p][q].cardLabel; // Assigning value from answer matrix to the current matrix
                }
                else if (i==r && j==s){
                    a[i][j].cardLabel = cardMatrix[r][s].cardLabel;
                }
            }
        }
        return a;
    }
    
    /**
     * Checks whether an integer is in a given range
     * @param a: Integer whose range has to be checked
     * @return : boolean check whether integer is in the given range
     */
    public boolean integerCheck(int a){
        boolean check = false;
        if (a>0 && a<5){
            check = true;
        }
        return check;
    }
    
    
    /**
     * Plays the game with providing a matrix with all cells as $ at beginning and then updating them based on user response
     * @param a: 
     */
    public void playGame(Card[][] a){
        boolean y = false; // Boolean to inidicate when all cards in the matrix are opened
        System.out.println("Lets start the game! Are you ready?");
        Card[][] initMatrix = new Card[4][4]; // Initializing new card matrix which will be set to all $ at start of the game
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[i].length;j++){
                initMatrix[j][i] = new Card();  
                initMatrix[j][i].cardLabel = "$";
                }
            }
        displayMatrix(initMatrix); // Displaying the initial matrix to the user to show coordinates and ask them to choose from them
        do
        {   
            boolean check = false; // Iniializing check to false so that while executes
            int i1=0,j1=0,i2=0,j2=0; // Iniializing all coordinates
            while (check == false) // Keep on asking for coordinates until user supplies correct coordinates
            {
            System.out.println("Give coordinates of the first card you want to open? (Enter (column, row) i.e. 2,3 for [2,3])");
            String coord1 = input.nextLine(); // Taking string inputs for coordinates
            System.out.println("Give coordinates of the second card you want to open? (Enter (column, row) i.e. 2,3 for [2,3])");
            String coord2 = input.nextLine();
            StringTokenizer str1  = new StringTokenizer(coord1,","); // Using StringTokenizer to break string into x and y coordinates
            StringTokenizer str2  = new StringTokenizer(coord2,",");
            try {
            i1 = Integer.parseInt(str1.nextToken())-1;//Taking Integer values for x coordinate
            j1 = Integer.parseInt(str1.nextToken())-1;//Taking Integer values for y coordinate
            i2 = Integer.parseInt(str2.nextToken())-1;
            j2 = Integer.parseInt(str2.nextToken())-1;
            check = integerCheck(i1+1) && integerCheck(j1+1) && integerCheck(i2+1) && integerCheck(j2+1); // Checking if all integers are in the given range
            if (i1==i2 && j1==j2){
                check = false;   //If the user enters same coordinates for both cards
                System.out.println("Please enter two different coordinates");
            }
            } catch (NumberFormatException e){
                check = false; //If user enters anything other than an integer in the coordinates
                System.out.println("Error: " + e);
            }
            if (check == false){
                System.out.println ("Atleast one of the coordinates passed is not in range [1,4] or is not Integer. Please re-enter coordinates");
            }
            }
            
            
            Card[][] tempMatrix = new Card[4][4]; //Creating temporary matrix to show chosen cards to the user
            for (int i=0;i<initMatrix.length;i++){
                for (int j=0;j<initMatrix[i].length;j++){
                    tempMatrix[i][j] = new Card();
                    tempMatrix[i][j].cardLabel = initMatrix[i][j].cardLabel; // Replicating temporary matrix with initial matrix
                }
            }
            displayMatrix(updateDisplayMatrix(tempMatrix,i1,j1,i2,j2)); // Upadting temp Matrix with coordinates' cards chosen 
            if (cardMatrix[i1][j1].cardLabel==(cardMatrix[i2][j2].cardLabel))
            {
                initMatrix = updateDisplayMatrix(initMatrix,i1,j1,i2,j2); // Updating Initial Matrix if the cards match
            }
            else
            {
                for(int i=0;i<100;i++)
                {
                    System.out.println("\n");
                } 
                System.out.println("Your cards didnt match. Keep playing: ");
                displayMatrix(initMatrix); //If the cards do not match, go back to the original matrix 
            }
            y = false;
            for (int i=0;i<a.length;i++){
                for (int j=0;j<a[i].length;j++){
                    if(initMatrix[i][j].cardLabel == "$")
                    {
                        y = true; // Even if any card label is $, it turns y to true.
                    }
                    }
                }
        } while (y==true); // If any of the cards is unturned, the game continues
        
        System.out.println("Congratulations, You nailed it!!");
    }
    
}
