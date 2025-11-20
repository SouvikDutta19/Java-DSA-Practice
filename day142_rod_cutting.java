import java.util.*;

public class day142_rod_cutting {

    public static int rodCutting(int[] price, int n) {
        int[] dp = new int[n + 1];
        int[] cuts = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int best = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                if (best < price[j - 1] + dp[i - j]) {
                    best = price[j - 1] + dp[i - j];
                    cuts[i] = j;
                }
            }
            dp[i] = best;
        }

        System.out.println("Maximum Profit: " + dp[n]);
        System.out.print("Cuts: ");

        while (n > 0) {
            System.out.print(cuts[n] + " ");
            n -= cuts[n];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        rodCutting(price, n);
    }
}
