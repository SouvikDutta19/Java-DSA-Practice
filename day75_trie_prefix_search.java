class TrieNode {
    TrieNode[] children=new TrieNode[26];
    boolean isEndOfWord;
}

public class day75_trie_prefix_search {
    TrieNode root=new TrieNode();

    void insert(String key){
        TrieNode node=root;
        for(char c:key.toCharArray()){
            if(node.children[c-'a']==null)
                node.children[c-'a']=new TrieNode();
            node=node.children[c-'a'];
        }
        node.isEndOfWord=true;
    }

    boolean search(String key){
        TrieNode node=root;
        for(char c:key.toCharArray()){
            if(node.children[c-'a']==null) return false;
            node=node.children[c-'a'];
        }
        return node.isEndOfWord;
    }

    boolean startsWith(String prefix){
        TrieNode node=root;
        for(char c:prefix.toCharArray()){
            if(node.children[c-'a']==null) return false;
            node=node.children[c-'a'];
        }
        return true;
    }

    public static void main(String[] args){
        day75_trie_prefix_search trie=new day75_trie_prefix_search();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
    }
}
