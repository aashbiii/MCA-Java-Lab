import java.util.Scanner;

// Program to reverse a number and check if it's a palindrome using functions
public class PG8ReversePalindrome {
    
    // Function to reverse an integer
    public static int reverseNumber(int num) {
        int reversed = 0;
        int original = num;
        
        // Handle negative numbers
        if (num < 0) {
            num = -num;
        }
        
        // Reverse the number digit by digit
        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num = num / 10;
        }
        
        // Return negative if original was negative
        if (original < 0) {
            return -reversed;
        }
        
        return reversed;
    }
    
    // Function to check if a number is palindrome
    // Uses reverseNumber function to compare original and reversed
    public static boolean isPalindrome(int num) {
        // Get the reversed number using reverseNumber function
        int reversed = reverseNumber(num);
        
        // Check if original equals reversed
        if (num == reversed) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input a number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Call reverseNumber function
        int reversed = reverseNumber(number);
        System.out.println("\nOriginal number: " + number);
        System.out.println("Reversed number: " + reversed);
        
        // Call isPalindrome function
        boolean palindrome = isPalindrome(number);
        
        // Display palindrome result
        if (palindrome) {
            System.out.println("\n" + number + " is a palindrome");
        } else {
            System.out.println("\n" + number + " is not a palindrome");
        }
        
        sc.close();
    }
}