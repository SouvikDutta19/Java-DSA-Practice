import java.util.*;

public class day216_evaluate_division {

    static class Edge {
        String node;
        double weight;

        Edge(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        Map<String, List<Edge>> graph =
                new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {

            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(
                    new Edge(b, value)
            );

            graph.get(b).add(
                    new Edge(a, 1.0 / value)
            );
        }

        double[] result =
                new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start)
                    || !graph.containsKey(end)) {

                result[i] = -1.0;
                continue;
            }

            if (start.equals(end)) {
                result[i] = 1.0;
                continue;
            }

            Set<String> visited =
                    new HashSet<>();

            result[i] = dfs(
                    start,
                    end,
                    1.0,
                    graph,
                    visited
            );
        }

        return result;
    }

    static double dfs(
            String current,
            String target,
            double product,
            Map<String, List<Edge>> graph,
            Set<String> visited) {

        if (current.equals(target))
            return product;

        visited.add(current);

        for (Edge edge : graph.get(current)) {

            if (visited.contains(edge.node))
                continue;

            double result = dfs(
                    edge.node,
                    target,
                    product * edge.weight,
                    graph,
                    visited
            );

            if (result != -1.0)
                return result;
        }

        return -1.0;
    }
}