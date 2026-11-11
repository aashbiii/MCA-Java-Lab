import java.util.Scanner;
class Employee {
    String name;
    double salary;

    // Base class constructor
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void showDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    String department;

    // Passing arguments to base class constructor
    Manager(String name, double salary, String department) {
        super(name, salary);   // calls Employee constructor
        this.department = department;
    }

    // Overcoming function overriding
    void showDetails() {
        System.out.println("Department: " + department);
        super.showDetails();   // calls Employee method
    }
}

public class PG17SuperDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String name = sc.next();
        System.out.print("Enter employee salary: ");
        double salary = sc.nextDouble();
        System.out.print("Enter department: ");
        String department = sc.next();
        Manager m = new Manager(name, salary, department);
        System.err.println("\nEmployee Details:");
        m.showDetails();
    }
}
