// Backtracking solution for Knight’s Tour problem
public class day109_knight_tour {
    static int N = 8;
    static int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

    static boolean isSafe(int x, int y, int[][] sol) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    static boolean solveKTUtil(int x, int y, int movei, int[][] sol) {
        if (movei == N * N) return true;
        for (int k = 0; k < 8; k++) {
            int nextX = x + xMove[k];
            int nextY = y + yMove[k];
            if (isSafe(nextX, nextY, sol)) {
                sol[nextX][nextY] = movei;
                if (solveKTUtil(nextX, nextY, movei + 1, sol)) return true;
                else sol[nextX][nextY] = -1;
            }
        }
        return false;
    }

    static boolean solveKT() {
        int[][] sol = new int[N][N];
        for (int[] row : sol)
            java.util.Arrays.fill(row, -1);
        sol[0][0] = 0;

        if (!solveKTUtil(0, 0, 1, sol)) {
            System.out.println("Solution does not exist");
            return false;
        } else printSolution(sol);
        return true;
    }

    static void printSolution(int[][] sol) {
        for (int[] row : sol) {
            for (int val : row)
                System.out.printf("%2d ", val);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solveKT();
    }
}
