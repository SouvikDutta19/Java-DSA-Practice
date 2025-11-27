// Day148 Trie (insert, search, startsWith)
import java.util.*;
public class Day148Trie {
    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean end = false;
    }
    static class Trie {
        TrieNode root = new TrieNode();
        void insert(String s){
            TrieNode cur = root;
            for(char c: s.toCharArray()){
                int idx = c - 'a';
                if(cur.next[idx]==null) cur.next[idx]=new TrieNode();
                cur = cur.next[idx];
            }
            cur.end = true;
        }
        boolean search(String s){
            TrieNode cur = root;
            for(char c: s.toCharArray()){
                int idx = c - 'a';
                if(cur.next[idx]==null) return false;
                cur = cur.next[idx];
            }
            return cur.end;
        }
        boolean startsWith(String prefix){
            TrieNode cur = root;
            for(char c: prefix.toCharArray()){
                int idx = c - 'a';
                if(cur.next[idx]==null) return false;
                cur = cur.next[idx];
            }
            return true;
        }
    }

    public static void main(String[] args){
        Trie t = new Trie();
        t.insert("apple");
        t.insert("app");
        System.out.println("search apple: " + t.search("apple")); // true
        System.out.println("search app: " + t.search("app")); // true
        System.out.println("startsWith ap: " + t.startsWith("ap")); // true
        System.out.println("search application: " + t.search("application")); // false
    }
}
