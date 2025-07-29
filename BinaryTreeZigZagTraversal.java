public class BinaryTreeZigZagTraversal {

    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    static void zigzagTraversal(Node root) {
        if (root == null) return;

        java.util.Stack<Node> currentLevel = new java.util.Stack<>();
        java.util.Stack<Node> nextLevel = new java.util.Stack<>();

        boolean leftToRight = true;
        currentLevel.push(root);

        while (!currentLevel.isEmpty()) {
            Node node = currentLevel.pop();
            System.out.print(node.data + " ");

            if (leftToRight) {
                if (node.left != null) nextLevel.push(node.left);
                if (node.right != null) nextLevel.push(node.right);
            } else {
                if (node.right != null) nextLevel.push(node.right);
                if (node.left != null) nextLevel.push(node.left);
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                java.util.Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(15);
        root.left.left = new Node(4);
        root.left.right = new Node(8);
        root.right.left = new Node(12);
        root.right.right = new Node(18);

        System.out.print("ZigZag Traversal: ");
        zigzagTraversal(root);
    }
}
