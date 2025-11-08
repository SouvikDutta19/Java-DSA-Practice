// day132_trieprefixsearch.java
import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord;
}

public class day132_trieprefixsearch {
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.endOfWord = true;
    }

    boolean searchPrefix(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null)
                return false;
            node = node.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        day132_trieprefixsearch trie = new day132_trieprefixsearch();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apply");
        System.out.println(trie.searchPrefix("app"));
        System.out.println(trie.searchPrefix("bat"));
    }
}
