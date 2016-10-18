/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruisecompany;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;


/**
 * Creates an object Sailor which has name, DateOfBirth and other attributes related to Sailor
 * @author paridhichoudhary
 */
public class Sailor {

    /**
     *
     */
    public String sailorID;

    /**
     *
     */
    public String name;

    /**
     *
     */
    public Calendar dateOfBirth;

    /**
     *
     */
    public double salary;

    /**
     *
     */
    public String nationality;

    /**
     *
     */
    public boolean supervisor;

    /**
     *
     */
    public final double basesalary = 50000;
    
    Random rand = new Random();
    
    /**
     *
     * @param name: Name of the Sailor
     * @param dateOfBirth: Date of Birth of Sailor
     * @param nationality: Nationality of Sailor
     */
    public Sailor(String name, Calendar dateOfBirth, String nationality ){
        
        setName(name);
        setDateOfBirth(dateOfBirth);
        setNationality(nationality);
        setSupervisor();
        setSailorId();
        setSalary();
    }

    private void setSailorId() {
        this.sailorID = name.charAt(0)+name.charAt(1)+name.charAt(2)+"" + 100 + rand.nextInt(899);
    }
    
    /**
     *
     * @return: Sailor Id
     */
    public String getSailorId(){
        return this.sailorID;
    }


    private void setName(String name) {
        this.name = name;
    }
    
    private String getName() {
        return this.name;
    }

    private void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    private String getNationality() {
        return this.nationality;
    }

    private void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    private Calendar getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    /**
     *Sets the salary after checking whether each sailor is a supervisor or not
     */
    public void setSalary(){
        if (this.supervisor==true){
            this.salary = 1.2 * this.basesalary;
        }
        else{
            this.salary = this.basesalary;
        }
    }
    
    /**
     *returns the salary
     * @return
     */
    public double getSalary(){
        return this.salary;
    }
    
    /**
     * sets supervisor boolean to true or false
     */
    public void setSupervisor(){
        boolean n = rand.nextBoolean();
        this.supervisor = n;
    }
    
    @Override
    public String toString(){
        String sailorDetail = "";
        sailorDetail = sailorDetail + "Name: " +this.name + "\n";
        sailorDetail = sailorDetail + "SailorId: " +this.sailorID + "\n";
        sailorDetail = sailorDetail + "Date Of Birth: " +this.dateOfBirth.getTime() + "\n";
        sailorDetail = sailorDetail + "Nationality: " +this.nationality + "\n";
        sailorDetail = sailorDetail + "Salary: " +this.salary + "\n";
        sailorDetail = sailorDetail + "Is a Supervisor? : " +this.supervisor + "\n";
        return sailorDetail;
    }
}
