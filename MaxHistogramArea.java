import java.util.Stack;

public class MaxHistogramArea {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0, i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()])
                stack.push(i++);
            else {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, heights[top] * width);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(max, heights[top] * width);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] hist = {2, 1, 5, 6, 2, 3};
        System.out.println("Max Area: " + largestRectangleArea(hist));
    }
}
