public class day156_n_queens_solution {

    final int N = 4;

    boolean isSafe(int board[][], int row, int col) {

        for (int i = 0; i < col; i++)
            if (board[row][i] == 1) return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1) return false;

        return true;
    }

    boolean solveNQ(int board[][], int col) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {

            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQ(board, col + 1))
                    return true;

                board[i][col] = 0;
            }
        }

        return false;
    }

    void printBoard(int board[][]) {
        for (int[] row : board) {
            for (int x : row)
                System.out.print(x + " ");
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int[][] board = new int[4][4];
        day156_n_queens_solution q = new day156_n_queens_solution();

        if (q.solveNQ(board, 0))
            q.printBoard(board);
        else
            System.out.println("No solution found");
    }
}