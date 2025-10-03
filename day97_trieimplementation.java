class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
    TrieNode() { isEndOfWord = false; }
}

public class day97_trieimplementation {
    static TrieNode root = new TrieNode();

    static void insert(String key) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (node.children[index] == null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    static boolean search(String key) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    public static void main(String[] args) {
        insert("hello");
        insert("world");
        System.out.println("Search hello: " + search("hello"));
        System.out.println("Search java: " + search("java"));
    }
}
