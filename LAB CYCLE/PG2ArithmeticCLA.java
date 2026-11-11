class PG2ArithmeticCLA {
    public static void main(String args[]) {
        // Check if three arguments are provided (two numbers and operation code)
        if (args.length < 3) {
            System.out.println("Usage: java ArithmeticCLA <a> <b> <operation>");
            return;
        }

        // Convert first argument to integer (first operand)
        int a = Integer.parseInt(args[0]);
        
        // Convert second argument to integer (second operand)
        int b = Integer.parseInt(args[1]);
        
        // Convert third argument to integer (operation code: 0-Add, 1-Sub, 2-Mul, 3-Div, 4-Mod)
        int o = Integer.parseInt(args[2]);

        // Perform operation based on operation code
        switch (o) {
            case 0:
                // Addition
                System.out.println(a + " + " + b + " = " + (a + b));
                break;

            case 1:
                // Subtraction
                System.out.println(a + " - " + b + " = " + (a - b));
                break;

            case 2:
                // Multiplication
                System.out.println(a + " * " + b + " = " + (a * b));
                break;

            case 3:
                // Division with zero check
                if (b == 0) {
                    System.out.println("Error: Division by zero");
                } else {
                    System.out.println(a + " / " + b + " = " + (a / b));
                }
                break;

            case 4:
                // Modulus with zero check
                if (b == 0) {
                    System.out.println("Error: Modulus by zero");
                } else {
                    System.out.println(a + " % " + b + " = " + (a % b));
                }
                break;

            default:
                // Invalid operation code
                System.out.println("Invalid operation code.");
        }
    }
}