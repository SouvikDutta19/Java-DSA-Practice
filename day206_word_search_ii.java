import java.util.*;

public class day206_word_search_ii {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public static List<String> findWords(char[][] board, String[] words){

        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    static void dfs(char[][] board, int i, int j, TrieNode node, List<String> result){

        char c = board[i][j];
        if(c == '#' || node.children[c - 'a'] == null)
            return;

        node = node.children[c - 'a'];

        if(node.word != null){
            result.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        int[] dirs = {0,1,0,-1,0};
        for(int d=0;d<4;d++){
            int ni = i + dirs[d];
            int nj = j + dirs[d+1];

            if(ni>=0 && nj>=0 && ni<board.length && nj<board[0].length)
                dfs(board, ni, nj, node, result);
        }

        board[i][j] = c;
    }

    static TrieNode buildTrie(String[] words){

        TrieNode root = new TrieNode();

        for(String word : words){
            TrieNode node = root;

            for(char c : word.toCharArray()){
                if(node.children[c-'a'] == null)
                    node.children[c-'a'] = new TrieNode();
                node = node.children[c-'a'];
            }
            node.word = word;
        }
        return root;
    }
}