import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord;
}

public class day50_trie_implementation {
    private final TrieNode root;

    public day50_trie_implementation() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        day50_trie_implementation trie = new day50_trie_implementation();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");

        System.out.println("Search 'apple': " + trie.search("apple"));
        System.out.println("Search 'appl': " + trie.search("appl"));
        System.out.println("Prefix 'app': " + trie.startsWith("app"));
        System.out.println("Prefix 'bat': " + trie.startsWith("bat"));
        System.out.println("Search 'batman': " + trie.search("batman"));
    }
}
