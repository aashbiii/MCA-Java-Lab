import java.util.Scanner;

class PrinterClass {
    public void printMessage(String message) {
        System.out.println("Printing message: [");
        System.out.println(message);
        System.out.println("]");
    }
}

class PrinterThread extends Thread {
    PrinterClass printer;
    String message;
    public PrinterThread(PrinterClass printer, String message) {
        this.printer = printer;
        this.message = message;
    }
    public void run() {
        printer.printMessage(message);
    }
}

class PG30PrinterDemo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the message for Thread 1: ");
        String message1 = sc.nextLine();
        System.out.print("Enter the message for Thread 2: ");
        String message2 = sc.nextLine();
        System.out.print("Enter the message for Thread 3: ");
        String message3 = sc.nextLine();

        PrinterClass printer = new PrinterClass();
        PrinterThread t1 = new PrinterThread(printer, message1);
        PrinterThread t2 = new PrinterThread(printer, message2);
        PrinterThread t3 = new PrinterThread(printer, message3);
        t1.start();
        t2.start();
        t3.start();
    }
}