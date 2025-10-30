// day123_wordladder.java
import java.util.*;

public class day123_wordladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int steps = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord)) return steps;
                char[] arr = word.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String next = new String(arr);
                        if (dict.contains(next)) {
                            q.offer(next);
                            dict.remove(next);
                        }
                    }
                    arr[j] = original;
                }
            }
            steps++;
        }
        return 0;
    }

    public static void main(String[] args) {
        day123_wordladder obj = new day123_wordladder();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("Shortest transformation length: " + obj.ladderLength("hit", "cog", wordList));
    }
}
