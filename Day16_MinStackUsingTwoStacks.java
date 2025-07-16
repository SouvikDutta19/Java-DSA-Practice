import java.util.Stack;

public class Day16_MinStackUsingTwoStacks {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
    }

    public void pop() {
        if (mainStack.pop().equals(minStack.peek()))
            minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Day16_MinStackUsingTwoStacks stack = new Day16_MinStackUsingTwoStacks();
        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.push(1);
        stack.pop();

        System.out.println("Top: " + stack.top());
        System.out.println("Minimum: " + stack.getMin());
    }
}
