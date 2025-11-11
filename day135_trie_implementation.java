// day135_trie_implementation.java
// Trie with insert, search, startsWith

import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}

public class day135_trie_implementation {
    private TrieNode root;

    public day135_trie_implementation() { root = new TrieNode(); }

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

    public static void main(String[] args) {
        day135_trie_implementation trie = new day135_trie_implementation();
        trie.insert("apple");
        trie.insert("app");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // true
        System.out.println(trie.startsWith("ap"));  // true
        System.out.println(trie.search("apply"));   // false
    }
}
