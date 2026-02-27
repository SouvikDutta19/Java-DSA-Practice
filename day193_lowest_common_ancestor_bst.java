public class Day193LowestCommonAncestorBST {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);

        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(2);
        root.right = new Node(8);

        Node p = root.left;
        Node q = root.right;

        System.out.println(lowestCommonAncestor(root, p, q).val);
    }
}