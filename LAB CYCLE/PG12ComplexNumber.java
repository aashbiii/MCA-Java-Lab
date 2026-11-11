import java.util.Scanner;

// Complex class with real and imaginary parts
class Complex {
    // Instance variables for real and imaginary parts
    private int real;
    private int imaginary;
        
    // Method to read complex number from user
    public void read(Scanner sc) {
        System.out.print("Enter real part: ");
        this.real = sc.nextInt();
        System.out.print("Enter imaginary part: ");
        this.imaginary = sc.nextInt();
    }
    
    // Method to display complex number
    public void display() {
        // Display in format: a + bi or a - bi
        if (imaginary >= 0) {
            System.out.println(real + " + " + imaginary + "i");
        } else {
            System.out.println(real + " - " + (-imaginary) + "i");
        }
    }
    
    // Method to add two complex numbers
    // (a + bi) + (c + di) = (a+c) + (b+d)i
    public Complex add(Complex c) {
        Complex result = new Complex();
        result.real = this.real + c.real;
        result.imaginary = this.imaginary + c.imaginary;
        return result;
    }
    
    // Method to multiply two complex numbers
    // (a + bi) * (c + di) = (ac - bd) + (ad + bc)i
    public Complex multiply(Complex c) {
        Complex result = new Complex();
        result.real = (this.real * c.real) - (this.imaginary * c.imaginary);
        result.imaginary = (this.real * c.imaginary) + (this.imaginary * c.real);
        return result;
    }
}

// Main class to test Complex number operations
public class PG12ComplexNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Create first complex number
        Complex c1 = new Complex();
        System.out.println("Enter first complex number:");
        c1.read(sc);
        
        // Create second complex number
        Complex c2 = new Complex();
        System.out.println("\nEnter second complex number:");
        c2.read(sc);
        
        // Display both complex numbers
        System.out.print("\nFirst complex number: ");
        c1.display();
        
        System.out.print("Second complex number: ");
        c2.display();
        
        // Add two complex numbers
        Complex sum = c1.add(c2);
        System.out.print("\nSum: ");
        sum.display();
        
        // Multiply two complex numbers
        Complex product = c1.multiply(c2);
        System.out.print("Product: ");
        product.display();
        
        sc.close();
    }
}