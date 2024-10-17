import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountingLedger {
    private static final String CSV_FILE = "src/main/resources/transactions.csv";
    private static Map<String, Transaction> transactions = new HashMap<>();

    public static void main(String[] args) {

        transactions = loadTransactions();

        Scanner scanner = new Scanner(System.in);
        String option;

        do {
            showMenu;
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    addDeposit(transactions, scanner);
                    break;
                case "2":
                    makePayment(transactions, scanner);
                    break;
                case "3":
                    showLedger(transactions);
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
        System.out.println("Main Menu");
        System.out.println("1) Add Deposit");
        System.out.println("2) Make Payment");
        System.out.println("3) View Ledger");
        System.out.println("4) Exit");
        System.out.println("Enter your choice: ");
    }
    private static void addDeposit(Map<String, Transaction> transactions, Scanner scanner) {
        System.out.println("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.println("Enter time (HH:MM:SS: ");
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
        System.out.println("Enter date (YYYY-MM-DD: ");
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
}

