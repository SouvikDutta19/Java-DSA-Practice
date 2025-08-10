import java.util.*;

public class day41_trie_autocomplete {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    static class Trie {
        TrieNode root = new TrieNode();

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

        void autoComplete(TrieNode node, String prefix, List<String> results) {
            if (node.isEndOfWord) results.add(prefix);
            for (char c = 'a'; c <= 'z'; c++) {
                int idx = c - 'a';
                if (node.children[idx] != null) {
                    autoComplete(node.children[idx], prefix + c, results);
                }
            }
        }

        List<String> getAutoComplete(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) return new ArrayList<>();
                node = node.children[idx];
            }
            List<String> results = new ArrayList<>();
            autoComplete(node, prefix, results);
            return results;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("car");
        trie.insert("cart");
        trie.insert("carbon");
        trie.insert("dog");

        System.out.println(trie.getAutoComplete("car"));
    }
}
