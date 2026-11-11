import java.util.Scanner;

public class Swap4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        System.out.println("\nOriginal values: a = " + a + ", b = " + b);
        
        System.out.println("\n--- Method 1: Using temporary variable ---");
        int x = a, y = b;
        int temp = x;
        x = y;
        y = temp;
        System.out.println("After swapping: a = " + x + ", b = " + y);
        
        System.out.println("\n--- Method 2: Using arithmetic operations ---");
        x = a;
        y = b;
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("After swapping: a = " + x + ", b = " + y);
        
        System.out.println("\n--- Method 3: Using XOR operator ---");
        x = a;
        y = b;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After swapping: a = " + x + ", b = " + y);
        
        sc.close();
    }
}