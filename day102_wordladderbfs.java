import java.util.*;

public class day102_wordladderbfs {
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
                char[] chArr = word.toCharArray();
                for (int j = 0; j < chArr.length; j++) {
                    char original = chArr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chArr[j] = c;
                        String newWord = new String(chArr);
                        if (dict.contains(newWord)) {
                            q.add(newWord);
                            dict.remove(newWord);
                        }
                    }
                    chArr[j] = original;
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("Shortest transformation length: " +
            ladderLength("hit", "cog", wordList));
    }
}
