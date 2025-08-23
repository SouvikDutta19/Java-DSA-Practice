import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

class TrieAutoComplete {
    private TrieNode root;

    public TrieAutoComplete() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.children.computeIfAbsent(c, k -> new TrieNode());
        }
        current.isWord = true;
    }

    public List<String> autocomplete(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) return new ArrayList<>();
            node = node.children.get(c);
        }
        List<String> results = new ArrayList<>();
        dfs(node, new StringBuilder(prefix), results);
        return results;
    }

    private void dfs(TrieNode node, StringBuilder prefix, List<String> results) {
        if (node.isWord) {
            results.add(prefix.toString());
        }
        for (char c : node.children.keySet()) {
            prefix.append(c);
            dfs(node.children.get(c), prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        TrieAutoComplete trie = new TrieAutoComplete();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("apply");
        trie.insert("apt");
        trie.insert("bat");

        System.out.println("Autocomplete for 'ap': " + trie.autocomplete("ap"));
    }
}
