import java.util.*;

public class day169_word_ladder {

    public static int ladderLength(String begin, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(end)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(end)) return level;

                char[] arr = word.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String next = new String(arr);
                        if (dict.contains(next)) {
                            queue.add(next);
                            dict.remove(next);
                        }
                    }
                    arr[j] = old;
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("Shortest Ladder Length = " +
                ladderLength("hit", "cog", words));
    }
}