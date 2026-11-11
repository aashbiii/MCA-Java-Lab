import java.util.Scanner;

public class Max6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        System.out.print("Enter third number: ");
        int c = sc.nextInt();
        
        System.out.println("\nInput numbers: a = " + a + ", b = " + b + ", c = " + c);
        
        System.out.println("\n--- Method 1: Using nested if-else ---");
        int max1;
        if (a > b) {
            if (a > c) {
                max1 = a;
            } else {
                max1 = c;
            }
        } else {
            if (b > c) {
                max1 = b;
            } else {
                max1 = c;
            }
        }
        System.out.println("Maximum: " + max1);
        
        System.out.println("\n--- Method 2: Using ternary operator ---");
        int max2 = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
        System.out.println("Maximum: " + max2);
        
        System.out.println("\n--- Method 3: Using Math.max() ---");
        int max3 = Math.max(a, Math.max(b, c));
        System.out.println("Maximum: " + max3);
        
        sc.close();
    }
}