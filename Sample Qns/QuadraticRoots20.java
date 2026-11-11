import java.util.Scanner;

public class QuadraticRoots20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Quadratic equation format: ax^2 + bx + c = 0");
        System.out.print("\nEnter coefficient a: ");
        double a = sc.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = sc.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = sc.nextDouble();
        
        if (a == 0) {
            System.out.println("\nNot a quadratic equation (a cannot be 0)");
            sc.close();
            return;
        }
        
        double discriminant = b * b - 4 * a * c;
        
        System.out.println("\nDiscriminant = " + discriminant);
        
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("\nRoots are real and distinct:");
            System.out.println("Root 1 = " + root1);
            System.out.println("Root 2 = " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("\nRoots are real and equal:");
            System.out.println("Root 1 = Root 2 = " + root);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.println("\nRoots are complex and imaginary:");
            System.out.println("Root 1 = " + realPart + " + " + imaginaryPart + "i");
            System.out.println("Root 2 = " + realPart + " - " + imaginaryPart + "i");
        }
        
        sc.close();
    }
}