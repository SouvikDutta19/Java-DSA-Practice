// day125_maximum_sum_increasing_subsequence.java
import java.util.*;

public class day125_maximum_sum_increasing_subsequence {
    public static int maxSumIS(int[] arr, int n) {
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i])
                    dp[i] = dp[j] + arr[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100, 4, 5};
        System.out.println("Maximum Sum of Increasing Subsequence: " + maxSumIS(arr, arr.length));
    }
}
