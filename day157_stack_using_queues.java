import java.util.*;

public class day157_stack_using_queues {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int x) {
        q2.add(x);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    int pop() {
        if (q1.isEmpty()) return -1;
        return q1.remove();
    }

    public static void main(String[] args) {
        day157_stack_using_queues s = new day157_stack_using_queues();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Pop: " + s.pop());
    }
}