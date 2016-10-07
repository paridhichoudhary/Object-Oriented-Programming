/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InvoiceSummary;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 Takes inputs of 3 items with their description ( name, quantity, price) and provides the invoice summary
 * with tax added to the subtotal 
 */
public class InvoiceSummary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        // Give the command to input your name and assign to a variable
        System.out.printf("Please enter your name: ");
        String per_name = input.nextLine();
        
        // Give the command to input first item name, quantity and price and assign to a variable
        Item item1 = new Item();
        String item1_name = item1.getItemName("first");
        int item1_qty = item1.getItemQuantity("first");
        double item1_price = item1.getItemPrice("first");
        // Give the command to input first item name, quantity and price and assign to a variable
        Item item2 = new Item();
        String item2_name = item1.getItemName("second");
        int item2_qty = item1.getItemQuantity("second");
        double item2_price = item1.getItemPrice("second");
        // Give the command to input first item name, quantity and price and assign to a variable
        Item item3 = new Item();
        String item3_name = item1.getItemName("third");
        int item3_qty = item1.getItemQuantity("third");
        double item3_price = item1.getItemPrice("third");
        
        // Assign a random number to invoice_num
        Random rand = new Random();
        int invoice_num = 10000 + rand.nextInt(99999);
        
        // Take local date using now function in LocalDate package
        LocalDate today = LocalDate.now();

        // Tax Rate to be assigned to a variable
        double tax_rate = (0.0725);
        
        // Calculate item wise total, subtotal, taxes applicable and the final_total including everything
        double item1_total = (item1_qty * item1_price);
        double item2_total = (item2_qty * item2_price);
        double item3_total = (item3_qty * item3_price);
        double sub_total = (item1_total + item2_total + item3_total);
        double sales_tax = (sub_total * tax_rate);
        double final_total = (sales_tax + sub_total);
        

        // Print out the output in the format asked
        System.out.printf("%s%-30.30s%s"," ","Invoice for " + per_name, "\n");
        System.out.printf("%s%-30.30s%30s%s"," ","No: " + invoice_num,"Date: "+today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), "\n");
        System.out.printf("%s%-30.30s%10s%10s%10s%s","  ","Item","Quantity","Price","Total","\n");
        System.out.printf("%s%-30.30s%10d%10.2f%10.2f%s","  ",item1_name,item1_qty,item1_price,item1_total,"\n");
        System.out.printf("%s%-30.30s%10d%10.2f%10.2f%s","  ",item2_name,item2_qty,item2_price,item2_total,"\n");
        System.out.printf("%s%-30.30s%10d%10.2f%10.2f%s","  ",item3_name,item3_qty,item3_price,item3_total,"\n");
        System.out.printf("%s%-50.30s%10.2f%s","  ","Subtotal",sub_total, "\n");
        System.out.printf("%s%-50.30s%10.2f%s","  ","7.25% sales tax",sales_tax, "\n");
        System.out.printf("%s%-50.30s%10.2f%s","  ","Total",final_total, "\n");
        
    
    }
    
}
