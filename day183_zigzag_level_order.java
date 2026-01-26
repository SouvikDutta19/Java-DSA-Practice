import java.util.*;

public class day183_zigzag_level_order {

    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    public static void zigzag(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            int[] level = new int[size];

            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                int idx = leftToRight ? i : size - 1 - i;
                level[idx] = n.val;

                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }

            for (int v : level) System.out.print(v + " ");
            leftToRight = !leftToRight;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        zigzag(root);
    }
}