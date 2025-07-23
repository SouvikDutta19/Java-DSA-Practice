import java.util.*;

public class Day23_TrieAutocomplete {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.children.computeIfAbsent(c, k -> new TrieNode());
        }
        curr.isEndOfWord = true;
    }

    public List<String> autoComplete(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) return result;
            curr = curr.children.get(c);
        }
        dfs(curr, prefix, result);
        return result;
    }

    private void dfs(TrieNode node, String word, List<String> result) {
        if (node.isEndOfWord) result.add(word);
        for (char c : node.children.keySet()) {
            dfs(node.children.get(c), word + c, result);
        }
    }

    public static void main(String[] args) {
        Day23_TrieAutocomplete trie = new Day23_TrieAutocomplete();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("ape");
        trie.insert("bat");

        System.out.println("Autocomplete for 'ap': " + trie.autoComplete("ap"));
    }
}
