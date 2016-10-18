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
public class Engineer extends Sailor {
    
    /**
     *
     *@param name: Name of the Sailor/Engineer
     * @param dateOfBirth: Date of Birth of Sailor/Engineer
     * @param nationality: Nationality of Sailor/Engineer
     */
    public Engineer(String name, Calendar dateOfBirth, String nationality) {
        super(name, dateOfBirth, nationality);
        setSalary();
    }
    
    /**
     *Override the salary function of sailor
     */
    @Override
    public void setSalary(){
        this.salary = 80000;
    }
}
