public class day33_2dsparsematrixsumqueries {
    private int[][] prefix;

    public day33_2dsparsematrixsumqueries(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                prefix[i][j] = matrix[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1] - prefix[row2 + 1][col1] + prefix[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };
        day33_2dsparsematrixsumqueries obj = new day33_2dsparsematrixsumqueries(matrix);
        System.out.println("Sum Region (2,1)-(4,3): " + obj.sumRegion(2, 1, 4, 3));
    }
}
