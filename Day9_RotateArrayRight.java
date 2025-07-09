import java.util.Scanner;

public class Day9_RotateArrayRight {

    public static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        k %= n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    public static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++; right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.print("Enter number of rotations: ");
        int k = sc.nextInt();

        rotateRight(arr, k);

        System.out.println("🔁 Array after right rotation:");
        for (int val : arr) System.out.print(val + " ");

        sc.close();
    }
}
