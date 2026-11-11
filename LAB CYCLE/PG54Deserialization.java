import java.io.*;

class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    int    eno;
    String ename;
    float  esal;
    String edept;
}

public class PG54Deserialization {

    public static void main(String[] args) {

        try {
            FileInputStream   fis = new FileInputStream("employee.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Employee emp = (Employee) ois.readObject();

            ois.close();
            fis.close();

            System.out.println("Object de-serialized successfully!");
            System.out.println("------------------------------------------");
            System.out.println("Emp No   : " + emp.eno);
            System.out.println("Emp Name : " + emp.ename);
            System.out.println("Emp Sal  : " + emp.esal);
            System.out.println("Emp Dept : " + emp.edept);
            System.out.println("------------------------------------------");

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Run Serialization first.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("De-serialization error: " + e.getMessage());
        }
    }
}