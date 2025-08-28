class MaxPathSumTree {
    static class Node {
        int data;
        Node left, right;
        Node(int d) { data = d; left = right = null; }
    }

    static int maxSum;

    public static int findMaxUtil(Node node) {
        if (node == null) return 0;

        int left = Math.max(0, findMaxUtil(node.left));
        int right = Math.max(0, findMaxUtil(node.right));

        maxSum = Math.max(maxSum, left + right + node.data);

        return Math.max(left, right) + node.data;
    }

    public static int findMaxSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        findMaxUtil(root);
        return maxSum;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);

        System.out.println("Maximum Path Sum: " + findMaxSum(root));
    }
}
