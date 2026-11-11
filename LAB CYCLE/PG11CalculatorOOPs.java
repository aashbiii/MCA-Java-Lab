import java.util.Scanner;

// Calculator class with two numbers and arithmetic operations
class Calculator {
    // Instance variables to store two numbers
    private int num1;
    private int num2;
    
    // Constructor to initialize the numbers
    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    
    // Method to perform addition
    public int add() {
        return num1 + num2;
    }
    
    // Method to perform subtraction
    public int subtract() {
        return num1 - num2;
    }
    
    // Method to perform multiplication
    public int multiply() {
        return num1 * num2;
    }
    
    // Method to perform division
    public int divide() {
        // Check for division by zero
        if (num2 == 0) {
            System.out.println("Error: Division by zero!");
            return 0;
        }
        return num1 / num2;
    }
}

// Main class to test Calculator
public class PG11CalculatorOOPs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input two numbers
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        // Create Calculator object with two numbers
        Calculator calc = new Calculator(a, b);
        
        // Display menu
        System.out.println("\n--- Menu ---");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();
        
        // Perform operation based on user choice
        switch (choice) {
            case 1:
                System.out.println("\nResult: " + a + " + " + b + " = " + calc.add());
                break;
            
            case 2:
                System.out.println("\nResult: " + a + " - " + b + " = " + calc.subtract());
                break;
            
            case 3:
                System.out.println("\nResult: " + a + " * " + b + " = " + calc.multiply());
                break;
            
            case 4:
                if (b != 0) {
                    System.out.println("\nResult: " + a + " / " + b + " = " + calc.divide());
                } else {
                    System.out.println("\nError: Cannot divide by zero");
                }
                break;
            
            default:
                System.out.println("\nInvalid choice!");
        }
        
        sc.close();
    }
}