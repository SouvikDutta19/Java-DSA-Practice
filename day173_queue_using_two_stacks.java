import java.util.*;

public class day173_queue_using_two_stacks {

    static class MyQueue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        void push(int x) {
            s1.push(x);
        }

        int pop() {
            if(s2.isEmpty())
                while(!s1.isEmpty())
                    s2.push(s1.pop());
            return s2.pop();
        }

        int peek() {
            if(s2.isEmpty())
                while(!s1.isEmpty())
                    s2.push(s1.pop());
            return s2.peek();
        }

        boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(10);
        q.push(20);
        q.push(30);
        System.out.println(q.pop());
    }
}