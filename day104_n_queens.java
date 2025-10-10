import java.util.*;

// Solving the N-Queens problem using Backtracking
public class day104_n_queens {
    static void solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');
        List<List<String>> solutions = new ArrayList<>();
        backtrack(board, 0, solutions);
        for (List<String> sol : solutions)
            System.out.println(sol);
    }

    static void backtrack(char[][] board, int row, List<List<String>> solutions) {
        if (row == board.length) {
            List<String> temp = new ArrayList<>();
            for (char[] r : board)
                temp.add(new String(r));
            solutions.add(temp);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, solutions);
                board[row][col] = '.';
            }
        }
    }

    static boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;
        return true;
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }
}
