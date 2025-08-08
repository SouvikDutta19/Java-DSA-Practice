// Count Number of Distinct Islands using DFS and HashSet

import java.util.*;

public class day39_numberofdistinctislands {
    static int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public static int numDistinctIslands(int[][] grid) {
        Set<String> uniqueIslands = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    List<String> shape = new ArrayList<>();
                    dfs(grid, visited, r, c, r, c, shape);
                    uniqueIslands.add(String.join(",", shape));
                }
            }
        }
        return uniqueIslands.size();
    }

    private static void dfs(int[][] grid, boolean[][] visited, int r, int c, int baseR, int baseC, List<String> shape) {
        visited[r][c] = true;
        shape.add((r - baseR) + ":" + (c - baseC));

        for (int[] d : directions) {
            int newR = r + d[0], newC = c + d[1];
            if (newR >= 0 && newC >= 0 && newR < grid.length && newC < grid[0].length &&
                grid[newR][newC] == 1 && !visited[newR][newC]) {
                dfs(grid, visited, newR, newC, baseR, baseC, shape);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,0,1,1},
            {0,0,0,1,1}
        };
        System.out.println("Number of distinct islands: " + numDistinctIslands(grid));
    }
}
