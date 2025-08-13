class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++)
            children[i] = null;
    }
}

public class day44_trie_implementation {
    static TrieNode root;

    static void insert(String key) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    static boolean search(String key) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return node != null && node.isEndOfWord;
    }

    public static void main(String[] args) {
        root = new TrieNode();
        String words[] = {"hello", "world", "trie", "java"};
        for (String w : words)
            insert(w);

        System.out.println(search("world"));
        System.out.println(search("javac"));
    }
}
