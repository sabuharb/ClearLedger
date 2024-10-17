package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClearAccountLedger {
    private static final String CSV_FILE = "src/main/resources/transactions.csv";
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
        System.out.println("▐░░░░░░░░░░░░░▌");
        System.out.println("⚜️Main Menu ⚜️");
        System.out.println("▐░░░░░░░░░░░░░▌");
        System.out.println("🔰 1) Add Deposit");
        System.out.println("🔰 2) Make Payment");
        System.out.println("🔰 3) View Ledger");
        System.out.println("🔰 4) Exit");
        System.out.println("📝Enter your choice: ");
    }


    private static void showLedgerMenu(Map<String, Transaction> transactions, Scanner scanner) {
        String option;
        do {
            System.out.println("\n--- Ledger Menu ---");
            System.out.println("A) All - Display all entries");
            System.out.println("D) Deposits - Display only the entries that are deposits");
            System.out.println("P) Payments - Display only the negative entries (or payments)");
            System.out.println("R) Reports - Run predefined reports or a custom search");
            System.out.println("B) Back - Return to the main menu");
            System.out.println("Enter your choice: ");
            option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "A":
                    showLedger(transactions);
                    break;
                case "D":
                    viewOnlyDeposits(transactions);
                    break;
                case "P":
                    viewOnlyPayments(transactions);
                    break;
                case "R":
                    showReportsMenu(transactions, scanner);
                    break;
                case "B":
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        } while (!option.equals("B"));
    }


    private static void showReportsMenu(Map<String, Transaction> transactions, Scanner scanner) {
        String option;
        do {
            System.out.println("\n--- Reports Menu ---");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back to Ledger Menu");
            System.out.println("Enter your choice: ");
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
                    System.out.println("Returning to Ledger Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        } while (!option.equals("0"));
    }


    private static void addDeposit(Map<String, Transaction> transactions, Scanner scanner) {
        System.out.println("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.println("Enter time (HH:MM:SS): ");
        String time = scanner.nextLine();
        System.out.println("Enter description: ");
        String description = scanner.nextLine();
        System.out.println("Enter Vendor: ");
        String vendor = scanner.nextLine();
        System.out.println("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        Transaction deposit = new Transaction(date, time, description, vendor, amount);
        transactions.put(description, deposit);
        System.out.println("Deposit added successfully!");
    }


    private static void makePayment(Map<String, Transaction> transactions, Scanner scanner) {
        System.out.println("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.println("Enter time (HH:MM:SS): ");
        String time = scanner.nextLine();
        System.out.println("Enter description: ");
        String description = scanner.nextLine();
        System.out.println("Enter vendor: ");
        String vendor = scanner.nextLine();
        System.out.println("Enter amount (negative for payment): ");
        double amount = Double.parseDouble(scanner.nextLine());

        Transaction payment = new Transaction(date, time, description, vendor, amount);
        transactions.put(description, payment);
        System.out.println("Payment added successfully!");
    }


    private static Map<String, Transaction> loadTransactions() {
        Map<String, Transaction> transactions = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
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
        System.out.println("\n--- All Ledger Entries ---");
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (Transaction t : transactions.values()) {
                System.out.println(t);
            }
        }
    }


    private static void viewOnlyDeposits(Map<String, Transaction> transactions) {
        System.out.println("\n--- Deposits Only ---");
        for (Transaction t : transactions.values()) {
            if (t.getAmount() > 0) {
                System.out.println(t);
            }
        }
    }


    private static void viewOnlyPayments(Map<String, Transaction> transactions) {
        System.out.println("\n--- Payments Only ---");
        for (Transaction t : transactions.values()) {
            if (t.getAmount() < 0) {
                System.out.println(t);
            }
        }
    }


    private static void displayTransactionsInRange(LocalDate startDate, LocalDate endDate) {
        System.out.println("\n--- Transactions in Range ---");
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

        System.out.println("\n--- Transactions by Vendor: " + vendorSearch + " ---");
        boolean found = false;
        for (Transaction t : transactions.values()) {
            if (t.getVendor().toLowerCase().contains(vendorSearch)) {
                System.out.println(t);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No transactions found for the vendor: " + vendorSearch);
        }
    }
}