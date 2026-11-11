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

public class PG55ISASerialization {
    public static void main(String args[]) {
        try {
            // Create Student object
            Student s = new Student(101, "Ashbi", "MCA", 88.5f);

            // Serialize Student
            FileOutputStream   fout1 = new FileOutputStream("student.txt");
            ObjectOutputStream out1  = new ObjectOutputStream(fout1);
            out1.writeObject(s);
            out1.flush();
            out1.close();
            System.out.println("Student serialized successfully.");
            System.out.println(s.id + " " + s.name + " " + s.course + " " + s.marks);

            // Create Teacher object
            Teacher t = new Teacher(501, "Jees", "Java", 75000f);

            // Serialize Teacher
            FileOutputStream   fout2 = new FileOutputStream("teacher.txt");
            ObjectOutputStream out2  = new ObjectOutputStream(fout2);
            out2.writeObject(t);
            out2.flush();
            out2.close();
            System.out.println("\nTeacher serialized successfully.");
            System.out.println(t.id + " " + t.name + " " + t.subject + " " + t.salary);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}