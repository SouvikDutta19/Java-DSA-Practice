import java.util.*;

public class Day23_SuffixAutomaton {
    static class State {
        int len, link;
        Map<Character, Integer> next = new HashMap<>();
    }

    List<State> st;
    int size, last;

    public Day23_SuffixAutomaton(String s) {
        int max = 2 * s.length();
        st = new ArrayList<>(max);
        st.add(new State());
        st.get(0).len = 0;
        st.get(0).link = -1;
        size = 1;
        last = 0;

        for (char c : s.toCharArray()) {
            addChar(c);
        }
    }

    void addChar(char c) {
        int curr = size++;
        st.add(new State());
        st.get(curr).len = st.get(last).len + 1;
        int p = last;

        while (p != -1 && !st.get(p).next.containsKey(c)) {
            st.get(p).next.put(c, curr);
            p = st.get(p).link;
        }

        if (p == -1) {
            st.get(curr).link = 0;
        } else {
            int q = st.get(p).next.get(c);
            if (st.get(p).len + 1 == st.get(q).len) {
                st.get(curr).link = q;
            } else {
                int clone = size++;
                st.add(new State());
                st.get(clone).len = st.get(p).len + 1;
                st.get(clone).next.putAll(st.get(q).next);
                st.get(clone).link = st.get(q).link;

                while (p != -1 && st.get(p).next.get(c) == q) {
                    st.get(p).next.put(c, clone);
                    p = st.get(p).link;
                }

                st.get(q).link = st.get(curr).link = clone;
            }
        }

        last = curr;
    }

    public static void main(String[] args) {
        Day23_SuffixAutomaton automaton = new Day23_SuffixAutomaton("abcbc");
        System.out.println("Suffix Automaton built successfully.");
    }
}
