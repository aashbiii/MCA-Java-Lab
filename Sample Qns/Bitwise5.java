import java.util.Scanner;

public class Bitwise5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        System.out.println("\nOriginal values: a = " + a + ", b = " + b);
        
        System.out.println("\n--- Bitwise Logical Operators ---");
        System.out.println("a & b (AND): " + (a & b));
        System.out.println("a | b (OR): " + (a | b));
        System.out.println("a ^ b (XOR): " + (a ^ b));
        System.out.println("~a (NOT): " + (~a));
        System.out.println("~b (NOT): " + (~b));
        
        System.out.println("\n--- Left Shift Operator ---");
        System.out.println("a << 1: " + (a << 1));
        System.out.println("a << 2: " + (a << 2));
        System.out.println("b << 1: " + (b << 1));
        System.out.println("b << 2: " + (b << 2));
        
        System.out.println("\n--- Right Shift Operator ---");
        System.out.println("a >> 1: " + (a >> 1));
        System.out.println("a >> 2: " + (a >> 2));
        System.out.println("b >> 1: " + (b >> 1));
        System.out.println("b >> 2: " + (b >> 2));
        
        System.out.println("\n--- Unsigned Right Shift Operator ---");
        System.out.println("a >>> 1: " + (a >>> 1));
        System.out.println("a >>> 2: " + (a >>> 2));
        
        sc.close();
    }
}