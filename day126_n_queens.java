public class day126_n_queens {

    static void solveNQueens(int n) {
        int[][] board = new int[n][n];
        placeQueens(board, 0, n);
    }

    static boolean placeQueens(int[][] board, int row, int n) {
        if (row == n) {
            printBoard(board, n);
            return true;
        }

        boolean res = false;
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;
                res = placeQueens(board, row + 1, n) || res;
                board[row][col] = 0;
            }
        }
        return res;
    }

    static boolean isSafe(int[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1) return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        for (int i = row, j = col; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 1) return false;

        return true;
    }

    static void printBoard(int[][] board, int n) {
        for (int[] row : board) {
            for (int cell : row)
                System.out.print((cell == 1 ? "Q " : ". "));
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 8;
        solveNQueens(n);
    }
}
