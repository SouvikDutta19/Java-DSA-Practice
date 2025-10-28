// day121_trieprefixsearch.java
import java.util.*;

public class day121_trieprefixsearch {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWordEnd = false;
    }

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray())
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        node.isWordEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return false;
        }
        return node.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        day121_trieprefixsearch trie = new day121_trieprefixsearch();
        trie.insert("apple");
        trie.insert("app");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("appl"));
    }
}
