import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

public class day49_trie_prefix_suffix {
    private TrieNode root;

    public day49_trie_prefix_suffix() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return curr.isEndOfWord;
    }

    public static void main(String[] args) {
        day49_trie_prefix_suffix trie = new day49_trie_prefix_suffix();
        trie.insert("apple");
        trie.insert("app");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("ap"));
        System.out.println(trie.search("bat"));
    }
}
