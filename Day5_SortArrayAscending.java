import java.util.Arrays;
import java.util.Scanner;

public class Day5_SortArrayAscending {

    public static void sortArray(int[] arr) {
        Arrays.sort(arr);
        System.out.println("📈 Sorted array in ascending order: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sortArray(arr);

        sc.close();
    }
}
