import java.util.Scanner;

public class Day3_FindMissingNumber {

    public static int findMissing(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array (n-1): ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter elements from 1 to n with one missing:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int missing = findMissing(arr, size + 1);
        System.out.println("🕵️ Missing number is: " + missing);

        sc.close();
    }
}
