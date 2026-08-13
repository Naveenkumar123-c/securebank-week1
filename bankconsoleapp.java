import java.util.HashMap;
import java.util.Scanner;

public class BankConsoleApp {

    static HashMap<Integer, Account> accounts = new HashMap<>();

    static Scanner scanner = new Scanner(System.in);

    static int nextAccountId = 1001;

    public static void main(String[] args) {

        int choice;

        System.out.println("=================================");
        System.out.println("       WELCOME TO SECURE BANK");
        System.out.println("=================================");

        do {

            System.out.println("\n=================================");
            System.out.println("          SECURE BANK");
            System.out.println("=================================");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Close Account");
            System.out.println("6. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    closeAccount();
                    break;

                case 6:
                    System.out.println(
                        "Thank you for using Secure Bank!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        scanner.close();
    }


    // CREATE ACCOUNT
    static void createAccount() {

        scanner.nextLine();

        System.out.print("Enter customer name: ");

        String customerName = scanner.nextLine();

        int id = nextAccountId++;

        Account account =
            new Account(id, customerName);

        accounts.put(id, account);

        System.out.println(
            "\nAccount created successfully!"
        );

        System.out.println(
            "Account ID: " + id
        );

        System.out.println(
            "Customer Name: " + customerName
        );
    }


    // DEPOSIT
    static void deposit() {

        System.out.print("Enter Account ID: ");

        int id = scanner.nextInt();

        if (!accounts.containsKey(id)) {

            System.out.println(
                "Account not found!"
            );

            return;
        }

        System.out.print(
            "Enter deposit amount: "
        );

        double amount = scanner.nextDouble();

        if (amount <= 0) {

            System.out.println(
                "Amount must be greater than zero!"
            );

            return;
        }

        Account account = accounts.get(id);

        account.deposit(amount);

        System.out.println(
            "Deposit successful!"
        );

        System.out.println(
            "Current Balance: ₹"
            + account.getBalance()
        );
    }


    // WITHDRAW
    static void withdraw() {

        System.out.print("Enter Account ID: ");

        int id = scanner.nextInt();

        if (!accounts.containsKey(id)) {

            System.out.println(
                "Account not found!"
            );

            return;
        }

        System.out.print(
            "Enter withdrawal amount: "
        );

        double amount = scanner.nextDouble();

        if (amount <= 0) {

            System.out.println(
                "Amount must be greater than zero!"
            );

            return;
        }

        Account account = accounts.get(id);

        if (amount > account.getBalance()) {

            System.out.println(
                "Insufficient funds!"
            );

            return;
        }

        account.withdraw(amount);

        System.out.println(
            "Withdrawal successful!"
        );

        System.out.println(
            "Remaining Balance: ₹"
            + account.getBalance()
        );
    }


    // CHECK BALANCE
    static void checkBalance() {

        System.out.print("Enter Account ID: ");

        int id = scanner.nextInt();

        if (!accounts.containsKey(id)) {

            System.out.println(
                "Account not found!"
            );

            return;
        }

        Account account = accounts.get(id);

        System.out.println(
            "\n----- ACCOUNT DETAILS -----"
        );

        System.out.println(
            "Account ID: "
            + account.getId()
        );

        System.out.println(
            "Customer Name: "
            + account.getCustomerName()
        );

        System.out.println(
            "Balance: ₹"
            + account.getBalance()
        );
    }


    // CLOSE ACCOUNT
    static void closeAccount() {

        System.out.print("Enter Account ID: ");

        int id = scanner.nextInt();

        if (!accounts.containsKey(id)) {

            System.out.println(
                "Account not found!"
            );

            return;
        }

        accounts.remove(id);

        System.out.println(
            "Account " + id
            + " closed successfully!"
        );
    }
}


// ACCOUNT CLASS
class Account {

    private int id;

    private String customerName;

    private double balance;


    public Account(
        int id,
        String customerName
    ) {

        this.id = id;

        this.customerName = customerName;

        this.balance = 0;
    }


    public int getId() {

        return id;
    }


    public String getCustomerName() {

        return customerName;
    }


    public double getBalance() {

        return balance;
    }


    public void deposit(double amount) {

        balance += amount;
    }


    public void withdraw(double amount) {

        balance -= amount;
    }
}