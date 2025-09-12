import java.util.*;

class TrieNode{
    TrieNode[] children=new TrieNode[26];
    boolean isEnd;
}

public class day73_trie_implementation {
    static TrieNode root=new TrieNode();

    static void insert(String word){
        TrieNode node=root;
        for(char c:word.toCharArray()){
            int idx=c-'a';
            if(node.children[idx]==null) node.children[idx]=new TrieNode();
            node=node.children[idx];
        }
        node.isEnd=true;
    }

    static boolean search(String word){
        TrieNode node=root;
        for(char c:word.toCharArray()){
            int idx=c-'a';
            if(node.children[idx]==null) return false;
            node=node.children[idx];
        }
        return node.isEnd;
    }

    public static void main(String[] args){
        insert("apple");
        insert("app");
        System.out.println(search("app"));
        System.out.println(search("appl"));
    }
}
