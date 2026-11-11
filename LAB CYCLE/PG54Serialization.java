import java.io.*;
import java.util.Scanner;

class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    int    eno;
    String ename;
    float  esal;
    String edept;

    public Employee(int eno, String ename, float esal, String edept) {
        this.eno   = eno;
        this.ename = ename;
        this.esal  = esal;
        this.edept = edept;
    }
}

public class PG54Serialization {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Employee Details:");

        System.out.print("Emp No   : ");
        int eno = Integer.parseInt(sc.nextLine());

        System.out.print("Emp Name : ");
        String ename = sc.nextLine();

        System.out.print("Emp Sal  : ");
        float esal = Float.parseFloat(sc.nextLine());

        System.out.print("Emp Dept : ");
        String edept = sc.nextLine();

        Employee emp = new Employee(eno, ename, esal, edept);

        try {
            FileOutputStream   fos = new FileOutputStream("employee.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(emp);

            oos.close();
            fos.close();
            sc.close();

            System.out.println("\nObject serialized successfully!");
            System.out.println("------------------------------------------");
            System.out.println("Emp No   : " + emp.eno);
            System.out.println("Emp Name : " + emp.ename);
            System.out.println("Emp Sal  : " + emp.esal);
            System.out.println("Emp Dept : " + emp.edept);
            System.out.println("------------------------------------------");
            System.out.println("Saved to : employee.ser");

        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }
    }
}
