import java.util.Scanner;

public class SecondSmallest15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();
        
        int[] arr = new int[size];
        
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        
        for (int i = 0; i < size; i++) {
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] < secondSmallest && arr[i] != smallest) {
                secondSmallest = arr[i];
            }
        }
        
        if (secondSmallest == Integer.MAX_VALUE) {
            System.out.println("\nNo second smallest element exists");
        } else {
            System.out.println("\nSmallest element: " + smallest);
            System.out.println("Second smallest element: " + secondSmallest);
        }
        
        sc.close();
    }
}