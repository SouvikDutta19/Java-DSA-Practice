import java.util.*;

public class day87_chess_knight_moves {
    static int minSteps(int n, int[] start, int[] end) {
        int[][] dirs = {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) return cur[2];
            for (int[] d : dirs) {
                int nx = cur[0] + d[0], ny = cur[1] + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 8;
        int[] start = {0, 0}, end = {7, 7};
        System.out.println(minSteps(n, start, end));
    }
}
