// day132_rodcutting.java
public class day132_rodcutting {
    static int cutRod(int price[], int n) {
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
        int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum obtainable value is " + cutRod(arr, size));
    }
}
