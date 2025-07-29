public class NQueenSolver {

    final int N = 8;
    int[][] board = new int[N][N];

    boolean isSafe(int row, int col) {
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1) return false;

        for (int i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1) return false;

        for (int i=row, j=col; i<N && j>=0; i++, j--)
            if (board[i][j] == 1) return false;

        return true;
    }

    boolean solveNQUtil(int col) {
        if (col >= N) return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;
                if (solveNQUtil(col + 1)) return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    void solve() {
        if (!solveNQUtil(0)) {
            System.out.println("Solution does not exist");
            return;
        }

        for (int[] row : board) {
            for (int x : row)
                System.out.print((x == 1 ? "Q " : ". "));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new NQueenSolver().solve();
    }
}
