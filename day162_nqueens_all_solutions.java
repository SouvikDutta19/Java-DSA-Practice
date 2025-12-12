// Day162 - N-Queens: print all solutions using backtracking
import java.util.*;

public class day162_nqueens_all_solutions {
    static void solve(int row, char[][] board, List<List<String>> res) {
        int n = board.length;
        if (row == n) {
            List<String> sol = new ArrayList<>();
            for (char[] r : board) sol.add(new String(r));
            res.add(sol);
            return;
        }
        for (int col=0; col<n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(row+1, board, res);
                board[row][col] = '.';
            }
        }
    }
    static boolean isSafe(char[][] board, int r, int c) {
        int n = board.length;
        for (int i=0;i<r;i++) if (board[i][c]=='Q') return false;
        for (int i=r-1, j=c-1; i>=0 && j>=0; i--,j--) if (board[i][j]=='Q') return false;
        for (int i=r-1, j=c+1; i>=0 && j<n; i--,j++) if (board[i][j]=='Q') return false;
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i=0;i<n;i++) Arrays.fill(board[i], '.');
        List<List<String>> res = new ArrayList<>();
        solve(0, board, res);
        System.out.println("Total solutions: " + res.size());
        for (List<String> sol : res) {
            for (String row : sol) System.out.println(row);
            System.out.println();
        }
    }
}