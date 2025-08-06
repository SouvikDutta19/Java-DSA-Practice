public class day37_rotate_matrix_90_degrees {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // Reverse each row
        for (int[] row : matrix) {
            int start = 0, end = n - 1;
            while (start < end) {
                int temp = row[start];
                row[start] = row[end];
                row[end] = temp;
                start++;
                end--;
            }
        }
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("Matrix after 90-degree rotation:");
        printMatrix(matrix);
    }
}
