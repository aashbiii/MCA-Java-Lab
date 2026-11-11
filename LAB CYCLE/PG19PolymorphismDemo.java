// Program to implement run-time polymorphism in Java(interface).
interface Animal {
    void sound();
}
class Dog implements Animal {
    public void sound() {
        System.out.println("Woof");
    }
}
class Cat implements Animal {
    public void sound() {
        System.out.println("Meow");
    }
}
public class PG19PolymorphismDemo {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        
        myDog.sound();
        myCat.sound();
    }
}