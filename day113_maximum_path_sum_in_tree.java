// Program to find Maximum Path Sum in a Binary Tree

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class day113_maximum_path_sum_in_tree {
    static int maxSum;

    public static int findMaxSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }

    private static int helper(Node node) {
        if (node == null) return 0;

        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));

        maxSum = Math.max(maxSum, node.data + left + right);
        return node.data + Math.max(left, right);
    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println("Maximum path sum: " + findMaxSum(root));
    }
}
