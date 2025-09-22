import java.util.*;

class SuffixTrieNode {
    Map<Character, SuffixTrieNode> children = new HashMap<>();
}

public class day87_suffix_trie {
    private SuffixTrieNode root;

    public day87_suffix_trie(String text) {
        root = new SuffixTrieNode();
        for (int i = 0; i < text.length(); i++) {
            insertSuffix(text.substring(i));
        }
    }

    private void insertSuffix(String s) {
        SuffixTrieNode node = root;
        for (char c : s.toCharArray()) {
            node.children.putIfAbsent(c, new SuffixTrieNode());
            node = node.children.get(c);
        }
    }

    public boolean search(String pattern) {
        SuffixTrieNode node = root;
        for (char c : pattern.toCharArray()) {
            if (!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        day87_suffix_trie trie = new day87_suffix_trie("banana");
        System.out.println(trie.search("ana")); 
        System.out.println(trie.search("apple")); 
    }
}
