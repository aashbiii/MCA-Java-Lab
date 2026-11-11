import java.util.Scanner;

// CString class with string data member and various operations
class CString {
    // Instance variable to store string
    private String str;
       
    // Method to read string from user
    public void read(Scanner sc) {
        System.out.print("Enter string: ");
        this.str = sc.nextLine();
    }
    
    // Method to display string
    public void display() {
        System.out.println(str);
    }
    
    // Method to compare two strings (returns boolean)
    public boolean compare(CString other) {
        // Returns true if strings are equal, false otherwise
        return this.str.equals(other.str);
    }
    
    // Method to add (concatenate with space) two strings
    public CString add(CString other) {
        CString result = new CString();
        result.str = this.str + " " + other.str;
        return result;
    }
    
    // Method to concatenate two strings (without space)
    public CString concatenate(CString other) {
        CString result = new CString();
        result.str = this.str + other.str;
        return result;
    }
    
}

// Main class to test CString operations
public class PG13StringOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Create first CString object
        CString s1 = new CString();
        System.out.println("Enter first string:");
        s1.read(sc);
        
        // Create second CString object
        CString s2 = new CString();
        System.out.println("\nEnter second string:");
        s2.read(sc);
        
        // Display both strings
        System.out.print("\nFirst string: ");
        s1.display();
        
        System.out.print("Second string: ");
        s2.display();
        
        // Compare two strings
        boolean isEqual = s1.compare(s2);
        System.out.println("\nAre strings equal? " + isEqual);
        
        // Add two strings (with space)
        CString added = s1.add(s2);
        System.out.print("Added string (with space): ");
        added.display();
        
        // Concatenate two strings (without space)
        CString concatenated = s1.concatenate(s2);
        System.out.print("Concatenated string (without space): ");
        concatenated.display();
        
        sc.close();
    }
}