import java.util.Scanner;

class PrinterSyncClass {
    public synchronized void printMessage(String message) {
        
        try {
            System.out.println("Printing message: [");
            Thread.sleep(1000);
            System.out.println(message);
            System.out.println("]");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        
    }
}

class PrinterSyncThread extends Thread {
    PrinterSyncClass printer;
    String message;
    public PrinterSyncThread(PrinterSyncClass printer, String message) {
        this.printer = printer;
        this.message = message;
    }
    public void run() {
        printer.printMessage(message);
    }
}

public class PG31PrinterSyncDemo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the message for Thread 1: ");
        String message1 = sc.nextLine();
        System.out.print("Enter the message for Thread 2: ");
        String message2 = sc.nextLine();
        System.out.print("Enter the message for Thread 3: ");
        String message3 = sc.nextLine();

        PrinterSyncClass printer = new PrinterSyncClass();
        PrinterSyncThread t1 = new PrinterSyncThread(printer, message1);
        PrinterSyncThread t2 = new PrinterSyncThread(printer, message2);
        PrinterSyncThread t3 = new PrinterSyncThread(printer, message3);
        t1.start();
        t2.start();
        t3.start();
    }
}