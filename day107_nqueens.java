import java.util.*;

// Solving N-Queens using Backtracking
public class day107_nqueens {
    static void solve(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(0, board, n);
    }

    static void backtrack(int row, char[][] board, int n) {
        if (row == n) {
            for (char[] r : board) System.out.println(Arrays.toString(r));
            System.out.println();
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board, n);
                board[row][col] = '.';
            }
        }
    }

    static boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) if (board[i][col] == 'Q') return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) if (board[i][j] == 'Q') return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) if (board[i][j] == 'Q') return false;
        return true;
    }

    public static void main(String[] args) {
        int N = 4;
        System.out.println("Solutions for " + N + "-Queens:");
        solve(N);
    }
}
