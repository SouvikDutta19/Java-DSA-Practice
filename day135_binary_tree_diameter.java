// day135_binary_tree_diameter.java
// Diameter of binary tree (longest path between two nodes)

public class day135_binary_tree_diameter {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static class Result { int val; Result(int v) { val = v; } }

    static int diameterUtil(Node root, Result res) {
        if (root == null) return 0;
        int l = diameterUtil(root.left, res);
        int r = diameterUtil(root.right, res);
        res.val = Math.max(res.val, l + r + 1);
        return Math.max(l, r) + 1;
    }

    static int diameter(Node root) {
        Result res = new Result(0);
        diameterUtil(root, res);
        return res.val;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("Diameter of tree: " + diameter(root));
    }
}
