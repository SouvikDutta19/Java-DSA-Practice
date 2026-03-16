public class day199_lowest_common_ancestor_bst {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val){ this.val = val; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        TreeNode p = root.left;
        TreeNode q = root.right;

        System.out.println(lowestCommonAncestor(root,p,q).val);
    }
}