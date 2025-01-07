import java.util.Scanner;

class Bank {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;
    static double minimumBalance = 1000;

    void getDetails(Scanner scanner) {
        System.out.println("Enter your name:");
        this.customerName = scanner.nextLine();
        System.out.println("Enter your account number:");
        this.accountNumber = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter your account type (1 for Savings, 2 for Current):");
        this.accountType = scanner.nextLine();
        System.out.println("Enter initial balance: ");
        this.balance = scanner.nextDouble();
        scanner.nextLine(); 
    }

    void deposit(Scanner scanner) {
        System.out.println("Enter deposit amount:");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Amount has been deposited.");
        System.out.println("Current balance: " + balance);
    }

    void withdraw(Scanner scanner) {
        System.out.println("Enter amount to withdraw:");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Amount has been withdrawn.");
            checkMinimumBalance();
            System.out.println("Current balance: " + balance);
        }
    }

    void checkMinimumBalance() {
        if (balance < minimumBalance) {
            System.out.println("Penalty applied for falling below minimum balance.");
            balance -= 100;
            System.out.println("Current balance after penalty: " + balance);
        }
    }

    void display() {
        System.out.println("Account holder name: " + customerName);
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account type: " + accountType);
        System.out.println("Current balance: " + balance);
    }
}

class Savings extends Bank {

    void computeCompoundInterest(Scanner scanner) {
        System.out.println("Enter principal amount for interest calculation:");
        double principal = scanner.nextDouble();
        System.out.println("Enter time period in years:");
        int years = scanner.nextInt();
        System.out.println("Enter rate of interest:");
        double rate = scanner.nextDouble();
        int n = 4;

        double interest = principal * Math.pow((1 + rate / (100 * n)), n * years) - principal;
        balance += interest;
        System.out.println("Interest has been added.");
        System.out.println("Current balance: " + balance);
    }
}

class Current extends Bank {

    void chequeOperations(Scanner scanner) {
        System.out.println("Do you want to deposit or withdraw using cheque? (1: Deposit, 2: Withdraw):");
        int choice = scanner.nextInt();
        if (choice == 1) {
            depositUsingCheque(scanner);
        } else {
            withdrawUsingCheque(scanner);
        }
    }

    void depositUsingCheque(Scanner scanner) {
        System.out.println("Enter cheque amount to be deposited:");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Amount has been deposited using cheque.");
        System.out.println("Current balance: " + balance);
    }

    void withdrawUsingCheque(Scanner scanner) {
        System.out.println("Enter cheque amount to be withdrawn:");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Amount has been withdrawn using cheque.");
            checkMinimumBalance();
            System.out.println("Current balance: " + balance);
        }
    }
}

public class BankApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of customers:");
        int numberOfCustomers = scanner.nextInt();
        scanner.nextLine();
        Bank[] customers = new Bank[numberOfCustomers];

        for (int i = 0; i < numberOfCustomers; i++) {
            System.out.println("Select account type for customer " + (i + 1) + ": (1: Savings, 2: Current)");
            int accountType = scanner.nextInt();
            scanner.nextLine(); 
            
            if (accountType == 1) {
                Savings savingsAccount = new Savings();
                savingsAccount.getDetails(scanner);
                customers[i] = savingsAccount;
            } else {
                Current currentAccount = new Current();
                currentAccount.getDetails(scanner);
                customers[i] = currentAccount;
            }
        }

        for (Bank customer : customers) {
            customer.display();
        }

        scanner.close();
    }
}
