/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adelaidefarm;

/**
 *Creates a Tray object which has a String attribute 'Fruit' which stores name of the fruit
 * @author paridhichoudhary
 */
public class Tray {

    /**
     *Stores name of the tray
     */
    public String name;

    /**
     * Stores name of the fruit
     */
    public String fruitname;
    
    /**
     *Sets name to the fruitname attribute of tray
     * @param s
     */
    public void setName(String s)
    {
       name = s;
    }
    
    /**
     *gets name of the tray
     * @return
     */
    public String getName()
    {
       return name;
    }
    /**
     *Sets fruit in a specific tray
     * @param s: Name for the fruit
     */
    public void setFruitName(String s)
    {
       fruitname = s;
    }
    
    /**
     *Returns fruit inside a tray
     * @return: name of the fruit inside the tray
     */
    public String getFruitName()
    {
        return fruitname;
    }
    
}
