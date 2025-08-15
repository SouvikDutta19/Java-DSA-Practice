import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

public class day46_trieimplementation {
    private TrieNode root;

    public day46_trieimplementation() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.get(ch);
            if (current == null) {
                return false;
            }
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            current = current.children.get(ch);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        day46_trieimplementation trie = new day46_trieimplementation();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");

        System.out.println("Search apple: " + trie.search("apple"));
        System.out.println("Search app: " + trie.search("app"));
        System.out.println("StartsWith ap: " + trie.startsWith("ap"));
        System.out.println("StartsWith bat: " + trie.startsWith("bat"));
        System.out.println("Search bad: " + trie.search("bad"));
    }
}
