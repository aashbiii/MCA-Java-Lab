import java.util.Scanner;
class Employee1 {
    int eno;
    String ename;
    double esal;

    Employee1(int eno, String ename, double esal) {
        this.eno = eno;
        this.ename = ename;
        this.esal = esal;
    }

    void display() {
        System.out.println("Employee No: " + eno);
        System.out.println("Employee Name: " + ename);
        System.out.println("Employee Salary: " + esal);
    }

    boolean compareByEno(int searchEno) {
        return this.eno == searchEno;
    }
}
public class PG18EmployeeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        Employee1[] employees = new Employee1[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for employee " + (i + 1) + ":");
            System.out.print("\nEnter employee no: ");
            int eno = sc.nextInt();
            System.out.print("Enter employee name: ");
            String ename = sc.next();
            System.out.print("Enter employee salary: ");
            double esal = sc.nextDouble();
            employees[i] = new Employee1(eno, ename, esal);
        }
        System.out.println("\nEmployee Details:");
        for (Employee1 emp : employees) {
            emp.display();
            System.out.println();
        }

        System.out.print("Enter employee no to search: ");
        int searchEno = sc.nextInt(); // Example eno to search
        System.out.println("\nSearching for Employee with No: " + searchEno);
        boolean found = false;
        for (Employee1 emp : employees) {
            if (emp.compareByEno(searchEno)) {
                System.out.println("Employee Found!\n");
                emp.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with No " + searchEno + " not found.");
        }
    }
}