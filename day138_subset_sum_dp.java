// day138_subset_sum_dp.java
public class day138_subset_sum_dp {

    public static boolean subsetSum(int[] arr, int sum) {
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i <= arr.length; i++)
            dp[i][0] = true;

        for (int i = 1; i <= arr.length; i++) {
            for (int s = 1; s <= sum; s++) {
                if (arr[i-1] <= s)
                    dp[i][s] = dp[i-1][s] || dp[i-1][s - arr[i-1]];
                else
                    dp[i][s] = dp[i-1][s];
            }
        }
        return dp[arr.length][sum];
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println("Subset Sum Possible: " + subsetSum(arr, sum));
    }
}
