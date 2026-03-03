import java.util.*;

public class Day194AlienDictionary {

    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words)
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());

            for (int j = 0; j < len; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (!graph.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        graph.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j),
                                indegree.get(w2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (char c : indegree.keySet())
            if (indegree.get(c) == 0)
                queue.add(c);

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            char c = queue.poll();
            result.append(c);

            for (char neighbor : graph.get(c)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0)
                    queue.add(neighbor);
            }
        }

        return result.length() == indegree.size()
                ? result.toString() : "";
    }
}