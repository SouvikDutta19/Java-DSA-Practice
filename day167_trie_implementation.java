class TrieNode167 {
    TrieNode167[] children = new TrieNode167[26];
    boolean isEnd;
}

public class day167_trie_implementation {

    static TrieNode167 root = new TrieNode167();

    static void insert(String word) {
        TrieNode167 curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null)
                curr.children[idx] = new TrieNode167();
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    static boolean search(String word) {
        TrieNode167 curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return curr.isEnd;
    }

    public static void main(String[] args) {
        insert("apple");
        insert("app");

        System.out.println(search("apple"));
        System.out.println(search("app"));
        System.out.println(search("ap"));
    }
}