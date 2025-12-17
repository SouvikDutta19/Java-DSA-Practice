import java.util.*;

class GraphNode167 {
    int val;
    List<GraphNode167> neighbors;

    GraphNode167(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
}

public class day167_clone_graph {

    static GraphNode167 clone(GraphNode167 node, Map<GraphNode167, GraphNode167> map) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);

        GraphNode167 copy = new GraphNode167(node.val);
        map.put(node, copy);

        for (GraphNode167 nei : node.neighbors)
            copy.neighbors.add(clone(nei, map));

        return copy;
    }

    public static void main(String[] args) {
        GraphNode167 n1 = new GraphNode167(1);
        GraphNode167 n2 = new GraphNode167(2);
        GraphNode167 n3 = new GraphNode167(3);

        n1.neighbors.add(n2);
        n2.neighbors.add(n3);
        n3.neighbors.add(n1);

        GraphNode167 cloned = clone(n1, new HashMap<>());
        System.out.println("Cloned node value: " + cloned.val);
    }
}