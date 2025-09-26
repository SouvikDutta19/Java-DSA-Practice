import java.util.*;

class Node {
    int val;
    Node left, right;
    Node(int x) { val = x; }
}

public class day90_serialize_deserialize_bst {
    public static String serialize(Node root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString().trim();
    }

    private static void preorder(Node root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(" ");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public static Node deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<Integer> q = new LinkedList<>();
        for (String s : data.split(" ")) q.add(Integer.parseInt(s));
        return build(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static Node build(Queue<Integer> q, int min, int max) {
        if (q.isEmpty()) return null;
        int val = q.peek();
        if (val < min || val > max) return null;
        q.poll();
        Node node = new Node(val);
        node.left = build(q, min, val);
        node.right = build(q, val, max);
        return node;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);

        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);
        Node deserialized = deserialize(serialized);
        System.out.println("Root after Deserialization: " + deserialized.val);
    }
}
