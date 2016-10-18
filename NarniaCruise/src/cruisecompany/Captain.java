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
public class Captain extends Sailor {
    
    /**
     *
     * @param name: Name of the Sailor/Captain
     * @param dateOfBirth: Date of Birth of Sailor/Captain
     * @param nationality: Nationality of Sailor/Captain
     */
    public Captain(String name, Calendar dateOfBirth, String nationality) {
        super(name, dateOfBirth, nationality);
        setSalary();
    }
    
    /**
     *Function to override salary of sailor with captain
     */
    @Override
    public void setSalary(){
        this.salary = 300000;
    }
    
}
