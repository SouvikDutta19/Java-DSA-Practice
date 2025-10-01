import java.util.*;

public class day95_stackimplementation {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public day95_stackimplementation(int size) {
        maxSize = size;
        stackArray = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full!");
        } else {
            stackArray[++top] = value;
            System.out.println(value + " pushed to stack.");
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stackArray[top--];
    }

    public int peek() {
        return (top != -1) ? stackArray[top] : -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public static void main(String[] args) {
        day95_stackimplementation stack = new day95_stackimplementation(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
    }
}
