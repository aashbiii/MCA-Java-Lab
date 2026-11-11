import java.util.Scanner;

public class PG3GuessNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Set the secret number
        int secretNumber = 25;
        int guess;
        int attempts = 0;
        
        // Display instructions to the user
        System.out.println("I have a secret number between 20 and 30.");
        System.out.println("Try to guess it!");
        
        // Do-while loop continues until correct guess
        do {
            // Prompt user for input
            System.out.print("\nEnter your guess (20-30): ");
            guess = sc.nextInt();
            
            // Increment attempt counter
            attempts++;
            
            // Provide hints based on user's guess
            if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else {
                // Display success message with attempt count
                System.out.println("\nCongratulations! You guessed the secret number " + secretNumber);
                System.out.println("Number of attempts: " + attempts);
            }
            
        } while (guess != secretNumber); // Loop until correct guess
        
        sc.close();
    }
}