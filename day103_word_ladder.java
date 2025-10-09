import java.util.*;

// Program to find the shortest transformation sequence from start word to end word (Word Ladder Problem)
public class day103_word_ladder {

    static class Pair {
        String word;
        int steps;
        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String word = current.word;
            int steps = current.steps;

            if (word.equals(endWord)) return steps;

            for (int i = 0; i < word.length(); i++) {
                char[] chArr = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chArr[i] = c;
                    String newWord = new String(chArr);
                    if (wordSet.contains(newWord)) {
                        queue.add(new Pair(newWord, steps + 1));
                        wordSet.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int result = ladderLength(beginWord, endWord, wordList);
        if (result != 0)
            System.out.println("Shortest transformation length: " + result);
        else
            System.out.println("No transformation possible!");
    }
}
