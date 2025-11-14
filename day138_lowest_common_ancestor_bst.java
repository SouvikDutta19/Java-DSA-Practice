// day138_lowest_common_ancestor_bst.java
class Node {
    int val;
    Node left, right;

    Node(int val) { this.val = val; }
}

public class day138_lowest_common_ancestor_bst {

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val)
                root = root.left;
            else if (p.val > root.val && q.val > root.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(2);
        root.right = new Node(8);
        root.left.left = new Node(0);
        root.left.right = new Node(4);

        Node p = root.left;
        Node q = root.right;
        Node lca = lowestCommonAncestor(root, p, q);

        System.out.println("LCA in BST: " + lca.val);
    }
}
