import java.util.Scanner;

public class Day12_TransposeMatrix {

    public static void transpose(int[][] mat, int rows, int cols) {
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                transposed[j][i] = mat[i][j];

        System.out.println("🔁 Transposed Matrix:");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(transposed[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = 2, cols = 3;
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        transpose(matrix, rows, cols);
    }
}
