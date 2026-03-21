import java.util.*;

public class day200_shortest_path_binary_matrix {

    public static int shortestPathBinaryMatrix(int[][] grid){

        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        grid[0][0] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0]==n-1 && cur[1]==n-1)
                return cur[2];

            for(int[] d : dir){
                int x = cur[0]+d[0];
                int y = cur[1]+d[1];

                if(x>=0 && y>=0 && x<n && y<n && grid[x][y]==0){
                    q.add(new int[]{x,y,cur[2]+1});
                    grid[x][y]=1;
                }
            }
        }

        return -1;
    }
}