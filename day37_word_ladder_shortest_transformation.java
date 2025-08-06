import java.util.*;

public class day37_word_ladder_shortest_transformation {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String word = queue.poll();
                if (word.equals(endWord)) return steps;

                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String next = new String(chars);
                        if (dict.contains(next)) {
                            queue.add(next);
                            dict.remove(next);
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest transformation length: " + result);
    }
}
