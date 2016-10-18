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
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;
/**
 *Creates a cruise with one ship(its inherent sailors), cruise number, sailing date, ending date, departure Port, ticketCost, passengers on board, itinerary of the cruise as well
 * @author paridhichoudhary
 */
public class Cruise {
    
    /**
     *
     */
    public long cruiseNo;

    /**
     *
     */
    public Calendar sailingDate;

    /**
     *
     */
    public Calendar returnDate;

    /**
     *
     */
    public PortOfCall departurePort;

    /**
     *
     */
    public double ticketCost;

    /**
     *
     */
    public Ship ship;

    /**
     *
     */
    public ArrayList<Passenger> passengers;

    /**
     *
     */
    public CruiseItinerary itinerary;

    /**
     *
     */
    public boolean random = true;
    
    Random rand = new Random();
    
    /**
     *Sets the attributes provided, sets passengers randomly after fetching from the text file, sets the ship, cruise Itinerary and departure port
     * @param sailingDate
     * @param returnDate
     * @param ticketCost
     * @throws FileNotFoundException
     * @throws IOException
     */
    public Cruise(Calendar sailingDate, Calendar returnDate, double ticketCost) throws FileNotFoundException, IOException{
        setCruiseNumber();
        setSailingDate(sailingDate);
        setReturnDate(returnDate);
        setTicketCost(ticketCost);
        setPassengersRandomly();
        setShip();
        setCruiseItinerary();
        setDeparturePort(itinerary.portsCovered.get(0));
    }

    /**
     * Randomly creates a cruise number
     */
    public void setCruiseNumber(){
        this.cruiseNo = 1000 + rand.nextInt(8999);
    }
    
    /**
     *Gets cruise number
     * @return
     */
    public int getCruiseNumber(){
        int a=0;
        return a;
    }

    /**
     *Sets the sailing date 
     * @param sailingDate
     */
    public void setSailingDate(Calendar sailingDate){
        this.sailingDate = sailingDate;
    }
    
    /**
     *gets the sailing date
     * @return
     */
    public Calendar getSailingDate(){
        return this.sailingDate;
    }
    
    /**
     *
     * @param returnDate
     */
    public void setReturnDate(Calendar returnDate){
        this.returnDate = returnDate;
    }
    
    /**
     *
     * @return
     */
    public Calendar getReturnDate(){
        return this.returnDate;
    }
    
    /**
     *
     * @param departurePort
     */
    public void setDeparturePort(PortOfCall departurePort){
        this.departurePort = departurePort;
    }
    
    /**
     *
     * @return
     */
    public PortOfCall getDeparturePort(){
        return this.departurePort;
    }

    /**
     *
     * @param ticketCost
     */
    public void setTicketCost(double ticketCost){
        this.ticketCost = ticketCost;
    }
    
    /**
     *
     * @return
     */
    public double getTicketCost(){
        return this.ticketCost;
    }    
    
    /**
     *Takes data from shipsData.txt and stores in Ship object, along with creating other attributes of ship object
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void setShip() throws FileNotFoundException, IOException{
        InputFileReader reader = new InputFileReader();
        reader.readFile("ShipsData.txt");
        int n = 1+ rand.nextInt(reader.fieldsLines.size()-1);
        String[] shipDetails = reader.wordsArray.get(n);
        reader.fieldsLines.remove(n);
        reader.wordsArray.remove(n);
        this.ship = new Ship(Double.parseDouble(shipDetails[0]),Integer.parseInt(shipDetails[1]),Integer.parseInt(shipDetails[2]));
    }
    
    /**
     *
     * @return
     */
    public Ship getShip(){
        return this.ship;
    }
    
    /**
     *Takes the file PassengerData.txt and sets passengers randomly in the arraylist based on the number of passengers, randomly chosen between 30 and 60
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void setPassengersRandomly() throws FileNotFoundException, IOException{
        InputFileReader reader = new InputFileReader();
        reader.readFile("PassengersData.txt");
        int numberOfPassengers = 30 + rand.nextInt(60); // Number of passengers to be added to the cruise
        this.passengers = new ArrayList();
        for (int i = 0; i<numberOfPassengers;i++){
            int n = 1+rand.nextInt(reader.fieldsLines.size()-1); // picking a random row from the file
            String[] passengerDetails = reader.wordsArray.get(n); // taking all the elements for that selected row 
            reader.fieldsLines.remove(n);
            reader.wordsArray.remove(n);
            Calendar date = Calendar.getInstance();// Coverting string date into date object
            if (passengerDetails[3].split("/").length!=3){
                for(i =0;i<passengerDetails[3].split("/").length;i++){
                    System.out.println(passengerDetails[3].split("/")[i]);
                }
            }
            date.set(Integer.parseInt(passengerDetails[3].split("/")[2]),Integer.parseInt(passengerDetails[3].split("/")[0]),Integer.parseInt(passengerDetails[3].split("/")[1])); //
            this.passengers.add(i,new Passenger(passengerDetails[0],passengerDetails[1],passengerDetails[2],date,900)); //Calls the constructor of passenger class to create a new passenger object. Uses fixed cost of Tickets and adds the object to Passenger ArrayList 
        }
     }
    
    /**
     * Function to set Passengers Manually; Asks for inputs of fields taken from text file in random setting method
     */
    public void setPassengersManually() {
        boolean add = true;
        Scanner input = new Scanner(System.in);
        while(add!=false)
        {
            System.out.println("Please Enter Name of the passenger: "); //Takes input of name
            String name = input.nextLine();
            System.out.println("Please Enter Address of the passenger: ");//Takes input of Address
            String address = input.nextLine();
            System.out.println("Please Enter Nationality of the passenger: ");//Takes input of Nationality
            String nationality = input.nextLine();
            System.out.println("Please Enter Date of Birth of the passenger: ");//Takes input of DOB
            String dOB = input.nextLine();
            Calendar date = Calendar.getInstance();
            if (dOB.split("/").length!=3){
                for(int i =0;i<dOB.split("/").length;i++){
                    System.out.println(dOB.split("/")[i]);
                }
            }
            date.set(Integer.parseInt(dOB.split("/")[2]),Integer.parseInt(dOB.split("/")[0]),Integer.parseInt(dOB.split("/")[1]));
            this.passengers.add(new Passenger(name,address,nationality,date,900)); //Calls the constructor as in random method
            boolean validInput = false; // Checks if the passenger wants to input more manual details of passengers
            // Checks if the passenger wants to input more manual details of passengers
            while(validInput==false){
            System.out.println("Do you still want to add passengers manually (Enter Yes or No) : ");
            String ans = input.nextLine();
            if (ans.equals("Yes")||ans.equals("No")){ //Yes and No are valid inputs; everything else is invalid
                if (ans.equals("Yes")){
                    add = true;
                }
                else{
                    add = false;
                }
                validInput = true;
                break;
            }
            else{
            System.out.println("Invalid Input. Please enter Yes or No: ");//If anything other than yes or no is entered, they are asked to enter again
            validInput=false;
            }
            }
        }
     }
    
    /**
     *Reports the cruiseEvaluation by the passengers
     * @return
     */
    public String reportCruiseEvaluationByPassengers(){
        String cruiseEvaluation = "";
        
        for (int i =0; i<this.passengers.size();i++){
            cruiseEvaluation = cruiseEvaluation + passengers.get(i).name + "\n" + passengers.get(i).fillEvaluationForm()+"\n"; // calls fillEvaluationForm for each passenger and stores in a string being built up
        }
        
        return cruiseEvaluation;
    }
    
    /**
     * 
     * @return
     */
    public ArrayList<Passenger> getPassengers(){
        return this.passengers;
    }
    
    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void setCruiseItinerary() throws FileNotFoundException, IOException{
        this.itinerary = new CruiseItinerary(this.sailingDate, this.returnDate);
    }
    
    /**
     *
     * @return
     */
    public CruiseItinerary getCruiseItinerary(){
        return this.itinerary;
    }
    
    /**
     *Gets Nationality wise Revenue using a hashtable where key is the nationality and corresponding value is the revenue for this cruise
     * @return
     */
    public Hashtable getNationalityWiseRevenue(){
        Hashtable nationalityWiseRevenue = new Hashtable();
        
        for (int i=1;i<passengers.size();i++)// iterates through all elements of nationality to sum up revenue
        {
            String key = passengers.get(i).nationality;
            if(nationalityWiseRevenue.containsKey(key))// if the nationality is already present in the dictionary, increment its revenue by to already existing value
            {
               nationalityWiseRevenue.replace(key,nationalityWiseRevenue.get(key),(double) nationalityWiseRevenue.get(key)+passengers.get(i).moneyPaidForJoiningCruise+passengers.get(i).moneySpentOnCruise); 
            }
            else
            {
                nationalityWiseRevenue.put(key,passengers.get(i).moneyPaidForJoiningCruise+passengers.get(i).moneySpentOnCruise);
            }
        }
        return nationalityWiseRevenue;
    }
    
    /**
     *Same as Nationality Wise Revenue
     * @return
     */
    public Hashtable getAgeWiseRevenue(){
        Hashtable ageWiseRevenue = new Hashtable();
        String str = "";
        for (int i = 0; i<=100;i=i+25){
            ageWiseRevenue.put(str + i + "-"+(i+25), 0.0);
        }
        for (int i=0;i<passengers.size();i++){
            if (passengers.get(i).age>0 && passengers.get(i).age<=25){
                String key = "0-25";
                ageWiseRevenue.replace(key,ageWiseRevenue.get(key),(double) ageWiseRevenue.get(key)+passengers.get(i).moneyPaidForJoiningCruise+passengers.get(i).moneySpentOnCruise);
            }
            else if (passengers.get(i).age>25 && passengers.get(i).age<=50){
                String key = "25-50";
                ageWiseRevenue.replace(key,ageWiseRevenue.get(key),(double) ageWiseRevenue.get(key)+passengers.get(i).moneyPaidForJoiningCruise+passengers.get(i).moneySpentOnCruise);
            }
            else if (passengers.get(i).age>50 && passengers.get(i).age<=75){
                String key = "50-75";
                ageWiseRevenue.replace(key,ageWiseRevenue.get(key),(double) ageWiseRevenue.get(key)+passengers.get(i).moneyPaidForJoiningCruise+passengers.get(i).moneySpentOnCruise);
            }
            else if (passengers.get(i).age>75 && passengers.get(i).age<=100){
                String key = "75-100";
                ageWiseRevenue.replace(key,ageWiseRevenue.get(key),(double) ageWiseRevenue.get(key)+passengers.get(i).moneyPaidForJoiningCruise+passengers.get(i).moneySpentOnCruise);
            }
        }
        return ageWiseRevenue;
        
    }
    
    /**
     *Gets total salary cost for the cruise
     * @return
     */
    public double getTotalSalaryCost(){
        double totalSalaryCost = 0;
        totalSalaryCost = totalSalaryCost + this.ship.getCaptain().salary;
        for (int i =0;i<this.ship.getEngineers().length;i++){
            this.ship.getEngineers()[i].toString();
            totalSalaryCost = totalSalaryCost + this.ship.getEngineers()[i].salary; //Sums up each sailors salary in the existing total salary
        }
        for (int i =0;i<this.ship.getCooks().length;i++){
            this.ship.getCooks()[i].toString();
            totalSalaryCost = totalSalaryCost + this.ship.getCooks()[i].salary;
        }
        for (int i =0;i<this.ship.getSailors().length;i++){
            this.ship.getSailors()[i].toString();
            totalSalaryCost = totalSalaryCost + this.ship.getSailors()[i].salary;
        }
        for (int i =0;i<this.ship.getDoctors().length;i++){
            this.ship.getDoctors()[i].toString();
            totalSalaryCost = totalSalaryCost + this.ship.getDoctors()[i].salary;
        }
        return totalSalaryCost;
    }
    
    /**
     *Gets the total docking fee by calling the setDockingFee function on each port, the cruise passess through
     * @return
     */
    public double getTotalDockingFee(){
        //Docking Fees
        double totalDockingFee =0;
        for (int i=0;i<this.itinerary.portsCovered.size();i++){
            this.itinerary.portsCovered.get(i).setDockingFee(this.ship);
            totalDockingFee = totalDockingFee + this.itinerary.portsCovered.get(i).getDockingFee();
        }
        return totalDockingFee;
    }
    
    /**
     *Total Expenditure is total cost of salary and total docking fee
     * @return
     */
    public double getTotalExpenditure(){
        
        double totalExpenditure =0;
        totalExpenditure = getTotalSalaryCost() + getTotalDockingFee();
        
        return totalExpenditure;
    }
    
    /**
     * Sorts all passengers using their money spent
     */
    public void getPassengerDetailsSorted(){
        double leastMoneySpentOnCruise = passengers.get(0).moneySpentOnCruise;
        for (int i=1;i<passengers.size();i++){
            while(passengers.get(i).moneySpentOnCruise<passengers.get(i-1).moneySpentOnCruise){ //Checks the passenger before and exchanges positions if its smaller in value. Keeps going until it checks every value
                Passenger tmpPassenger = passengers.get(i-1); 
                passengers.set((i-1),passengers.get(i));
                passengers.set(i,tmpPassenger);
                if (i!=1){
                i--;}
            }
        }
        String passengerDetails ="";
        for (int i=1;i<passengers.size();i++){
            passengerDetails = passengerDetails + passengers.get(i).toString()+"\n";
        }
    }
    
    /**
     *Profit is Total REvenue - Total Cost
     * @return
     */
    public double getProfit (){
        double totalCost = getTotalExpenditure();
        double totalRevenues = 0;
        for (int i=0;i<passengers.size();i++){
            totalRevenues = totalRevenues+ passengers.get(i).moneyPaidForJoiningCruise + passengers.get(i).moneySpentOnCruise;
        }
        double totalProfit = totalRevenues - totalCost;
        return totalProfit;
    }
    /**
     * REturn details of the cruise in form of a string
     * @return 
     */
    @Override
    public String toString(){
        String cruiseDetail = "";
        cruiseDetail = cruiseDetail + "Sailing Date: " + this.sailingDate + "\n";
        cruiseDetail = cruiseDetail + "Return Date: " + this.returnDate + "\n";
        cruiseDetail = cruiseDetail + "Employees: "  + "\n";
        cruiseDetail = cruiseDetail + this.ship.getCaptain().toString()  + "\n";
        cruiseDetail = cruiseDetail + "Engineers: "  + "\n";
        for (int i =0;i<this.ship.getEngineers().length;i++){    
            cruiseDetail = cruiseDetail + this.ship.getEngineers()[i].toString() +"\n";
        }
        cruiseDetail = cruiseDetail + "Cooks: "  + "\n";
        for (int i =0;i<this.ship.getCooks().length;i++){
            cruiseDetail = cruiseDetail + this.ship.getCooks()[i].toString()+"\n";
        }
        cruiseDetail = cruiseDetail + "Sailors: "  + "\n";
        for (int i =0;i<this.ship.getSailors().length;i++){
            cruiseDetail = cruiseDetail + this.ship.getSailors()[i].toString()+"\n";
        }
        for (int i =0;i<this.ship.getDoctors().length;i++){
            cruiseDetail = cruiseDetail + "Doctors: "  + "\n";
            cruiseDetail = cruiseDetail + this.ship.getDoctors()[i].toString()+"\n";
        }
        
        cruiseDetail = cruiseDetail +"\n"+ "Passengers: "  + "\n";
        for (int i =0;i<this.passengers.size();i++){
            cruiseDetail = cruiseDetail + this.passengers.get(i).toString()+"\n";
        }
        
        cruiseDetail = cruiseDetail + "\n" + "Ports of Call: "  + "\n";
        for (int i =0;i<this.itinerary.portsCovered.size();i++){
            cruiseDetail = cruiseDetail + this.itinerary.portsCovered.get(i).toString()+"\n";
        }
        
        cruiseDetail = cruiseDetail + "\n" + "Money Spent by Passengers on cruise: " + "\n";
        double totalRevenues = 0;
        for (int i=0;i<passengers.size();i++){
            totalRevenues = totalRevenues+ passengers.get(i).moneySpentOnCruise;
        }
        cruiseDetail = cruiseDetail + totalRevenues+"\n";
        return cruiseDetail;
    }
    
    /**
     *Gets only employee details in form of a string
     * @return
     */
    public String getEmployeeDetails(){
        String cruiseDetail = "";
        
        cruiseDetail = cruiseDetail + "Employees: "  + "\n";
        cruiseDetail = cruiseDetail + this.ship.getCaptain().toString()  + "\n";
        cruiseDetail = cruiseDetail + "Engineers: "  + "\n";
        for (int i =0;i<this.ship.getEngineers().length;i++){    
            cruiseDetail = cruiseDetail + this.ship.getEngineers()[i].toString() +"\n";
        }
        cruiseDetail = cruiseDetail + "Cooks: "  + "\n";
        for (int i =0;i<this.ship.getCooks().length;i++){
            cruiseDetail = cruiseDetail + this.ship.getCooks()[i].toString()+"\n";
        }
        cruiseDetail = cruiseDetail + "Sailors: "  + "\n";
        for (int i =0;i<this.ship.getSailors().length;i++){
            cruiseDetail = cruiseDetail + this.ship.getSailors()[i].toString()+"\n";
        }
        for (int i =0;i<this.ship.getDoctors().length;i++){
            cruiseDetail = cruiseDetail + "Doctors: "  + "\n";
            cruiseDetail = cruiseDetail + this.ship.getDoctors()[i].toString()+"\n";
        }
        return cruiseDetail;
    }
}
