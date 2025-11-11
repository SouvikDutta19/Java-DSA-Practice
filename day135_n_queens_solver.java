import java.util.*;

public class day135_n_queens_solver {
    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(res, board, 0);
        return res;
    }

    private static void backtrack(List<List<String>> res, char[][] board, int row) {
        if (row == board.length) {
            List<String> copy = new ArrayList<>();
            for (char[] r : board)
                copy.add(new String(r));
            res.add(copy);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(res, board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println("N-Queens solutions for n=4:");
        for (List<String> sol : solveNQueens(4))
            System.out.println(sol);
    }
}
