public class PG36GenericMethods {

    // Generic method to print any type of array
    public static <T> void printArray(T[] array) {
        System.out.print("Array elements: ");
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Generic method to find maximum of three values
    public static <T extends Comparable<T>> T findMax(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) max = b;
        if (c.compareTo(max) > 0) max = c;
        return max;
    }

    // Generic method to swap two elements of an array
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Generic method to check if an element exists in an array
    public static <T> boolean contains(T[] array, T key) {
        for (T element : array) {
            if (element.equals(key)) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        // Integer array
        Integer[] intArray = {10, 20, 30, 40, 50};
        printArray(intArray);

        // String array
        String[] strArray = {"Java", "Python", "C++", "HTML"};
        printArray(strArray);

        // Double array
        Double[] dblArray = {1.1, 2.2, 3.3, 4.4};
        printArray(dblArray);

        // Find Maximum
        System.out.println("\nMax of (10, 55, 30)     : " + findMax(10, 55, 30));
        System.out.println("Max of (Apple, Mango, Fig): " + findMax("Apple", "Mango", "Fig"));
        System.out.println("Max of (1.5, 9.9, 3.3)  : " + findMax(1.5, 9.9, 3.3));

        // Swap
        System.out.println("\nBefore swap: ");
        printArray(intArray);
        swap(intArray, 0, 4);
        System.out.println("After swap (index 0 & 4): ");
        printArray(intArray);

        // Contains
        System.out.println("\n\"Python\" in strArray : " + contains(strArray, "Python"));
        System.out.println("\"Ruby\" in strArray   : " + contains(strArray, "Ruby"));
    }
}