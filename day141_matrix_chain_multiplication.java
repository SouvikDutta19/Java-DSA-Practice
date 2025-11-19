// day141_matrix_chain_multiplication.java
// Computes minimum multiplication cost and prints optimal parenthesization.

import java.util.*;

public class day141_matrix_chain_multiplication {

    public static int matrixChainOrder(int[] dims) {
        int n = dims.length - 1;
        int[][] dp = new int[n + 1][n + 1];
        int[][] split = new int[n + 1][n + 1];

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + dims[i-1] * dims[k] * dims[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        split[i][j] = k;
                    }
                }
            }
        }

        System.out.println("Minimum multiplications: " + dp[1][n]);
        System.out.print("Optimal parenthesization: ");
        printOptimalParens(split, 1, n);
        System.out.println();
        return dp[1][n];
    }

    private static void printOptimalParens(int[][] split, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
            return;
        }
        System.out.print("(");
        printOptimalParens(split, i, split[i][j]);
        System.out.print(" x ");
        printOptimalParens(split, split[i][j] + 1, j);
        System.out.print(")");
    }

    public static void main(String[] args) {
        int[] dims = {40, 20, 30, 10, 30}; // matrices: A1 40x20, A2 20x30, A3 30x10, A4 10x30
        matrixChainOrder(dims);
    }
}
