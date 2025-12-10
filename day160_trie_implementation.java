class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null)
                cur.children[idx] = new TrieNode();
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null)
                return false;
            cur = cur.children[idx];
        }
        return cur.isEnd;
    }

    boolean delete(TrieNode node, String word, int depth) {
        if (node == null) return false;

        if (depth == word.length()) {
            if (!node.isEnd) return false;
            node.isEnd = false;
            return isEmpty(node);
        }

        int idx = word.charAt(depth) - 'a';
        if (delete(node.children[idx], word, depth + 1)) {
            node.children[idx] = null;
            return !node.isEnd && isEmpty(node);
        }

        return false;
    }

    boolean isEmpty(TrieNode node) {
        for (TrieNode n : node.children)
            if (n != null) return false;
        return true;
    }
}

public class day160_trie_implementation {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");

        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));

        trie.delete(trie.root, "apple", 0);
        System.out.println(trie.search("apple"));
    }
}