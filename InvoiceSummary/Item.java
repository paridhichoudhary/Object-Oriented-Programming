/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InvoiceSummary;
import java.util.Scanner;

/**
 *
Takes description inputs of the items i.e. name, quantity and price
 */
public class Item {
    Scanner input = new Scanner(System.in);
    public String getItemName(String s){
        System.out.printf("Please enter name of " + s + " item: ");
        String name = input.nextLine();
        return name;
    }
    
    public int getItemQuantity(String s){
        System.out.printf("Please enter quantity of " + s + " item: ");
        int qty = input.nextInt();
        input.nextLine();
        return qty;
    }
    
    public double getItemPrice(String s){
        System.out.printf("Please enter price of " + s +" item: ");
        double price = input.nextDouble();
        input.nextLine();
        return price;
    }
    
}
