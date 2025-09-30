class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class day94_bst_to_greater_sum_tree {
    static int sum = 0;

    static void transform(TreeNode root) {
        if (root == null) return;
        transform(root.right);
        sum += root.val;
        root.val = sum;
        transform(root.left);
    }

    static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        transform(root);
        inorder(root);
    }
}
