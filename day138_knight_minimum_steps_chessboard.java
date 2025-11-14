// day138_knight_minimum_steps_chessboard.java
import java.util.*;

public class day138_knight_minimum_steps_chessboard {
    static int[][] moves = {
        {2,1},{1,2},{-1,2},{-2,1},
        {-2,-1},{-1,-2},{1,-2},{2,-1}
    };

    public static int minSteps(int N, int sx, int sy, int tx, int ty) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (x == tx && y == ty) return dist;

            for (int[] mv : moves) {
                int nx = x + mv[0];
                int ny = y + mv[1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Minimum knight moves: " + minSteps(8, 0, 0, 7, 7));
    }
}
