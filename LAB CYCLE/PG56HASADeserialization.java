import java.io.*;

class Address implements Serializable {
    String street;
    String city;
    String state;
    int    pincode;

    public Address(String street, String city, String state, int pincode) {
        this.street  = street;
        this.city    = city;
        this.state   = state;
        this.pincode = pincode;
    }
}

class Department implements Serializable {
    int    dno;
    String dname;
    String dloc;

    public Department(int dno, String dname, String dloc) {
        this.dno   = dno;
        this.dname = dname;
        this.dloc  = dloc;
    }
}

class Employee implements Serializable {
    int        eno;
    String     ename;
    float      esal;
    Address    address;     // HAS-A
    Department department;  // HAS-A

    public Employee(int eno, String ename, float esal,
                    String street, String city, String state, int pincode,
                    int dno, String dname, String dloc) {
        this.eno        = eno;
        this.ename      = ename;
        this.esal       = esal;
        address         = new Address(street, city, state, pincode);
        department      = new Department(dno, dname, dloc);
    }
}

public class PG56HASADeserialization {
    public static void main(String args[]) {
        try {
            // Deserialize Employee
            ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("employee.txt"));
            Employee emp = (Employee) in.readObject();
            in.close();

            System.out.println("success");
            System.out.println(emp.eno + " " + emp.ename + " " + emp.esal);
            System.out.println(emp.address.street + " " + emp.address.city + " " +
                               emp.address.state  + " " + emp.address.pincode);
            System.out.println(emp.department.dno + " " + emp.department.dname + " " +
                               emp.department.dloc);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}