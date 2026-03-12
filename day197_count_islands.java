public class day197_count_islands {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void dfs(char[][] grid, int x, int y){

        int m = grid.length;
        int n = grid[0].length;

        if(x<0 || y<0 || x>=m || y>=n || grid[x][y]=='0')
            return;

        grid[x][y] = '0';

        for(int i=0;i<4;i++)
            dfs(grid, x+dx[i], y+dy[i]);
    }

    public static int numIslands(char[][] grid){

        int count = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args){

        char[][] grid = {
                {'1','1','0'},
                {'1','0','0'},
                {'0','1','1'}
        };

        System.out.println(numIslands(grid));
    }
}