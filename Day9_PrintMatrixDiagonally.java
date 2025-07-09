import java.util.Scanner;

public class Day9_PrintMatrixDiagonally {

    public static void printDiagonals(int[][] matrix, int rows, int cols) {
        System.out.println("↘️ Primary Diagonal:");
        for (int i = 0; i < Math.min(rows, cols); i++) {
            System.out.print(matrix[i][i] + " ");
        }

        System.out.println("\n↙️ Secondary Diagonal:");
        for (int i = 0; i < Math.min(rows, cols); i++) {
            System.out.print(matrix[i][cols - i - 1] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows and columns: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];
        System.out.println("Enter matrix elements:");

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                matrix[i][j] = sc.nextInt();

        printDiagonals(matrix, r, c);

        sc.close();
    }
}
