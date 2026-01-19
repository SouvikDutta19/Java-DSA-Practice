import java.util.*;

public class day180_min_stack {

    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();

    static void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }

    static void pop() {
        if (stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }

    static int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        push(5); push(2); push(10);
        System.out.println(getMin());
        pop();
        System.out.println(getMin());
    }
}