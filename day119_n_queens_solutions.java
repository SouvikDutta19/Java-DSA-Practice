import java.util.*;

// Generate and print all solutions to N-Queens using backtracking
public class day119_n_queens_solutions {

    static void solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        List<List<String>> results = new ArrayList<>();
        backtrack(0, board, results);
        printResults(results);
    }

    static void backtrack(int col, char[][] board, List<List<String>> results) {
        int n = board.length;
        if (col == n) {
            results.add(construct(board));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(col + 1, board, results);
                board[row][col] = '.';
            }
        }
    }

    static boolean isSafe(char[][] board, int row, int col) {
        int i, j, n = board.length;
        for (i = 0; i < col; i++) if (board[row][i] == 'Q') return false;
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) if (board[i][j] == 'Q') return false;
        for (i = row, j = col; j >= 0 && i < n; i++, j--) if (board[i][j] == 'Q') return false;
        return true;
    }

    static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) res.add(new String(row));
        return res;
    }

    static void printResults(List<List<String>> results) {
        int count = 1;
        for (List<String> sol : results) {
            System.out.println("Solution " + count++ + ":");
            for (String row : sol) System.out.println(row);
            System.out.println();
        }
        if (results.isEmpty()) System.out.println("No solutions");
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }
}
