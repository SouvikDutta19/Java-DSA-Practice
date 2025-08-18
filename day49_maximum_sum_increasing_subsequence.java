import java.util.*;

public class day49_maximum_sum_increasing_subsequence {

    public static int maxSumIS(int arr[], int n) {
        int[] msis = new int[n];
        for (int i = 0; i < n; i++) 
            msis[i] = arr[i];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) {
                    msis[i] = msis[j] + arr[i];
                }
            }
        }
        int max = msis[0];
        for (int i = 1; i < n; i++) 
            if (max < msis[i]) 
                max = msis[i];
        return max;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements: ");
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        
        System.out.println("Maximum Sum Increasing Subsequence: " + maxSumIS(arr, n));
        sc.close();
    }
}
