// Parallel search using n/5 threads

import java.util.Scanner;

class SearchThread extends Thread {
    int[] arr;
    int start, end, key, threadId;
    int foundIndex = -1;

    SearchThread(int[] arr, int start, int end, int key, int threadId) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.key = key;
        this.threadId = threadId;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            if (arr[i] == key) {
                foundIndex = i;
                System.out.println("Element " + key + " found at index " + i +" by Thread-" + threadId);
                break;
            }
        }
    }

    int getFoundIndex() {
        return foundIndex;
    }
}

public class PG28ParallelSearch {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int threadCount = n / 5;
        int segmentSize = 5;

        SearchThread[] threads = new SearchThread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int start = i * segmentSize;
            int end = Math.min(start + segmentSize, n);

            threads[i] = new SearchThread(arr, start, end, key, i + 1);
            threads[i].start();
        }

        for (SearchThread t : threads) {
            t.join();
        }

        sc.close();
    }
}
