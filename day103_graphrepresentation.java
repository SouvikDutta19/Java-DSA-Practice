import java.util.*;

public class day103_graphrepresentation {
    private Map<Integer, List<Integer>> adjList;

    public day103_graphrepresentation() {
        adjList = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u); // For undirected graph
    }

    public void printGraph() {
        for (var node : adjList.keySet()) {
            System.out.println(node + " -> " + adjList.get(node));
        }
    }

    public static void main(String[] args) {
        day103_graphrepresentation graph = new day103_graphrepresentation();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 5);
        System.out.println("Adjacency List Representation:");
        graph.printGraph();
    }
}
