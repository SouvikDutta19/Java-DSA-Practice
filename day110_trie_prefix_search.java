// Program to implement Trie Data Structure with prefix search functionality

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord;
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c))
                return false;
            current = current.children.get(c);
        }
        return current.isEndOfWord;
    }

    public List<String> startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c))
                return new ArrayList<>();
            current = current.children.get(c);
        }

        List<String> results = new ArrayList<>();
        collectWords(current, prefix, results);
        return results;
    }

    private void collectWords(TrieNode node, String prefix, List<String> results) {
        if (node.isEndOfWord) results.add(prefix);
        for (char c : node.children.keySet())
            collectWords(node.children.get(c), prefix + c, results);
    }
}

public class day110_trie_prefix_search {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("apply");
        trie.insert("apt");

        System.out.println("Search 'app': " + trie.search("app"));
        System.out.println("Words starting with 'ap': " + trie.startsWith("ap"));
    }
}
