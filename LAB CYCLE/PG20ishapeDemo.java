/*Create an interface ishape having two prototypes draw and mov, create two classes
circle and rectangle which implements the above interface. In the main function only
a reference object of ishape is created, depends on the choice entered by the user , it
points to the respective memory location.*/

import java.util.Scanner;
interface ishape {
    void draw();
    void mov();
}
class circle implements ishape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
    public void mov() {
        System.out.println("Moving Circle");
    }
}
class rectangle implements ishape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
    public void mov() {
        System.out.println("Moving Rectangle");
    }
}

public class PG20ishapeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 for Circle or 2 for Rectangle:");
        int choice = sc.nextInt();
        
        ishape shape;
        if (choice == 1) {
            shape = new circle();
        } else {
            shape = new rectangle();
        }
        
        shape.draw();
        shape.mov();
        
        sc.close();
    }
}