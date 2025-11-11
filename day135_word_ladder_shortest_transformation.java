import java.util.*;

public class day135_word_ladder_shortest_transformation {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord)) return level;
                for (int j = 0; j < word.length(); j++) {
                    char[] arr = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String newWord = new String(arr);
                        if (dict.contains(newWord)) {
                            q.add(newWord);
                            dict.remove(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("Shortest transformation length: " + ladderLength("hit", "cog", words));
    }
}
