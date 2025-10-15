// Diameter of Binary Tree using recursion
class Node {
    int data;
    Node left, right;
    Node(int item) { data = item; }
}

public class day109_binary_tree_diameter {
    Node root;

    static class Height { int h; }

    int diameter(Node root, Height height) {
        Height lh = new Height(), rh = new Height();
        if (root == null) {
            height.h = 0;
            return 0;
        }
        int ldiameter = diameter(root.left, lh);
        int rdiameter = diameter(root.right, rh);
        height.h = Math.max(lh.h, rh.h) + 1;
        return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
    }

    public static void main(String[] args) {
        day109_binary_tree_diameter tree = new day109_binary_tree_diameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("Diameter of the tree is: " + tree.diameter(tree.root, new Height()));
    }
}
