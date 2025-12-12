// Day162 - Trie with insert, search, startsWith and delete
import java.util.*;

public class day162_trie_with_prefix_and_delete {
    static class Node {
        Node[] next = new Node[26];
        boolean end = false;
    }

    Node root = new Node();

    public void insert(String s) {
        Node cur = root;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (cur.next[i] == null) cur.next[i] = new Node();
            cur = cur.next[i];
        }
        cur.end = true;
    }

    public boolean search(String s) {
        Node cur = root;
        for (char c : s.toCharArray()) {
            cur = cur.next[c - 'a'];
            if (cur == null) return false;
        }
        return cur.end;
    }

    public boolean startsWith(String p) {
        Node cur = root;
        for (char c : p.toCharArray()) {
            cur = cur.next[c - 'a'];
            if (cur == null) return false;
        }
        return true;
    }

    public boolean delete(String s) {
        return delete(root, s, 0);
    }

    private boolean delete(Node node, String s, int idx) {
        if (node == null) return false;
        if (idx == s.length()) {
            if (!node.end) return false;
            node.end = false;
            return isEmpty(node);
        }
        int i = s.charAt(idx) - 'a';
        if (delete(node.next[i], s, idx+1)) {
            node.next[i] = null;
            return !node.end && isEmpty(node);
        }
        return false;
    }

    private boolean isEmpty(Node node) {
        for (Node n : node.next) if (n != null) return false;
        return true;
    }

    public static void main(String[] args) {
        day162_trie_with_prefix_and_delete trie = new day162_trie_with_prefix_and_delete();
        trie.insert("apple");
        trie.insert("app");
        System.out.println("search apple: " + trie.search("apple")); // true
        System.out.println("startsWith ap: " + trie.startsWith("ap")); // true
        trie.delete("apple");
        System.out.println("search apple after delete: " + trie.search("apple")); // false
        System.out.println("search app: " + trie.search("app")); // true
    }
}