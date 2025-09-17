import java.util.*;

public class day81_n_queens {
    static List<List<String>> res=new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(char[] row:board) Arrays.fill(row,'.');
        backtrack(board,0);
        return res;
    }

    static void backtrack(char[][] board,int row) {
        if(row==board.length) {
            List<String> sol=new ArrayList<>();
            for(char[] r:board) sol.add(new String(r));
            res.add(sol); return;
        }
        for(int col=0;col<board.length;col++) {
            if(isValid(board,row,col)) {
                board[row][col]='Q';
                backtrack(board,row+1);
                board[row][col]='.';
            }
        }
    }

    static boolean isValid(char[][] b,int r,int c) {
        for(int i=0;i<r;i++) if(b[i][c]=='Q') return false;
        for(int i=r-1,j=c-1;i>=0&&j>=0;i--,j--) if(b[i][j]=='Q') return false;
        for(int i=r-1,j=c+1;i>=0&&j<b.length;i--,j++) if(b[i][j]=='Q') return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
