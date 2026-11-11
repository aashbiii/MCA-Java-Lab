import java.util.Scanner;

// HASA relationship class
class Address {
    String city;
    String state;

    Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    void displayAddress() {
        System.out.println("City: " + city);
        System.out.println("State: " + state);
    }
}

// Base class (ISA relationship)
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayPerson() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Derived class (ISA + HASA)
class Student extends Person {   // ISA relationship
    int rollNo;
    Address address;            // HASA relationship

    Student(String name, int age, int rollNo, Address address) {
        super(name, age);
        this.rollNo = rollNo;
        this.address = address;
    }

    void displayStudent() {
        displayPerson();
        System.out.println("Roll No: " + rollNo);
        address.displayAddress();
    }
}

public class PG15ISAHASADemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student details:");
        System.out.print("\nEnter student name: ");
        String name = sc.next();
        System.out.print("Enter student age: ");
        int age = sc.nextInt();
        System.out.print("Enter student roll number: ");
        int rollNo = sc.nextInt();

        System.out.println("\nEnter address details:");
        System.out.print("\nEnter City: ");
        String city = sc.next();
        System.out.print("Enter State: ");
        String state = sc.next();

        Address addr = new Address(city, state);

        Student s = new Student(name, age, rollNo, addr);

        System.out.print("\nStudent Details:\n");
        s.displayStudent();
    }
}
