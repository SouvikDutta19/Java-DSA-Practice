import java.util.Stack;

class MinStack {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    int pop() {
        int val = mainStack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
        return val;
    }

    int getMin() {
        return minStack.peek();
    }
}

public class day160_min_stack {
    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(2);

        System.out.println("Min: " + stack.getMin());
        stack.pop();
        System.out.println("Min after pop: " + stack.getMin());
    }
}