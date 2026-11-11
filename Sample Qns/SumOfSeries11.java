import java.util.Scanner;

public class SumOfSeries11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        int sum = 0;
        int i = 1;
        
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                sum += j;
                j++;
            }
            i++;
        }
        
        System.out.println("\nSum of the series 1+1+2+1+2+3+...+1+2+3+...+" + n + " is: " + sum);
        
        sc.close();
    }
}