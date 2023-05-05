package com.kf;
import java.io.*;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.util.Arrays;
import java.util.Scanner;

public class Ledger {
    // create static scanner instance
    // create static variable called transactions, It will be an ArrayList of positive transactions
    // create static instance FileWriter object
    static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        loadTransactionsFromFile();

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
                    break;
                default:
                    System.out.println("Input command not found.");
            }

        } while(!userInput.equalsIgnoreCase("X"));

    }
    public static void loadTransactionsFromFile(){
        // Read data from file
        try { // Create a try/catch statement to handle file import
            // Create an instance of FileReader with an approximate path of "./src/main/java/com/kf/transactions.txt"
            FileReader transactionFile = new FileReader("./src/main/java/com/kf/transactions.txt");
            BufferedReader bufferedReader = new BufferedReader(transactionFile);

            String line;

            // Create a variable that stores a property instance using the data from the current line
            while((line = bufferedReader.readLine()) != null){
                // Parse/Split the line on "|" and store in variable
                String[] splitLine = line.split("\\|");
                String date = splitLine[0];
                String time = splitLine[1];
                String desc = splitLine[2];
                String vendor = splitLine[3];
                float amount = Float.parseFloat(splitLine[4]);

                Transaction transaction = new Transaction(date, time, desc, vendor, amount);
                transactions.add(transaction);

            }
            // Close the scanner instance
            bufferedReader.close();
            // Handle catch/exception
        } catch (IOException e){
            System.out.println("Failed to load transactions from file.");
            e.printStackTrace();
        }

    }


    public static void addDeposit(){

        System.out.println("\t| Add Deposit |");
        System.out.println("Date of deposit (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.println("Time of deposit (HH:MM:SS): ");
        String time = scanner.nextLine();

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
            FileWriter fileWriter = new FileWriter("./src/main/java/com/kf/Transactions.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n" + date + "|" + time + "|" + desc + "|" + vendor + "|" + amount);
            System.out.println("Deposit added successfully. ");
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Unsuccessful Deposit. ");
            e.printStackTrace();
        }
    }



    public static void makePayment(){
        System.out.println("\t| Make Payment |");
        System.out.println("Date of payment (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.println("Time of payment (HH:MM:SS): ");
        String time = scanner.nextLine();

        System.out.println("Short description of payment: ");
        String desc = scanner.nextLine();

        System.out.println("Vendor of payment: ");
        String vendor = scanner.nextLine();


        System.out.println("Amount for payment: ");
        float amount = scanner.nextFloat() * -1;
        scanner.nextLine();


        Transaction payment = new Transaction(date, time, desc, vendor, amount);
        transactions.add(payment);

        try {
            FileWriter fileWriter = new FileWriter("./src/main/java/com/kf/Transactions.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n" + date + "|" + time + "|" + desc + "|" + vendor + "|" + amount);
            System.out.println("Payment made successfully. ");
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Unsuccessful Payment. ");
            e.printStackTrace();
        }
    }

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
                    System.out.println("Returning to Home...");
                    return;
                default:
                    System.out.println("Input command not found.");
            }

        } while (!userInput.equalsIgnoreCase("H"));

    }
    public static void displayAll(){
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }

    }
    public static void displayDeps(){
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() > 0 ) {
                System.out.println(transaction.getAmount());
            }
        }
    }
    public static void displayPays(){
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0 ) {
                System.out.println(transaction.getAmount());
            }
        }
    }
    public static void runReports() {
        int subInput;
        String vendorName;
        do {
            System.out.println("\t1) Month to Date"); //
            System.out.println("\t2) Previous Month"); //
            System.out.println("\t3) Year to Date"); //
            System.out.println("\t4) Previous Year"); //
            System.out.println("\t5) Search by Vendor"); // user will be prompted for the vendor name
            System.out.println("\t0) Back."); // back to Report page
            System.out.print("Command: ");

            subInput = scanner.nextInt();
            switch (subInput) {
                case 1:
                    break;
                case 2:
                    System.out.print("| Last Month's Reports |");
                    break;
                case 3:
                    break;
                case 4:
                    System.out.print("| Last Year's Reports |");
                    break;
                case 5:
                    System.out.println("\nEnter Vendor name or...");
                    vendorName = scanner.nextLine();
                    for (Transaction transaction : transactions) {
                        System.out.println(transaction);
                        if(vendorName.equalsIgnoreCase(transaction.getVendor())){
                            System.out.println(transaction.getVendor());
                        }
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Input command not found.");
            }

        } while (subInput != 0);


    }


}