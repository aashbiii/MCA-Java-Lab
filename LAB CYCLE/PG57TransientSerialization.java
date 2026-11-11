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

public class PG57TransientSerialization {
    public static void main(String args[]) {
        try {
            Student s = new Student(101, "Ashbi", 21);

            FileOutputStream   fout = new FileOutputStream("student.txt");
            ObjectOutputStream out  = new ObjectOutputStream(fout);
            out.writeObject(s);
            out.flush();
            out.close();

            System.out.println("success");
            System.out.println("Before Serialization:");
            System.out.println("ID   : " + s.id);
            System.out.println("Name : " + s.name);
            System.out.println("Age  : " + s.age);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}