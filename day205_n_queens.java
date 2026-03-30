import java.util.*;

public class day205_n_queens {

    public static List<List<String>> solveNQueens(int n){

        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for(char[] row : board)
            Arrays.fill(row,'.');

        solve(0, board, res);
        return res;
    }

    static void solve(int col, char[][] board, List<List<String>> res){

        if(col == board.length){
            List<String> temp = new ArrayList<>();
            for(char[] row : board)
                temp.add(new String(row));
            res.add(temp);
            return;
        }

        for(int row=0;row<board.length;row++){

            if(isSafe(board,row,col)){
                board[row][col] = 'Q';
                solve(col+1, board, res);
                board[row][col] = '.';
            }
        }
    }

    static boolean isSafe(char[][] board,int row,int col){

        for(int i=0;i<col;i++)
            if(board[row][i]=='Q') return false;

        for(int i=row,j=col;i>=0 && j>=0;i--,j--)
            if(board[i][j]=='Q') return false;

        for(int i=row,j=col;i<board.length && j>=0;i++,j--)
            if(board[i][j]=='Q') return false;

        return true;
    }
}