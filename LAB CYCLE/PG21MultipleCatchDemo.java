//Write a program using multiple catch statements / predefined Exceptions.

import java.io.*;

public class PG21MultipleCatchDemo {
    public static void main(String[] args) {
        DataInputStream sc = new DataInputStream(System.in);
        try {
            System.out.print("Enter first number:");
            String s = sc.readLine();
            int a = Integer.parseInt(s);
            System.out.print("Enter second number:");
            s = sc.readLine();
            int b = Integer.parseInt(s);
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (IOException e1) {
            System.out.println("IO Exception occurred: " + e1);
        } catch (NumberFormatException e2) {
            System.out.println("Number Format Exception occurred: " + e2);
        } catch (ArithmeticException e3) {
            System.out.println("Arithmetic Exception occurred: " + e3);
        } catch (Exception e4) {
            System.out.println("Other Exception occurred: " + e4);
        }
    }
}