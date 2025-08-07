// Rod Cutting Problem - Memoized Version

import java.util.Arrays;

public class day38_rodcuttingmemoization {
    public static int cutRod(int price[], int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return rodCuttingHelper(price, n, dp);
    }

    private static int rodCuttingHelper(int[] price, int n, int[] dp) {
        if (n == 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];

        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal, price[i] + rodCuttingHelper(price, n - i - 1, dp));
        }

        dp[n] = maxVal;
        return dp[n];
    }

    public static void main(String[] args) {
        int[] price = {2, 5, 9, 8};
        int n = price.length;
        System.out.println("Maximum obtainable value: " + cutRod(price, n));
    }
}
