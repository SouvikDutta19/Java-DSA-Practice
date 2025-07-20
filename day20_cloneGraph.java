import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}

public class day20_cloneGraph {
    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private static Node dfs(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) return visited.get(node);

        Node clone = new Node(node.val);
        visited.put(node, clone);
        for (Node neighbor : node.neighbors)
            clone.neighbors.add(dfs(neighbor, visited));

        return clone;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        Node clone = cloneGraph(node1);
        System.out.println("Graph cloned successfully.");
    }
}
