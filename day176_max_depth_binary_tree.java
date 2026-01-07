public class day176_max_depth_binary_tree {

    static class Node {
        int val;
        Node left, right;
        Node(int v){ val=v; }
    }

    public static int maxDepth(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);

        System.out.println(maxDepth(root));
    }
}