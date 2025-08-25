import java.util.*;

public class day56_maximal_rectangle {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxArea = 0;
        int[] heights = new int[matrix[0].length];
        
        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == '1') heights[i]++;
                else heights[i] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    
    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int[] extended = Arrays.copyOf(heights, heights.length + 1);
        
        for (int i = 0; i < extended.length; i++) {
            while (!stack.isEmpty() && extended[i] < extended[stack.peek()]) {
                int height = extended[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        System.out.println("Maximal Rectangle Area: " + maximalRectangle(matrix));
    }
}
