import java.util.Scanner;

public class PG38StringOperations {

    // a. Length of a string
    static void findLength(String str) {
        System.out.println("String : \"" + str + "\"");
        System.out.println("Length : " + str.length());
    }

    // b. Compare for equality
    static void compareStrings(String str1, String str2) {
        System.out.println("String 1 : \"" + str1 + "\"");
        System.out.println("String 2 : \"" + str2 + "\"");

        if (str1.equals(str2))
            System.out.println("Result   : Strings are EQUAL (case-sensitive)");
        else
            System.out.println("Result   : Strings are NOT EQUAL (case-sensitive)");

        if (str1.equalsIgnoreCase(str2))
            System.out.println("Result   : Strings are EQUAL (case-insensitive)");
        else
            System.out.println("Result   : Strings are NOT EQUAL (case-insensitive)");

        int cmp = str1.compareTo(str2);
        if      (cmp < 0) System.out.println("Order    : \"" + str1 + "\" comes BEFORE \"" + str2 + "\" alphabetically");
        else if (cmp > 0) System.out.println("Order    : \"" + str1 + "\" comes AFTER  \"" + str2 + "\" alphabetically");
        else              System.out.println("Order    : Both strings are identical");
    }

    // c. Extract a substring
    static void extractSubstring(String str, Scanner sc) {
        System.out.println("String : \"" + str + "\"");
        System.out.println("Length : " + str.length());
        System.out.print("Enter start index       : ");
        int start = sc.nextInt();
        System.out.print("Enter end index         : ");
        int end = sc.nextInt();
        sc.nextLine();

        if (start < 0 || end > str.length() || start > end) {
            System.out.println("Invalid indices! Please check the range.");
        } else {
            System.out.println("Substring [" + start + ", " + end + ") : \"" + str.substring(start, end) + "\"");
            System.out.println("Substring from " + start + " to end   : \"" + str.substring(start) + "\"");
        }
    }

    // d. Convert to uppercase and lowercase
    static void convertCase(String str) {
        System.out.println("Original   : \"" + str + "\"");
        System.out.println("Uppercase  : \"" + str.toUpperCase() + "\"");
        System.out.println("Lowercase  : \"" + str.toLowerCase() + "\"");
    }

    // e. Reverse a string
    static void reverseString(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println("Original : \"" + str + "\"");
        System.out.println("Reversed : \"" + reversed + "\"");

        if (str.equalsIgnoreCase(reversed))
            System.out.println("Note     : This string is a PALINDROME!");
        else
            System.out.println("Note     : This string is NOT a palindrome.");
    }

    // ── main ──────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- STRING OPERATIONS MENU ---");
            System.out.println("1. Length of a String");
            System.out.println("2. Compare Two Strings");
            System.out.println("3. Extract a Substring");
            System.out.println("4. Convert to Upper/Lowercase");
            System.out.println("5. Reverse a String");
            System.out.println("6. Exit");
            System.out.println("------------------------------");
            System.out.print("Enter your choice (1-6): ");
            choice = sc.nextInt();
            sc.nextLine();

            System.out.println("----------------------------------------");

            switch (choice) {

                case 1:
                    System.out.print("Enter a string: ");
                    String s1 = sc.nextLine();
                    findLength(s1);
                    break;

                case 2:
                    System.out.print("Enter String 1: ");
                    String cmp1 = sc.nextLine();
                    System.out.print("Enter String 2: ");
                    String cmp2 = sc.nextLine();
                    compareStrings(cmp1, cmp2);
                    break;

                case 3:
                    System.out.print("Enter a string: ");
                    String s3 = sc.nextLine();
                    extractSubstring(s3, sc);
                    break;

                case 4:
                    System.out.print("Enter a string: ");
                    String s4 = sc.nextLine();
                    convertCase(s4);
                    break;

                case 5:
                    System.out.print("Enter a string: ");
                    String s5 = sc.nextLine();
                    reverseString(s5);
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter between 1 and 6.");
            }

            System.out.println("----------------------------------------");

        } while (choice != 6);

        sc.close();
    }
}