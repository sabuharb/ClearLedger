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
}


