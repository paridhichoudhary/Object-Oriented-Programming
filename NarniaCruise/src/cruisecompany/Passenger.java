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
 *Creates a passenger with name, date of birth, cruise expenditure, home address and other attributes
 * @author paridhichoudhary
 */
public class Passenger {

    /**
     *
     */
    public long passengerNumber;

    /**
     *
     */
    public String name;

    /**
     *
     */
    public String homeAddress;

    /**
     *
     */
    public String nationality;

    /**
     *
     */
    public Calendar dateOfBirth;

    /**
     *
     */
    public double moneyPaidForJoiningCruise;

    /**
     *
     */
    public double moneySpentOnCruise;

    /**
     *
     */
    public double age;
    
    /**
     *Constructor which makes passenger object, sets age, moneyPaidFor Cruise and money Spent on cruise randomly
     * @param name
     * @param homeAddress
     * @param nationality
     * @param dateOfBirth
     * @param moneyPaidForJoiningCruise
     */
    public Passenger(String name, String homeAddress,String nationality,Calendar dateOfBirth,double moneyPaidForJoiningCruise){
        
        setPassengerNumber();
        setName(name);
        setHomeAddress(homeAddress);
        setNationality(nationality);
        setDateOfBirth(dateOfBirth);
        setAge();
        setMoneyPaidForJoiningCruise(moneyPaidForJoiningCruise);
        setMoneySpentOnCruise();
        
    }
    
    /**
     *
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     *
     * @return
     */
    public String getName(){
        return this.name;
    }
    
    /**
     *
     * @param homeAddress
     */
    public void setHomeAddress(String homeAddress){
        this.homeAddress = homeAddress;
    }
    
    /**
     *
     * @return
     */
    public String getHomeAddress(){
        return this.homeAddress;
    }

    /**
     *
     * @param nationality
     */
    public void setNationality(String nationality){
        this.nationality = nationality;
    }
    
    /**
     *
     * @return
     */
    public String getNationality(){
        return this.nationality;
    }    

    /**
     *
     * @param dateOfBirth
     */
    public void setDateOfBirth(Calendar dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
     *
     * @return
     */
    public Calendar getDateOfBirth(){
        return this.dateOfBirth;
    }   
    
    /**
     * Subtracts current year with the birth year to give age of passenger
     */
    public void setAge(){
        Calendar today = Calendar.getInstance();
        age = (today.get(Calendar.YEAR) - this.dateOfBirth.get(Calendar.YEAR));
    }
    
    /**
     *gets age attribute
     * @return
     */
    public double getAge(){
        return this.age;
    }
    
    /**
     * Creates evaluation form for each passenger and fills responses out of the five options randomly
     * @return
     */
    public String fillEvaluationForm(){
        Random random = new Random();
        String evaluation="";
        String[] ratingOptions = {"Very Poor","Poor","Average","Good","Excellent"}; // Five possible options for review
        evaluation = evaluation + "1. How did you like the itinerary?:   " + ratingOptions[random.nextInt(5)] + "\n"; // Randomly selects one of the five options
        evaluation = evaluation + "2. How would you rate the quality of food on the cruise?:   " + ratingOptions[random.nextInt(5)] + "\n";
        evaluation = evaluation + "3. How would you rate the staff on Cruise?:   " + ratingOptions[random.nextInt(5)] + "\n";
        evaluation = evaluation + "4. How would you rate the entertainment events at the cruise?:   " + ratingOptions[random.nextInt(5)] + "\n";
        evaluation = evaluation + "5. How was the overall experience?:   " + ratingOptions[random.nextInt(5)] + "\n";
        return evaluation;
    }
    /**
     * Returns passenger details, in form of a string
     * @return 
     */
    @Override
    public String toString(){
        String passengerDetail = "";
        passengerDetail = passengerDetail + "Name: " +this.name + "\n";
        passengerDetail = passengerDetail + "PassengerNumber: " +this.passengerNumber + "\n";
        passengerDetail = passengerDetail + "HomeAddress: " +this.homeAddress + "\n";
        passengerDetail = passengerDetail + "Date Of Birth: " +this.dateOfBirth.getTime() + "\n";
        passengerDetail = passengerDetail + "Age: " +this.age + "\n";
        passengerDetail = passengerDetail + "Nationality: " +this.nationality + "\n";
        passengerDetail = passengerDetail + "Money paid for joining cruise: " +this.moneyPaidForJoiningCruise + "\n";
        passengerDetail = passengerDetail + "Money spent on cruise : " +this.moneySpentOnCruise + "\n";
        return passengerDetail;
    }
    
    private void setPassengerNumber() {
        Random rand = new Random();
        this.passengerNumber = 1000000 + rand.nextInt(8999999);
    }
    
    private long getPassengerNumber() {
        return this.passengerNumber;
    }
    /**
     * Sets money spent on Cruise Randomly
     */
    private void setMoneySpentOnCruise() {
        Random rand = new Random();
        this.moneySpentOnCruise = 500 + rand.nextInt(20000);
    }

    private double getMoneySpentOnCruise() {
        return this.moneySpentOnCruise;
    }

    private void setMoneyPaidForJoiningCruise(double moneyPaidForJoiningCruise) {
        this.moneyPaidForJoiningCruise = moneyPaidForJoiningCruise;
    }
    
    private double getMoneyPaidForJoiningCruise() {
        return this.moneyPaidForJoiningCruise;
    }

}
