// Program to solve Word Ladder problem using BFS

import java.util.*;

public class day113_word_ladder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return level;
                for (String neighbor : getNeighbors(word)) {
                    if (dict.contains(neighbor)) {
                        queue.add(neighbor);
                        dict.remove(neighbor);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    private static List<String> getNeighbors(String word) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String newWord = new String(chars);
                neighbors.add(newWord);
            }
            chars[i] = old;
        }
        return neighbors;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("Shortest transformation length: " +
                ladderLength("hit", "cog", wordList));
    }
}
