public class day208_binary_tree_max_path_sum {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val){ this.val = val; }
    }

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root){
        dfs(root);
        return maxSum;
    }

    static int dfs(TreeNode node){

        if(node == null) return 0;

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        maxSum = Math.max(maxSum, left + right + node.val);

        return node.val + Math.max(left, right);
    }
}