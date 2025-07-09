import java.util.Scanner;

public class Day9_TransposeMatrix {

    public static int[][] transpose(int[][] matrix, int r, int c) {
        int[][] transposed = new int[c][r];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                transposed[j][i] = matrix[i][j];

        return transposed;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns of matrix: ");
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] matrix = new int[r][c];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                matrix[i][j] = sc.nextInt();

        int[][] result = transpose(matrix, r, c);
        System.out.println("🔄 Transposed matrix:");
        printMatrix(result);

        sc.close();
    }
}
