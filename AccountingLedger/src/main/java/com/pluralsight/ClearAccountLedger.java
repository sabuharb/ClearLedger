package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClearAccountLedger {
    private static final String CSV_FILE = "AccountingLedger/src/main/resources/transactions.csv";
    private static Map<String, Transaction> transactions = new HashMap<>();

    public static void main(String[] args) {

        transactions = loadTransactions();

        Scanner scanner = new Scanner(System.in);
        String option;

        do {
            showMenu();
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    addDeposit(transactions, scanner);
                    break;
                case "2":
                    makePayment(transactions, scanner);
                    break;
                case "3":
                    showLedgerMenu(transactions, scanner);
                    break;
                case "4":
                    saveTransactions(transactions);
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        } while (!option.equals("4"));
    }


    private static void showMenu() {
        System.out.println("\uD83C\uDF38Welcome to Clear Accounting Ledger!\uD83C\uDF38");
        System.out.println("-------------------------------");
        System.out.println("▐░░░░░░░⚜️Main Menu ⚜️░░░░░░▌");
        System.out.println("-------------------------------");
        System.out.println("🔰 1\uFE0F⃣ Add a Magical Deposit! ✨");
        System.out.println("🔰 2\uFE0F⃣ Make a Lovely Payment \uD83D\uDC95");
        System.out.println("🔰 3\uFE0F⃣ Peek at Your Cute Ledger \uD83D\uDCD6");
        System.out.println("🔰 4\uFE0F⃣ Wave Goodbye and Exit \uD83D\uDC4B");
        System.out.println("\uD83D\uDC49 Enter your choice here: ");
    }


    private static void showLedgerMenu(Map<String, Transaction> transactions, Scanner scanner) {
        String option;
        do {
            System.out.println("------------------------------");
            System.out.println("\n▐░░░░░░ \uD83C\uDF3CLedger Menu\uD83C\uDF3C ░░░░░░▌");
            System.out.println("------------------------------");
            System.out.println("🔰1\uFE0F⃣ View All the Sparkly Entries ✨");
            System.out.println("🔰2\uFE0F⃣ Only Show Sweet Deposits \uD83D\uDCB0");
            System.out.println("🔰3\uFE0F⃣ Only Show Pretty Payments \uD83D\uDCB8");
            System.out.println("🔰4\uFE0F⃣ Run Magical Reports \uD83D\uDD2E");
            System.out.println("🔰5\uFE0F⃣ Go Back to the Cozy Main Menu \uD83C\uDFE0");
            System.out.println("\uD83D\uDC49 Enter your choice here: ");
            option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "1":
                    showLedger(transactions);
                    break;
                case "2":
                    viewOnlyDeposits(transactions);
                    break;
                case "3":
                    viewOnlyPayments(transactions);
                    break;
                case "4":
                    showReportsMenu(transactions, scanner);
                    break;
                case "5":
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        } while (!option.equals("5"));
    }


    private static void showReportsMenu(Map<String, Transaction> transactions, Scanner scanner) {
        String option;
        do {
            System.out.println("------------------------------");
            System.out.println("\n▐░░░░░░ \uD83D\uDD2E Magical Reports Menu \uD83D\uDD2E ░░░░░░▌");
            System.out.println("------------------------------");
            System.out.println("🔰1\uFE0F⃣ Month-To-Date \uD83C\uDF1F\"");
            System.out.println("🔰2\uFE0F⃣ Previous Month \uD83C\uDF19");
            System.out.println("🔰3\uFE0F⃣ Year-To-Date \uD83C\uDF1E\"");
            System.out.println("🔰4\uFE0F⃣ Previous Year \uD83C\uDF0C");
            System.out.println("🔰5\uFE0F⃣ Search by Vendor \uD83D\uDD0D");
            System.out.println("🔰0\uFE0F⃣ Go Back \uD83C\uDFE0");
            System.out.println("\uD83D\uDC49 Enter your choice here: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    monthToDate(transactions);
                    break;
                case "2":
                    previousMonth(transactions);
                    break;
                case "3":
                    yearToDate(transactions);
                    break;
                case "4":
                    previousYear(transactions);
                    break;
                case "5":
                    searchByVendor(scanner, transactions);
                    break;
                case "0":
                    System.out.println("\uD83D\uDC49 Enter your choice here: ");
                    break;
                default:
                    System.out.println("❌ Hmm, I didn’t catch that. Try again! ❌");
            }
        } while (!option.equals("0"));
    }


    private static void addDeposit(Map<String, Transaction> transactions, Scanner scanner) {
        System.out.println("\uD83D\uDCC5 Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.println("⏰ Enter time (HH:MM:SS): ");
        String time = scanner.nextLine();
        System.out.println("\uD83D\uDCDD What’s the description? ");
        String description = scanner.nextLine();
        System.out.println("\uD83C\uDFE2 Who is the Vendor? ");
        String vendor = scanner.nextLine();
        System.out.println("\uD83D\uDCB5 How much are we adding? ");
        double amount = Double.parseDouble(scanner.nextLine());

        Transaction deposit = new Transaction(date, time, description, vendor, amount);
        transactions.put(description, deposit);
        System.out.println("\uD83C\uDF89 Woohoo! Deposit added successfully! \uD83C\uDF89");
    }


    private static void makePayment(Map<String, Transaction> transactions, Scanner scanner) {
        System.out.println("\uD83D\uDCB8 Let’s record your payment! \uD83D\uDCB8");
        System.out.println("\uD83D\uDCC5 Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.println("⏰ Enter time (HH:MM:SS): ");
        String time = scanner.nextLine();
        System.out.println("\uD83D\uDCDD What’s the description? ");
        String description = scanner.nextLine();
        System.out.println("\uD83C\uDFE2 Who is the Vendor? ");
        String vendor = scanner.nextLine();
        System.out.println("\uD83D\uDCB5 How much are we paying? (use negative for payments): ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount >0) {
            amount = -amount;
        }

        Transaction payment = new Transaction(date, time, description, vendor, amount);
        transactions.put(description, payment);
        System.out.println("✔\uFE0F Payment recorded! You’re doing great! \uD83C\uDF1F");
    }



    private static Map<String, Transaction> loadTransactions() {
        Map<String, Transaction> transactions = new HashMap<>();
        try
                (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split("\\|");

                if (data.length != 5) {
                    System.out.println("Invalid transaction format: " + line);
                    continue;
                }

                try {
                    String date = data[0].trim();
                    String time = data[1].trim();
                    String description = data[2].trim();
                    String vendor = data[3].trim();
                    double amount = Double.parseDouble(data[4].trim());

                    Transaction transaction = new Transaction(date, time, description, vendor, amount);
                    transactions.put(description, transaction);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount format in line: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading transactions: " + e.getMessage());
        }
        return transactions;
    }


    private static void saveTransactions(Map<String, Transaction> transactions) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE))) {
            for (Transaction t : transactions.values()) {
                bw.write(t.toCsvString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving transactions!");
        }
    }


    private static void showLedger(Map<String, Transaction> transactions) {
        System.out.println("\n▐░░░░░░ \uD83D\uDCDA Here’s Your Full Ledger \uD83D\uDCDA ░░░░░░▌");
        if (transactions.isEmpty()) {
            System.out.println("It’s a little empty in here. Add something magical! ✨");
        } else {
            for (Transaction t : transactions.values()) {
                System.out.println(t);
            }
        }
    }


    private static void viewOnlyDeposits(Map<String, Transaction> transactions) {
        System.out.println("\n▐░░░░░░ \uD83D\uDCB0 Showing Only Your Happy Deposits! \uD83D\uDCB0 ░░░░░░▌");
        for (Transaction t : transactions.values()) {
            if (t.getAmount() > 0) {
                System.out.println(t);
            }
        }
    }


    private static void viewOnlyPayments(Map<String, Transaction> transactions) {
        System.out.println("\n▐░░░░░░ \uD83D\uDCB8 Showing Only Your Lovely Payments \uD83D\uDCB8 ░░░░░░▌");
        boolean found = false;
        for (Transaction t : transactions.values()) {
            if (t.getAmount() < 0) {
                System.out.println(t);
                found = true;
            }
        }
        if (!found) {
            String vendorSearch = "";
            System.out.println("No Transactions found for vendor: " + vendorSearch);
        }
    }


    private static void displayTransactionsInRange(LocalDate startDate, LocalDate endDate) {
        System.out.println("\n▐░░░░░░ Transactions in Range ░░░░░░▌");
        for (Transaction t : transactions.values()) {
            LocalDate transactionDate = LocalDate.parse(t.getDate());
            if (!transactionDate.isBefore(startDate) && !transactionDate.isAfter(endDate)) {
                System.out.println(t);
            }
        }
    }


    private static void monthToDate(Map<String, Transaction> transactions) {
        ClearAccountLedger.transactions = transactions;
        LocalDate today = LocalDate.now();
        LocalDate startOfMonth = today.withDayOfMonth(1);
        displayTransactionsInRange(startOfMonth, today);
    }

    private static void previousMonth(Map<String, Transaction> transactions) {
        ClearAccountLedger.transactions = transactions;
        LocalDate today = LocalDate.now();
        LocalDate startOfLastMonth = today.minusMonths(1).withDayOfMonth(1);
        LocalDate endOfLastMonth = today.withDayOfMonth(1).minusDays(1);
        displayTransactionsInRange(startOfLastMonth, endOfLastMonth);
    }

    private static void yearToDate(Map<String, Transaction> transactions) {
        ClearAccountLedger.transactions = transactions;
        LocalDate today = LocalDate.now();
        LocalDate startOfYear = today.withDayOfYear(1);
        displayTransactionsInRange(startOfYear, today);
    }

    private static void previousYear(Map<String, Transaction> transactions) {
        ClearAccountLedger.transactions = transactions;
        LocalDate today = LocalDate.now();
        LocalDate startOfLastYear = today.minusYears(1).withDayOfYear(1);
        LocalDate endOfLastYear = today.minusYears(1).withDayOfYear(today.minusYears(1).lengthOfYear());
        displayTransactionsInRange(startOfLastYear, endOfLastYear);
    }

    private static void searchByVendor(Scanner scanner, Map<String, Transaction> transactions) {
        System.out.println("Enter vendor name to search for: ");
        String vendorSearch = scanner.nextLine().toLowerCase();

        System.out.println("\n▐░░░░░░ \uD83D\uDCB8 Showing Only Your Lovely Payments \uD83D\uDCB8 " + vendorSearch + " ░░░░░░▌");
        boolean found = false;
        for (Transaction t : transactions.values()) {
            if (t.getVendor().toLowerCase().contains(vendorSearch)) {
                System.out.println(t);
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ Hmm, I didn’t catch that. Try again! ❌ " + vendorSearch);
        }
    }
}