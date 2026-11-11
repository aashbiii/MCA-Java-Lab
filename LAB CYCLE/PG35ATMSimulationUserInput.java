
import java.util.Scanner;

// Bank account class
class BankAccount {
    private int balance;

    BankAccount(int balance) {
        this.balance = balance;
    }

    // synchronized withdraw method
    synchronized void withdraw(String user, int amount) {
        System.out.println(user + " trying to withdraw " + amount);

        if (balance >= amount) {
            try {
                Thread.sleep(500); // simulate ATM delay
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            balance -= amount;
            System.out.println(user + " withdrawal successful. Balance = " + balance);
        } else {
            System.out.println(user + " withdrawal failed. Insufficient balance.");
        }
        System.out.println();
    }

    // synchronized deposit method
    synchronized void deposit(String user, int amount) {

        System.out.println(user + " depositing " + amount);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        balance += amount;
        System.out.println(user + " deposit successful. Balance = " + balance);
        System.out.println();
    }
}

// ATM user thread
class ATMUser extends Thread {
    BankAccount account;
    String user;
    int amount;
    int choice;

    ATMUser(BankAccount account, String user, int choice, int amount) {
        this.account = account;
        this.user = user;
        this.choice = choice;
        this.amount = amount;
    }

    public void run() {
        if (choice == 1) {
            account.deposit(user, amount);
        } else if (choice == 2) {
            account.withdraw(user, amount);
        }
    }
}

// Main class
class PG35ATMSimulationUserInput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial account balance: ");
        int balance = sc.nextInt();

        BankAccount account = new BankAccount(balance);

        System.out.print("Enter number of users: ");
        int n = sc.nextInt();

        ATMUser[] users = new ATMUser[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nUser " + (i + 1));
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            System.out.print("Enter amount: ");
            int amount = sc.nextInt();

            users[i] = new ATMUser(account, "User-" + (i + 1), choice, amount);
        }

        // Start all user threads
        for (int i = 0; i < n; i++) {
            users[i].start();
        }

        sc.close();
    }
}

