/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruisecompany;

import java.io.FileNotFoundException;
import java.util.Random;
/**
 *Creates a port based on its name, population and country
 * @author paridhichoudhary
 */
public class PortOfCall {
    
    /**
     *
     */
    public String name;

    /**
     *
     */
    public String country;

    /**
     *
     */
    public long population;

    /**
     *
     */
    public boolean passportRequired;

    /**
     *
     */
    public double currentDockingFee;
    
    Random rand = new Random();
    
    /**
     *Constructor to make a new port
     * @param name
     * @param country
     * @param population
     */
    public PortOfCall(String name, String country,long population){
     
        this.currentDockingFee = 0;
        setName(name);
        setCountry(country);
        setPopulation(population);
        setPassportRequired();
        
    }
    
    /**
     *Sets the name of the port
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Gets the name of the port
     * @return
     */
    public String getName(){
        return this.name;
    }
    
    /**
     *Sets the name of the country
     * @param country
     */
    public void setCountry(String country){
        this.country = country;
    }
    
    /**
     *Gets the name of the country
     * @return
     */
    public String getCountry(){
        return this.country;
    }

    /**
     *Sets population of port
     * @param population
     */
    public void setPopulation(long population){
        this.population = population;
    }
    
    /**
     *Gets population of port
     * @return
     */
    public long getPopulation(){
        return this.population;
    }    

    /**
     *Boolean whether passport is required or not
     */
    public void setPassportRequired(){
        boolean n = rand.nextBoolean();
        this.passportRequired = n;
    }
    
    /**
     *Gets whether passport is required or not
     * @return
     */
    public boolean getPassportRequired(){
        return this.passportRequired;
    }   
    
    /**
     *Sets the docking fee on the port based on its ship weight
     * @param ship
     */
    public void setDockingFee(Ship ship){
        if (ship.weight<30000){
            this.currentDockingFee = 20000;
        }
        
        if (ship.weight>30000 && ship.weight<50000){
            this.currentDockingFee = 50000;
        }
        
        if (ship.weight>50000){
            this.currentDockingFee = 100000;
        }
        
    }
    
    /**
     * Gets the docking fee at the port
     * @return
     */
    public double getDockingFee(){
        return this.currentDockingFee;
    }   
    
    /**
     * Returns the details of a port in the form of a string
     * @return
     */
    @Override
    public String toString(){
        String portDetail = "";
        portDetail = portDetail + "Name: " +this.name + "\n";
        portDetail = portDetail + "Country: " +this.country + "\n";
        portDetail = portDetail + "Population: " +this.population + "\n";
        portDetail = portDetail + "Passport Required? : " +this.passportRequired + "\n";
        return portDetail;
    }
    
    
}
