public class day125_knight_tour {

    static int N = 8;

    static boolean isSafe(int x, int y, int[][] sol) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    static boolean solveKnightTour() {
        int[][] sol = new int[N][N];
        for (int[] row : sol) java.util.Arrays.fill(row, -1);

        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        sol[0][0] = 0;
        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else {
            printSolution(sol);
        }
        return true;
    }

    static boolean solveKTUtil(int x, int y, int movei, int[][] sol, int[] xMove, int[] yMove) {
        if (movei == N * N)
            return true;

        for (int k = 0; k < 8; k++) {
            int nextX = x + xMove[k];
            int nextY = y + yMove[k];
            if (isSafe(nextX, nextY, sol)) {
                sol[nextX][nextY] = movei;
                if (solveKTUtil(nextX, nextY, movei + 1, sol, xMove, yMove))
                    return true;
                else
                    sol[nextX][nextY] = -1;
            }
        }
        return false;
    }

    static void printSolution(int[][] sol) {
        for (int[] row : sol) {
            for (int val : row)
                System.out.printf("%2d ", val);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solveKnightTour();
    }
}
