import java.util.Scanner;

class ThreadClass extends Thread {
    int n;

    public ThreadClass(int n) {
        this.n = n;
    }

    public void run() {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }
}

class PG25ThreadClassDemo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number for Thread 1: ");
        int num1 = sc.nextInt();
        System.out.print("Enter a number for Thread 2: ");
        int num2 = sc.nextInt();
        ThreadClass t1 = new ThreadClass(num1);
        ThreadClass t2 = new ThreadClass(num2);
        t1.start();
        t2.start();
    }
}