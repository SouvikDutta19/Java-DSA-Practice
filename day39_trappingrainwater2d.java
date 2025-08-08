// Trapping Rain Water II using Priority Queue (2D grid)

import java.util.*;

public class day39_trappingrainwater2d {
    public static int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m < 3 || n < 3) return 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = visited[m - 1][j] = true;
        }

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int water = 0;

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0], c = cell[1] + d[1];
                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
                    visited[r][c] = true;
                    water += Math.max(0, cell[2] - heightMap[r][c]);
                    pq.offer(new int[]{r, c, Math.max(cell[2], heightMap[r][c])});
                }
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[][] heightMap = {
            {1,4,3,1,3,2},
            {3,2,1,3,2,4},
            {2,3,3,2,3,1}
        };
        System.out.println("Trapped rainwater: " + trapRainWater(heightMap));
    }
}
