// Sudoku solver using backtracking
public class day119_sudoku_solver {

    static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int d = 0; d < 9; d++)
            if (board[row][d] == num || board[d][col] == num) return false;

        int startRow = row - row % 3, startCol = col - col % 3;
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (board[startRow + r][startCol + c] == num) return false;

        return true;
    }

    static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) return true;
                            board[row][col] = 0;
                        }
                    }
                    return false; // trigger backtracking
                }
            }
        }
        return true; // solved
    }

    static void printBoard(int[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int d = 0; d < 9; d++) System.out.print(board[r][d] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = {
            {3,0,6,5,0,8,4,0,0},
            {5,2,0,0,0,0,0,0,0},
            {0,8,7,0,0,0,0,3,1},
            {0,0,3,0,1,0,0,8,0},
            {9,0,0,8,6,3,0,0,5},
            {0,5,0,0,9,0,6,0,0},
            {1,3,0,0,0,0,2,5,0},
            {0,0,0,0,0,0,0,7,4},
            {0,0,5,2,0,6,3,0,0}
        };

        if (solveSudoku(board)) {
            System.out.println("Solved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }
    }
}
