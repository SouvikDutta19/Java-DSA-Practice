class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
}

public class day103_trieimplementation {
    TrieNode root = new TrieNode();

    public void insert(String key) {
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String key) {
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    public static void main(String[] args) {
        day103_trieimplementation trie = new day103_trieimplementation();
        trie.insert("apple");
        trie.insert("app");
        System.out.println("Search apple: " + trie.search("apple"));
        System.out.println("Search app: " + trie.search("app"));
        System.out.println("Search apply: " + trie.search("apply"));
    }
}
