import java.util.Scanner;

// Program to find maximum using function overloading
public class PG7MaxOfThree {
    
    // Function to find maximum of two integers
    public static int findMax(int a, int b) {
        // Return the larger of two numbers
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
    
    // Overloaded function to find maximum of three integers
    // Uses the two-parameter findMax function
    public static int findMax(int a, int b, int c) {
        // Find max of first two numbers
        int maxOfTwo = findMax(a, b);
        
        // Find max of result and third number
        return findMax(maxOfTwo, c);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input two numbers
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        
        // Find maximum of two numbers using two-parameter function
        int maxTwo = findMax(num1, num2);
        System.out.println("\nMaximum of " + num1 + " and " + num2 + " is: " + maxTwo);
        
        // Input third number
        System.out.print("\nEnter third number: ");
        int num3 = sc.nextInt();
        
        // Find maximum of three numbers using three-parameter overloaded function
        int maxThree = findMax(num1, num2, num3);
        System.out.println("\nMaximum of " + num1 + ", " + num2 + ", and " + num3 + " is: " + maxThree);
        
        sc.close();
    }
}