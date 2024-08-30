package Third;

import java.util.Scanner;

class BankAccount {

    private double balence;

    public BankAccount(double currentBalance) {
        if (currentBalance > 0) {
            this.balence = currentBalance;
        } else {
            this.balence = 0.0;
        }
    }

    public double getBalence() {
        return balence;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balence += amount;
            System.out.println("Successfully Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be in positive");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balence) {
            balence -= amount;
            System.out.println("Successfully WithDraw: $" + amount);
            return true;
        } else if (amount > balence) {
            System.out.println("Insufficiant Balance WithDraw Failed...!!");
            return false;
        } else {
            System.out.println("Withdrawl amount must be positive...!!");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;
    private Scanner in;

    public ATM(BankAccount account) {
        this.account = account;
        this.in = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you For using the ATM, GoodBye!");
                    in.close();
                    break;
                default:
                    System.out.println("Invlid Option, Please Try again");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n===========ATM Menu===========");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. WithDraw Money");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private void checkBalance() {
        System.out.println("Your Currnet balance: $" + account.getBalence());
    }

    private void deposit() {
        System.out.print("Enter the Amount to deposit: $");
        double amt = in.nextDouble();
        account.deposit(amt);
    }

    private void withdraw() {
        System.out.print("Enter the Amount to withdraw: $");
        double amt = in.nextDouble();
        account.withdraw(amt);
    }

}

/**
 * ATMSystem
 */
public class ATMSystem {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(158.64);

        ATM atm = new ATM(account);

        atm.start();
    }
}