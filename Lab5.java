// 1. Develop a Java program to demonstrate Banking System, demonstrate different
// features such deposit, withdrawal of the amount can be done with ease. Demonstrate
// for atleast 15 customers.

// import java.util.Scanner;


class Bank {
   String name;
   String id;
   int balance;
   String[][] transactions = new String[10][2];
   int transactionIndex = 0;


   int deposit(int amt) {
       balance += amt;
       System.out.println("Amount " + amt + " deposited");
       if (transactionIndex < 10) {
           transactions[transactionIndex][0] = "+";
           transactions[transactionIndex][1] = String.valueOf(amt);
           transactionIndex++;
       }
       return balance;
   }


   int withdraw(int amt) {
       if (amt > balance) {
           System.out.println("Insufficient balance");
       } else {
           balance -= amt;
           System.out.println("Amount " + amt + " withdrawn");
           if (transactionIndex < 10) {
               transactions[transactionIndex][0] = "-";
               transactions[transactionIndex][1] = String.valueOf(amt);
               transactionIndex++;
           }
       }
       return balance;
   }


   void display() {
       System.out.println("Name: " + this.name);
       System.out.println("ID: " + this.id);
       System.out.println("Balance: " + this.balance);
       for (int i = 0; i < transactionIndex; i++) {
           System.out.println("Transaction: " + transactions[i][0] + " " + transactions[i][1]);
       }
   }


   void getDetails(Scanner input) {
       System.out.println("Enter your name:");
       this.name = input.nextLine();
       System.out.println("Enter your bank ID:");
       this.id = input.nextLine();
       System.out.println("Enter your initial balance:");
       this.balance = input.nextInt();
       input.nextLine();
   }
}


public class bankingsystem {
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.println("Enter the number of customers you want to enter details for:");
       int n = input.nextInt();
       input.nextLine();


       Bank[] customers = new Bank[n];
       for (int i = 0; i < n; i++) {
           Bank c1 = new Bank();
           c1.getDetails(input);
           customers[i] = c1;
       }


       while (true) {
           System.out.println("\nSelect an option:");
           System.out.println("1. Deposit");
           System.out.println("2. Withdraw");
           System.out.println("3. Display Account Details");
           System.out.println("4. Exit");
           int choice = input.nextInt();
           input.nextLine();


           if (choice == 4) {
               break;
           }


           System.out.println("Enter customer index (0 to " + (n - 1) + "):");
           int customerIndex = input.nextInt();
           input.nextLine();


           switch (choice) {
               case 1:
                   System.out.println("Enter amount to deposit:");
                   int depositAmount = input.nextInt();
                   input.nextLine();
                   customers[customerIndex].deposit(depositAmount);
                   break;


               case 2:
                   System.out.println("Enter amount to withdraw:");
                   int withdrawAmount = input.nextInt();
                   input.nextLine();
                   customers[customerIndex].withdraw(withdrawAmount);
                   break;


               case 3:
                   customers[customerIndex].display();
                   break;


               default:
                   System.out.println("Invalid option. Please try again.");
           }
       }


       input.close();
   }
}
