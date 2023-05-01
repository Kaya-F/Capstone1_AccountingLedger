package com.kf;

import java.util.Scanner;

public class Ledger {
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
            System.out.print("");

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
    public static void addDeposit(){}

    public static void makePayment(){}

    public static void openLedger(){
        String userInput;
        do {
            System.out.println("| Ledger |");
            System.out.println("\tA) All"); // displays all entries
            System.out.println("\tD) Deposits"); // only displays the entries that are deposits into the account
            System.out.println("\tP) Payments");// only displays the negative entries/payments
            System.out.println("\tR) Reports"); // screen allows user to run pre-defined reports or to run a custom search
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
                default:
                    System.out.println("Input command not found.");
            }

        } while (!userInput.equalsIgnoreCase("3"));

    }
    public static void displayAll(){

    }
    public static void displayDeps(){}
    public static void displayPays(){}
    public static void runReports(){
        int subInput;
        String subInput;
        do{

            subInput = scanner.nextInt();

            System.out.println("\t1) Month to Date"); //
            System.out.println("\t2) Previous Month"); //
            System.out.println("\t3) Year to Date"); //
            System.out.println("\t4) Previous Year"); //
            System.out.println("\t5) Search by Vendor"); // user will be prompted for the vendor name
            System.out.println("\t0) Back."); // back to Report page
            System.out.println("\tH) Home."); // back to Ledger Home

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
                    break;
                case "H":
                    break;
                default:
                    System.out.println("Input command not found.");
            }

        } while (!subInput.equalsIgnoreCase("H"));

    }


}