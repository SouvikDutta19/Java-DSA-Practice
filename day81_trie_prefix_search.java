class TrieNode {
    TrieNode[] children=new TrieNode[26];
    boolean isEnd;
}

public class day81_trie_prefix_search {
    TrieNode root=new TrieNode();

    void insert(String word) {
        TrieNode node=root;
        for(char c:word.toCharArray()) {
            if(node.children[c-'a']==null) node.children[c-'a']=new TrieNode();
            node=node.children[c-'a'];
        }
        node.isEnd=true;
    }

    boolean search(String word) {
        TrieNode node=root;
        for(char c:word.toCharArray()) {
            if(node.children[c-'a']==null) return false;
            node=node.children[c-'a'];
        }
        return node.isEnd;
    }

    boolean startsWith(String prefix) {
        TrieNode node=root;
        for(char c:prefix.toCharArray()) {
            if(node.children[c-'a']==null) return false;
            node=node.children[c-'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        day81_trie_prefix_search trie=new day81_trie_prefix_search();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
    }
}
