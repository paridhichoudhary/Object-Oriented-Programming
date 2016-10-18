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
public class Doctor extends Sailor {
    
    /**
     *
     * @param name: Name of the Sailor/Doctor
     * @param dateOfBirth: Date of Birth of Sailor/Doctor
     * @param nationality: Nationality of Sailor/Doctor
     */
    public Doctor(String name, Calendar dateOfBirth, String nationality) {
        super(name, dateOfBirth, nationality);
    }
    
}
