public class day181_lca_binary_tree {

    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static Node lca(Node root, int a, int b) {
        if (root == null || root.val == a || root.val == b)
            return root;

        Node left = lca(root.left, a, b);
        Node right = lca(root.right, a, b);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);

        System.out.println(lca(root, 6, 2).val);
    }
}