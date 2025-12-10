public class day160_n_queens {

    static boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < col; i++)
            if (board[row][i] == 'Q') return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        for (int i = row, j = col; i < n && j >= 0; i++, j--)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    static boolean solve(char[][] board, int col, int n) {
        if (col >= n) return true;

        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = 'Q';

                if (solve(board, col + 1, n)) return true;

                board[i][col] = '.';
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 8;
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        solve(board, 0, n);

        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}