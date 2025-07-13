public class Day13_SumOfDiagonalsMatrix {

    public static int sumDiagonals(int[][] mat) {
        int sum = 0, n = mat.length;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i]; // Main diagonal
            if (i != n - i - 1) sum += mat[i][n - i - 1]; // Secondary diagonal
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("➕ Sum of diagonals: " + sumDiagonals(mat));
    }
}
