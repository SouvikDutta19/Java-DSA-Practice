import java.util.*;

public class day151_sortstack {

    public static void insertSorted(Stack<Integer> st, int val) {
        if (st.isEmpty() || st.peek() <= val) {
            st.push(val);
            return;
        }

        int top = st.pop();
        insertSorted(st, val);
        st.push(top);
    }

    public static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) return;

        int top = st.pop();
        sortStack(st);
        insertSorted(st, top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(30);
        st.push(5);
        st.push(18);
        st.push(14);
        st.push(3);

        System.out.println("Original stack: " + st);
        sortStack(st);
        System.out.println("Sorted stack: " + st);
    }
}
