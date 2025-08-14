import java.util.*;

public class day45_max_sum_increasing_subsequence {

    public static int maxSumIS(int arr[], int n) {
        int[] msis = new int[n];
        System.arraycopy(arr, 0, msis, 0, n);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) {
                    msis[i] = msis[j] + arr[i];
                }
            }
        }

        int max = msis[0];
        for (int i = 1; i < n; i++) {
            if (msis[i] > max) max = msis[i];
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100, 4, 5};
        System.out.println("Maximum sum of increasing subsequence is " + maxSumIS(arr, arr.length));
    }
}
