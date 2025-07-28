public class BalancedBinaryTreeCheck {
    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            this.data = val;
            this.left = this.right = null;
        }
    }

    static class Tree {
        boolean isBalanced(Node root) {
            return checkHeight(root) != -1;
        }

        int checkHeight(Node node) {
            if (node == null) return 0;

            int left = checkHeight(node.left);
            if (left == -1) return -1;

            int right = checkHeight(node.right);
            if (right == -1) return -1;

            if (Math.abs(left - right) > 1) return -1;
            return Math.max(left, right) + 1;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.left.left = new Node(50);

        System.out.println("Is tree balanced? " + tree.isBalanced(root));
    }
}
