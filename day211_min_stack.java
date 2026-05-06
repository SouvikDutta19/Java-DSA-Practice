import java.util.*;

public class day211_min_stack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public day211_min_stack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val){
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
    }

    public void pop(){
        if(stack.pop().equals(minStack.peek()))
            minStack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
}