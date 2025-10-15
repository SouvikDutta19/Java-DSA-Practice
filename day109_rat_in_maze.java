// Rat in a Maze using Backtracking
public class day109_rat_in_maze {
    static int N;

    boolean solveMaze(int[][] maze) {
        N = maze.length;
        int[][] sol = new int[N][N];
        if (!solveMazeUtil(maze, 0, 0, sol)) {
            System.out.println("No path found");
            return false;
        }
        printSolution(sol);
        return true;
    }

    boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y)) {
            if (sol[x][y] == 1) return false;
            sol[x][y] = 1;
            if (solveMazeUtil(maze, x + 1, y, sol)) return true;
            if (solveMazeUtil(maze, x, y + 1, sol)) return true;
            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    void printSolution(int[][] sol) {
        for (int[] row : sol) {
            for (int v : row)
                System.out.print(v + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
        new day109_rat_in_maze().solveMaze(maze);
    }
}
