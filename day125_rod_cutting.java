import java.util.*;

public class day125_rod_cutting {

    static int rodCutting(int[] price, int n) {
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
        int[] price = {2, 5, 7, 8, 10};
        int n = price.length;
        System.out.println("Maximum obtainable value: " + rodCutting(price, n));
    }
}
