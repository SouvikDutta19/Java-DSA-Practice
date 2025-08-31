import java.util.*;

public class day62_knight_shortest_path {
    static class Cell {
        int x, y, dist;
        Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int minStepsToReachTarget(int[] knightPos, int[] targetPos, int N) {
        int[] dx = {2,2,1,1,-1,-1,-2,-2};
        int[] dy = {1,-1,2,-2,2,-2,1,-1};

        boolean[][] visited = new boolean[N+1][N+1];
        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(knightPos[0], knightPos[1], 0));
        visited[knightPos[0]][knightPos[1]] = true;

        while (!q.isEmpty()) {
            Cell t = q.poll();
            if (t.x == targetPos[0] && t.y == targetPos[1]) return t.dist;

            for (int i = 0; i < 8; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];
                if (x >= 1 && y >= 1 && x <= N && y <= N && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new Cell(x, y, t.dist + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] knightPos = {1, 1};
        int[] targetPos = {8, 8};
        int N = 8;
        System.out.println("Minimum steps: " +
            minStepsToReachTarget(knightPos, targetPos, N));
    }
}
