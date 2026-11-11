import java.util.Scanner;

class PG5PassArray {

    static void printarray(int arr[]) {
        System.out.println("Array elements: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static void printarraywithsize(int arr[], int n) {
        System.out.println("Array using size: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void printelement(int element) {
        System.out.println("Individual element: " + element);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the array size: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        printarray(arr);

        printarraywithsize(arr, n);

        System.out.println("Passing elements one by one:");
        for (int i = 0; i < n; i++) {
            printelement(arr[i]);
        }

        sc.close();
    }
}
