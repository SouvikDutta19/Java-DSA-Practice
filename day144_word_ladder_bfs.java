import java.util.*;

public class day144_word_ladder_bfs {

    public static int ladderLength(String begin, String end, List<String> dict) {
        Set<String> set = new HashSet<>(dict);
        if (!set.contains(end)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(begin);

        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                String word = q.poll();

                if (word.equals(end)) return level;

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[i] = ch;
                        String next = new String(arr);

                        if (set.contains(next)) {
                            q.add(next);
                            set.remove(next);
                        }
                    }

                    arr[i] = original;
                }
            }

            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("Word Ladder Length: " +
                ladderLength("hit", "cog", dict));
    }
}
