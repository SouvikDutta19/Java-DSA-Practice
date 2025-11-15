// day138_binary_tree_diameter.java
class TNode {
    int val;
    TNode left, right;
    TNode(int val) { this.val = val; }
}

public class day138_binary_tree_diameter {

    static int diameter = 0;

    public static int diameterOfBinaryTree(TNode root) {
        depth(root);
        return diameter;
    }

    private static int depth(TNode node) {
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(4);
        root.left.right = new TNode(5);

        System.out.println("Diameter: " + diameterOfBinaryTree(root));
    }
}
