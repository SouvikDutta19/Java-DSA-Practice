import java.util.*;

public class day60_n_queens {
    static List<List<String>> solutions;

    public static List<List<String>> solveNQueens(int n) {
        solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(board, 0);
        return solutions;
    }

    private static void backtrack(char[][] board, int row) {
        if (row == board.length) {
            List<String> config = new ArrayList<>();
            for (char[] r : board) config.add(new String(r));
            solutions.add(config);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) if (board[i][col] == 'Q') return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) if (board[i][j] == 'Q') return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) if (board[i][j] == 'Q') return false;
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(4);
        for (List<String> sol : res) {
            for (String row : sol) System.out.println(row);
            System.out.println();
        }
    }
}
