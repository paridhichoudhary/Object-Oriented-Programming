/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruisecompany;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Creates a ship with weight, number, yearBuilt and passengerCapacity, Sailors, Captains,Doctors, Cooks, Engineers 
 * @author paridhichoudhary
 */
public class Ship {
    
    Random rand = new Random();
    
    private int shipNumber;

    /**
     *
     */
    public double weight;

    /**
     *
     */
    public int yearBuilt;

    /**
     *
     */
    public int passengerCapacity;
    private Sailor captain;
    private Sailor[] engineers;
    private Sailor[] doctors;
    private Sailor[] cooks;
    private Sailor[] sailors;

    /**
     *Use this to fix the number of sailors in the ship
     */
    public final int numberOfSailorsTotal = 10 + rand.nextInt(11);

    /**
     * Keep a track of number of Sailors Remaining to add extra sailors and doctors
     */
    public int numberOfSailorsRemaining=numberOfSailorsTotal;

    /**
     * A dynamic array list to initially have data for all sailors and then remove it as and when data is used for any sailor object 
     */
    public ArrayList<String[]> sailorsRemaining = new ArrayList();
    
    /**
     *Constructor takes in inputs:
     * @param weight
     * @param yearBuilt
     * @param passengerCapacity
     * makes ship object with all the sailors
     * @throws IOException
     */
    public Ship(double weight, int yearBuilt, int passengerCapacity) throws IOException{
        setShipNumber();
        setWeight(weight);
        setYearBuilt(yearBuilt);
        setPassengerCapacity(passengerCapacity);
        setSailorsRemaining();
        setCaptain();
        setDoctors();
        setEngineers();
        setCooks();
        setSailors();
    }

    /**
     *Takes up input from SailorsData file and stores in an array list to be used dynamically
     * @throws IOException
     */
    public void setSailorsRemaining() throws IOException{
        InputFileReader reader = new InputFileReader();
        reader.readFile("SailorsData.txt");
        this.sailorsRemaining = reader.wordsArray;
    }
    
    /**
     * Sets ship number randomly
     */
    private void setShipNumber() {
        this.shipNumber = 10000 + rand.nextInt(50000);
    }
    
     /**
     * @return the shipNumber
     */
    public int getShipNumber() {
        return shipNumber;
    }

   

    private void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }
    
    private int getYearBuilt() {
        return this.yearBuilt;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }
    
    private double getWeight() {
        return this.getWeight();
    }

    private void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
    
    private int getPassengerCapacity() {
        return this.passengerCapacity;
    }

    /**
     * Gets the captain of the ship
     * @return the captain
     */
    public Sailor getCaptain() {
        return captain;
    }

    /**
     * Sets the captain of the ship
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public void setCaptain() throws FileNotFoundException, IOException {
        if (numberOfSailorsRemaining!=0){
        int n = 1+ rand.nextInt(numberOfSailorsRemaining-1);
        String[] captainDetails = sailorsRemaining.get(n);
        sailorsRemaining.remove(n);
        Calendar date = Calendar.getInstance();
        date.set(Integer.parseInt(captainDetails[1].split("/")[2]),Integer.parseInt(captainDetails[1].split("/")[0]),Integer.parseInt(captainDetails[1].split("/")[1]));
        captain = new Captain(captainDetails[0],date,captainDetails[2]);
        numberOfSailorsRemaining = numberOfSailorsRemaining -1;
    }
    }
    /**
     * @return the engineers
     */
    public Sailor[] getEngineers() {
        return engineers;
    }

    /**
     * Sets engineers based on randomly picking one number between 0 and number of sailors remaining. For that number, adds that many Engineer objects in the Engineer array
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public void setEngineers() throws FileNotFoundException, IOException {
        if (numberOfSailorsRemaining!=0){
        int numberOfEngineers = rand.nextInt(numberOfSailorsRemaining); // Number of random engineers to be added
        this.engineers = new Engineer[numberOfEngineers];
        for (int i = 0; i<this.engineers.length;i++){
            int n = 1+rand.nextInt(sailorsRemaining.size()-1);// Choosing a random row from the file
            String[] engineerDetails = sailorsRemaining.get(n); // Using the data at that row to add into an array
            sailorsRemaining.remove(n);
            Calendar date = Calendar.getInstance(); // Coverting string date into date object
            date.set(Integer.parseInt(engineerDetails[1].split("/")[2]),Integer.parseInt(engineerDetails[1].split("/")[0]),Integer.parseInt(engineerDetails[1].split("/")[1])); 
            this.engineers[i] = new Engineer(engineerDetails[0],date,engineerDetails[2]); // Calls the constructor with arguments
            }
            numberOfSailorsRemaining = numberOfSailorsRemaining - numberOfEngineers;
    }
    }
    /**
     * @return the doctors
     */
    public Sailor[] getDoctors() {
        return doctors;
    }

    /**
     * Same as Engineer
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public void setDoctors() throws FileNotFoundException, IOException {
        if (numberOfSailorsRemaining!=0){
        int numberOfDoctors = rand.nextInt(numberOfSailorsRemaining);
        this.doctors = new Doctor[numberOfDoctors];
        for (int i = 0; i<this.doctors.length;i++){
            int n = 1 + rand.nextInt(sailorsRemaining.size()-1);
            String[] doctorDetails = sailorsRemaining.get(n);
            sailorsRemaining.remove(n);
            Calendar date = Calendar.getInstance();
            date.set(Integer.parseInt(doctorDetails[1].split("/")[2]),Integer.parseInt(doctorDetails[1].split("/")[0]),Integer.parseInt(doctorDetails[1].split("/")[1]));
            this.doctors[i] = new Doctor(doctorDetails[0],date,doctorDetails[2]);
        }
            numberOfSailorsRemaining = numberOfSailorsRemaining-numberOfDoctors;
    }
    }
    /**
     * @return the cooks
     */
    public Sailor[] getCooks() {
        return cooks;
    }

    /**
     * Same as Engineer
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public void setCooks() throws FileNotFoundException, IOException {
        if (numberOfSailorsRemaining!=0){
        int numberOfCooks =  rand.nextInt(numberOfSailorsRemaining);
        this.cooks = new Cook[numberOfCooks];
        for (int i = 0; i<this.cooks.length;i++){
            int n = 1 + rand.nextInt(sailorsRemaining.size()-1);
            String[] cookDetails = sailorsRemaining.get(n);
            sailorsRemaining.remove(n);
            Calendar date = Calendar.getInstance();
            date.set(Integer.parseInt(cookDetails[1].split("/")[2]),Integer.parseInt(cookDetails[1].split("/")[0]),Integer.parseInt(cookDetails[1].split("/")[1]));
            this.cooks[i] = new Cook(cookDetails[0],date,cookDetails[2]);
        }
            numberOfSailorsRemaining = numberOfSailorsRemaining - numberOfCooks;
    }
    }
    
    /**
     * Same as Engineer
     * @return the sailors
     */
    public Sailor[] getSailors() {
        return sailors;
    }

    /**
     * Same as Engineer
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public void setSailors() throws FileNotFoundException, IOException {
        if (numberOfSailorsRemaining!=0){
        int numberOfSailors = numberOfSailorsRemaining;
        this.sailors = new Sailor[numberOfSailors];
        for (int i = 0; i<this.sailors.length;i++){
            int n = 1 + rand.nextInt(sailorsRemaining.size()-1);
            String[] sailorDetails = sailorsRemaining.get(n);
            sailorsRemaining.remove(n);
            Calendar date = Calendar.getInstance();
            date.set(Integer.parseInt(sailorDetails[1].split("/")[2]),Integer.parseInt(sailorDetails[1].split("/")[0]),Integer.parseInt(sailorDetails[1].split("/")[1]));
            this.sailors[i] = new Sailor(sailorDetails[0],date,sailorDetails[2]);
            
    }
            numberOfSailorsRemaining = numberOfSailorsRemaining - numberOfSailors;
    }
    }
   
            
    
}
