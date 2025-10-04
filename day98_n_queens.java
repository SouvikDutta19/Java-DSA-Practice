import java.util.*;

public class day98_n_queens {
    static List<List<String>> res = new ArrayList<>();

    static void solve(int n, int row, char[][] board, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] r : board) temp.add(new String(r));
            res.add(temp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols[col] || d1[row - col + n - 1] || d2[row + col]) continue;
            board[row][col] = 'Q';
            cols[col] = d1[row - col + n - 1] = d2[row + col] = true;
            solve(n, row + 1, board, cols, d1, d2);
            board[row][col] = '.';
            cols[col] = d1[row - col + n - 1] = d2[row + col] = false;
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] r : board) Arrays.fill(r, '.');
        solve(n, 0, board, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
