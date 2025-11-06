// day130_trie.java
// Trie (prefix tree) with insert, search, startsWith and delete

import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}

public class day130_trie {
    private final TrieNode root;

    public day130_trie() { root = new TrieNode(); }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children[ch - 'a'];
            if (node == null) return false;
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.children[ch - 'a'];
            if (node == null) return false;
        }
        return true;
    }

    public boolean delete(String word) {
        return deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(TrieNode node, String word, int depth) {
        if (node == null) return false;
        if (depth == word.length()) {
            if (!node.isEnd) return false;
            node.isEnd = false;
            return noChildren(node);
        }
        int idx = word.charAt(depth) - 'a';
        if (deleteHelper(node.children[idx], word, depth + 1)) {
            node.children[idx] = null;
            return !node.isEnd && noChildren(node);
        }
        return false;
    }

    private boolean noChildren(TrieNode node) {
        for (TrieNode child : node.children) if (child != null) return false;
        return true;
    }

    public static void main(String[] args) {
        day130_trie trie = new day130_trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app"));// true
        trie.insert("app");
        System.out.println(trie.search("app"));     // true
        System.out.println("Deleting 'app' -> " + trie.delete("app"));
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.search("apple"));   // true
    }
}
