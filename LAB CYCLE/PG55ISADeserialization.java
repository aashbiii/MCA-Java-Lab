import java.io.*;

class Person implements Serializable {
    int    id;
    String name;

    Person(int id, String name) {
        this.id   = id;
        this.name = name;
    }
}

class Student extends Person {
    String course;
    float  marks;

    public Student(int id, String name, String course, float marks) {
        super(id, name);
        this.course = course;
        this.marks  = marks;
    }
}

class Teacher extends Person {
    String subject;
    float  salary;

    public Teacher(int id, String name, String subject, float salary) {
        super(id, name);
        this.subject = subject;
        this.salary  = salary;
    }
}

public class PG55ISADeserialization {
    public static void main(String args[]) {
        try {
            // Deserialize Student
            ObjectInputStream in1 = new ObjectInputStream(
                new FileInputStream("student.txt"));
            Student s = (Student) in1.readObject();
            in1.close();
            System.out.println("Student de-serialized successfully.");
            System.out.println(s.id + " " + s.name + " " + s.course + " " + s.marks);

            // Deserialize Teacher
            ObjectInputStream in2 = new ObjectInputStream(
                new FileInputStream("teacher.txt"));
            Teacher t = (Teacher) in2.readObject();
            in2.close();
            System.out.println("\nTeacher de-serialized successfully.");
            System.out.println(t.id + " " + t.name + " " + t.subject + " " + t.salary);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}