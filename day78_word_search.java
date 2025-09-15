public class day78_word_search {
    public static boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(dfs(board,word,0,i,j)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board,String word,int idx,int i,int j){
        if(idx==word.length()) return true;
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(idx)) return false;
        char temp=board[i][j];
        board[i][j]='#';
        boolean found=dfs(board,word,idx+1,i+1,j)||
                      dfs(board,word,idx+1,i-1,j)||
                      dfs(board,word,idx+1,i,j+1)||
                      dfs(board,word,idx+1,i,j-1);
        board[i][j]=temp;
        return found;
    }

    public static void main(String[] args) {
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println("Word Found? "+exist(board,"ABCCED"));
    }
}
