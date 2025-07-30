// Java implementation of Trie (Prefix Tree)
import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
}

public class day30_trieimplementation {
    static TrieNode root;

    public day30_trieimplementation() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }

    boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null)
                return false;
            node = node.children[idx];
        }
        return node.isEndOfWord;
    }

    public static void main(String[] args) {
        day30_trieimplementation trie = new day30_trieimplementation();
        trie.insert("apple");
        trie.insert("app");
        System.out.println(trie.search("app"));    // true
        System.out.println(trie.search("apple"));  // true
        System.out.println(trie.search("apricot"));// false
    }
}
