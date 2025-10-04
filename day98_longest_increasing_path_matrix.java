public class day98_longest_increasing_path_matrix {
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];
        int max = 1;
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x>=0 && y>=0 && x<matrix.length && y<matrix[0].length && matrix[x][y]>matrix[i][j]) {
                max = Math.max(max, 1 + dfs(matrix,x,y,memo));
            }
        }
        memo[i][j] = max;
        return max;
    }
    public static int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length,res=0;
        int[][] memo=new int[m][n];
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) res=Math.max(res,dfs(matrix,i,j,memo));
        return res;
    }
    public static void main(String[] args) {
        int[][] matrix={{9,9,4},{6,6,8},{2,1,1}};
        System.out.println("Longest Path: "+longestIncreasingPath(matrix));
    }
}
