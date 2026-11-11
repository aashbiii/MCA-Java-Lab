import java.io.*;

class Student implements Serializable {
    int    id;
    String name;
    transient int age;  // will NOT be serialized

    public Student(int id, String name, int age) {
        this.id   = id;
        this.name = name;
        this.age  = age;
    }
}

public class PG57TransientDeserialization {
    public static void main(String args[]) {
        try {
            ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("student.txt"));
            Student s = (Student) in.readObject();
            in.close();

            System.out.println("success");
            System.out.println("After Deserialization:");
            System.out.println("ID   : " + s.id);
            System.out.println("Name : " + s.name);
            System.out.println("Age  : " + s.age + " (transient - not serialized)");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}