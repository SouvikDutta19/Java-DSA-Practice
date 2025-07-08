import java.util.Scanner;

public class Day8_SumOfArrayElements {

    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int val : arr) sum += val;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int sum = sumArray(arr);
        System.out.println("➕ Sum of array elements: " + sum);

        sc.close();
    }
}
