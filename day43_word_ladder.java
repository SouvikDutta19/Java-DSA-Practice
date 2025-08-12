import java.util.*;

public class day43_word_ladder {
    static class WordNode {
        String word;
        int numSteps;
        WordNode(String word, int numSteps) {
            this.word = word;
            this.numSteps = numSteps;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(beginWord, 1));

        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.word;

            if (word.equals(endWord)) return top.numSteps;

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char temp = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String newWord = new String(arr);
                    if (wordSet.contains(newWord)) {
                        queue.add(new WordNode(newWord, top.numSteps + 1));
                        wordSet.remove(newWord);
                    }
                }
                arr[i] = temp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println("Shortest transformation sequence length: " + ladderLength(beginWord, endWord, wordList));
    }
}
