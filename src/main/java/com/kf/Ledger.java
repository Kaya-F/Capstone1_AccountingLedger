package com.kf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Ledger {
    // create static scanner instance
    // create static variable called transactions, It will be an ArrayList of positive transactions
    // create static instance FileWriter object
    static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        // Initialize variable for user input
        String userInput;

        // Create do-while loop that runs unless the user enters "4"
        do {// Create main menu:
            System.out.println("| Home |");
            System.out.println("\tD) Add a Deposit ");
            System.out.println("\tP) Make Payment (Debit)");
            System.out.println("\tL) Ledger");
            System.out.println("\tX) Exit.");
            System.out.print("Command: ");

            userInput = scanner.nextLine();

            // Create switch statement that handles cases related to each menu item
            switch (userInput){
                case "D":
                    addDeposit(); // Runs custom static method called addDeposit
                    break;
                case "P":
                    makePayment(); // Runs custom static method called makePayment
                    break;
                case "L":
                    openLedger(); // Runs custom static method called openLedger
                    break;
                case "X":
                    System.out.println("Exiting Application...");
                default:
                    System.out.println("Input command not found.");
            }

        } while(!userInput.equalsIgnoreCase("4"));

    }
    public static void addDeposit(){

        System.out.println("\t| Add Deposit |");
        System.out.println("Date of deposit (YYYY-MM-DD): ");
        float date = scanner.nextFloat();

        System.out.println("Time of deposit (HH:MM:SS): ");
        float time = scanner.nextFloat();

        System.out.println("Short description of deposit: ");
        String desc = scanner.nextLine();

        System.out.println("Vendor of deposit: ");
        String vendor = scanner.nextLine();


        System.out.println("Amount for deposit: ");
        float amount = scanner.nextFloat();
        scanner.nextLine();


        Transaction deposit = new Transaction(date, time, desc, vendor, amount);
        transactions.add(deposit);

        try {
            FileWriter fileWriter = new FileWriter("./src/main/java/com/kf/Transactions.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write( "Deposit: " + date + "|" + time + "|" + desc + "|" + vendor + "|" + amount);
            System.out.println("Deposit added successfully. ");
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Unsuccessful Deposit. ");
            e.printStackTrace();
        }
    }



    public static void makePayment(){}

    public static void openLedger(){
        String userInput;
        do {
            System.out.println("| Ledger |");
            System.out.println("\tA) All"); // displays all entries
            System.out.println("\tD) Deposits"); // only displays the entries that are deposits into the account
            System.out.println("\tP) Payments");// only displays the negative entries/payments
            System.out.println("\tR) Reports"); // screen allows user to run pre-defined reports or to run a custom search
            System.out.println("\tH) Home."); // back to Ledger Home
            System.out.print("Command: ");

            userInput = scanner.nextLine();

            switch(userInput){ // Ledger Menu
                case "A":
                    displayAll(); // Runs custom static method called displayAll
                    break;
                case "D":
                    displayDeps();  // Runs custom static method called displayDeps
                    break;
                case "P":
                    displayPays(); // Runs custom static method called displayPays
                    break;
                case "R":
                    runReports(); // Runs custom static method called runReports
                    break;
                case "H":
                    break;
                default:
                    System.out.println("Input command not found.");
            }

        } while (!userInput.equalsIgnoreCase("3"));

    }
    public static void displayAll(){
        for (Transaction currentTransaction : transactions) {
            System.out.println(currentTransaction);
        }

    }
    public static void displayDeps(){

    }
    public static void displayPays(){}
    public static void runReports(){
        int subInput;
        do{

            subInput = scanner.nextInt();

            System.out.println("\t1) Month to Date"); //
            System.out.println("\t2) Previous Month"); //
            System.out.println("\t3) Year to Date"); //
            System.out.println("\t4) Previous Year"); //
            System.out.println("\t5) Search by Vendor"); // user will be prompted for the vendor name
            System.out.println("\t0) Back."); // back to Report page

            switch(subInput){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Input command not found.");
            }

        } while (subInput != 0 );

    }
    public static void readFromFile(){

    }

}