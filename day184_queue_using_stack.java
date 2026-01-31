import java.util.*;

public class day184_queue_using_stack {

    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    static void enqueue(int x) {
        s1.push(x);
    }

    static int dequeue() {
        if (s2.isEmpty())
            while (!s1.isEmpty())
                s2.push(s1.pop());
        return s2.pop();
    }

    public static void main(String[] args) {
        enqueue(1);
        enqueue(2);
        enqueue(3);
        System.out.println(dequeue());
    }
}