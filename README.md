
Hello and Welcome to My Clear Accounting Ledger Project!

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

CSV File:

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

Below are my Screenshots of what I just went over:
<img width="524" alt="Screenshot 2024-10-18 at 12 28 23 PM" src="https://github.com/user-attachments/assets/9802f96f-1d2b-44a4-87ca-afb2565d34b8">
<img width="503" alt="Screenshot 2024-10-18 at 12 30 37 PM" src="https://github.com/user-attachments/assets/e091783f-3ac2-4edb-b2cb-96945b486726">
<img width="487" alt="Screenshot 2024-10-18 at 12 33 15 PM" src="https://github.com/user-attachments/assets/f2b7dbdd-a0ac-4734-abc4-ef5beffb77c2">
<img width="937" alt="Screenshot 2024-10-18 at 12 34 52 PM" src="https://github.com/user-attachments/assets/84cc1218-d355-457d-83c9-5097d0b983c3">
<img width="889" alt="Screenshot 2024-10-18 at 12 35 44 PM" src="https://github.com/user-attachments/assets/c9d03d16-440e-4a6c-bc3c-651705f911f8">
<img width="623" alt="Screenshot 2024-10-18 at 12 36 16 PM" src="https://github.com/user-attachments/assets/e6be2a2a-c739-4807-9c0e-2a9e00d7<img width="829" alt="Screenshot 2024-10-18 at 12 37 09 PM" src="https://github.com/user-attachments/assets/f7117ba1-bb23-4eac-818c-9859a2a61645">
22c2">

![Uploading Screenshot 2024-10-18 at 12.37.09 PM.png…]()<img width="905" alt="Screenshot 2024-10-18 at 12 38 01 PM" src="https://github.com/user-attachments/assets/d698120d-277e-4142-b901-8ad8e9d449e6">



<img width="545" alt="Screenshot 2024-10-18 at 12 38 31 PM" src="https://github.com/user-attachments/assets/797f6365-399e-40a4-a6a9-be416712e698">
<img width="890" alt="Screenshot 2024-10-18 at 12 39 25 PM" src="https://github.com/user-attachments/assets/a10d7727-2c45-4bdc-9956-4ab38a99a7c3">

<img width="637" alt="Screenshot 2024-10-18 at 12 39 53 PM" src="https://github.com/user-attachments/assets/b7cb88e1-0428-4746-bc2d-94d018ecd435">

<img width="556" alt="Screenshot 2024-10-18 at 12 40 40 PM" src="https://github.com/user-attachmen<img width="634" alt="Screenshot 2024-10-18 at 12 41 11 PM" src="https://github.com/user-attachments/assets/3a8ac430-adde-4791-8cf2-5082e48001d4">
ts/assets/e8828a4f-8510-419e-b396-361e566778e6">
<img width="626" alt="Screenshot 2024-10-18 at 12 41 45 PM" src="https://github.com/user-attachments/assets/4ff7c87c-2b1f-4959-ae4f-ad6b7b025f06">
<img width="677" alt="Screenshot 2024-10-18 at 12 42 21 PM" src="https://github.com/user-attachments/assets/12a93e6b-0ba9-4696-9b54-9c44143cce6c">





Thanks for exploring my project! 
