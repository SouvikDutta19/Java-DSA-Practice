// day121_ratmazeallpaths.java
import java.util.*;

public class day121_ratmazeallpaths {
    static List<String> res;

    public static List<String> findPath(int[][] m, int n) {
        res = new ArrayList<>();
        if (m[0][0] == 0 || m[n - 1][n - 1] == 0) return res;
        boolean[][] visited = new boolean[n][n];
        solve(m, 0, 0, n, "", visited);
        return res;
    }

    private static void solve(int[][] m, int x, int y, int n, String path, boolean[][] visited) {
        if (x == n - 1 && y == n - 1) {
            res.add(path);
            return;
        }

        visited[x][y] = true;

        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        char[] move = {'D', 'L', 'R', 'U'};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && m[nx][ny] == 1 && !visited[nx][ny])
                solve(m, nx, ny, n, path + move[i], visited);
        }

        visited[x][y] = false;
    }

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        System.out.println(findPath(maze, 4));
    }
}
