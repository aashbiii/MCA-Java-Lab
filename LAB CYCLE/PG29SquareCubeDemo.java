import java.util.Scanner;

class SquareClass extends Thread {
    int n;
    public SquareClass(int n) {
        this.n = n;
    }
    public void run() {
        System.out.println("\nSquare: " + n*n);
    }
}

class CubeClass extends Thread {
    int n;
    public CubeClass(int n) {
        this.n = n;
    }
    public void run() {
        System.out.println("\nCube: " + n*n*n);

    }
}

class PG29SquareCubeDemo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();
        SquareClass t1 = new SquareClass(num);
        CubeClass t2 = new CubeClass(num);
        t1.start();
        t2.start();
    }
}