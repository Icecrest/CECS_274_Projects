package Lab1;
//Created by Sean C. on 1/25/2018

import java.util.Scanner;

public class Warehouse {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("How many items would you like to add?: ");
        int numItems = scan.nextInt();

        String[] items = new String[numItems];
        double[] prices = new double[numItems];

        for(int i = 0; i < items.length; i++){
            System.out.print("~\nEnter a product to insert: ");
            items[i] = scan.next();
            System.out.print("Enter a price for the item: ");
            prices[i] = scan.nextDouble();
        }

        System.out.println("~\n\nItems in the products list:");
        for(int i = 0; i < items.length; i++){
            System.out.println(String.format("%d. %s\t\t$%.2f", i+1, items[i], prices[i]));
        }
        double total = 0.0;
        for(double i : prices){
            total += i;
        }
        System.out.printf("Total:\t\t%.2f", total);

    }

}
