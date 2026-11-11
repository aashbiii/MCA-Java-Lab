class PG1SumCLA {
    public static void main(String args[]) {
        // Check if at least two arguments are provided
        if (args.length < 2) {
            System.out.println("Usage: java PG1SumCLA <num1> <num2>");
            return;
        }

        // Convert first command-line argument from String to int
        int a = Integer.parseInt(args[0]);
        
        // Convert second command-line argument from String to int
        int b = Integer.parseInt(args[1]);

        // Display the sum of two numbers
        System.out.println(a + " + " + b + " = " + (a + b));
    }
}