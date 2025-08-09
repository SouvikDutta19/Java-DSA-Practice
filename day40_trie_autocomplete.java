import java.util.*;

public class day40_trie_autocomplete {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            }
            node.isWord = true;
        }

        List<String> autocomplete(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                node = node.children.get(c);
                if (node == null) return new ArrayList<>();
            }
            List<String> results = new ArrayList<>();
            dfs(node, new StringBuilder(prefix), results);
            return results;
        }

        void dfs(TrieNode node, StringBuilder prefix, List<String> results) {
            if (node.isWord) results.add(prefix.toString());
            for (char c : node.children.keySet()) {
                dfs(node.children.get(c), prefix.append(c), results);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("apt");
        System.out.println(trie.autocomplete("ap"));
    }
}
