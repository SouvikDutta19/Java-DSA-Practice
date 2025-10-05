class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}

public class day99_trieimplementation {
    private TrieNode root;

    public day99_trieimplementation() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        day99_trieimplementation trie = new day99_trieimplementation();
        trie.insert("apple");
        trie.insert("app");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("ap"));
    }
}
