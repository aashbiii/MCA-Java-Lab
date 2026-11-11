import java.util.Scanner;

// Program to display numbers in descending and ascending order using recursive functions
public class PG10RecursiveDisplay {
    
    // Recursive function to display from n to 1 (descending)
    public static void displayDescending(int n) {
        // Base case: if n becomes 0, stop recursion
        if (n == 0) {
            return;
        }
        
        // Print current number
        System.out.print(n + " ");
        
        // Recursive call with n-1
        displayDescending(n - 1);
    }
    
    // Recursive function to display from 1 to n (ascending)
    public static void displayAscending(int n) {
        // Base case: if n becomes 0, stop recursion
        if (n == 0) {
            return;
        }
        
        // Recursive call first with n-1
        displayAscending(n - 1);
        
        // Print current number after recursive call
        System.out.print(n + " ");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input the value of n
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        // Display from n to 1 using recursive function
        System.out.print("\nNumbers from " + n + " to 1 (Descending): ");
        displayDescending(n);
        
        // Display from 1 to n using recursive function
        System.out.print("\n\nNumbers from 1 to " + n + " (Ascending): ");
        displayAscending(n);
        
        sc.close();
    }
}