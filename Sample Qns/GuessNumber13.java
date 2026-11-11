import java.util.Scanner;

public class GuessNumber13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int secretNumber = 25;
        int guess;
        int attempts = 0;
        
        System.out.println("I have a secret number between 20 and 30.");
        System.out.println("Try to guess it!");
        
        do {
            System.out.print("\nEnter your guess (20-30): ");
            guess = sc.nextInt();
            attempts++;
            
            if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("\nCongratulations! You guessed the secret number " + secretNumber);
                System.out.println("Number of attempts: " + attempts);
            }
            
        } while (guess != secretNumber);
        
        sc.close();
    }
}