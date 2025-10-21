// day114_trie_autocomplete.java
// Trie implementation with insert, search, and simple autocomplete (collect top-k lexicographic suggestions).
import java.util.*;
class Main {
    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean end;
    }
    static class Trie {
        TrieNode root = new TrieNode();
        void insert(String s){
            TrieNode cur = root;
            for(char c: s.toCharArray()){
                if(c<'a' || c>'z') continue;
                int idx = c-'a';
                if(cur.next[idx]==null) cur.next[idx]=new TrieNode();
                cur = cur.next[idx];
            }
            cur.end=true;
        }
        boolean search(String s){
            TrieNode cur = root;
            for(char c: s.toCharArray()){
                if(c<'a' || c>'z') return false;
                int idx=c-'a';
                if(cur.next[idx]==null) return false;
                cur=cur.next[idx];
            }
            return cur.end;
        }
        List<String> autocomplete(String prefix, int k){
            TrieNode cur = root;
            for(char c: prefix.toCharArray()){
                if(c<'a' || c>'z') return Collections.emptyList();
                int idx=c-'a';
                if(cur.next[idx]==null) return Collections.emptyList();
                cur = cur.next[idx];
            }
            List<String> res = new ArrayList<>();
            dfs(cur, new StringBuilder(prefix), res, k);
            return res;
        }
        void dfs(TrieNode node, StringBuilder sb, List<String> res, int k){
            if(res.size()>=k) return;
            if(node.end) res.add(sb.toString());
            for(int i=0;i<26;i++){
                if(node.next[i]!=null){
                    sb.append((char)('a'+i));
                    dfs(node.next[i], sb, res, k);
                    sb.setLength(sb.length()-1);
                    if(res.size()>=k) return;
                }
            }
        }
    }

    // Example interactive usage:
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();
        int n = sc.nextInt(); // number of words to insert
        for(int i=0;i<n;i++){
            trie.insert(sc.next().toLowerCase());
        }
        int q = sc.nextInt();
        while(q-- > 0){
            String type = sc.next();
            if(type.equals("search")){
                System.out.println(trie.search(sc.next().toLowerCase()) ? "YES" : "NO");
            } else if(type.equals("auto")){
                String prefix = sc.next().toLowerCase();
                int k = sc.nextInt();
                List<String> ans = trie.autocomplete(prefix,k);
                if(ans.isEmpty()) System.out.println("NO SUGGESTIONS");
                else for(String s: ans) System.out.println(s);
            }
        }
        sc.close();
    }
}
