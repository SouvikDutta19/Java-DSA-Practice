public class day175_lowest_common_ancestor {

    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    public static Node lca(Node root, int p, int q) {
        if (root == null || root.val == p || root.val == q)
            return root;

        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        Node ans = lca(root, 6, 2);
        System.out.println("LCA: " + ans.val);
    }
}