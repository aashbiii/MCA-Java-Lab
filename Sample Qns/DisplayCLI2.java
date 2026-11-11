public class DisplayCLI2 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide two numbers as arguments.");
            System.out.println("Usage: java DisplayNumbers <number1> <number2>");
            return;
        }
        
        System.out.println("First number: " + args[0]);
        System.out.println("Second number: " + args[1]);
        
        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            System.out.println("\nAs integers:");
            System.out.println("First number: " + num1);
            System.out.println("Second number: " + num2);
        } catch (NumberFormatException e) {
            System.out.println("\nNote: One or both arguments are not valid integers.");
        }
    }
}