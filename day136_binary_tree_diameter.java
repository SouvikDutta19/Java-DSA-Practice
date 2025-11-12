class Node {
    int data;
    Node left, right;
    Node(int item) { data = item; left = right = null; }
}

public class day136_binary_tree_diameter {
    static int maxDiameter = 0;

    static int height(Node root) {
        if (root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        height(root);
        System.out.println("Diameter of the tree: " + maxDiameter);
    }
}
