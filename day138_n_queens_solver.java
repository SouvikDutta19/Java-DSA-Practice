// day138_n_queens_solver.java
import java.util.*;

public class day138_n_queens_solver {

    static List<List<String>> result = new ArrayList<>();
    static char[][] board;

    public static List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(0);
        return result;
    }

    private static void backtrack(int row) {
        if (row == board.length) {
            List<String> temp = new ArrayList<>();
            for (char[] r : board) temp.add(new String(r));
            result.add(temp);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 'Q';
                backtrack(row + 1);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(int r, int c) {
        for (int i = 0; i < r; i++)
            if (board[i][c] == 'Q') return false;

        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        for (int i = r, j = c; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    public static void main(String[] args) {
        List<List<String>> sol = solveNQueens(4);
        System.out.println(sol);
    }
}
