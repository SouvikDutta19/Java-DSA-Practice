public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                if(board[row][col] == '.') {
                    for(char c = '1'; c <= '9'; c++) {
                        if(isValid(board, row, col, c)) {
                            board[row][col] = c;
                            if(solve(board)) return true;
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == c || board[row][i] == c ||
               board[3*(row/3)+i/3][3*(col/3)+i%3] == c)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver solver = new SudokuSolver();
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        solver.solveSudoku(board);
        for(char[] row : board) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}
