import java.util.Arrays;
import java.util.Scanner;

public class Day8_BinarySearchIterative {

    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        int index = binarySearch(arr, key);
        if (index != -1)
            System.out.println("✅ Element found at index: " + index);
        else
            System.out.println("❌ Element not found.");

        sc.close();
    }
}
