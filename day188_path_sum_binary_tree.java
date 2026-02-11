public class Day188PathSumBinaryTree {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    public static boolean hasPathSum(Node root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null)
            return targetSum == root.val;

        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);

        System.out.println(hasPathSum(root, 20));
    }
}