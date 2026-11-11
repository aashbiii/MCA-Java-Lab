import java.util.Scanner;

public class Minimum7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        System.out.print("Enter third number: ");
        int c = sc.nextInt();
        
        int min = Math.min(a, Math.min(b, c));
        
        System.out.println("\nMinimum of " + a + ", " + b + ", and " + c + " is: " + min);
        
        sc.close();
    }
}