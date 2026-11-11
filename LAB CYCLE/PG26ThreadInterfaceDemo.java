import java.util.Scanner;

class ThreadInterface implements Runnable {
    int n;
    public ThreadInterface(int n) {
        this.n = n;
    }
    public void run() {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }
}

class PG26ThreadInterfaceDemo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number for Thread 1: ");
        int num1 = sc.nextInt();
        System.out.print("Enter a number for Thread 2: ");
        int num2 = sc.nextInt();
        ThreadInterface t1 = new ThreadInterface(num1);
        ThreadInterface t2 = new ThreadInterface(num2);
        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        th1.start();
        th2.start();
    }
}