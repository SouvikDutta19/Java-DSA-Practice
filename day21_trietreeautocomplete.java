import java.util.*;

public class day21_trietreeautocomplete {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.isEndOfWord = true;
        }

        List<String> autocomplete(String prefix) {
            List<String> result = new ArrayList<>();
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (!node.children.containsKey(c))
                    return result;
                node = node.children.get(c);
            }
            dfs(node, prefix, result);
            return result;
        }

        void dfs(TrieNode node, String word, List<String> result) {
            if (node.isEndOfWord) result.add(word);
            for (char c : node.children.keySet()) {
                dfs(node.children.get(c), word + c, result);
            }
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("code");
        trie.insert("coder");
        trie.insert("coding");
        trie.insert("cool");
        trie.insert("comet");

        List<String> matches = trie.autocomplete("co");
        System.out.println("Autocomplete results for 'co': " + matches);
    }
}
