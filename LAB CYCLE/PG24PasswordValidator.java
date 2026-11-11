import java.util.Scanner;
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
public class PG24PasswordValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a password to validate: ");
        String password = sc.nextLine();
        
        try {
            validatePassword(password);
            System.out.println("Password is valid.");
        } catch (InvalidPasswordException e) {
            System.out.println("Invalid Password: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
    
    public static void validatePassword(String password) throws InvalidPasswordException {
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password must be at least 8 characters long.");
        }
        
        if (!password.matches(".*[a-z].*")) {
            throw new InvalidPasswordException("Password must contain at least one lowercase letter.");
        }
        
        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException("Password must contain at least one uppercase letter.");
        }
        
        if (!password.matches(".*[0-9].*")) {
            throw new InvalidPasswordException("Password must contain at least one digit.");
        }
        
        if (!password.matches(".*[#*!{}()\\[\\]=].*")) {
            throw new InvalidPasswordException("Password must contain at least one special character (#, *, !, {, }, (, ), [, ], =).");
        }
        
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                throw new InvalidPasswordException("Password must not contain consecutive repeating characters.");
            }
        }
    }
}