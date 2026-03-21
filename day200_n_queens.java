import java.util.*;

public class day200_n_queens {

    public static List<List<String>> solveNQueens(int n){

        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for(char[] row : board)
            Arrays.fill(row,'.');

        backtrack(0,board,result);
        return result;
    }

    static void backtrack(int row, char[][] board, List<List<String>> result){

        if(row == board.length){
            List<String> temp = new ArrayList<>();
            for(char[] r : board)
                temp.add(new String(r));
            result.add(temp);
            return;
        }

        for(int col=0; col<board.length; col++){
            if(isSafe(board,row,col)){
                board[row][col]='Q';
                backtrack(row+1,board,result);
                board[row][col]='.';
            }
        }
    }

    static boolean isSafe(char[][] board,int row,int col){

        for(int i=0;i<row;i++)
            if(board[i][col]=='Q') return false;

        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
            if(board[i][j]=='Q') return false;

        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++)
            if(board[i][j]=='Q') return false;

        return true;
    }
}