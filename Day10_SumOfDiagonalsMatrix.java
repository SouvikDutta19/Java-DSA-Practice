import java.util.Scanner;

public class Day10_SumOfDiagonalsMatrix {

    public static int diagonalSum(int[][] matrix) {
        int sum = 0, n = matrix.length;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
            if (i != n - i - 1) {
                sum += matrix[i][n - i - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter matrix size (n x n): ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        System.out.println("➕ Sum of diagonals: " + diagonalSum(matrix));
        sc.close();
    }
}
