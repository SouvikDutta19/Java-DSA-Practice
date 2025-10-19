// Program to find minimum subset sum difference (Partition Problem) using DP

import java.util.*;

public class day112_minimum_partition_sum_difference {
    public static int minSubsetSumDifference(int[] arr, int n) {
        int total = 0;
        for (int num : arr) total += num;

        boolean[][] dp = new boolean[n + 1][total / 2 + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= total / 2; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int j = total / 2; j >= 0; j--) {
            if (dp[n][j]) {
                minDiff = total - 2 * j;
                break;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        int n = arr.length;
        System.out.println("Minimum subset sum difference: " + minSubsetSumDifference(arr, n));
    }
}
