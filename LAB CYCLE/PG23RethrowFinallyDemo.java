//Write a program to implement re-throw and finally.

import java.io.*;
public class PG23RethrowFinallyDemo {
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
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occurred: " + e);
            throw e; // Re-throwing the exception
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception occurred: " + e);
            throw e; // Re-throwing the exception
        } catch (IOException e) {
            System.out.println("IO Exception occurred: " + e);
            throw new RuntimeException(e); // Wrapping and re-throwing
        } finally {
            System.out.println("Execution of try-catch block is complete.");
        }
    }
}