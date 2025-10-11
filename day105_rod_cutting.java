import java.util.*;

// Rod Cutting Problem using DP
public class day105_rod_cutting {
    public static int cutRod(int price[], int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                maxVal = Math.max(maxVal, price[j] + dp[i - j - 1]);
            dp[i] = maxVal;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int arr[] = {2, 5, 7, 8, 10};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value: " + cutRod(arr, size));
    }
}
