class Node {
    int data;
    Node left, right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class CheckBinarySearchTree {

    public static boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTUtil(Node node, int min, int max) {
        if (node == null)
            return true;
        if (node.data <= min || node.data >= max)
            return false;

        return isBSTUtil(node.left, min, node.data) &&
               isBSTUtil(node.right, node.data, max);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(1);
        root.left.right = new Node(8);

        System.out.println("Is BST? " + isBST(root));
    }
}
