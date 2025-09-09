import java.util.*;

class ACNode {
    ACNode[] next=new ACNode[26];
    ACNode fail;
    List<String> out=new ArrayList<>();
}

public class day70_aho_corasick {
    ACNode root=new ACNode();

    void insert(String word){
        ACNode node=root;
        for(char c:word.toCharArray()){
            int i=c-'a';
            if(node.next[i]==null) node.next[i]=new ACNode();
            node=node.next[i];
        }
        node.out.add(word);
    }

    void build(){
        Queue<ACNode> q=new LinkedList<>();
        root.fail=root; q.add(root);
        while(!q.isEmpty()){
            ACNode cur=q.poll();
            for(int i=0;i<26;i++){
                ACNode nxt=cur.next[i];
                if(nxt!=null){
                    nxt.fail=(cur==root)?root:cur.fail.next[i];
                    if(nxt.fail==null) nxt.fail=root;
                    nxt.out.addAll(nxt.fail.out);
                    q.add(nxt);
                } else if(cur!=root){
                    cur.next[i]=cur.fail.next[i];
                }
            }
        }
    }

    void search(String text){
        ACNode node=root;
        for(int i=0;i<text.length();i++){
            int idx=text.charAt(i)-'a';
            if(idx<0 || idx>=26){ node=root; continue; }
            node=(node.next[idx]!=null)?node.next[idx]:root;
            for(String w:node.out) System.out.println("Found "+w+" at "+(i-w.length()+1));
        }
    }

    public static void main(String[] args){
        day70_aho_corasick ac=new day70_aho_corasick();
        ac.insert("he"); ac.insert("she"); ac.insert("his"); ac.insert("hers");
        ac.build();
        ac.search("ushers");
    }
}
