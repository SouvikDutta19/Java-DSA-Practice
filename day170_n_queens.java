import java.util.*;

public class day170_n_queens {

    static void solve(int col, int n, char[][] board,
                      boolean[] leftRow,
                      boolean[] lowerDiag,
                      boolean[] upperDiag,
                      List<List<String>> res) {

        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (char[] row : board)
                temp.add(new String(row));
            res.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (!leftRow[row] &&
                !lowerDiag[row + col] &&
                !upperDiag[n - 1 + col - row]) {

                board[row][col] = 'Q';
                leftRow[row] = lowerDiag[row + col] =
                        upperDiag[n - 1 + col - row] = true;

                solve(col + 1, n, board, leftRow, lowerDiag, upperDiag, res);

                board[row][col] = '.';
                leftRow[row] = lowerDiag[row + col] =
                        upperDiag[n - 1 + col - row] = false;
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');

        List<List<String>> res = new ArrayList<>();
        solve(0, n, board, new boolean[n],
                new boolean[2*n], new boolean[2*n], res);

        for (List<String> sol : res) {
            System.out.println(sol);
        }
    }
}