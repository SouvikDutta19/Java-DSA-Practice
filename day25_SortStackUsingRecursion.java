import java.util.Stack;

public class day25_SortStackUsingRecursion {

    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack);
            insertSorted(stack, top);
        }
    }

    private static void insertSorted(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || value > stack.peek()) {
            stack.push(value);
            return;
        }

        int temp = stack.pop();
        insertSorted(stack, value);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
