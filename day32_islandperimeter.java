public class day32_islandperimeter {
    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1) {
                    perimeter += 4;

                    if (i > 0 && grid[i - 1][j] == 1) perimeter--;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) perimeter--;
                    if (j > 0 && grid[i][j - 1] == 1) perimeter--;
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) perimeter--;
                }

        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
        };

        System.out.println("Island Perimeter: " + islandPerimeter(grid)); // Output: 16
    }
}
