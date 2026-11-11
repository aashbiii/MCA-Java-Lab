import java.util.Scanner;

class OddClass extends Thread {
    int n;
    public OddClass(int n) {
        this.n = n;
    }
    public void run() {
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0)
                System.out.println("\nOdd: " + i);
        }
    }
}

class EvenClass extends Thread {
    int n;
    public EvenClass(int n) {
        this.n = n;
    }
    public void run() {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                System.out.println("\nEven: " + i);
        }
    }
}

class PG27OddEvenDemo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a value for n: ");
        int n = sc.nextInt();
        OddClass t1 = new OddClass(n);
        EvenClass t2 = new EvenClass(n);
        t1.start();
        t2.start();
    }
}