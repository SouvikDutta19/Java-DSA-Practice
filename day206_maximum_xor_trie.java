public class day206_maximum_xor_trie {

    static class Node {
        Node[] links = new Node[2];
    }

    Node root = new Node();

    void insert(int num){
        Node node = root;

        for(int i=31;i>=0;i--){
            int bit = (num >> i) & 1;

            if(node.links[bit] == null)
                node.links[bit] = new Node();

            node = node.links[bit];
        }
    }

    int getMax(int num){
        Node node = root;
        int max = 0;

        for(int i=31;i>=0;i--){
            int bit = (num >> i) & 1;

            if(node.links[1-bit] != null){
                max |= (1<<i);
                node = node.links[1-bit];
            }
            else{
                node = node.links[bit];
            }
        }
        return max;
    }

    public int findMaximumXOR(int[] nums){

        for(int num : nums)
            insert(num);

        int max = 0;

        for(int num : nums)
            max = Math.max(max, getMax(num));

        return max;
    }
}