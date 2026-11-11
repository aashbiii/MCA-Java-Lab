import java.util.Scanner;

class Bank {
    int balance;
    Bank(int balance) {
        this.balance = balance;
    }

    void deposit(int amount) {
    int temp = balance;
    try { Thread.sleep(100); } catch (Exception e) {}
    balance = temp + amount;
        System.out.println("Deposited: " + amount + 
                           " | Balance: " + balance);
    }

    void withdraw(int amount) {
    int temp = balance;
    try { Thread.sleep(100); } catch (Exception e) {}
    balance = temp - amount;
        System.out.println("Withdrawn: " + amount + 
                           " | Balance: " + balance);
    }
}


class Deposit extends Thread {
    Bank bank;
    int amount;

    Deposit(Bank bank, int amount) {
        this.bank = bank;
        this.amount = amount;
    }

    public void run() {
        bank.deposit(amount);
    }
}

class Withdraw extends Thread {
    Bank bank;
    int amount;

    Withdraw(Bank bank, int amount) {
        this.bank = bank;
        this.amount = amount;
    }

    public void run() {
        bank.withdraw(amount);
    }
}

public class PG33BankDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int initialBalance = 10000;
        System.out.println("Initial Balance: " + initialBalance);
        Bank bank = new Bank(initialBalance);

        System.out.print("Enter the amount to deposit: ");
        int depositAmount = sc.nextInt();
        System.out.print("Enter the amount to withdraw: ");
        int withdrawAmount = sc.nextInt();

        Deposit d = new Deposit(bank, depositAmount);
        Withdraw w = new Withdraw(bank, withdrawAmount);

        d.start();
        w.start();
    }
}
