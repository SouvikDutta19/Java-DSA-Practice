import java.util.*;

class Node{
    Node[] children=new Node[26];
    boolean isEnd;
}

public class day73_trie_autocomplete {
    static Node root=new Node();

    static void insert(String word){
        Node node=root;
        for(char c:word.toCharArray()){
            int idx=c-'a';
            if(node.children[idx]==null) node.children[idx]=new Node();
            node=node.children[idx];
        }
        node.isEnd=true;
    }

    static void dfs(Node node,String prefix,List<String> result){
        if(node.isEnd) result.add(prefix);
        for(int i=0;i<26;i++){
            if(node.children[i]!=null){
                dfs(node.children[i],prefix+(char)(i+'a'),result);
            }
        }
    }

    static List<String> autocomplete(String prefix){
        Node node=root;
        for(char c:prefix.toCharArray()){
            int idx=c-'a';
            if(node.children[idx]==null) return new ArrayList<>();
            node=node.children[idx];
        }
        List<String> result=new ArrayList<>();
        dfs(node,prefix,result);
        return result;
    }

    public static void main(String[] args){
        insert("apple"); insert("app"); insert("apply"); insert("apt");
        System.out.println(autocomplete("app"));
    }
}
