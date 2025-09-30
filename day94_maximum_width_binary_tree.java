import java.util.*;

class NodeWidth {
    TreeNode node;
    int index;
    NodeWidth(TreeNode n, int i) { node = n; index = i; }
}

public class day94_maximum_width_binary_tree {
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<NodeWidth> q = new LinkedList<>();
        q.add(new NodeWidth(root, 0));
        int maxWidth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = q.peek().index;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                NodeWidth nw = q.poll();
                int curr = nw.index - minIndex;
                if (i == 0) first = curr;
                if (i == size - 1) last = curr;
                if (nw.node.left != null) q.add(new NodeWidth(nw.node.left, 2 * curr));
                if (nw.node.right != null) q.add(new NodeWidth(nw.node.right, 2 * curr + 1));
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
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
        System.out.println("Max Width: " + widthOfBinaryTree(root));
    }
}
