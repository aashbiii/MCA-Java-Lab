import java.util.Scanner;

public class Difference8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        int larger = Math.max(a, b);
        int smaller = Math.min(a, b);
        int difference = 0;
        
        while (smaller < larger) {
            smaller++;
            difference++;
        }
        
        System.out.println("\nDifference between " + a + " and " + b + " is: " + difference);
        
        sc.close();
    }
}