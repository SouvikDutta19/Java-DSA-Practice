public class day97_coinchange {
    static int countWays(int coins[], int m, int n) {
        int table[] = new int[n + 1];
        table[0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = coins[i]; j <= n; j++)
                table[j] += table[j - coins[i]];
        return table[n];
    }

    public static void main(String args[]) {
        int coins[] = {1, 2, 3};
        int n = 4;
        System.out.println("Ways to make change: " + countWays(coins, coins.length, n));
    }
}
