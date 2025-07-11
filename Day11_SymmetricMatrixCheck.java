import java.util.Scanner;

public class Day11_SymmetricMatrixCheck {

    public static boolean isSymmetric(int[][] matrix, int n) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] != matrix[j][i])
                    return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter matrix size (n x n): ");
        int n = sc.nextInt();
        int[][] mat = new int[n][n];

        System.out.println("Enter matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();

        System.out.println(isSymmetric(mat, n) ? "✅ Matrix is symmetric" : "❌ Matrix is not symmetric");
        sc.close();
    }
}
