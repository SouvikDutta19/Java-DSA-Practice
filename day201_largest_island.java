import java.util.*;

public class day201_largest_island {

    static int n;
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public static int largestIsland(int[][] grid){

        n = grid.length;
        Map<Integer,Integer> map = new HashMap<>();
        int id = 2;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    int size = dfs(grid,i,j,id);
                    map.put(id,size);
                    id++;
                }
            }
        }

        int max = 0;

        for(int val : map.values())
            max = Math.max(max,val);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j] == 0){

                    Set<Integer> seen = new HashSet<>();
                    int size = 1;

                    for(int[] d : dirs){
                        int x=i+d[0], y=j+d[1];

                        if(x>=0 && y>=0 && x<n && y<n && grid[x][y] > 1){
                            int idx = grid[x][y];
                            if(!seen.contains(idx)){
                                size += map.get(idx);
                                seen.add(idx);
                            }
                        }
                    }

                    max = Math.max(max,size);
                }
            }
        }

        return max == 0 ? n*n : max;
    }

    static int dfs(int[][] grid,int i,int j,int id){

        if(i<0 || j<0 || i>=n || j>=n || grid[i][j]!=1)
            return 0;

        grid[i][j] = id;
        int size = 1;

        for(int[] d : dirs)
            size += dfs(grid,i+d[0],j+d[1],id);

        return size;
    }
}