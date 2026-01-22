class day181_trie_implementation {

    static class Trie {
        Trie[] child = new Trie[26];
        boolean end;
    }

    static Trie root = new Trie();

    static void insert(String word) {
        Trie curr = root;
        for (char c : word.toCharArray()) {
            if (curr.child[c - 'a'] == null)
                curr.child[c - 'a'] = new Trie();
            curr = curr.child[c - 'a'];
        }
        curr.end = true;
    }

    static boolean search(String word) {
        Trie curr = root;
        for (char c : word.toCharArray()) {
            if (curr.child[c - 'a'] == null)
                return false;
            curr = curr.child[c - 'a'];
        }
        return curr.end;
    }

    public static void main(String[] args) {
        insert("apple");
        insert("app");
        System.out.println(search("app"));
    }
}