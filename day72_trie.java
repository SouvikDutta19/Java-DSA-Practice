class TrieNode {
    TrieNode[] children=new TrieNode[26];
    boolean end;
}

public class day72_trie {
    static TrieNode root=new TrieNode();

    static void insert(String word){
        TrieNode node=root;
        for(char c:word.toCharArray()){
            int idx=c-'a';
            if(node.children[idx]==null) node.children[idx]=new TrieNode();
            node=node.children[idx];
        }
        node.end=true;
    }
    static boolean search(String word){
        TrieNode node=root;
        for(char c:word.toCharArray()){
            int idx=c-'a';
            if(node.children[idx]==null) return false;
            node=node.children[idx];
        }
        return node.end;
    }

    public static void main(String[] args){
        insert("hello"); insert("world");
        System.out.println(search("hello"));
        System.out.println(search("java"));
    }
}
