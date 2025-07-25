import java.util.*;

public class ShortestPathInBinaryMatrix {
    static int[][] directions = {{1,0},{0,1},{1,1},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1}};

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        boolean[][] visited = new boolean[n][n];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (x == n - 1 && y == n - 1) return dist;
            for (int[] d : directions) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n &&
                    grid[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0,1,0},
            {1,0,0},
            {1,1,0}
        };
        System.out.println("Shortest path: " + shortestPathBinaryMatrix(grid));
    }
}
