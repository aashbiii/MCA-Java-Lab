import java.util.Scanner;

// Student class with student number, name and program
class Student {
    // Instance variables for student details
    private int sno;
    private String sname;
    private String sprogram;
      
    // Method to read student details from user
    public void read(Scanner sc) {
        System.out.print("Enter student number: ");
        this.sno = sc.nextInt();
        sc.nextLine(); // Consume newline
        
        System.out.print("Enter student name: ");
        this.sname = sc.nextLine();
        
        System.out.print("Enter student program: ");
        this.sprogram = sc.nextLine();
    }
    
    // Method to display student details
    public void display() {
        System.out.println("Student Number: " + sno);
        System.out.println("Student Name: " + sname);
        System.out.println("Student Program: " + sprogram);
    }
    
    // Method to compare two student objects for equality
    // Two students are equal if all three attributes match
    public boolean compare(Student other) {
        // Check student number
        if (this.sno != other.sno) {
            return false;
        }
        
        // Check student name
        if (!this.sname.equals(other.sname)) {
            return false;
        }
        
        // Check student program
        if (!this.sprogram.equals(other.sprogram)) {
            return false;
        }
        
        // If all checks pass, students are equal
        return true;
    }
}

// Main class to test Student operations
public class PG14StudentCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Create first student object
        Student student1 = new Student();
        System.out.println("Enter details of first student:");
        student1.read(sc);
        
        // Create second student object
        Student student2 = new Student();
        System.out.println("\nEnter details of second student:");
        student2.read(sc);
        
        // Display first student details
        System.out.println("\n--- First Student Details ---");
        student1.display();
        
        // Display second student details
        System.out.println("\n--- Second Student Details ---");
        student2.display();
        
        // Compare two student objects
        boolean isEqual = student1.compare(student2);
        System.out.println("\n--- Comparison Result ---");
        if (isEqual) {
            System.out.println("Both students are equal");
        } else {
            System.out.println("Students are not equal");
        }
        
        sc.close();
    }
}