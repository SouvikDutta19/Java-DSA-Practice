import java.util.*;

public class day88_longest_increasing_path_matrix {
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int dfs(int[][] mat, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j];
        int max = 1;
        for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            if (ni>=0 && nj>=0 && ni<mat.length && nj<mat[0].length && mat[ni][nj] > mat[i][j]) {
                max = Math.max(max, 1 + dfs(mat, ni, nj, dp));
            }
        }
        return dp[i][j] = max;
    }

    public static void main(String[] args) {
        int[][] mat = {{9,9,4},{6,6,8},{2,1,1}};
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i=0;i<m;i++) for (int j=0;j<n;j++) res = Math.max(res, dfs(mat,i,j,dp));
        System.out.println("Longest increasing path: " + res);
    }
}
