import java.util.*;

public class day145_trie_prefix_search {

    static class Node {
        Node[] child = new Node[26];
        boolean end;
    }

    static class Trie {
        Node root = new Node();

        void insert(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (curr.child[idx] == null) curr.child[idx] = new Node();
                curr = curr.child[idx];
            }
            curr.end = true;
        }

        boolean startsWith(String prefix) {
            Node curr = root;
            for (char c : prefix.toCharArray()) {
                int idx = c - 'a';
                if (curr.child[idx] == null) return false;
                curr = curr.child[idx];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        t.insert("app");

        System.out.println(t.startsWith("ap"));
        System.out.println(t.startsWith("ba"));
    }
}
