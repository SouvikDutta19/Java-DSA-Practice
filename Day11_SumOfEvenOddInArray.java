import java.util.Scanner;

public class Day11_SumOfEvenOddInArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int evenSum = 0, oddSum = 0;
        for (int value : arr) {
            if (value % 2 == 0) evenSum += value;
            else oddSum += value;
        }

        System.out.println("🔵 Even Sum: " + evenSum);
        System.out.println("🔴 Odd Sum: " + oddSum);
        sc.close();
    }
}
