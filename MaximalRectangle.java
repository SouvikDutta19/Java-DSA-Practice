import java.util.*;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int max = 0;
        int[] height = new int[matrix[0].length];
        for(char[] row : matrix) {
            for(int j = 0; j < row.length; j++) {
                height[j] = row[j] == '1' ? height[j] + 1 : 0;
            }
            max = Math.max(max, largestRectangleArea(height));
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int i = 0;
        while(i < heights.length) {
            if(stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
        }
        while(!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(max, h * w);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximalRectangle obj = new MaximalRectangle();
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        System.out.println("Maximal Rectangle: " + obj.maximalRectangle(matrix));
    }
}
