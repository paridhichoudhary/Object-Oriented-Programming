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
/**
 *
 * @author paridhichoudhary
 */
public class CruiseItinerary {
    
    /**
     *
     */
    public Calendar startingDate;

    /**
     *
     */
    public Calendar endingDate;

    /**
     *
     */
    public ArrayList<PortOfCall> portsCovered = new ArrayList();   // contains list of ports through which Cruise goes in an ascending order
    
    Random rand = new Random();
    
    /**
     *
     * @param startingDate: Date on which cruise Started. Set randomly
     * @param endingDate: Date on which Cruise ended. Set Randomly.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public CruiseItinerary(Calendar startingDate, Calendar endingDate) throws FileNotFoundException, IOException{
        
        setStartingDate(startingDate);
        setEndingDate(endingDate);
        setPortsCovered();
        
    }
    
    /**
     *
     * @param startingDate
     */
    public void setStartingDate(Calendar startingDate){
        this.startingDate = startingDate;
    }
    
    /**
     *
     * @return
     */
    public Calendar getStartingDate(){
        return this.startingDate;
    }
    
    /**
     *
     * @param startingDate
     */
    public void setEndingDate(Calendar startingDate){
        this.endingDate = endingDate;
    }
    
    /**
     *
     * @return
     */
    public Calendar getEndingDate(){
        return this.endingDate;
    }
   
    /**
     *Takes input from PortsData.txt and creates 2-6 ports randomly out of it.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void setPortsCovered() throws FileNotFoundException, IOException{
        InputFileReader reader = new InputFileReader();
        reader.readFile("PortsData.txt");    
        int n = 2 + rand.nextInt(5); // Number of ports covered
        for (int i=0;i<n-1;i++){
            int m = 1 + rand.nextInt(reader.fieldsLines.size()-1);
            String[] portDetails = reader.wordsArray.get(m);
            reader.fieldsLines.remove(m);
            reader.wordsArray.remove(m);
            PortOfCall port = new PortOfCall(portDetails[0],portDetails[1],Long.parseLong(portDetails[2]));
            this.portsCovered.add(i, port);
            
        }
            this.portsCovered.add(n-1,portsCovered.get(0));
        
    }
    
    /**
     *Returns the ports covered in the itinerary
     * @return
     */
    public ArrayList<PortOfCall> getPortsCovered(){
        return this.portsCovered;
    }
    
    
    
}
