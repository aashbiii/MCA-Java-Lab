class Parent {
    void display() {
        System.out.println("This is Parent class display method");
    }
}

class Child extends Parent {

    // Overridden method
    void display() {
        System.out.println("This is Child class display method");

        // Calling parent class method
        super.display();
    }
}

public class PG16OverrideDemo {
    public static void main(String[] args) {

        Child obj = new Child();
        obj.display();
    }
}
