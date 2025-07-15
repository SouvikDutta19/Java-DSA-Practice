import java.util.*;

public class Day15_FlightNetworkGraphBFS {

    static void bfs(Map<String, List<String>> graph, String start) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String city = queue.poll();
            System.out.println("✈️ Visiting: " + city);
            for (String neighbor : graph.getOrDefault(city, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<String, List<String>> flights = new HashMap<>();
        flights.put("Delhi", Arrays.asList("Mumbai", "Bangalore"));
        flights.put("Mumbai", Arrays.asList("Chennai"));
        flights.put("Chennai", Arrays.asList("Kolkata"));
        flights.put("Bangalore", Arrays.asList("Hyderabad"));

        bfs(flights, "Delhi");
    }
}
