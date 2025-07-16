public class Day16_RotateMatrix90Degrees {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                swap(matrix, i, j, j, i);

        // Reverse rows
        for (int[] row : matrix) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = row[left];
                row[left++] = row[right];
                row[right--] = temp;
            }
        }
    }

    private static void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(mat);
        for (int[] row : mat) {
            for (int num : row)
                System.out.print(num + " ");
            System.out.println();
        }
    }
}
