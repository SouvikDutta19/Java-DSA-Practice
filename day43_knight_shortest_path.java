import java.util.*;

public class day43_knight_shortest_path {
    static class Cell {
        int x, y, dist;
        Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static boolean isInside(int x, int y, int N) {
        return (x >= 1 && x <= N && y >= 1 && y <= N);
    }

    public static int minStepToReachTarget(int knightPos[], int targetPos[], int N) {
        int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
        int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

        boolean[][] visited = new boolean[N+1][N+1];
        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(knightPos[0], knightPos[1], 0));
        visited[knightPos[0]][knightPos[1]] = true;

        while (!q.isEmpty()) {
            Cell t = q.poll();
            if (t.x == targetPos[0] && t.y == targetPos[1])
                return t.dist;

            for (int i = 0; i < 8; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];

                if (isInside(x, y, N) && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new Cell(x, y, t.dist + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int N = 8;
        int knightPos[] = {1, 1};
        int targetPos[] = {8, 8};
        System.out.println("Minimum steps: " + minStepToReachTarget(knightPos, targetPos, N));
    }
}
