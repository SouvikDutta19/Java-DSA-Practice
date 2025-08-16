import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord;
}

public class day47_trie_with_autocomplete {
    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.isEndOfWord = true;
    }

    private void dfs(TrieNode node, String prefix, List<String> results) {
        if (node.isEndOfWord) results.add(prefix);
        for (char c : node.children.keySet()) {
            dfs(node.children.get(c), prefix + c, results);
        }
    }

    public List<String> autoComplete(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) return new ArrayList<>();
            node = node.children.get(c);
        }
        List<String> results = new ArrayList<>();
        dfs(node, prefix, results);
        return results;
    }

    public static void main(String[] args) {
        day47_trie_with_autocomplete trie = new day47_trie_with_autocomplete();
        trie.insert("cat");
        trie.insert("car");
        trie.insert("cart");
        trie.insert("dog");
        trie.insert("dove");

        System.out.println("Autocomplete for 'ca': " + trie.autoComplete("ca"));
    }
}
