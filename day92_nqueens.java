import java.util.*;

public class day92_nqueens {
    static List<List<String>> res=new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(char[] row:board) Arrays.fill(row,'.');
        backtrack(board,0);
        return res;
    }
    static void backtrack(char[][] board,int row){
        if(row==board.length){
            List<String> temp=new ArrayList<>();
            for(char[] r:board) temp.add(new String(r));
            res.add(temp); return;
        }
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]='Q';
                backtrack(board,row+1);
                board[row][col]='.';
            }
        }
    }
    static boolean isSafe(char[][] board,int r,int c){
        for(int i=0;i<r;i++) if(board[i][c]=='Q') return false;
        for(int i=r-1,j=c-1;i>=0&&j>=0;i--,j--) if(board[i][j]=='Q') return false;
        for(int i=r-1,j=c+1;i>=0&&j<board.length;i--,j++) if(board[i][j]=='Q') return false;
        return true;
    }
    public static void main(String[] args){
        System.out.println(solveNQueens(4));
    }
}
