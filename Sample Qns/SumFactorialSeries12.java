import java.util.Scanner;

public class SumFactorialSeries12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        double sum = 0.0;
        long factorial = 1;
        
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            sum += (double) i / factorial;
        }
        
        System.out.println("\nSum of the series 1+2/2!+3/3!+4/4!+...+" + n + "/" + n + "! is: " + sum);
        
        sc.close();
    }
}