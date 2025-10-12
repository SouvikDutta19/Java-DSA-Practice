import java.util.*;

// A* Search on a 2D grid using Manhattan distance heuristic
public class day106_a_star {
    static class Node implements Comparable<Node> {
        int r, c;
        int g; // cost from start
        int f; // g + h
        Node parent;
        Node(int r, int c, int g, int f, Node p) { this.r = r; this.c = c; this.g = g; this.f = f; this.parent = p; }
        public int compareTo(Node o) { return Integer.compare(this.f, o.f); }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int heuristic(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    public static List<int[]> aStar(int[][] grid, int[] start, int[] goal) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<Node> open = new PriorityQueue<>();
        boolean[][] closed = new boolean[n][m];
        int[][] gScore = new int[n][m];
        for (int[] row : gScore) Arrays.fill(row, Integer.MAX_VALUE);

        Node startNode = new Node(start[0], start[1], 0, heuristic(start[0], start[1], goal[0], goal[1]), null);
        open.add(startNode);
        gScore[start[0]][start[1]] = 0;

        while (!open.isEmpty()) {
            Node cur = open.poll();
            if (closed[cur.r][cur.c]) continue;
            closed[cur.r][cur.c] = true;

            if (cur.r == goal[0] && cur.c == goal[1]) {
                List<int[]> path = new ArrayList<>();
                while (cur != null) {
                    path.add(new int[]{cur.r, cur.c});
                    cur = cur.parent;
                }
                Collections.reverse(path);
                return path;
            }

            for (int k = 0; k < 4; k++) {
                int nr = cur.r + dr[k], nc = cur.c + dc[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nr][nc] == 1) continue; // obstacle
                int tentativeG = cur.g + 1;
                if (tentativeG < gScore[nr][nc]) {
                    gScore[nr][nc] = tentativeG;
                    int f = tentativeG + heuristic(nr, nc, goal[0], goal[1]);
                    open.add(new Node(nr, nc, tentativeG, f, cur));
                }
            }
        }
        return Collections.emptyList(); // no path
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0,0,0,0,0},
            {1,1,0,1,0},
            {0,0,0,0,0},
            {0,1,1,1,0},
            {0,0,0,0,0}
        };
        int[] start = {0,0}, goal = {4,4};
        List<int[]> path = aStar(grid, start, goal);
        if (path.isEmpty()) System.out.println("No path found");
        else {
            System.out.println("Path:");
            for (int[] p : path) System.out.println(Arrays.toString(p));
        }
    }
}
