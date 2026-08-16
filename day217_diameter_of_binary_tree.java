public class day217_diameter_of_binary_tree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int diameter;

    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    private static int height(TreeNode node) {

        if (node == null)
            return 0;

        int left = height(node.left);
        int right = height(node.right);

        diameter = Math.max(
                diameter,
                left + right
        );

        return 1 + Math.max(left, right);
    }
}