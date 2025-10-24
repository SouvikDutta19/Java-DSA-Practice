import java.util.*;
// Aho-Corasick finite automaton for multiple pattern matching
public class day117_aho_corasick {
    static class Node {
        Node[] next = new Node[26];
        Node link = null;
        List<Integer> out = new ArrayList<>();
    }

    Node root = new Node();

    void add(String pat, int id) {
        Node cur = root;
        for (char ch : pat.toCharArray()) {
            int c = ch - 'a';
            if (cur.next[c] == null) cur.next[c] = new Node();
            cur = cur.next[c];
        }
        cur.out.add(id);
    }

    void build() {
        Queue<Node> q = new LinkedList<>();
        root.link = root;
        for (int c = 0; c < 26; c++) {
            if (root.next[c] != null) {
                root.next[c].link = root;
                q.add(root.next[c]);
            } else {
                root.next[c] = root;
            }
        }
        while (!q.isEmpty()) {
            Node v = q.poll();
            for (int c = 0; c < 26; c++) {
                Node u = v.next[c];
                if (u != null) {
                    u.link = v.link.next[c];
                    u.out.addAll(u.link.out);
                    q.add(u);
                } else {
                    v.next[c] = v.link.next[c];
                }
            }
        }
    }

    Map<Integer, List<Integer>> search(String text) {
        Map<Integer, List<Integer>> res = new HashMap<>();
        Node cur = root;
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i) - 'a';
            cur = cur.next[c];
            for (int id : cur.out) {
                res.computeIfAbsent(id, k -> new ArrayList<>()).add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        day117_aho_corasick ac = new day117_aho_corasick();
        String[] pats = {"he", "she", "his", "hers"};
        for (int i = 0; i < pats.length; i++) ac.add(pats[i], i);
        ac.build();
        String text = "ushers";
        Map<Integer, List<Integer>> found = ac.search(text);
        for (int id : found.keySet()) {
            System.out.println("Pattern \"" + pats[id] + "\" occurrences at ending positions: " + found.get(id));
        }
    }
}
