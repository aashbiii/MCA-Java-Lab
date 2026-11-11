import java.util.Scanner;

public class Display9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter starting number (m): ");
        int m = sc.nextInt();
        
        System.out.print("Enter ending number (n): ");
        int n = sc.nextInt();
        
        System.out.println("\nNumbers from " + m + " to " + n + ":");
        
        int i = m;
        while (i <= n) {
            System.out.print(i + " ");
            i++;
        }
        
        sc.close();
    }
}