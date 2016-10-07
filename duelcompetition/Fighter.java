/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

import java.util.ArrayList;
import java.util.Random;
import java.util.Hashtable;
import java.util.List;

/**
 *Class creates a fighter who would have a name, alive, accuracy fields and a shootAtTarget method which will hit the fighter passed as an argument
 * @author paridhichoudhary
 */
public class Fighter {

    /**
     *Name of the fighter
     */
    public String name;

    /**
     *Shooting accuracy as an array. For example: if accuracy is 1/3, accuracy array would be [1,0,0]
     */
    public int[] accuracy;

    /**
     *Alive status of the fighter
     */
    public boolean alive=true;
    
    Random rand = new Random(); // to pick up random accuracy for the fighter
    
    /**
     *Method takes in , fighter to be hit as argument, takes into account accuracy of the fighter whose object it is
     * @param target
     * @return
     */
    public boolean shootAtTarget(Fighter target){
        if (this.accuracy[rand.nextInt(this.accuracy.length)] == 1)
        {
            target.alive = false; // if the randomly picked number out of accuracy array is 1, the target will die
        }
        else 
        {
            target.alive = true; // if the randomly picked number out of accuracy array is 0, the target will be alive.
        }
        return target.alive;
    }
    
    /**
     *Setting accuracy of fighter using an array
     * @param a
     */
    public void setAccuracy (int[] a){
        this.accuracy = a;
    }
    
    /**
     *Getting accuracy of fighter using an array
     * @return
     */
    public int[] getAccuracy (){
        return this.accuracy;
    }
    
    /**
     *Setting name of fighter
     * @param s
     */
    public void setName (String s){
        this.name = s;
    }
    
    /**
     *Getting name of the fighter
     * @return
     */
    public String getName (){
        return this.name;
    }
        
    
    
    
}
