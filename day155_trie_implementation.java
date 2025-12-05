class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}

public class day155_trie_implementation {

    private TrieNode root;

    day155_trie_implementation() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }

        node.isEnd = true;
    }

    boolean search(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null)
                return false;
            node = node.children[index];
        }

        return node.isEnd;
    }

    public static void main(String[] args) {
        day155_trie_implementation trie = new day155_trie_implementation();
        trie.insert("souvik");
        trie.insert("data");

        System.out.println("Search souvik: " + trie.search("souvik"));
        System.out.println("Search dat: " + trie.search("dat"));
    }
}