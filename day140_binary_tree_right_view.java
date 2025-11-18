// day140_binary_tree_right_view.java

import java.util.*;

public class day140_binary_tree_right_view {

    static class Node {
        int data;
        Node left, right;

        Node(int d) { data = d; }
    }

    public static List<Integer> rightView(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Node last = null;

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                last = curr;

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            result.add(last.data); // rightmost of the level
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(4);

        System.out.println(rightView(root));
    }
}
