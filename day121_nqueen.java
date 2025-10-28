// day121_nqueen.java
import java.util.*;

public class day121_nqueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        solve(0, board, res);
        return res;
    }

    private void solve(int col, char[][] board, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                solve(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board) {
        for (int i = 0; i < col; i++)
            if (board[row][i] == 'Q') return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        for (int i = row, j = col; i < board.length && j >= 0; i++, j--)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board)
            list.add(new String(row));
        return list;
    }

    public static void main(String[] args) {
        day121_nqueen obj = new day121_nqueen();
        System.out.println(obj.solveNQueens(4));
    }
}
