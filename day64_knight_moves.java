import java.util.*;

public class day64_knight_moves {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    static class Cell {
        int x, y, dist;
        Cell(int x, int y, int dist) {
            this.x = x; this.y = y; this.dist = dist;
        }
    }

    public static int minKnightMoves(int n, int startX, int startY, int endX, int endY) {
        boolean[][] visited = new boolean[n][n];
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            if (curr.x == endX && curr.y == endY) return curr.dist;

            for (int i = 0; i < 8; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Cell(nx, ny, curr.dist + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 8;
        int startX = 0, startY = 0;
        int endX = 7, endY = 7;
        System.out.println("Minimum Knight Moves: " + minKnightMoves(n, startX, startY, endX, endY));
    }
}
