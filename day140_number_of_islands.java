// day140_number_of_islands.java

import java.util.*;

public class day140_number_of_islands {

    static int rows, cols;
    static char[][] grid;

    public static int numIslands(char[][] g) {
        grid = g;
        rows = g.length;
        cols = g[0].length;

        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int r, int c) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0')
            return;

        grid[r][c] = '0';

        dfs(r + 1, c);
        dfs(r - 1, c);
        dfs(r, c + 1);
        dfs(r, c - 1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0'},
                {'1','0','0','1'},
                {'0','0','1','1'}
        };

        System.out.println(numIslands(grid));
    }
}
