import java.util.*;

public class day214_cheapest_flights_within_k_stops {

    public static int findCheapestPrice(int n,
                                        int[][] flights,
                                        int src,
                                        int dst,
                                        int k) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] flight : flights) {
            graph.get(flight[0]).add(
                    new int[]{flight[1], flight[2]}
            );
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0, 0});

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int city = current[0];
            int cost = current[1];
            int stops = current[2];

            if (stops > k)
                continue;

            for (int[] neighbor : graph.get(city)) {

                int nextCity = neighbor[0];
                int nextCost = neighbor[1];

                if (cost + nextCost < dist[nextCity]) {

                    dist[nextCity] = cost + nextCost;

                    queue.offer(
                            new int[]{
                                    nextCity,
                                    dist[nextCity],
                                    stops + 1
                            }
                    );
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE
                ? -1
                : dist[dst];
    }
}