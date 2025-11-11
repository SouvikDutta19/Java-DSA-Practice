import java.util.*;

public class day135_rat_in_a_maze_backtracking {
    static int N = 4;
    static int[][] sol = new int[N][N];

    static boolean isSafe(int[][] maze, int x, int y) {
        return x < N && y < N && maze[x][y] == 1;
    }

    static boolean solveMaze(int[][] maze, int x, int y) {
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y)) {
            sol[x][y] = 1;
            if (solveMaze(maze, x + 1, y)) return true;
            if (solveMaze(maze, x, y + 1)) return true;
            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        if (solveMaze(maze, 0, 0)) {
            for (int[] r : sol)
                System.out.println(Arrays.toString(r));
        } else System.out.println("No path found");
    }
}
