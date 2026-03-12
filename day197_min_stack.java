import java.util.Stack;

class day197_min_stack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);

        if(minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        if(stack.pop().equals(minStack.peek()))
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args){

        day197_min_stack obj = new day197_min_stack();

        obj.push(3);
        obj.push(5);
        obj.push(2);

        System.out.println(obj.getMin());
    }
}