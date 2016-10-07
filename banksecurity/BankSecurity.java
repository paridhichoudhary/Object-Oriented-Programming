/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksecurity;
import java.util.List;

/**
 * Class converts number provided by the user into words representing same cash amount
 * @author paridhichoudhary
 */
public class BankSecurity {

    /**
     * Main program to run this code
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cheque cheque = new Cheque();
        cheque.setCash();
        cheque.completeString();

    }
    
}
