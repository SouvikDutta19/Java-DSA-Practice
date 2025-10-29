// day122_wordladder.java
import java.util.*;

public class day122_wordladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
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

                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char orig = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (dict.contains(newWord)) {
                            q.add(newWord);
                            dict.remove(newWord);
                        }
                    }
                    chars[j] = orig;
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        day122_wordladder obj = new day122_wordladder();
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(obj.ladderLength("hit","cog",list));
    }
}
