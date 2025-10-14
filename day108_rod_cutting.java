import java.util.*;

// Rod Cutting Problem using DP
public class day108_rod_cutting {
    static int cutRod(int[] price, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                dp[i] = Math.max(dp[i], price[j] + dp[i - j - 1]);
        return dp[n];
    }

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = price.length;
        System.out.println("Maximum obtainable value: " + cutRod(price, n));
    }
}
