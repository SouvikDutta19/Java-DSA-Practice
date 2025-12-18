import java.util.*;

public class day169_min_stack {

    static class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek())
                minStack.push(val);
        }

        void pop() {
            if (stack.peek().equals(minStack.peek()))
                minStack.pop();
            stack.pop();
        }

        int top() {
            return stack.peek();
        }

        int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.pop();

        System.out.println("Top: " + ms.top());
        System.out.println("Min: " + ms.getMin());
    }
}