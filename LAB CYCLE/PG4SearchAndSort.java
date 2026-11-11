import java.util.Scanner;

public class PG4SearchAndSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input array size
        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();
        
        // Declare array
        int[] arr = new int[size];
        
        // Input array elements
        System.out.print("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Display original array
        System.out.print("\nOriginal array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        
        // Linear Search on original array
        System.out.print("\n\nEnter element to search: ");
        int searchElement = sc.nextInt();
        
        boolean found = false;
        int position = -1;
        
        // Traverse array to find element
        for (int i = 0; i < size; i++) {
            if (arr[i] == searchElement) {
                found = true;
                position = i;
                break;
            }
        }
        
        // Display linear search result
        if (found) {
            System.out.println("Element " + searchElement + " found at index " + position);
        } else {
            System.out.println("Element " + searchElement + " not found in the array");
        }
        
        // Bubble Sort - Sort array in ascending order
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                // Swap if current element is greater than next element
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        
        // Display sorted array
        System.out.print("\nSorted array (Ascending): ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        
        // Binary Search on sorted array
        System.out.print("\n\nEnter element to search in sorted array: ");
        searchElement = sc.nextInt();
        
        // Initialize binary search variables
        int left = 0;
        int right = size - 1;
        found = false;
        position = -1;
        
        // Binary search algorithm
        while (left <= right) {
            // Calculate middle index
            int mid = left + (right - left) / 2;
            
            // Check if element is at middle
            if (arr[mid] == searchElement) {
                found = true;
                position = mid;
                break;
            }
            
            // If element is greater, ignore left half
            if (arr[mid] < searchElement) {
                left = mid + 1;
            } else {
                // If element is smaller, ignore right half
                right = mid - 1;
            }
        }
        
        // Display binary search result
        if (found) {
            System.out.println("Element " + searchElement + " found at index " + position + " using Binary Search");
        } else {
            System.out.println("Element " + searchElement + " not found in the array");
        }
        
        sc.close();
    }
}