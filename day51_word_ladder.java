import java.util.*;

public class day51_word_ladder {

    static class WordNode {
        String word;
        int steps;

        WordNode(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(beginWord, 1));

        while (!queue.isEmpty()) {
            WordNode current = queue.poll();
            String word = current.word;

            if (word.equals(endWord)) {
                return current.steps;
            }

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char old = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String nextWord = new String(arr);
                    if (dict.contains(nextWord)) {
                        queue.add(new WordNode(nextWord, current.steps + 1));
                        dict.remove(nextWord);
                    }
                }
                arr[i] = old;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest Transformation Sequence Length: " + result);
    }
}
