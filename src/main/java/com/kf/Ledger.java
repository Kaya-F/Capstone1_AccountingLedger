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
            System.out.println("\tD.Add a Deposit ");
            System.out.println("\tP.Make Payment (Debit)");
            System.out.println("\tL. Ledger");
            System.out.println("\tX. Exit.");
            System.out.print("");

            userInput = scanner.nextLine();

            // Show prompt for user showing the possible options and asking for an input
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

    public static void openLedger(){}
}