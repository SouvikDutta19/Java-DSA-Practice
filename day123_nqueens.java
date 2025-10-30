// day123_nqueens.java
import java.util.*;

public class day123_nqueens {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(board, 0);
        return res;
    }

    void backtrack(char[][] board, int row) {
        if (row == board.length) {
            List<String> temp = new ArrayList<>();
            for (char[] r : board) temp.add(new String(r));
            res.add(temp);
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

    boolean isSafe(char[][] b, int r, int c) {
        for (int i = 0; i < r; i++) if (b[i][c] == 'Q') return false;
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) if (b[i][j] == 'Q') return false;
        for (int i = r - 1, j = c + 1; i >= 0 && j < b.length; i--, j++) if (b[i][j] == 'Q') return false;
        return true;
    }

    public static void main(String[] args) {
        day123_nqueens obj = new day123_nqueens();
        System.out.println("Solutions for 4-Queens:");
        for (List<String> sol : obj.solveNQueens(4)) System.out.println(sol);
    }
}
