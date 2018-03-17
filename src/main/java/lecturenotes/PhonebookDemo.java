package lecturenotes;
//Created by Sean C. on 1/30/2018

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PhonebookDemo {
    /*
    * TASK: Write a program that behaves like a phonebook, with menu options
    * to add a new contact, edit an existing one, delete a contact, display all,
    * or exit the program.  The program should initially ask for the user to
    * store as many contacts as desired, stopping when the user enters done.
    */

    public static int menuDisplay(Scanner k){
        System.out.println("1: Add new contact\n2: Edit an existing contact\n" +
                "3: Delete a contact\n4: Display all contacts\n" +
                "5: Exit the program");
        return k.nextInt();
    }

    public static void main(String[] args){
        String input;
        ArrayList<String> phonebook = new ArrayList<String>();

        // System init
        System.out.print("Enter as many contacts as you would like.  Type \"DONE\" when finished\n>>");
        Scanner k = new Scanner(System.in);
        input = k.nextLine();
        while(!input.equalsIgnoreCase("Done")){
            phonebook.add(input);

            System.out.print("Please enter your next contact or type \"DONE\" to exit the program.\n>>");
            input = k.nextLine();
        }

        System.out.println("\"What would you like to do now?");
        int decision = menuDisplay(k);

        while(true){
            switch(decision){
                case 1:
                    // Add
                    System.out.print("Please enter the name and number of your contact.\n>>");
                    k.nextLine();
                    phonebook.add(k.nextLine().trim());
                    System.out.println("Phonebook updated!");
                    Collections.sort(phonebook);
                    break;
                case 2:
                    //Edit
                    System.out.print("Please enter the name of the contact you would like to modify.\n>>");
                    k.nextLine();
                    String edit = k.nextLine().trim();
                    boolean in = false;
                    int index = 0;
                    for(String i : phonebook){
                        if(i.contains(edit)){
                            in = true;
                            index = phonebook.indexOf(i);
                            break;
                        }
                    }
                    if(in){
                        System.out.print("Enter the new contact information. (Name and number)\n>>");
                        String update = k.nextLine();

                        phonebook.set(index, update);
                        Collections.sort(phonebook);
                        System.out.println("Phonebook updated!");
                    }else{
                        System.out.println("Contact not found.");
                    }

                    break;
                case 3:
                    //Delete
                    System.out.print("Please enter the name of the contact you would like to remove.\n>>");
                    k.nextLine();
                    String remove = k.nextLine().trim();
                    in = false;
                    index = 0;

                    for(String i : phonebook){
                        if(i.contains(remove)){
                            in = true;
                            index = phonebook.indexOf(i);
                            break;
                        }
                    }
                    if(in){
                        phonebook.remove(index);
                        System.out.println("Phonebook updated!");
                        break;
                    }else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    //Display
                    int i = 1;
                    for(String c : phonebook){
                        System.out.printf("%d. %s\n",i, c);
                        i++;
                    }
                    System.out.println();
                    break;
                case 5:
                    //Exit
                    System.out.print("Goodbye!");
                    System.exit(1);
                default:
                    //Validate
                    System.out.println("Invalid input, please try again\n\n");
                    menuDisplay(k);
                    break;
            }
            decision = menuDisplay(k);
        }

    }

}
