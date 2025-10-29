// day122_wordsearch2_trie.java
import java.util.*;

public class day122_wordsearch2_trie {
    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word = null;
    }

    TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (node.next[idx] == null) node.next[idx] = new TrieNode();
                node = node.next[idx];
            }
            node.word = w;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        Set<String> res = new HashSet<>();
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dfs(board, i, j, root, vis, res);
        return new ArrayList<>(res);
    }

    void dfs(char[][] b, int i, int j, TrieNode node, boolean[][] vis, Set<String> res) {
        int m = b.length, n = b[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || vis[i][j]) return;
        node = node.next[b[i][j] - 'a'];
        if (node == null) return;
        if (node.word != null) res.add(node.word);
        vis[i][j] = true;
        dfs(b, i + 1, j, node, vis, res);
        dfs(b, i - 1, j, node, vis, res);
        dfs(b, i, j + 1, node, vis, res);
        dfs(b, i, j - 1, node, vis, res);
        vis[i][j] = false;
    }

    public static void main(String[] args) {
        day122_wordsearch2_trie obj = new day122_wordsearch2_trie();
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        System.out.println("Found words: " + obj.findWords(board, words));
    }
}
