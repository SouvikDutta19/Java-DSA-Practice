import java.util.*;

// Trie Implementation for String Storage and Search
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}

public class day104_trie_implementation {
    private TrieNode root;

    public day104_trie_implementation() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null)
                curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null)
                return false;
            curr = curr.children[index];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null)
                return false;
            curr = curr.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        day104_trie_implementation trie = new day104_trie_implementation();
        trie.insert("apple");
        trie.insert("app");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("ap"));
        System.out.println(trie.search("banana"));
    }
}
