import java.util.*;

class TreeNode2 {
    int val;
    TreeNode2 left, right;
    TreeNode2(int x) { val = x; }
}

public class day86_kth_smallest_bst {
    public static int kthSmallest(TreeNode2 root, int k) {
        Stack<TreeNode2> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(3);
        root.left = new TreeNode2(1);
        root.left.right = new TreeNode2(2);
        root.right = new TreeNode2(4);

        System.out.println("Kth Smallest: " + kthSmallest(root, 1));
    }
}
