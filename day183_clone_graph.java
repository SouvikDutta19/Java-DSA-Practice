import java.util.*;

public class day183_clone_graph {

    static class Node {
        int val;
        List<Node> neighbors = new ArrayList<>();
        Node(int v) { val = v; }
    }

    static Map<Node, Node> map = new HashMap<>();

    static Node clone(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);

        Node copy = new Node(node.val);
        map.put(node, copy);

        for (Node n : node.neighbors)
            copy.neighbors.add(clone(n));

        return copy;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        a.neighbors.add(b);
        b.neighbors.add(a);

        Node cloned = clone(a);
        System.out.println(cloned.val);
    }
}