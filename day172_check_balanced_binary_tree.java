public class day172_check_balanced_binary_tree {

    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static class TreeInfo {
        int height;
        boolean isBalanced;
        TreeInfo(int h, boolean b) {
            height = h;
            isBalanced = b;
        }
    }

    public static TreeInfo check(Node root) {
        if (root == null)
            return new TreeInfo(0, true);

        TreeInfo left = check(root.left);
        TreeInfo right = check(root.right);

        boolean currBalanced = Math.abs(left.height - right.height) <= 1
                && left.isBalanced && right.isBalanced;

        return new TreeInfo(Math.max(left.height, right.height) + 1, currBalanced);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.println("Is Balanced? " + check(root).isBalanced);
    }
}