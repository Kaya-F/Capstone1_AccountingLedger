# Accounting Ledger
With this application you can track all financial transactions for a business or personal use.

All transactions in the application should be read from and saved to a transaction file named transactions.csv. Each transaction should be saved as a single line with the following format.
```
date|time|description|vendor|amount
2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50 2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00 
```
[loadTransactionsFromFile()] to read data from file...
```
try { // Create a try/catch statement to handle file import
// Create an instance of FileReader with an approximate path of "./src/main/java/com/kf/transactions.txt"
FileReader transactionFile = new FileReader("./src/main/java/com/kf/transactions.txt");
BufferedReader bufferedReader = new BufferedReader(transactionFile);
String line = bufferedReader.readLine();
// Create a variable that stores a property instance using the data from the current line
while (line != null) {
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
```
### First Screen (Ledger Home)
```
System.out.println("| Home |");
System.out.println("\tD) Add a Deposit "); // prompts user for deposit info and saves it to the txt file
System.out.println("\tP) Make Payment (Debit)"); // prompts user for debit info and saves it to the txt file
System.out.println("\tL) Ledger"); // displays ledger screen
System.out.println("\tX) Exit."); 
```
### Second Screen (Ledger History)
```
System.out.println("| Ledger |");
System.out.println("\tA) All"); // displays all entries
System.out.println("\tD) Deposits"); // only displays the entries that are deposits into the account
System.out.println("\tP) Payments");// only displays the negative entries/payments
System.out.println("\tR) Reports"); // screen allows user to run pre-defined reports or to run a custom search
System.out.println("\tH) Home."); // back to Ledger Home
```
### Third Screen (Reports)
```
System.out.println("\t1) Month to Date"); // displays transaction history from currentmonth to now 
System.out.println("\t2) Previous Month"); // displays transaction history from previous month
System.out.println("\t3) Year to Date"); // displays transaction history from currentyear to now
System.out.println("\t4) Previous Year"); // displays transaction history from previous year
System.out.println("\t5) Search by Vendor"); // user will be prompted for the vendor name and displays all entries from that vendor
System.out.println("\t0) Back."); // back to Report page
```  
Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "main"
