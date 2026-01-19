import java.util.*;

public class day180_serialize_deserialize_tree {

    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static String serialize(Node root) {
        if (root == null) return "null,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    static Node deserialize(Queue<String> q) {
        String val = q.poll();
        if (val.equals("null")) return null;

        Node node = new Node(Integer.parseInt(val));
        node.left = deserialize(q);
        node.right = deserialize(q);
        return node;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        String data = serialize(root);
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        Node newRoot = deserialize(q);

        System.out.println(newRoot.val);
    }
}