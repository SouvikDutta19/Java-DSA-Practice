import java.util.*;

public class day152_nqueens {

    public static boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;

        for (int i = row - 1, j = col - 1; 
             i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        for (int i = row - 1, j = col + 1; 
             i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    public static void solve(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            List<String> config = new ArrayList<>();
            for (char[] r : board)
                config.add(new String(r));
            result.add(config);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        List<List<String>> result = new ArrayList<>();
        solve(board, 0, result);

        System.out.println("N-Queens Solutions:");
        for (List<String> config : result)
            System.out.println(config);
    }
}
