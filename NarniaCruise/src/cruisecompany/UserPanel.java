/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruisecompany;

import java.util.ArrayList;

/**
 *
 * @author paridhichoudhary
 */
public class UserPanel {

    /**
     * Defines array list of panel options for user panel
     */
    public ArrayList<String[]> panelOptions = new ArrayList();
    
    /**
     *Sets the user panel using SetPanelOptions function
     * @param panelOptions
     */
    public UserPanel(ArrayList<String[]> panelOptions){
        for (int i=0;i<panelOptions.size();i++){
            setPanelOptions(i,panelOptions.get(i));
        }
    }
    
    /**
     *Takes in input of place at which option has to be added and adds the string array to it
     * @param n
     * @param s
     */
    public void setPanelOptions(int n,String[] s ){
            this.panelOptions.add(n, s);
    }
    
    /**
     * Gets the panel options
     * @param n
     * @return
     */
    public String[] getPanelOptions(int n){
            return this.panelOptions.get(n);
    }
    
    /**
     *
     * @param n
     */
    public void displayPanelOptions(int[] n){
            String currUserPanel = "";
            for (int i =0;i<n.length;i++){
                if (panelOptions.get(n[i]).length==1){
                    currUserPanel += i+1 + ". " + panelOptions.get(n[i])[0]+"\n";
                }
                else {
                    currUserPanel += i+1 + ". " + panelOptions.get(n[i])[0]+"\n";
                    for (int j=1;j<this.panelOptions.get(n[i]).length;j++){
                    currUserPanel += "  "+j + ". " + panelOptions.get(n[i])[j]+"\n";
                    }
                }
                
                
            }
            System.out.println(currUserPanel);
    }
    
}
