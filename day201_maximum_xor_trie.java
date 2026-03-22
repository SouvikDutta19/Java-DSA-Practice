class day201_maximum_xor_trie {

    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(int num){
            TrieNode node = root;

            for(int i=31;i>=0;i--){
                int bit = (num >> i) & 1;

                if(node.children[bit] == null)
                    node.children[bit] = new TrieNode();

                node = node.children[bit];
            }
        }

        int getMax(int num){
            TrieNode node = root;
            int max = 0;

            for(int i=31;i>=0;i--){
                int bit = (num >> i) & 1;

                if(node.children[1-bit] != null){
                    max |= (1 << i);
                    node = node.children[1-bit];
                }
                else
                    node = node.children[bit];
            }

            return max;
        }
    }

    public static int findMaximumXOR(int[] nums){

        Trie trie = new Trie();

        for(int num : nums)
            trie.insert(num);

        int max = 0;

        for(int num : nums)
            max = Math.max(max, trie.getMax(num));

        return max;
    }
}