import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Day8_SortArrayDescending {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println("⬇️ Sorted array in descending order: " + Arrays.toString(arr));

        sc.close();
    }
}
