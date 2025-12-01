import java.util.*;

public class day151_boundarytraversal {

    static class Node {
        int data;
        Node left, right;
        Node(int d) { data = d; }
    }

    static List<Integer> result = new ArrayList<>();

    static void leftBoundary(Node root) {
        Node cur = root.left;
        while (cur != null) {
            if (!(cur.left == null && cur.right == null))
                result.add(cur.data);
            cur = (cur.left != null) ? cur.left : cur.right;
        }
    }

    static void leaves(Node root) {
        if (root == null) return;

        leaves(root.left);
        if (root.left == null && root.right == null)
            result.add(root.data);
        leaves(root.right);
    }

    static void rightBoundary(Node root) {
        Node cur = root.right;
        Stack<Integer> s = new Stack<>();

        while (cur != null) {
            if (!(cur.left == null && cur.right == null))
                s.push(cur.data);
            cur = (cur.right != null) ? cur.right : cur.left;
        }

        while (!s.isEmpty())
            result.add(s.pop());
    }

    public static List<Integer> boundary(Node root) {
        if (root == null) return result;

        if (!(root.left == null && root.right == null))
            result.add(root.data);

        leftBoundary(root);
        leaves(root);
        rightBoundary(root);

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.right = new Node(25);

        System.out.println("Boundary Traversal: " + boundary(root));
    }
}
