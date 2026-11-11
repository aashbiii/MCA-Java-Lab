import java.util.Scanner;

public class SearchArray14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();
        
        int[] arr = new int[size];
        
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("\nEnter element to search: ");
        int searchElement = sc.nextInt();
        
        boolean found = false;
        int position = -1;
        
        for (int i = 0; i < size; i++) {
            if (arr[i] == searchElement) {
                found = true;
                position = i;
                break;
            }
        }
        
        if (found) {
            System.out.println("\nElement " + searchElement + " found at index " + position);
        } else {
            System.out.println("\nElement " + searchElement + " not found in the array");
        }
        
        sc.close();
    }
}