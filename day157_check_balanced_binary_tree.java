class TreeNodeB {
    int data;
    TreeNodeB left, right;

    TreeNodeB(int d) {
        data = d;
    }
}

public class day157_check_balanced_binary_tree {

    static int height(TreeNodeB root) {
        if (root == null) return 0;

        int lh = height(root.left);
        if (lh == -1) return -1;

        int rh = height(root.right);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;

        return Math.max(lh, rh) + 1;
    }

    static boolean isBalanced(TreeNodeB root) {
        return height(root) != -1;
    }

    public static void main(String[] args) {
        TreeNodeB root = new TreeNodeB(1);
        root.left = new TreeNodeB(2);
        root.left.left = new TreeNodeB(3);

        System.out.println("Is Balanced? " + isBalanced(root));
    }
}