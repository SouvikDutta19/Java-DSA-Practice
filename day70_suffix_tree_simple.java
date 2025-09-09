import java.util.*;

class Node {
    Map<Character, Node> children = new HashMap<>();
}

public class day70_suffix_tree_simple {
    Node root = new Node();

    void insertSuffix(String s) {
        for (int i = 0; i < s.length(); i++) {
            Node cur = root;
            for (int j = i; j < s.length(); j++) {
                cur.children.putIfAbsent(s.charAt(j), new Node());
                cur = cur.children.get(s.charAt(j));
            }
        }
    }

    public static void main(String[] args) {
        day70_suffix_tree_simple st = new day70_suffix_tree_simple();
        st.insertSuffix("banana$");
        System.out.println("Suffix tree built for banana$");
    }
}
