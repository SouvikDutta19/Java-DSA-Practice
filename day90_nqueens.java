import java.util.*;

public class day90_nqueens {
    static List<List<String>> res;

    public static List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(board, 0);
        return res;
    }

    private static void backtrack(char[][] board, int row) {
        if (row == board.length) {
            List<String> temp = new ArrayList<>();
            for (char[] r : board) temp.add(new String(r));
            res.add(temp);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) if (board[i][col] == 'Q') return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) if (board[i][j] == 'Q') return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) if (board[i][j] == 'Q') return false;
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> result = solveNQueens(4);
        for (List<String> sol : result) System.out.println(sol);
    }
}
