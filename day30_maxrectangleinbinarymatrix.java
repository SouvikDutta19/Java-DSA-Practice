import java.util.*;

public class day30_maxrectangleinbinarymatrix {

    public static int maxHist(int[] row) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int i = 0;
        while (i < row.length) {
            if (stack.isEmpty() || row[stack.peek()] <= row[i]) {
                stack.push(i++);
            } else {
                int top = row[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, top * width);
            }
        }
        while (!stack.isEmpty()) {
            int top = row[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(max, top * width);
        }
        return max;
    }

    public static int maxRectangle(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int max = maxHist(matrix[0]);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 1)
                    matrix[i][j] += matrix[i - 1][j];
            max = Math.max(max, maxHist(matrix[i]));
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0}
        };
        System.out.println("Max rectangle area: " + maxRectangle(matrix)); // Output: 8
    }
}
