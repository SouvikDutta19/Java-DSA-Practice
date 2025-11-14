// day138_longest_increasing_path_matrix.java
import java.util.*;

public class day138_longest_increasing_path_matrix {
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int m, n;

    public static int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] memo = new int[m][n];
        int max = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                max = Math.max(max, dfs(matrix, memo, i, j));

        return max;
    }

    private static int dfs(int[][] matrix, int[][] memo, int i, int j) {
        if (memo[i][j] != 0) return memo[i][j];

        int best = 1;
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j])
                best = Math.max(best, 1 + dfs(matrix, memo, x, y));
        }

        memo[i][j] = best;
        return best;
    }

    public static void main(String[] args) {
        int[][] mat = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println("Longest Increasing Path: " + longestIncreasingPath(mat));
    }
}
