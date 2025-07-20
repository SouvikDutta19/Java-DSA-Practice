public class day20_rotateImage90Degrees {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                swap(matrix, i, j, j, i);

        for (int[] row : matrix)
            reverse(row);
    }

    private static void swap(int[][] m, int i1, int j1, int i2, int j2) {
        int temp = m[i1][j1];
        m[i1][j1] = m[i2][j2];
        m[i2][j2] = temp;
    }

    private static void reverse(int[] row) {
        int i = 0, j = row.length - 1;
        while (i < j) {
            int tmp = row[i];
            row[i++] = row[j];
            row[j--] = tmp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int[] row : matrix) {
            for (int cell : row) System.out.print(cell + " ");
            System.out.println();
        }
    }
}
