import java.util.*;

public class MaximumWidthBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int maxWidth = 0;
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0L});

        while (!queue.isEmpty()) {
            int size = queue.size();
            long min = (long) queue.peek()[1];
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Object[] curr = queue.poll();
                TreeNode node = (TreeNode) curr[0];
                long index = (long) curr[1] - min;
                if (i == 0) first = index;
                if (i == size - 1) last = index;
                if (node.left != null) queue.offer(new Object[]{node.left, 2 * index});
                if (node.right != null) queue.offer(new Object[]{node.right, 2 * index + 1});
            }
            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println("Maximum width: " + widthOfBinaryTree(root));
    }
}
