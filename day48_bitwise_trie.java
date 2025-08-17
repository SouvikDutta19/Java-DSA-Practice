import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[2];
}

public class day48_bitwise_trie {
    private TrieNode root;

    public day48_bitwise_trie() {
        root = new TrieNode();
    }

    public void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    public int query(int num) {
        TrieNode node = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int oppositeBit = 1 - bit;
            if (node.children[oppositeBit] != null) {
                maxXor |= (1 << i);
                node = node.children[oppositeBit];
            } else {
                node = node.children[bit];
            }
        }
        return maxXor;
    }

    public static void main(String[] args) {
        day48_bitwise_trie trie = new day48_bitwise_trie();
        int[] nums = {3, 10, 5, 25, 2, 8};
        for (int num : nums) {
            trie.insert(num);
        }
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, trie.query(num));
        }
        System.out.println("Maximum XOR is: " + max);
    }
}
