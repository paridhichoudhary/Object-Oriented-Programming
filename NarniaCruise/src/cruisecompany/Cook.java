/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruisecompany;

import java.util.Calendar;

/**
 *
 * @author paridhichoudhary
 */
public class Cook extends Sailor {
    
    /**
     *
     * @param name: Name of the Sailor/Cook
     * @param dateOfBirth: Date of Birth of Sailor/Cook
     * @param nationality: Nationality of Sailor/Cook
     */
    public Cook(String name, Calendar dateOfBirth, String nationality) {
        super(name, dateOfBirth, nationality);
        setSalary();
    }
    
    /**
     *Function to override salary of sailor with cook
     */
    @Override
    public void setSalary(){
        this.salary = 80000;
    }
    
}
