/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruisecompany;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;
import java.time.LocalDate;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Set;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *Creates a company which has 1-5 cruises and all attributes within it
 * @author paridhichoudhary
 */
public class CruiseCompany {

    /**
     *
     */
    public Cruise[] cruises;
    Random rand = new Random();
    
    /**
     *Calls the constructor of cruise to set up
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public CruiseCompany() throws FileNotFoundException, IOException, Exception{
        OutputFileWriter fileWrite = new OutputFileWriter();
        int n = 1+ rand.nextInt(5);
        cruises = new Cruise[n];
        LocalDate today = LocalDate.now();
        Calendar startingDate = Calendar.getInstance();
        startingDate.set(today.getYear(),today.getMonthValue(),today.getDayOfMonth());
        Calendar endingDate = Calendar.getInstance();
        endingDate.set(startingDate.get(Calendar.YEAR), startingDate.get(Calendar.DATE),startingDate.get(Calendar.MONTH));
        int daysToAdd = 10 + rand.nextInt(40);
        endingDate.add(Calendar.DATE, daysToAdd);
        for (int i =0 ; i<n; i++){
            cruises[i] = new Cruise(startingDate,endingDate,900);
            //fileWrite.writeFile("Cruise " + (i+1) + " Details.txt", cruises[i].toString());
        }
        
        
    }
    
    /**
     *Calls the input from the user
     * @throws Exception
     */
    public void serveUser() throws Exception{
        OutputFileWriter fileWrite = new OutputFileWriter();
        boolean finish = false;
        try{
        while(finish==false){ // Keep asking until they chose to stop
        int[] inputs = getUserInput();
        Scanner input = new Scanner(System.in);
        
        if (inputs[0]==1){
            System.out.println("Cruise Created."); 
        }
        if (inputs[0]==2 && inputs[1]==2){
            System.out.println("Passengers added Randomly.");
        }
        if (inputs[0]==2 && inputs[1]==1){
            System.out.println("We have " + cruises.length + "cruises. Which cruise do you want to add passengers to?");
            int ans = input.nextInt();
            input.nextLine();
            cruises[ans-1].setPassengersManually(); //Calls set passenger manually method on each option
            System.out.println("Passengers added Manually.");
        }
        if (inputs[0]==3 && inputs[1]==1){
            getRevenueReports();
            System.out.println("Revenue File saved in the folder.");
        }
        if (inputs[0]==3 && inputs[1]==2){//Details of all sailors with salary and docking fee for the cruise
            String answer = ""; 
            for (int i =0;i<cruises.length;i++){
                answer = answer + cruises[i].getEmployeeDetails() + "\n";
                answer = answer + "Total Salary Cost: " + cruises[i].getTotalSalaryCost() + "\n";
                answer = answer + "Total Docking Fee: " + cruises[i].getTotalDockingFee() + "\n";
                
            }
            fileWrite.writeFile("Employee and Cruise Details.txt", answer);
            System.out.println("Employee and Cruise Details are stored in the file: Employee and Cruise Details.txt");
        }
        //Gives the passenger details for all cruises combined
        if (inputs[0]==3 && inputs[1]==3){
            String passengerDetail = ""; 
            for (int i =0;i<cruises.length;i++){
                cruises[i].getPassengerDetailsSorted();
                passengerDetail = passengerDetail + "Cruise " + (i+1) + "Passenger Details: "+"\n";
                for (int j =0;j<cruises[i].passengers.size();j++){
                passengerDetail = passengerDetail + cruises[i].passengers.get(j).toString()+"\n";
                }
            }
            fileWrite.writeFile("PassengerDetails.txt", passengerDetail);
            System.out.println("Passenger Details are as store in the file: PassengerDetails.txt");
        
        }
        //Gives the evaluation form  details for all cruises combined
        if (inputs[0]==3 && inputs[1]==4){
            String passengerEvaluationForms = "";
            for (int i =0;i<cruises.length;i++){
                cruises[i].getPassengerDetailsSorted();
                passengerEvaluationForms = passengerEvaluationForms + "Cruise" + (i+1) + "Passenger Evaluation Forms: "+"\n";
                for (int j =0;j<cruises[i].passengers.size();j++){
                passengerEvaluationForms = passengerEvaluationForms + cruises[i].passengers.get(i).fillEvaluationForm()+"\n";
                }
            }
            fileWrite.writeFile("PassengerEvaluations.txt", passengerEvaluationForms);
            System.out.println("Passenger Evaluations are as store in the file: Evaluations.txt");
        }
        //Gives the Profits for all cruises 
        if (inputs[0]==3 && inputs[1]==5){
            for (int i =0;i<cruises.length;i++){
                double cruiseProfit = cruises[i].getProfit();
                System.out.println("Cruise " +(i+1)+"Profit is: " + cruiseProfit);
            }
        }
        if (inputs[0]==4){
            for (int i =0;i<cruises.length;i++){
                fileWrite.writeFile("Cruise " + (i+1) + " Details.txt", cruises[i].toString());
            }
        }
        //Keeps asking if they want to see more options
        System.out.println("What Else do you want to do. Please enter Yes to see the menu again? ");
        String ans = input.nextLine();
        if (ans.equals("Yes")){
            finish = false;
        }
        else{
            System.out.println("Either you want to close the menu or you have entered a wrong value. We are closing the user menu.");
            finish = true;
        }
        }
        } catch(Exception e){
            System.out.println("Invalid Input. Please start over again.");
        }
}
        
    /**
     * Get the inputs from the user. Takes inputs for the feature chosen and stores the responses in an array to be used in ServeUser function
     * @return
     */
    public int[] getUserInput(){
        ArrayList<String[]> panelOptions = new ArrayList();
        //All options for user menu
        String[][] option = {{"Create a cruise with ship, sailors and ports randomly"},
                             {"Add passengers to a cruise",
                              "Do you want to add passengers Manually?",
                              "Do you want to add passengers Randomly?"
                             },
                             {"Provide reports on the following areas:",
                              "Revenue generated from the cruise passengers by nationality and age",
                              "Details of all Sailors that worked on a cruise and the total cost of paying their salaries and the total cost of docking at different ports",
                              "List of passengers with their details sorted by moneySpentOnCruise",
                              "Cruise evaluation by passengers (assume each passenger completes a 5 question survey at the end of the cruise and generate/store random responses)",
                              "Did the ship make a profit? Use the expenses and earnings from passengers."
                             },
                            {
                             "Information about the cruise including employees, passengers, ports-of-call, and money spent by employees on the cruise must be stored in text files once the cruise is over."
                            }
                          };
        for (int i=0;i<option.length;i++){
            panelOptions.add(option[i]);
        }
        
        UserPanel userPanel = new UserPanel(panelOptions);
        
        Scanner input = new Scanner(System.in);
        int[] indexes = new int[panelOptions.size()];
        for (int i=0;i<panelOptions.size();i++)
        {
            indexes[i] =i;
        }
        System.out.println("Please see below the features available: ");
        userPanel.displayPanelOptions(indexes);
        int[] chosenOption = new int[2];
        chosenOption[0] = input.nextInt();
        input.nextLine();
        if (chosenOption[0]==3){
            System.out.println("Which of the option in 3 would you like to choose? ");
            chosenOption[1] = input.nextInt();
            input.nextLine();
        }
        else if (chosenOption[0]==2){
            System.out.println("Which of the option in 2 would you like to choose? ");
            chosenOption[1] = input.nextInt();
            input.nextLine();
        }
        else{
            chosenOption[1]=0;
        }
        return chosenOption;
    }
    
    /**
     * Reports to generate revenue based on functions in each cruise
     * @throws Exception
     */
    public void getRevenueReports() throws Exception{
        OutputFileWriter fileWrite = new OutputFileWriter();
        String revenueReport = "";
        Hashtable nationalityWiseRevenue = new Hashtable();
        
        nationalityWiseRevenue = cruises[0].getNationalityWiseRevenue();
                
        for (int i=1;i<cruises.length;i++)// iterates through all elements of rollsum to count frequency
        {
            Set<String> keySet = cruises[i].getNationalityWiseRevenue().keySet();
            
            for (String key: keySet){
                if(nationalityWiseRevenue.containsKey(key))// if the sum is already present in the dictionary, increment its frequency by 1 else add a new key to the dictionary
                    {
                       nationalityWiseRevenue.replace(key,nationalityWiseRevenue.get(key),(double) nationalityWiseRevenue.get(key)+(double)cruises[i].getNationalityWiseRevenue().get(key)); 
                    }
                else
                    {
                        nationalityWiseRevenue.put(key,(double) cruises[i].getNationalityWiseRevenue().get(key));
                    }
            }
            
        }
            revenueReport = revenueReport + "NationalityWiseRevenue" + "\n";
        {
            Set<String> keySet = nationalityWiseRevenue.keySet();
            
            for (String key: keySet){
                revenueReport = revenueReport + key + " : " + nationalityWiseRevenue.get(key) + "\n";
            }
            
           
        }
        
        revenueReport = revenueReport + "\n\n";
        
        Hashtable ageWiseRevenue = new Hashtable();
        
        ageWiseRevenue = cruises[0].getAgeWiseRevenue();
                
        for (int i=1;i<cruises.length;i++)// iterates through all elements of rollsum to count frequency
        {
            Set<String> keySet = cruises[i].getAgeWiseRevenue().keySet();
            
            for (String key: keySet){
                if(ageWiseRevenue.containsKey(key))// if the sum is already present in the dictionary, increment its frequency by 1 else add a new key to the dictionary
                    {
                       ageWiseRevenue.replace(key,ageWiseRevenue.get(key),(double) ageWiseRevenue.get(key)+(double)cruises[i].getAgeWiseRevenue().get(key)); 
                    }
                else
                    {
                        ageWiseRevenue.put(key,(double) cruises[i].getAgeWiseRevenue().get(key));
                    }
            }
            
        }
        revenueReport = revenueReport + "AgeWiseRevenue" + "\n";
        {
            Set<String> keySet = ageWiseRevenue.keySet();
            
            for (String key: keySet){
               revenueReport = revenueReport + key + " : " + ageWiseRevenue.get(key)+"\n";
            }
        }
        fileWrite.writeFile("Nationality and Age wise Revenue Report.txt", revenueReport);
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws IOException, Exception {
        // TODO code application logic here
        CruiseCompany NarniaCruise = new CruiseCompany();
        NarniaCruise.serveUser(); //Calls the serveUser function for cruise COmpany which calls all the other methods
        
    }  
        
}
    

