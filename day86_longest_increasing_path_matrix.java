public class day86_longest_increasing_path_matrix {
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int rows, cols;

    public static int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length; cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, dfs(matrix, i, j, memo));
            }
        }
        return max;
    }

    private static int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];
        int max = 1;
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && y >= 0 && x < rows && y < cols && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, 1 + dfs(matrix, x, y, memo));
            }
        }
        memo[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println("Longest Increasing Path: " + longestIncreasingPath(matrix));
    }
}
