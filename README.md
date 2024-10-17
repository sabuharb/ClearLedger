 ClearAccountLedger & Transaction - README

Project Overview

This project is an Accounting Ledger Application designed to help track financial transactions such as:
deposits and payments. 
It includes two key components:
 the ClearAccountLedger class, which handles the overall ledger operations,
 and the Transaction class, which represents individual transactions.

ClearAccountLedger Class:

This class is the main controller of the application. It allows you to:

- Add a Deposit: Record a new deposit to the ledger by entering the date, time, description, vendor, and amount.
- Make a Payment: Record a new payment (negative transaction) by entering the same details.
- View Ledger: Access the full list of transactions, only deposits, or only payments.
- Run Reports: Generate detailed reports like month-to-date, year-to-date, previous month, and previous year transactions. You can also search transactions by vendor.

Transaction Class:

Each financial transaction is an object of this class. It contains:

- Date: When the transaction occurred.
- Time: The exact time of the transaction.
- Description: A short description of the transaction.
- Vendor: Who the transaction was with.
- Amount: The amount of money (positive for deposits, negative for payments).

The Transaction class also includes:

- toString(): Formats how transactions are displayed.
- toCsvString Converts transaction details into a format to be saved in a CSV file.

How It Works?

 1. Adding a Deposit
You will be asked to input the transaction details. Once added, the deposit is saved and can be viewed later in the ledger.

2. Making a Payment
This is similar to adding a deposit, except that the amount will be negative, representing a payment. 

 3. Viewing the Ledger
You can view all transactions, filter for deposits, or filter for payments. A simple report is generated, listing all transactions.

 4. Running Reports
You can generate reports based on time ranges, like:
- Month to Date
- Year to Date
- Previous Month
- Previous Year

You can also search for specific transactions by vendor.

## CSV File

Transactions are saved in a CSV file (transactions.csv) using the following format:


YYYY-MM-DD | HH:MM:SS | Description | Vendor | Amount


This ensures that all transactions are easily saved and loaded when the application starts.

What I Learned?

As a beginner in Java programming, I learned how to:
- Use Java to create classes and objects.
- Work with Scanner for user input.
- Store and manipulate data using HashMap.
- Read from and write to a CSV file using BufferedReader and BufferedWriter.
- Implement basic reports using loops and date filtering with Java's LocalDate.

This project helped me understand how financial transactions can be tracked in real-world applications and how to structure a simple command-line interface.

 Future Improvements

- Add more complex reporting options.
- Enhance error handling for user input.
- Build a graphical user interface (GUI) to make the app more user-friendly.

Thanks for exploring my project! 
